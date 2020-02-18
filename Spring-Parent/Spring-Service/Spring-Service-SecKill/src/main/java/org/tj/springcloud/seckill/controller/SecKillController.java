package org.tj.springcloud.seckill.controller;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tj.springcloud.common.model.userservice.User;
import org.tj.springcloud.common.util.HttpResult;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/secKillService")
public class SecKillController {


    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    DefaultRedisScript<String> redisScript;

    @GetMapping("/init")
    public HttpResult init() {


        List<Map<String, Object>> goodsList = new ArrayList<Map<String, Object>>();
        Map<String, Object> goodsMap = new HashMap<String, Object>();
        goodsMap.put("id", "001");
        goodsMap.put("name", "一号商品");
        goodsMap.put("num", "10");
        goodsMap.put("price", "200");
        // redisTemplate.boundListOps("skillservice:goods").leftPush(goodsMap);
        goodsList.add(goodsMap);


        goodsMap = new HashMap<String, Object>();

        goodsMap.put("id", "002");
        goodsMap.put("name", "二号商品");
        goodsMap.put("num", "10");
        goodsMap.put("price", "200");
        //   redisTemplate.boundListOps("skillservice:goods").leftPush(goodsMap);
        goodsList.add(goodsMap);

        goodsMap = new HashMap<String, Object>();


        goodsMap.put("id", "003");
        goodsMap.put("name", "三号商品");
        goodsMap.put("num", "10");
        goodsMap.put("price", "200");
        //   redisTemplate.boundListOps("skillservice:goods").leftPush(goodsMap);
        goodsList.add(goodsMap);

        //


        //把商品放入redis，并且生成库存map用来控制防止超卖
        redisTemplate.opsForValue().set("skillservice:goodslist", JSON.toJSONString(goodsList));
/*        for (Map<String, Object> map : goodsList) {

        }*/
        goodsList.stream().forEach(map -> {

            String id = (String) map.get("id");
            String num = (String) map.get("num");

            //生成库存的key，用来控制超卖
            redisTemplate.boundHashOps("skillservice:goodsMap").put(id, Integer.valueOf(num));


        });
        redisTemplate.delete("skillservice:userquenelist");

        return HttpResult.OK();
    }


    @GetMapping("goodslist")
    public HttpResult getGoodsList() {
        return HttpResult.OK().data(redisTemplate.boundListOps("skillservice:goods").range(0, redisTemplate.boundListOps("skillservice:goods").size() - 1));
    }


    @GetMapping("goodslist1")
    public HttpResult getGoodsList1() {
        return HttpResult.OK().data(JSON.parseArray(redisTemplate.opsForValue().get("skillservice:goodslist").toString()));
    }


    /**
     * 下单排队
     *
     * @return
     */
    @GetMapping("/quene")
    public HttpResult quene(String username, String goodsid) {

        if (checkUserName(username)) {
            log.info("用户存在正在排队的订单");
            return HttpResult.ERROR("用户存在正在排队的订单");
        }
        BoundListOperations options = redisTemplate.boundListOps("skillservice:userquenelist:" + goodsid);
        if (redisTemplate.boundHashOps("skillservice:goodsMap").increment(goodsid, -1) >= 0) {


            //进入下单排队的redis
            options.leftPush(username);

            log.info("____queneNum=" + options.size());
            return HttpResult.OK();
        } else {
            log.info("已售罄");
            return HttpResult.ERROR("已售罄");

        }


    }

    @GetMapping("/queneLua")
    public HttpResult queneLua(String username, String goodsid) {

        List<String> keys = new ArrayList<String>();
        keys.add("skillservice:userquenelist");
        keys.add(username);
        keys.add("skillservice:goodsMap");
        keys.add(goodsid);
        //redisTemplate.delete(key);
        //redisTemplate.opsForValue().set(key, "hahaha");
        //String s = redisTemplate.opsForValue().get(key);
        String result = redisTemplate.execute(redisScript, keys).toString();
        if ("1".equals(result)) {
            log.info("用户当前已有排队商品");
        } else if ("2".equals(result)) {
            log.info("排队中....");
        } else {
            log.info("商品不存在或库存不足");
        }
        //String s = redisTemplate.opsForValue().get(key).toString();
        //log.info(s);
        return HttpResult.OK().data("");
    }

    /**
     * 下单排队
     *
     * @return
     */
    // @GetMapping("/getGoodsKey")
    public boolean checkUserName(String userName) {

        //进入下单排队的redis
        Set<String> keys = redisTemplate.keys("skillservice:userquenelist:*");

        for (String key : keys) {
            BoundListOperations options = redisTemplate.boundListOps(key);
            List<String> currentUsernames = options.range(0, options.size());
            for (String currentUsername : currentUsernames) {
                if (currentUsername.equals(userName)) {
                    return true;
                }
            }


            // return HttpResult.OK().data(keys);

        }
        return false;
    }


}
