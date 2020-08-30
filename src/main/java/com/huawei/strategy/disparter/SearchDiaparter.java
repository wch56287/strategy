package com.huawei.strategy.disparter;

import com.huawei.strategy.entity.E2ePage;
import com.huawei.strategy.entity.Result;
import com.huawei.strategy.enums.SearchType;
import com.huawei.strategy.entity.RequestPara;
import com.huawei.strategy.service.CodeSearchService;
import com.huawei.strategy.service.PipelineSearchService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author
 * @date 2020/5/23 13:38
 * @description 各种查询的控制器
 */
@Component
public class SearchDiaparter implements  InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 用来存储8个查询的实体类对象
     */
    private final List<CallBackStrategy> callBackStrategyList = new ArrayList<>();

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 10,
            100, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(200));


    public Result search(RequestPara requestPara) {
        Result result = new Result();

        SearchType searchType = requestPara.getSearchType();

        List<E2ePage> list = new CopyOnWriteArrayList<>();

        if (searchType == null) {
            CountDownLatch countDownLatch = new CountDownLatch(callBackStrategyList.size());
            for (CallBackStrategy callBackStrategy : callBackStrategyList) {
                executor.execute(() -> {
                    E2ePage e2ePage = callBackStrategy.search(requestPara);
                    list.add(e2ePage);
                    countDownLatch.countDown();

                });
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            CallBackStrategy callBackStrategy = getSearch(searchType);
            if (callBackStrategy != null) {
                E2ePage e2ePage = callBackStrategy.search(requestPara);
                list.add(e2ePage);
            }
        }

        result.setE2ePages(list);

        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        callBackStrategyList.add(applicationContext.getBean(PipelineSearchService.class));
        callBackStrategyList.add(applicationContext.getBean(CodeSearchService.class));
    }

    private CallBackStrategy getSearch(SearchType searchType) {
        for (CallBackStrategy callBackStrategy : callBackStrategyList) {
            if (callBackStrategy.isOwn(searchType)) {
                return callBackStrategy;
            }
        }
        return null;
    }

}
