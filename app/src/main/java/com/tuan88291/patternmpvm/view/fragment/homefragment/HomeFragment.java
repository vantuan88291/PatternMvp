package com.tuan88291.patternmpvm.view.fragment.homefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.tuan88291.patternmpvm.BaseFragment;
import com.tuan88291.patternmpvm.data.local.entity.DataRoom;
import com.tuan88291.patternmpvm.R;
import com.tuan88291.patternmpvm.data.local.room.livedata.MyViewModel;
import com.tuan88291.patternmpvm.databinding.HomeFragmentBinding;
import com.tuan88291.patternmpvm.utils.observe.AutoDisposable;
import com.tuan88291.patternmpvm.utils.observe.ObserveEasy;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class HomeFragment extends BaseFragment implements HomeContract {
    private MyViewModel db;
    private HomeFragmentBinding binding;
    private AutoDisposable autoDisposable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = ViewModelProviders.of(this).get(MyViewModel.class);
        autoDisposable = new AutoDisposable();
        autoDisposable.bindTo(this.getLifecycle());
    }

    @Override
    protected View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    protected void viewCreated(View view, Bundle savedInstanceState) {

        getLifecycle().addObserver(HomePresenter.getInstance().setCallBack(this));
        binding.button.setOnClickListener(view1 -> {

            db.insert(new DataRoom("test", 1));
        });

        db.getAllData().observe(this, this::onDataChange);
        new ObserveEasy() {

            @Override
            protected AutoDisposable getDispose() {
                return autoDisposable;
            }

            @Override
            protected Object doBackground() {

                int a = 4 + 1;
                return a;
            }
        };
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoadComplete() {

    }

    @Override
    public void onError(String mess) {

        Toast.makeText(mContext(), mess, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDataChange(List<DataRoom> data) {
        LogUtils.a(data.size());
        binding.button.setText(data.size() + "");
        mContext().setItem(data.size() + "");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(HomePresenter.getInstance().setCallBack(this));
    }
}
