package org.example.strategie.设计模式消除if和else.不同折扣方法案例.discountType;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author redA
 * @时间: 2024年11月10日 上午2:03
 */
@Component
public class NYGCouponDiscount implements ICouponDiscount<Double>{
    public Integer getDiscount() {
        return 4;
    }

    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return skuPrice;
    }
}