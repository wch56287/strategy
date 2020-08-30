package com.huawei.strategy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: WangChunHui
 * @Date: 2020-06-07 22:35
 * @Description:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "韩"),
    FIVE(5, "赵"),
    SIX(6, "魏");

    private Integer retCode;
    private String retMessage;

    public static CountryEnum forEachCountryEnum(int i) {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element : myArray) {
            if (i == element.getRetCode()) {
                return element;
            }
        }
        return null;
    }
}
