package com.bryanwu95.customanimation;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Bryan on 2015/6/15.
 */
public class CustomAnimation extends Animation{
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        //t.getMatrix().setTranslate(200*interpolatedTime,200*interpolatedTime);
        t.getMatrix().setTranslate((float)Math.sin(interpolatedTime*40)*50,0);

        super.applyTransformation(interpolatedTime, t);


    }
}
