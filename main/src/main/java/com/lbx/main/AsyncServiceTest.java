package com.lbx.main;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lbx.lib_common.asyncService.AsyncListener;
import com.lbx.lib_common.asyncService.IAsyncService;

/**
 * .  ┏┓　　　┏┓
 * .┏┛┻━━━┛┻┓
 * .┃　　　　　　　┃
 * .┃　　　━　　　┃
 * .┃　┳┛　┗┳　┃
 * .┃　　　　　　　┃
 * .┃　　　┻　　　┃
 * .┃　　　　　　　┃
 * .┗━┓　　　┏━┛
 * .    ┃　　　┃        神兽保佑
 * .    ┃　　　┃          代码无BUG!
 * .    ┃　　　┗━━━┓
 * .    ┃　　　　　　　┣┓
 * .    ┃　　　　　　　┏┛
 * .    ┗┓┓┏━┳┓┏┛
 * .      ┃┫┫　┃┫┫
 * .      ┗┻┛　┗┻┛
 *
 * @author lbx
 * @date 2019/1/15.
 */

public class AsyncServiceTest {

    @Autowired(name = "/com/asyncService")
    IAsyncService asyncService;

    public AsyncServiceTest() {
        ARouter.getInstance().inject(this);
    }

    public void test(AsyncListener listener) {
        if (asyncService != null) {
            asyncService.sayAsync(listener);
        }
    }
}
