package com.huawei.strategy.disparter;

import com.huawei.strategy.entity.E2ePage;
import com.huawei.strategy.entity.Result;
import com.huawei.strategy.enums.SearchType;
import com.huawei.strategy.entity.RequestPara;


public interface CallBackStrategy  {

    /**
     * 该返回值用来判断是否是用来查询该枚举类型的方法
     *
     * @param searchType
     * @return
     */
    boolean isOwn(SearchType searchType);

    /**
     * 查询
     *
     * @param requestPara
     * @return
     */
    E2ePage search(RequestPara requestPara);

}
