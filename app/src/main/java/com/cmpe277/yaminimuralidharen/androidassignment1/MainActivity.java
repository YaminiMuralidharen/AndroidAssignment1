package com.cmpe277.yaminimuralidharen.androidassignment1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
private Button BActivitybutton,dialogButton;
private TextView ctrTextView;
private Intent activityIntent;
public  int counter=0;
private boolean isAcreated= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("ActivityA","OnCreate Called");
        BActivitybutton = findViewById(R.id.activitybutton);
        dialogButton =findViewById(R.id.dialogbutton);
        ctrTextView=findViewById(R.id.thcountstringval);
        ctrTextView.setText(String.valueOf(counter));
        BActivitybutton.setOnClickListener(this);
        dialogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
              //  counter++;

                Intent dialogIntent= new Intent(MainActivity.this,DialogActivity.class);
               // incrementCounter();
                onBackPressed();
                ctrTextView.setText(String.format("%04d", counter));
                dialogIntent.putExtra("ctrvalue",counter);
                startActivityForResult(dialogIntent,100);
                    }


        });

}
    @Override
    public void onClick(View v) {
      //  Intent activityIntent;
       // super.onPause();
        onBackPressed();
        Log.w("ActivityA","Calling B + COUNTER VALUE NOW" + counter);
        activityIntent=new Intent(this,ActivityB.class);
        ctrTextView.setText(String.format("%04d", counter));
        activityIntent.putExtra("ctrvalue",counter);
        startActivityForResult(activityIntent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==100 && resultCode == 200) {
        Bundle bundle = data.getExtras();
        if(bundle!=null) {
            counter =  bundle.getInt("ctrvalue");

        }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("ActivityA","onStart called");
    }

    @Override
    protected void onPause() {
      // ++counter;
       // onBackPressed();
        super.onPause();
       // counter++;
        Log.w("ActivityA","onPause called");
        Log.w("ActivityA","counter value" + counter);

    }
    @Override
    public void onStop() {
      super.onStop();
        Log.w("ActivityA","onStop called");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.w("ActivityA","onResume called");
        ctrTextView.setText(String.format("%04d", counter));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("ActivityA","onDestroy called");
    }
    private void incrementCounter(){
        counter++;
    }
    public void closeActivityA(View v) {

        MainActivity.this.finish();

    }

    @Override
    public void onBackPressed() {
        super.onPause();
       ++counter;
        Log.w("ActivityA","onbackpressed called");
    }
}
