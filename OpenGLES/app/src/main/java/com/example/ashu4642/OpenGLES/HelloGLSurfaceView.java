package com.example.ashu4642.OpenGLES;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class HelloGLSurfaceView extends GLSurfaceView {
    private float mPreviousY;
    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private HelloRenderer HelloRenderer;

    public HelloGLSurfaceView(Context context) {
        super(context);

        // Use OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        HelloRenderer = new HelloRenderer();
        setRenderer(HelloRenderer);
        // Renderer for drawing on GLSurfaceView

        // [OPTIONAL] Render the view only when there is a change in the drawing data
        // Prevents GLSurfaceView from getting redrawn until requestRender(), can be more efficient
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                float dx = x - mPreviousX;
                float dy = y - mPreviousY;

                // reverse direction of rotation above the mid-line
                if (y > getHeight() / 2) {
                    dx = dx * -1 ;
                }

                // reverse direction of rotation to left of the mid-line
                if (x < getWidth() / 2) {
                    dy = dy * -1 ;
                }

                HelloRenderer.setAngle(
                        HelloRenderer.getAngle() +
                                ((dx + dy) * TOUCH_SCALE_FACTOR));  // = 180.0f / 320
                requestRender();
        }

        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}
