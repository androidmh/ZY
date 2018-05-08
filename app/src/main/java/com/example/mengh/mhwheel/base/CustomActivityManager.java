/**
 * Project Name:ThreeTiProject
 * Package Name:com.threeti.threetiproject
 * File Name:CustomActivityManager.java
 * Function: 自定义Activity堆栈管理器. <br/>
 * Description: 自定义Activity管理器，用来自定义维护手机Activity堆栈.方便一次性关闭对个界面 <br/>
 */
package com.example.mengh.mhwheel.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class CustomActivityManager {
    /**
     * Activity堆栈,私有变量，不可更改
     */
    private Stack<Activity> activityStack;
    /**
     * Activity自定义管理器单例类，通过单例方法getInstance获取
     */
    private static CustomActivityManager instance;

    /**
     * Creates a new instance of CustomActivityManager.
     * 在构造函数中对Activity堆栈进行了实例化.
     */
    public CustomActivityManager() {
        activityStack = new Stack<>();
    }

    /**
     * getInstance:单例模式，获取CustomActivityManager的实例对象. <br/>
     * 此方法最好在Application里面调用，且在Application里面存放CustomActivityManager的实例化对象防止内存被释放
     * .<br/>
     *
     * @return CustomActivityManager 实例化对象
     */
    public static CustomActivityManager getInstance() {
        if (instance == null) {
            instance = new CustomActivityManager();
        }
        return instance;
    }

    /**
     * popActivity:退出堆栈里面指定的Activity. <br/>
     * 注意该方法只是将Activity从堆栈中移除，并没有将Activity关闭.<br/>
     *
     * @param activity 需要移除的Activity对象
     * @return boolean 如果指定的activity存在，则返回成功，否则返回失败
     */
    public boolean popActivity(Activity activity) {
        return activity != null && activityStack.remove(activity);
    }

    /**
     * currentActivity:得到当前堆栈中的栈顶Activity. <br/>
     * 返回当前自定义Activity堆栈中的栈顶元素，当当前Activity堆栈中为空时，则返回NULL对象.<br/>
     *
     * @return Activity or null 栈顶的Activity，可能未空
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (!activityStack.empty()) {
            activity = activityStack.lastElement();
        }
        return activity;
    }

    /**
     * pushActivity:将当前Activity推入栈中. <br/>
     *
     * @param activity 需要存放的Activity，主要不能为空
     */
    public void pushActivity(Activity activity) {
        if (activity != null) {
            activityStack.add(activity);
        }
    }

    /**
     * popAllActivity:退出栈中所有Activity，并且关闭所有的Activity. <br/>
     * 调用该方法后，所有的界面都会被关闭.<br/>
     */
    public void popAllActivity() {
        popAllActivityExceptOne(new ArrayList<Class<?>>());
    }

    /**
     * popAllActivityExceptOne:出了指定的Activity界面不关闭以后，关闭其他所有的Activity. <br/>
     *
     * @param cls 不需要关闭的界面
     */
    public void popAllActivityExceptOne(Class<?> cls) {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                return;
            }
            if (activity.getClass().equals(cls)) {
                return;
            }
            activity.finish();
        }
    }

	/**
	 * 上面方法有问题，并不会关闭所有的
	 *
	 * @param cls
	 * 			不需要关闭的界面
	 */
	public void popAllActivityExcept(Class<?> cls)
	{
		Activity clsActivity = null;
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
			if (activity.getClass().equals(cls)) {
				clsActivity = activity;
				popActivity(activity);
				continue;
			}
			activity.finish();
		}
		pushActivity(clsActivity);
	}

    /**
     * popAllActivityExceptOne:出了指定的Activity界面不关闭以后，关闭其他所有的Activity. <br/>
     *
     * @param list 不需要关闭的界面
     */
    public void popAllActivityExceptOne(List<Class<?>> list) {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                return;
            }
            if(null != list)
            {
                for (Class<?> cls : list)
                {
                    if (activity.getClass().equals(cls)) {
                        return;
                    }
                }
            }
            activity.finish();
        }
    }

}
