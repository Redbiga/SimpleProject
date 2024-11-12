package org.example.diffstringredistempte.diff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author redA
 * @时间: 2024年11月12日 下午12:44
 */
@Data // 自动生成getter、setter、toString、equals和hashCode方法
@NoArgsConstructor // 生成无参构造器
@AllArgsConstructor // 生成有参构造器
public class User implements Serializable {
    public  Integer age;
    public  String name;
}