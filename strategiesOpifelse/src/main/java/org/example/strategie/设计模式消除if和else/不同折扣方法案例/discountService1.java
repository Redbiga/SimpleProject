package org.example.strategie.设计模式消除if和else.不同折扣方法案例;

import lombok.RequiredArgsConstructor;
import org.example.strategie.设计模式消除if和else.不同折扣方法案例.discountType.ICouponDiscount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author redA
 * @时间: 2024年11月10日 下午9:14
 * @描述: 通过遍历list实现不同的折扣方式，消除if和else，后面新增优惠方式只需
 */
@Service
@RequiredArgsConstructor//这个注解是对final修饰的属性构造无参构造器
public class discountService1 {
    public final List<ICouponDiscount> couponDiscountList;//@Autowired默认根据type注入，这里是将ICouponDiscount的bean注入到list中
    public BigDecimal discountAmount(Integer type, Double couponInfo, BigDecimal skuPrice)
    {
        for(ICouponDiscount couponDiscount:couponDiscountList){
            if(couponDiscount.getDiscount().equals(type)){
                return couponDiscount.discountAmount(couponInfo,skuPrice);
            }
        }
        throw new IllegalArgumentException("优惠类型不合法");
    }
}