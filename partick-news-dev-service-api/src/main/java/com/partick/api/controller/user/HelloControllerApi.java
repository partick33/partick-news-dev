package com.partick.api.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * api的作用：
 * api相当于企业的领导，老板，部门经理
 * 其他服务层都是实现，他们相当于员工
 *
 * 运作：
 * 现在所有的接口都在此暴露，实现都是在各自的微服务中
 * @author partick_peng
 */
@Api(value = "部署集合测试Api")
public interface HelloControllerApi {

    /**
     * 项目整合测试api
     * @return
     */
    @ApiOperation(value = "hello测试方法接口",notes = "hello方法",httpMethod = "GET")
    @GetMapping("/hello")
    Object Hello();
}
