package org.example.diffstringredistempte.diff;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author redA
 * @时间: 2024年11月12日 下午12:51
 */
@Component
@RequiredArgsConstructor//只对 final 字段和标注了 @NonNull 的字段生成构造函数参数。
public class RedisOp {
    private  final RedisTemplate<Object, Object> redisTemplate;
    User user = new User(1,"redA");
    public  void  putRedis(){
        redisTemplate.opsForValue().set(user.getAge().toString(),user);
    }
    public  void getRedis(){
        Object  ans =  redisTemplate.opsForValue().get(user.getAge().toString());
        System.out.println(ans);
    }
    public  void  getStringRedis(){
        Object ans = redisTemplate.opsForValue().get("2");
    }
}