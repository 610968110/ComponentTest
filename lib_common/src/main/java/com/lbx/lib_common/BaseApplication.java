package com.lbx.lib_common;

import android.app.Application;
import android.support.annotation.CallSuper;

import lbx.xtoollib.XTools;

import static lbx.xtoollib.phone.xLogUtil.LEVEL_NONE;
import static lbx.xtoollib.phone.xLogUtil.LEVEL_VERBOSE;

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
 * @date 2018/12/10.
 */

public abstract class BaseApplication extends Application {

    @CallSuper
    @Override
    public void onCreate() {
        super.onCreate();
        boolean debug = XTools.ApkUtil().isApkInDebug(this);
        new XTools.Builder()
                .log(/*是否打印log*/true)
                .logTag(/*设置log的tag*/"xys")
                .logLevel(/*设置显示log的级别*/debug ? LEVEL_VERBOSE : LEVEL_NONE)
//                .logLevel(/*设置显示log的级别*/debug ? LEVEL_VERBOSE : LEVEL_VERBOSE)
                .errLogFilePath(/*设置crashLog的文件存储路径*/"JwPortal")
                .errLogFileName(/*设置crashLog的文件存储名*/"ERR")
                .errLogFile(
                            /*是否打印到文件*/true,
                            /*是否打印到log*/debug)
                .logPrintFile(
                            /*是否打印log到文件*/true,
                            /*打印log文件在sd卡下的路径*/"JwPortal/log",
                            /*打印到file的log是否加密(des+base64对称加密), null为不加密*/ null)
                .build(this)
                .init();
        onCreate(debug);
    }

    public abstract void onCreate(boolean isDebug);
}
