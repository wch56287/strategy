package com.huawei.strategy.service;

import com.huawei.strategy.disparter.CallBackStrategy;
import com.huawei.strategy.entity.E2ePage;
import com.huawei.strategy.entity.Result;
import com.huawei.strategy.entity.RequestPara;
import com.huawei.strategy.enums.SearchType;
import org.springframework.stereotype.Component;

/**
 * @Author: WangChunHui
 * @Date: 2020-05-24 14:43
 * @Description:
 */
@Component
public class CodeSearchService implements CallBackStrategy {
    @Override
    public boolean isOwn(SearchType searchType) {
        return false;
    }

    @Override
    public E2ePage search(RequestPara requestPara) {
        //code查询的逻辑代码
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("code....");
        return new E2ePage();
    }
}
