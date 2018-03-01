package com.cmpe277.yaminimuralidharen.androidassignment1;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.content.Intent;

public class ActivityB extends Activity {
public int counterB =0, ctr =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
           counterB= extras.getInt("ctrvalue");
        }
        Log.w("ActivityB","ctrvalue" +counterB);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //MainActivity.counter++;

    }

    public void closeActivity(View v) {
        ctr=counterB + 1;
        Intent intent = new Intent();
        intent.putExtra("ctrvalue",ctr);
        setResult(200,intent);
        ActivityB.this.finish();
    }
}
