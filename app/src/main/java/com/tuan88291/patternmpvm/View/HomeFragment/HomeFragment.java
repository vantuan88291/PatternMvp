package com.tuan88291.patternmpvm.View.HomeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tuan88291.patternmpvm.BaseFragment;
import com.tuan88291.patternmpvm.R;
import com.tuan88291.patternmpvm.databinding.HomeFragmentBinding;

import androidx.databinding.DataBindingUtil;

public class HomeFragment extends BaseFragment {
    private HomeFragmentBinding binding;
    @Override
    protected View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    protected void viewCreated(View view, Bundle savedInstanceState) {

        Toast.makeText(mContext(), "test", Toast.LENGTH_SHORT).show();
    }
}
