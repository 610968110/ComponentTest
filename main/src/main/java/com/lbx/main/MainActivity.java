package com.lbx.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author lbx
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void module1Activity(View view) {
        ARouter.getInstance().build("/module1/module1Activity").navigation();
    }

    public void module1ActivityWithParams(View view) {
        ARouter.getInstance()
                .build("/module1/module1Activity")
                .withString("name", "测试")
                .navigation();
    }

    public void url(View view) {
        ARouter.getInstance()
                .build("/test/webview")
                .withString("url", "file:///android_asset/schame-test.html")
                .navigation();
    }

    public void service(View view) {
        new ServiceTest().testService();
    }

    public void asyncService(View view) {
        new AsyncServiceTest().test((s) -> Toast.makeText(this, s, Toast.LENGTH_SHORT).show());
    }

    public void fragment(View view) {
        Fragment fragment = (Fragment) ARouter.getInstance()
                .build("/module1/module1Fragment")
                .navigation();
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_main, fragment)
                    .commitAllowingStateLoss();
        }
    }
}
