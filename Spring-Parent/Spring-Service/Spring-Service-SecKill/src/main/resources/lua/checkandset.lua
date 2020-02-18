--[[  接收参数，用户id，商品id]]--
if redis.call("HEXISTS", KEYS[1], KEYS[2]) > 0 then
    --[[ 第一步，判断用户是否有正在排队的订单，如果有，就直接返回正在排队，不能下单]]--
    return "1"
elseif redis.call("HEXISTS", KEYS[3], KEYS[4]) == 1 and tonumber(redis.call("HGET", KEYS[3], KEYS[4])) > 0 then
    --[[商品存在且有库存,则把用户加入排队队列，同时库存减一 ]]--
    redis.call("HSET", "skillservice:userquenelist",KEYS[2],KEYS[4])
    redis.call("HINCRBY", KEYS[3],KEYS[4],-1)

    return "2"
else
    return "3"
end
