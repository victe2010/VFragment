package com.victe.victefragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 13526 on 2017/10/28.
 */

public class BaseFragment extends Fragment {
    protected LayoutInflater inflater;
    private View contentView;
    private Context context;
    private ViewGroup container;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity().getApplicationContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        onCreateView(savedInstanceState);
        if (contentView == null)
            return super.onCreateView(inflater, container, savedInstanceState);
        return contentView;
    }

    protected void onCreateView(Bundle savedInstanceState) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (contentView != null){
            contentView = null;
        }
        if (container != null){
            container = null;
        }
        if (inflater != null){
            inflater = null;
        }
    }
    public Context getApplicationContext() {
        return context;
    }
    public void setContentView(int layoutResID) {
        setContentView((ViewGroup) inflater.inflate(layoutResID, container, false));
    }
    public void setContentView(View view) {
        contentView = view;
    }
    public View getContentView() {
        return contentView;
    }
    public View findViewById(int id) {
        if (contentView != null)
            return contentView.findViewById(id);
        return null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    //获取状态栏高度
    protected int getStatuesHeight() {
        int statusBarHeight1 = -1;
        int resourceId = getActivity().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight1 = getActivity().getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;
    }

}
