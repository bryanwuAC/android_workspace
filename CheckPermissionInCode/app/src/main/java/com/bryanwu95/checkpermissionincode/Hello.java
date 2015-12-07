package com.bryanwu95.checkpermissionincode;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Bryan on 2015/6/10.
 */
public class Hello {
    public static final String PERMISSION_SAY_HELLO="com.bryanwu95.checkpermissionincode.permission.SAY_HELLO";
    public static void sayHello(Context context){
        int checkResult=context.checkCallingOrSelfPermission(PERMISSION_SAY_HELLO);
        if(checkResult!= PackageManager.PERMISSION_GRANTED){
            throw new SecurityException("Execute sayHello method need com.bryanwu95.checkpermissionincode.permission.SAY_HELLO Permission");
        }
        System.out.println("Hello Bryan Wu");

    }
}
