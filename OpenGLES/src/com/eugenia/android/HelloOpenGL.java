package com.eugenia.android;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class HelloOpenGL extends Activity {

    private GLSurfaceView mGLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLView = new HelloGLSurfaceView(this);
        setContentView(mGLView);
    }
}
