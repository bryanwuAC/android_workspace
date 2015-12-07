package com.bryanwu95.learncontext;

import android.app.Application;

/**
 * Created by Bryan on 2015/6/8.
 */
public class App extends Application {
    private String textData="default";

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public String getTextData() {
        return textData;
    }
}
