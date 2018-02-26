package com.xinmang.feedbackproject.utils;

import android.widget.Toast;

import com.xinmang.feedbackproject.app.Application;


/**
 * Created by jingbin on 2016/12/14.
 * 单例Toast
 */

public class ToastUtil {

    private static Toast mToast;

    public static void showToast(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(Application.getInstance(), text, Toast.LENGTH_SHORT);
        }
        mToast.setText(text+"");
        mToast.show();
    }
}
