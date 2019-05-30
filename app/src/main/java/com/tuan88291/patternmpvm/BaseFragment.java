package com.tuan88291.patternmpvm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuan88291.patternmpvm.view.activity.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment implements BaseView{
    private MainActivity context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setErrorParent(Object data) {
        new AlertDialog.Builder(context)
                .setTitle("Your Alert")
                .setMessage(data.toString())
                .setCancelable(false)
                .setPositiveButton("ok", (dialog, which) -> {

                }).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = setView(inflater,container,savedInstanceState);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (MainActivity) context;
    }

    protected abstract View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    protected abstract void viewCreated(View view, Bundle savedInstanceState);
    protected MainActivity mContext() {
        return this.context;
    }

}
