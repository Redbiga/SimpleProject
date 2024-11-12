package org.example.diffstringredistempte.diff;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author redA
 * @时间: 2024年11月12日 下午12:51
 */
@Component
@RequiredArgsConstructor
public class StringOp {
    private final StringRedisTemplate stringRedisTemplate;
    User user = new User(2,"redB");
    public void putRedis() {
        stringRedisTemplate.opsForValue().set(user.getAge().toString(),user.toString());
    }
    public void getRedis() {
        String s = stringRedisTemplate.opsForValue().get(user.getAge().toString());
        System.out.println(s);
    }
}