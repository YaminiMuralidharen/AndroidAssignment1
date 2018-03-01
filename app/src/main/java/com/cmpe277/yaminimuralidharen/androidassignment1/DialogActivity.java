package com.cmpe277.yaminimuralidharen.androidassignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;


public class DialogActivity extends Activity {
    private int counterD =0, ctr =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        this.setFinishOnTouchOutside(false);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            counterD= extras.getInt("ctrvalue");
        }
        Log.w("DialogActivity","ctrvalue" +counterD);
    }

    public void closeDialog(View v) {
        ctr=counterD + 1;
        Intent intent = new Intent();
        intent.putExtra("ctrvalue",ctr);
        setResult(200,intent);
        DialogActivity.this.finish();
    }
}
