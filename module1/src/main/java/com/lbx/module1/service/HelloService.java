package com.lbx.module1.service;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface HelloService extends IProvider {
    String sayHello(String name);
}
