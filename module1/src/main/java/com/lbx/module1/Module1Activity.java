package com.lbx.module1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author lbx
 */
@Route(path = "/module1/module1Activity")
public class Module1Activity extends AppCompatActivity {

    @Autowired(name = "name")
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);
        ARouter.getInstance().inject(this);
        if (!TextUtils.isEmpty(name)) {
            TextView textView = (TextView) findViewById(R.id.tv_1);
            textView.setText(name);
        }
    }
}
