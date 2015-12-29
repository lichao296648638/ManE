package com.hshy41.mane.utils;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

public class ToastUtil {

	private static Toast mToast = null;

	private static void showToast(Context context, String text, int duration) {
		if (mToast == null) {
			mToast = Toast.makeText(context, text, duration);
		} else {
			mToast.setText(text);
			mToast.setDuration(duration);
		}

		mToast.show();
	}

	/**
	 * 显示吐司通知
	 * 
	 * @param context
	 * @param text
	 */
	public static void showToast(Context context, String text) {
		showToast(context, text, 0);
	}

	/**
	 * 长时间显示通知
	 * 
	 * @param context
	 * @param text
	 */
	public static void showLongToast(Context context, String text) {
		showToast(context, text, 1);
	}
}
