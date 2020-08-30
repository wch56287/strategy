package com.huawei.strategy.controller;

import com.huawei.strategy.entity.Result;
import com.huawei.strategy.entity.RequestPara;
import com.huawei.strategy.disparter.SearchDiaparter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "用户审计", description = "用户审计API", position = 100, protocols = "http")
@RestController
@RequestMapping(value = "/user")
public class Controller {

    @Autowired
    private SearchDiaparter searchDiaparter;

    @GetMapping(value = "/action")
    @ApiOperation(value = "获取用户列表", notes = "查询用户列表")
    public Result get(@ModelAttribute RequestPara requestPara) {
        long t1=System.currentTimeMillis();

        Result result = searchDiaparter.search(requestPara);

        System.out.println("一共耗时："+(System.currentTimeMillis()-t1)+"毫秒");
        return result;
    }
}