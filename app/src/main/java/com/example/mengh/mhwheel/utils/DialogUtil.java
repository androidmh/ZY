package com.example.mengh.mhwheel.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;



public class DialogUtil {

    public static AlertDialog getAlertDialog(Context context, String msg, String btName) {
        final AlertDialog alert = new AlertDialog.Builder(context).create();
        alert.setMessage(msg);
        alert.setButton(DialogInterface.BUTTON_NEGATIVE, btName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.dismiss();
            }
        });
        return alert;
    }

    public static AlertDialog getAlertDialog(Context context, String msg, String btName,
                                             DialogInterface.OnClickListener onclickListener) {
        final AlertDialog alert = new AlertDialog.Builder(context).create();
        alert.setMessage(msg);
        alert.setCancelable(false);
        alert.setButton(DialogInterface.BUTTON_POSITIVE, btName, onclickListener);
        return alert;
    }

    public static AlertDialog getAlertDialog(Context context, String title, String msg, String btName,
                                             DialogInterface.OnClickListener onclickListener) {
        final AlertDialog alert = new AlertDialog.Builder(context).create();
        alert.setTitle(title);
        alert.setMessage(msg);
        alert.setCancelable(false);
        alert.setButton(DialogInterface.BUTTON_POSITIVE, btName, onclickListener);
        return alert;
    }

    public static AlertDialog getAlertDialog(Context context, String title, String msg, String commitName,
                                             String cancelName, DialogInterface.OnClickListener onClick) {
        AlertDialog alert;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.setPositiveButton(commitName, onClick);
        builder.setNegativeButton(cancelName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert = builder.create();
        return alert;
    }

    public static AlertDialog getAlertDialog(Context context, String title, String msg, String commitName,
                                             String cancelName, DialogInterface.OnClickListener onClick, DialogInterface.OnClickListener oncanClick) {
        AlertDialog alert;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.setPositiveButton(commitName, onClick);
        builder.setNegativeButton(cancelName, oncanClick);
        alert = builder.create();
        return alert;
    }

    public static AlertDialog getAlertDialog(Context context, String msg, String items[],
                                             DialogInterface.OnClickListener onclickListener) {
        final AlertDialog alert = new AlertDialog.Builder(context).setItems(items, onclickListener).create();
        alert.setTitle(msg);
        alert.setCancelable(true);
        return alert;
    }

    public static AlertDialog getAlertDialog(Context context, String msg, String items[], String btName,
                                             DialogInterface.OnClickListener onclickListener,
                                             DialogInterface.OnClickListener onclickListener1) {
        final AlertDialog alert = new AlertDialog.Builder(context).setItems(items, onclickListener).create();
        alert.setTitle(msg);
        alert.setCancelable(false);
        alert.setButton(DialogInterface.BUTTON_POSITIVE, btName, onclickListener1);
        return alert;
    }


    public static ProgressDialog getProgressDialog(Context context, String msg) {
        return getProgressDialog(context, msg, false);
    }

    public static ProgressDialog getProgressDialog(Context context, String msg, boolean isCancelable) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(false);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(isCancelable);
        return progressDialog;
    }


	/**
	 * 显示长按选择对话框
	 *
	 * @param ctx
	 * 			上下文
	 * @param title
	 * 			标题(如果为null，则没有标题)
	 * @param items
	 * 			选项
	 * @param onClickListener
	 * 			点击时的监听
	 */
	public static void showOnLongClickDialog(final Context ctx, String title,String[] items,DialogInterface.OnClickListener onClickListener)
	{
		// 构建对话框
		AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(ctx, android.R.style.Theme_Holo_Light_Dialog));
		if(null != title)
		{
			builder.setTitle(title);
		}

		// 设置点击
		builder.setItems(items, onClickListener);

		// 显示对话框
		AlertDialog alertDialog = builder.create();
		alertDialog.setCanceledOnTouchOutside(true);
		alertDialog.show();
	}
}
