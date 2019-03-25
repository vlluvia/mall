package com.demo.mall.web;

import com.demo.mall.entities.Test;
import com.demo.mall.service.TestService;
import com.demo.mall.utils.ResultMessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/getTest/{id}")
    public ResultMessageBuilder.ResultMessage addBlacklist(@PathVariable int id) {

        Test test = testService.queryTest(id);

        return ResultMessageBuilder.success(test);
    }

}
