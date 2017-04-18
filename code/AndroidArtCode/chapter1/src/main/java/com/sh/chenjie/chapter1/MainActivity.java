package com.sh.chenjie.chapter1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  private String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d(TAG, "Chapter1  onCreate");

    Button btn = (Button) findViewById(R.id.buttonJump);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(MainActivity.this, Main2Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       startActivity(intent);
      }
    });
    Button btn2 = (Button) findViewById(R.id.button2);
    btn2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(MainActivity.this, Main3Activity.class);

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

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    Log.d(TAG, "Chapter1  onRestoreInstanceState 1");
    super.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
    Log.d(TAG, "Chapter1  onRestoreInstanceState 2");
    super.onRestoreInstanceState(savedInstanceState, persistentState);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    Log.d(TAG, "Chapter1  onSaveInstanceState 1");
    super.onSaveInstanceState(outState);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    Log.d(TAG, "Chapter1  onSaveInstanceState 2");
    super.onSaveInstanceState(outState, outPersistentState);
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    Log.d(TAG, "Chapter1  onConfigurationChanged 1");
    super.onConfigurationChanged(newConfig);
  }
}
