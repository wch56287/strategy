package com.huawei.strategy.service;

import com.huawei.strategy.disparter.CallBackStrategy;
import com.huawei.strategy.entity.E2ePage;
import com.huawei.strategy.entity.Result;
import com.huawei.strategy.entity.RequestPara;
import com.huawei.strategy.enums.SearchType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date 2020/5/23 13:35
 * @description
 */
@Component
public class PipelineSearchService implements CallBackStrategy {
    @Override
    public boolean isOwn(SearchType searchType) {
        return searchType == SearchType.Pipeline;
    }

    @Override
    public E2ePage search(RequestPara requestPara) {
        //pipeline查询的逻辑代码
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pipeline....");
        return new E2ePage();
    }
}
