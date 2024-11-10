package org.example.strategie.设计模式消除if和else.不同折扣方法案例.discountType;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author redA
 * @时间: 2024年11月10日 上午2:04
 */
@Component
public class DZCouponDiscount implements ICouponDiscount<Double>{
    public Integer getDiscount() {
        return 1;
    }

    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return skuPrice.multiply(new BigDecimal(couponInfo));
    }
}