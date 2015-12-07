package com.bryanwu95.layoutanimation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ScaleAnimation sa=new ScaleAnimation(0,1,0,1);
        sa.setDuration(5000);
        LinearLayout rootView=(LinearLayout)inflater.inflate(R.layout.fragment_main,container,false);
        LayoutAnimationController lac=new LayoutAnimationController(sa,0.5f);
        lac.setOrder(LayoutAnimationController.ORDER_RANDOM);
        rootView.setLayoutAnimation(lac);
        return rootView;
    }
}
