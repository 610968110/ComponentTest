package com.lbx.main;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lbx.lib_common.service.HelloService;

import lbx.xtoollib.XTools;
import lbx.xtoollib.phone.xLogUtil;

public class ServiceTest {

    @Autowired
    HelloService helloService;

    @Autowired(name = "/yourservicegroupname/hello")
    HelloService helloService2;

    HelloService helloService3;

    HelloService helloService4;

    @Autowired
    HelloService helloAgainService1;
    @Autowired(name = "/yourservicegroupname/helloAgain")
    HelloService helloAgainService2;

    public ServiceTest() {
        ARouter.getInstance().inject(this);
    }

    public void testService() {
        // 1. (推荐)使用依赖注入的方式发现服务,通过注解标注字段,即可使用，无需主动获取
        // Autowired注解中标注name之后，将会使用byName的方式注入对应的字段，不设置name属性，会默认使用byType的方式发现服务(当同一接口有多个实现的时候，必须使用byName的方式发现服务)
        String vergi1 = helloService.sayHello("Vergil1");
        String vergil2 = helloService2.sayHello("Vergil2");

        // 2. 使用依赖查找的方式发现服务，主动去发现服务并使用，下面两种方式分别是byName和byType
        helloService3 = ARouter.getInstance().navigation(HelloService.class);
        helloService4 = (HelloService) ARouter.getInstance().build("/yourservicegroupname/hello").navigation();
        String vergil3 = helloService3.sayHello("Vergil3");
        String vergil4 = helloService4.sayHello("Vergil4");

        String again1 = helloAgainService1.sayHello("again1");
        String again2 = helloAgainService2.sayHello("again2");
        String msg = "vergi1:" + vergi1 + "\n"
                + "vergil2:" + vergil2 + "\n"
                + "vergil3:" + vergil3 + "\n"
                + "vergil4:" + vergil4 + "\n"
                + "again1:" + again1 + "\n"
                + "again2:" + again2 + "\n";
        XTools.UiUtil().showToast(msg);
        xLogUtil.e(msg);
    }
}