package com.example.administrator.myfragment610;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Bryan on 2015/6/12.
 */
public class image2Fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView iv=new ImageView(getActivity());
        iv.setImageResource(R.drawable.img2);
        return iv;
    }
}
