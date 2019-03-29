package com.tuan88291.patternmpvm.utils.observe;

import com.blankj.utilcode.util.LogUtils;

import io.reactivex.disposables.Disposable;

public final class ExtensionDispose {
    public static void addTo(Disposable $receiver, AutoDisposable autoDisposable) {
        try {
            autoDisposable.add($receiver);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.a("faild add");

        }
    }
}
