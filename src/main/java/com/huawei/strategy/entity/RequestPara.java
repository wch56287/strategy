package com.huawei.strategy.entity;

import com.huawei.strategy.enums.SearchType;
import lombok.Data;

/**
 * @author
 * @date 2020/5/23 13:31
 * @description  controller参数实体类
 */
@Data
public class RequestPara {

    private SearchType searchType;

    private String userId;

    private String userName;

    private Integer pageNum;

    private Integer pageSize;

}
