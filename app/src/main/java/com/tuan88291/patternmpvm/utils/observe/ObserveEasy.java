package com.tuan88291.patternmpvm.utils.observe;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class ObserveEasy {
    protected abstract AutoDisposable getDispose();

    protected abstract Object doBackground();

    protected void onSuccess(Object result) {
    }

    protected void onLoading() {
    }

    protected void onLoadComplete() {
    }

    protected void onFail(String err) {

    }

    protected ObserveEasy() {
        this.onLoading();
        Disposable dowork = Observable.fromCallable(this::doBackground)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Object>() {

                    @Override
                    public void onNext(Object o) {
                        try {
                            onSuccess(o);
                        } catch (Exception e) {
                            onFail(e.getLocalizedMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        onFail(e.getLocalizedMessage());
                        onComplete();
                    }

                    @Override
                    public void onComplete() {
                        onLoadComplete();
                    }
                });
        if (this.getDispose() != null) {
            AutoDisposable autoDisposable = this.getDispose();
            ExtensionDispose.addTo(dowork, autoDisposable);
        }
    }

}
