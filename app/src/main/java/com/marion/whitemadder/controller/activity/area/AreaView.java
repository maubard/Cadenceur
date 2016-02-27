package com.marion.whitemadder.controller.activity.area;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.marion.whitemadder.model.Area;
import com.marion.whitemadder.model.Line;

import java.util.Random;

/**
 * Copyright (c) 06/02/16 marion
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 * ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class AreaView extends SurfaceView implements Runnable {

    private Area mArea;
    private SurfaceHolder mHolder;
    private Thread mThread = null;
    volatile boolean running = false;
    Random random;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public AreaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHolder = this.getHolder();
        random = new Random();
    }

    public void setArea(Area area) {
        this.mArea = area;
    }

    public void onResume(){
        running = true;
        mThread = new Thread(this);
        mThread.start();
    }

    public void onPause(){
        boolean retry = true;
        running = false;
        while(retry){
            try {
                mThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        while(running){
            if(mHolder.getSurface().isValid()){
                Canvas canvas = mHolder.lockCanvas();

                paint.setStyle(Paint.Style.FILL);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setStrokeWidth(3);

                if (mArea.getLines().size() == 0) {
                    paint.setColor(0x111111);
                    canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
                } else {
                    float maxDistance = mArea.getLineAtIndex(mArea.getLines().size() - 1).getDistance();

                    int x = 0;

                    for (int i = 0; i < mArea.getLines().size(); i++) {
                        Line line = mArea.getLineAtIndex(i);
                        int width = (int) (line.getDistance() * this.getWidth() / maxDistance);
                        paint.setColor(0xff000000 + ((i + 1) * 20 << 16) + ((i + 1) * 10 << 8) + (i + 1) * 50);
                        canvas.drawRect(x, 0, width, this.getHeight(), paint);
                        paint.setColor(Color.WHITE);

                        int xPos = (x + width) / 2;
                        int yPos = (int) ((canvas.getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));


                        canvas.drawText(line.getAverage().toString(), xPos, yPos, paint);
                        x = width;
                    }
                }


                mHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
