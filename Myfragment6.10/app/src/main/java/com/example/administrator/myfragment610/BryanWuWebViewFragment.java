package com.example.administrator.myfragment610;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Bryan on 2015/6/12.
 */
public class BryanWuWebViewFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.bryanwu_webview,container,false);
        WebView wv =(WebView)root.findViewById(R.id.wv);
        wv.loadUrl("http://baidu.com");
        return super.onCreateView(inflater, container, savedInstanceState);

    }
}
