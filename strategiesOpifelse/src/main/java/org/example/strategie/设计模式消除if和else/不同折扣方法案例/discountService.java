package org.example.strategie.设计模式消除if和else.不同折扣方法案例;

import lombok.RequiredArgsConstructor;
import org.example.strategie.设计模式消除if和else.不同折扣方法案例.discountType.ICouponDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author redA
 * @时间: 2024年11月10日 上午1:04
 * @需求:根据不同的折扣类型进行折扣
 * @原本的代码： <img src="https://raw.githubusercontent.com/Redbiga/imgs/main/20241110010901.png">
 * @总结： 这里是把不同的策略储存到map中，然后进行处理。
 */
@Service
@RequiredArgsConstructor
public class discountService {
    private final  List<ICouponDiscount> discountList;
    private Map<Integer,ICouponDiscount> map;
    @PostConstruct
    public void init(){
        map = discountList.stream().collect(Collectors.toMap(ICouponDiscount::getDiscount, Function.identity()));
    }
    public BigDecimal discountAmount(Integer type,Double couponInfo, BigDecimal skuPrice){
        return map.get(type).discountAmount(couponInfo,skuPrice);
    }
}