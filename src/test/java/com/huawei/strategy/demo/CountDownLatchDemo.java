package com.huawei.strategy.demo;

import com.huawei.strategy.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: WangChunHui
 * @Date: 2020-06-07 22:30
 * @Description:
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEachCountryEnum(i).getRetMessage()).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"**********秦帝国，一统华夏");
    }
}
