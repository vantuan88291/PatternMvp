package com.tuan88291.patternmpvm.View.HomeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.tuan88291.patternmpvm.BaseFragment;
import com.tuan88291.patternmpvm.Model.RoomData.DataRoom;
import com.tuan88291.patternmpvm.R;
import com.tuan88291.patternmpvm.Utils.Room.LiveData.MyViewModel;
import com.tuan88291.patternmpvm.databinding.HomeFragmentBinding;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class HomeFragment extends BaseFragment implements HomeContract{
    private MyViewModel db;
    private HomeFragmentBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = ViewModelProviders.of(this).get(MyViewModel.class);
    }

    @Override
    protected View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    protected void viewCreated(View view, Bundle savedInstanceState) {
        HomePresenter presenter = new HomePresenter(mContext(), this);
        presenter.getApi();
        binding.button.setOnClickListener(view1 -> {

            db.insert(new DataRoom("test", 1));
        });

        db.getAllData().observe(this, this::onDataChange);

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onSuccess() {
        LogUtils.a("ok");

    }

    @Override
    public void onError() {
        LogUtils.a("Error");
    }

    @Override
    public void onDataChange(List<DataRoom> data) {
        LogUtils.a(data.size());

    }
}
