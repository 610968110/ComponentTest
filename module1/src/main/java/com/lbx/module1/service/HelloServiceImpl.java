package com.lbx.module1.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/yourservicegroupname/hello", name = "测试服务")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }

    @Override
    public void init(Context context) {

    }
}