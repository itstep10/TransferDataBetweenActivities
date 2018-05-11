package org.itstep.transferdatabetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity
{
    public static final String MESSAGE_RESULT = "org.itstep.transferdatabetweenactivities.message_result";
    private static final String TAG = "DebugSecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent != null)
        {
            String message = "Empty result";
            if(intent.hasExtra(MainActivity.TAG_MESSAG))
                message = intent.getStringExtra(MainActivity.TAG_MESSAG);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.activity_second);
        Button button = findViewById(R.id.b_back);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.putExtra(MESSAGE_RESULT, "Hi! I'm from Second Activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop()
    {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onPause()
    {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onDestroy()
    {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
