package com.pick;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

class ExampleGLView extends GLSurfaceView {

    private ExampleGLRenderer triangleRenderer;

    public ExampleGLView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setEGLContextClientVersion(1);
        triangleRenderer = new ExampleGLRenderer();
        setRenderer(triangleRenderer);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    public ExampleGLView(MainActivity context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();

        switch(event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:
                triangleRenderer.onPress(x, y);
                break;
        }
        return super.onTouchEvent(event);
    }
}