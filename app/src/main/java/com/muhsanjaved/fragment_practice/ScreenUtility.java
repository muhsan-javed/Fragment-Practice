package com.muhsanjaved.fragment_practice;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenUtility {

    public float dpHeight;
    public float dpWidth;

    public float getDpHeight() {
        return dpHeight;
    }

    public float getDpWidth() {
        return dpWidth;
    }

    public ScreenUtility(Activity activity){

        Display  display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();

        display.getMetrics(outMetrics);

        float density= activity.getResources().getDisplayMetrics().density;

        dpHeight = outMetrics.heightPixels/density;
        dpWidth = outMetrics.widthPixels/density;

    }
}
