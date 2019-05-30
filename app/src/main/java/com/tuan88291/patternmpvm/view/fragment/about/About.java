package com.tuan88291.patternmpvm.view.fragment.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.tuan88291.patternmpvm.BaseFragment;
import com.tuan88291.patternmpvm.R;
import com.tuan88291.patternmpvm.databinding.AboutFragmentBinding;

import androidx.databinding.DataBindingUtil;

public class About extends BaseFragment implements AboutContract {
    private AboutFragmentBinding binding;
    @Override
    protected View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.about_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    protected void viewCreated(View view, Bundle savedInstanceState) {

        getLifecycle().addObserver(AboutPresenter.getInstance().setCallback(this));
        binding.title.setText(mContext().getItem());

    }

    @Override
    public void inCreate() {
        LogUtils.a("inCreate");
    }

    @Override
    public void inResume() {
        LogUtils.a("in inResume");


    }

    @Override
    public void indestroy() {
        LogUtils.a("in indestroy");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(AboutPresenter.getInstance());
    }
}
