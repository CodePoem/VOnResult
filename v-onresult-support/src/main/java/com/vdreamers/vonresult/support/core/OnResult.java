package com.vdreamers.vonresult.support.core;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


/**
 * 跳转结果返回发起者
 * <p>
 * date 2019/02/12 14:05:17
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Mr.D</a>
 */
public class OnResult {
    private static final String TAG = OnResult.class.getSimpleName();
    Lazy<OnResultFragment> mOnResultFragment;

    public OnResult(@NonNull final Activity activity) {
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            mOnResultFragment = getLazySingleton(fragmentActivity.getSupportFragmentManager());
        }
    }

    public OnResult(@NonNull final FragmentActivity activity) {
        mOnResultFragment = getLazySingleton(activity.getSupportFragmentManager());
    }

    public OnResult(@NonNull final Fragment fragment) {
        mOnResultFragment = getLazySingleton(fragment.getChildFragmentManager());
    }

    public static OnResult of(@NonNull final Activity activity) {
        return new OnResult(activity);
    }

    public static OnResult of(@NonNull final FragmentActivity activity) {
        return new OnResult(activity);
    }

    public static OnResult of(@NonNull final Fragment fragment) {
        return new OnResult(fragment);
    }

    @NonNull
    private Lazy<OnResultFragment> getLazySingleton(@NonNull final FragmentManager fragmentManager) {
        return new Lazy<OnResultFragment>() {

            private OnResultFragment onResultFragment;

            @Override
            public synchronized OnResultFragment get() {
                if (onResultFragment == null) {
                    onResultFragment = getOnResultFragment(fragmentManager);
                }
                return onResultFragment;
            }

        };
    }

    private OnResultFragment getOnResultFragment(@NonNull final FragmentManager fragmentManager) {
        OnResultFragment onResultFragment = findOnResultFragment(fragmentManager);
        boolean isNewInstance = onResultFragment == null;
        if (isNewInstance) {
            onResultFragment = new OnResultFragment();
            fragmentManager
                    .beginTransaction()
                    .add(onResultFragment, TAG)
                    .commitNowAllowingStateLoss();
        }
        return onResultFragment;
    }

    private OnResultFragment findOnResultFragment(@NonNull final FragmentManager fragmentManager) {
        return (OnResultFragment) fragmentManager.findFragmentByTag(TAG);
    }

    /**
     * 发起跳转请求
     *
     * @param intent           跳转裁剪意图
     * @param requestCode      请求码
     * @param onResultCallBack 跳转结果回调
     */
    public void start(Intent intent, int requestCode, OnResultCallBack onResultCallBack) {
        if (mOnResultFragment == null) {
            return;
        }
        mOnResultFragment.get().startForResult(intent, requestCode, onResultCallBack);
    }

    @FunctionalInterface
    public interface Lazy<V> {
        /**
         * 懒加载
         *
         * @return 返回懒加载对象
         */
        V get();
    }
}
