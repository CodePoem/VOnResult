package com.vdreamers.vonresult.core;

import android.content.Intent;

/**
 * 返回结果回调接口
 * <p>
 * date 2019/02/12 14:15:37
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Mr.D</a>
 */
public interface OnResultCallBack {

    /**
     * 返回结果回调方法
     *
     * @param requestCode 请求码
     * @param resultCode  结果码
     * @param data        返回结果意图
     */
    void onActivityResult(int requestCode, int resultCode, Intent data);
}
