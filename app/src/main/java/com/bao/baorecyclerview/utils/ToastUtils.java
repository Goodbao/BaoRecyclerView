package com.bao.baorecyclerview.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.bao.baorecyclerview.BaseApplication;


public class ToastUtils {
    private static Toast toast;

    /**
     * 显示长时间的Toast
     *
     * @param message 消息
     */
    public static void showLongToast(String message) {
        if (BaseApplication.getInstance() == null)
            return;
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getInstance(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(message);
            toast.show();
        }
    }

    /**
     * 显示短时间Toast
     *
     * @param message 消息
     */
    public static void showShortToast(String message) {
        if (BaseApplication.getInstance() == null)
            return;
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getInstance(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(message);
            toast.show();
        }
    }

    public static void cancelToast() {
        if (toast != null) {
            toast.cancel();
        }
    }
}
