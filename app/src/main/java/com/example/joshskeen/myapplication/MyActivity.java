package com.example.joshskeen.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {

    Button mClickMeButton;
    TextView mHelloWorldTextView;
    TextView mBuildConfigTextView;
    TextView mProductFlavorTextView;
    private TextView mApplicationIdTextView;
    private TextView mPackageNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mHelloWorldTextView = (TextView) findViewById(R.id.helloWorldTextView);

        mClickMeButton = (Button) findViewById(R.id.clickMeBtn);
        mClickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHelloWorldTextView.setText("HEY WORLD");
            }
        });

        mBuildConfigTextView = (TextView) findViewById(R.id.buildConfigTextView);
        // ignore missing BuildConfig warning

        String buildType;
        if (BuildConfig.DEBUG)  {
            buildType = "debug";
        } else {
            buildType = "release";
        }
        buildType = "build type: " + buildType;
        mBuildConfigTextView.setText(buildType);

        mProductFlavorTextView = (TextView) findViewById(R.id.productFlavorTextView);
        String flavor = "product flavor: " + AppConstants.FLAVOR;
        mProductFlavorTextView.setText(flavor);

        // it should be noted that the API is not updated to reflect the split between applicationId and PackageName
        // http://tools.android.com/tech-docs/new-build-system/applicationid-vs-packagename
        // so the method getPackageName() is a bit misleading. Its technically getApplicationId()
        mApplicationIdTextView = (TextView) findViewById(R.id.applicationIdTextView);
        String applicationId = "applicationId: " + this.getPackageName();
        mApplicationIdTextView.setText(applicationId);

        mPackageNameTextView = (TextView) findViewById(R.id.packageNameTextView);
        String packageName = "package name: " + this.getClass().getPackage().getName();
        mPackageNameTextView.setText(packageName);
    }
}
