package com.lbx.module1.asyncService;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
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
@Route(path = "/com/asyncService", name = "异步服务")
public class AsyncServiceImpl implements IAsyncService {

    @Override
    public void sayAsync(AsyncListener listener) {
        if (listener != null) {
            listener.callback("say async");
        }
    }

    @Override
    public void init(Context context) {

    }
}
