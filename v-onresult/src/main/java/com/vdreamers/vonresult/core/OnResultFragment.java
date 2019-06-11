package com.vdreamers.vonresult.core;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import androidx.fragment.app.Fragment;

/**
 * 跳转结果返回发起者-无视图Fragment
 * <p>
 * date 2019/02/12 14:05:47
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Mr.D</a>
 */
public class OnResultFragment extends Fragment {

    private Map<Integer, OnResultCallBack> mCallbacks = new HashMap<>();

    public OnResultFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startForResult(Intent intent, int requestCode, OnResultCallBack onResultCallBack) {
        mCallbacks.put(requestCode, onResultCallBack);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // callback方式的处理
        OnResultCallBack onResultCallBack = mCallbacks.remove(requestCode);
        if (onResultCallBack != null) {
            onResultCallBack.onActivityResult(requestCode, resultCode, data);
        }
    }
}
