package com.eugenia.android;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class HelloGLSurfaceView extends GLSurfaceView {

    public HelloGLSurfaceView(Context context) {
        super(context);

        // Use OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        // Renderer for drawing on GLSurfaceView
        setRenderer(new HelloRenderer());

        // [OPTIONAL] Render the view only when there is a change in the drawing data
        // Prevents GLSurfaceView from getting redrawn until requestRender(), can be more efficient
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

}
