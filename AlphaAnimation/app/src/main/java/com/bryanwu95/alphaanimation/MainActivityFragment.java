package com.bryanwu95.alphaanimation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_main,container,false);
        rootView.findViewById(R.id.btnAnimateMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlphaAnimation alphaAnimation=new AlphaAnimation(0,1); //Í¸Ã÷¶ÈÎª0-1
//                alphaAnimation.setDuration(3000);
//                v.startAnimation(alphaAnimation);
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.aa));
            }
        });
        return rootView;
    }
}
