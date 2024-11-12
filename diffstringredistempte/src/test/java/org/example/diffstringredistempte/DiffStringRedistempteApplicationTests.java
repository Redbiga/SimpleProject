package org.example.diffstringredistempte;

import org.example.diffstringredistempte.diff.RedisOp;
import org.example.diffstringredistempte.diff.StringOp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiffStringRedistempteApplicationTests {
    @Autowired
    private RedisOp redisOp;
    @Autowired
    private StringOp stringOp;
    @Test
    void contextLoads() {
    }
    @Test
    public void testRedis()
    {
        redisOp.putRedis();
        stringOp.putRedis();
        redisOp.getRedis();
        stringOp.getRedis();
        redisOp.getStringRedis();
    }
}
