package org.tj.springcloud.search.contorller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.search.service.SearchService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/21.
 */
@RestController
@CrossOrigin
@RequestMapping("searchService")
public class SearchController {


    @Resource
    private SearchService searchService;


    @GetMapping("/initSkuInfo")
    public HttpResult initSkuInfo() {
        searchService.initSkuInfo();
        System.out.println("异步调用，我已经完事了");
        return HttpResult.OK();

    }

    @GetMapping("/searchSkuInfo")
    public HttpResult searchSkuInfo(@RequestParam(required = false) Map<String, String> searchMap) throws IOException {
        return HttpResult.OK().data(searchService.searchSkuInfo(searchMap));

    }


}
