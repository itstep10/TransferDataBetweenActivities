package org.itstep.transferdatabetweenactivities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG_MESSAG = "org.itstep.transferdatabetweenactivities.MainActivity.message";

    private static final String TAG = "DebugMainActivity";
    private static final int ACTIVITY_REQUEST_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.b_go_to_next_activity);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(TAG_MESSAG, "Hi! I came from previe Activity");
                startActivity(intent);
                //startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == ACTIVITY_REQUEST_CODE)
        {
            String message = "Empty result";
            if(data.hasExtra(SecondActivity.MESSAGE_RESULT))
                message = data.getStringExtra(SecondActivity.MESSAGE_RESULT);

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show();
    }
}

