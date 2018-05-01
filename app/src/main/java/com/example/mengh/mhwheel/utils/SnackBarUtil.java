package com.example.mengh.mhwheel.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by HDM on 2017/12/22.
 * E-mail menghedianmo@163.com
 * author HDM
 */
public class SnackBarUtil {

    public static void show(View rootView, int textId) {
        Snackbar.make(rootView, textId, Snackbar.LENGTH_SHORT).show();
    }

    public static void show(View rootView, String text) {
        Snackbar.make(rootView, text, Snackbar.LENGTH_SHORT).show();
    }
}
