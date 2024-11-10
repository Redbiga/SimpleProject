package org.example.strategie;

import org.example.strategie.设计模式消除if和else.不同折扣方法案例.discountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class StrategiesOpifelseApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private discountService discountService1;
    @Test
    public void testDiscountAmount(){
        BigDecimal amount = discountService1.discountAmount(1, 0.5, new BigDecimal(100));
        System.out.println("满减优惠后金额："+amount);
    }

}
