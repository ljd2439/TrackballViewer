package com.example.jaedong.trackballviewer;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Viewer extends AppCompatActivity {

    private GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLSurfaceView = new TouchSurfaceView(this);
        setContentView(mGLSurfaceView);
        //mGLSurfaceView.requestFocus();
        //mGLSurfaceView.setFocusableInTouchMode(true);
    }

    @Override
    protected void onResume() {

        super.onResume();
        mGLSurfaceView.onResume();
    }
    @Override
    protected void onPause() {

        super.onPause();
        mGLSurfaceView.onPause();
    }
}


