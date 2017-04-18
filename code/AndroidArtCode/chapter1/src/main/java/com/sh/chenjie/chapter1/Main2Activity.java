package com.sh.chenjie.chapter1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

  private String TAG="MainActivity 2 ";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    Button btn = (Button) findViewById(R.id.buttonJump);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(Main2Activity.this, MainActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
      }
    });
    Button btn2 = (Button) findViewById(R.id.button2);
    btn2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(Main2Activity.this, Main3Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
      }
    });
  }

  @Override
  protected void onRestart() {
    Log.d(TAG, "Chapter1  onRestart 1");
    super.onRestart();

  }

  @Override
  protected void onStart() {
    Log.d(TAG, "Chapter1  onStart 1");
    super.onStart();

  }

  @Override
  protected void onResume() {
    Log.d(TAG, "Chapter1  onResume 1");
    super.onResume();

  }

  @Override
  protected void onPause() {
    Log.d(TAG, "Chapter1  onPause 1");
    super.onPause();

  }

  @Override
  protected void onStop() {
    Log.d(TAG, "Chapter1  onStop 1");
    super.onStop();

  }

  @Override
  protected void onDestroy() {
    Log.d(TAG, "Chapter1  onDestroy 1");
    super.onDestroy();

  }

  @Override
  protected void onNewIntent(Intent intent) {
    Log.d(TAG, "Chapter1  onNewIntent 1");
    super.onNewIntent(intent);

  }

}
