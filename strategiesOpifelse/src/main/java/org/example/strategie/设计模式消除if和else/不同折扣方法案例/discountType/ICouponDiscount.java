package org.example.strategie.设计模式消除if和else.不同折扣方法案例.discountType;

import java.math.BigDecimal;

public interface ICouponDiscount<T> {

    /**
     * 获取折扣类型
     * @return 折扣类型
     */
    Integer getDiscount();

    /**
     * @param couponInfo  折扣类型：打折，n元购。满减
     * @param skuPrice 原价
     * @return 订单价格
     */
    BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice);

}
