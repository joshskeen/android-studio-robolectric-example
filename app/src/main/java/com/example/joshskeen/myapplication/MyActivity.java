package com.example.joshskeen.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity
{

    private Button mClickMeButton;
    private Button mClickMeButton2;
    private TextView mHelloWorldTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mHelloWorldTextView = (TextView) findViewById(R.id.helloWorldTextView);
        mClickMeButton = (Button) findViewById(R.id.clickMeBtn);
        mClickMeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mHelloWorldTextView.setText("HEY WORLD");
            }
        });
        mClickMeButton2 = (Button) findViewById(R.id.clickMeBtn2);
        mClickMeButton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mHelloWorldTextView.setText("HEY WORLD 2");
            }
        });
    }
}
