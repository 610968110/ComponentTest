package com.lbx.module1.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/yourservicegroupname/helloAgain", name = "测试服务again")
public class HelloAgainServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello again, " + name;
    }

    @Override
    public void init(Context context) {

    }
}