package com.example.jaedong.trackballviewer;

import android.content.Context;
import android.opengl.GLES11;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by jaedong on 2016. 4. 6..
 */
public class TouchSurfaceView extends GLSurfaceView {

    private Renderer mRenderer;

    public TouchSurfaceView(Context context) {
        super(context);
        mRenderer = new Renderer();
        setRenderer(mRenderer);
       //setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    private class Renderer implements GLSurfaceView.Renderer {

        private Cube mCube;

        public Renderer() {
            mCube = new Cube();
        }

        public void onSurfaceCreated(GL10 gl, EGLConfig config) {

            gl.glDisable(GL10.GL_DITHER);
            gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
            gl.glClearColor(0, 0, 0, 1);
            gl.glShadeModel(GL10.GL_SMOOTH);
            gl.glEnable(GL10.GL_DEPTH_TEST);
            gl.glEnable(GL10.GL_CULL_FACE);
        }

        public void onSurfaceChanged(GL10 gl, int width, int height) {

            gl.glViewport(0, 0, width, height);
            float ratio = (float) width / height;
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
        }

        public void onDrawFrame(GL10 gl) {

            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();

            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

            mCube.draw(gl);
        }
    }


}
