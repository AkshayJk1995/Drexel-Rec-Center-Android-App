package com.example.akshayjk.attempt1.Helper;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.OverScroller;

/**
 * Created by AkshayJk on 30-Nov-17.
 */

public class ScrollableImageView extends android.support.v7.widget.AppCompatImageView {
    private GestureDetectorCompat gestureDetector;
    private OverScroller overScroller;

    private final int screenW;
    private final int screenH;

    private int positionX = 0;
    private int positionY = 0;

    public ScrollableImageView(Context context) {
        super(context);

        // We will need screen dimensions to make sure we don't overscroll the
        // image
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenW = dm.widthPixels;
        screenH = dm.heightPixels;

        gestureDetector = new GestureDetectorCompat(context, gestureListener);
        overScroller = new OverScroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        // computeScrollOffset() returns true only when the scrolling isn't
        // already finished
        if (overScroller.computeScrollOffset()) {
            positionX = overScroller.getCurrX();
            positionY = overScroller.getCurrY();
            scrollTo(positionX, positionY);
        } else {
            // when scrolling is over, we will want to "spring back" if the
            // image is overscrolled
            overScroller.springBack(positionX, positionY, 0, getMaxHorizontal(), 0, getMaxVertical());
        }
    }

    private int getMaxHorizontal() {
        return (Math.abs(getDrawable().getBounds().width() - screenW));
    }

    private int getMaxVertical() {
        return (Math.abs(getDrawable().getBounds().height() - screenH));
    }

    private GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener() {

        float factor;

        @Override
        public boolean onDown(MotionEvent e) {
            overScroller.forceFinished(true);
            ViewCompat.postInvalidateOnAnimation(ScrollableImageView.this);
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            overScroller.forceFinished(true);
            overScroller.fling(positionX, positionY, (int) -velocityX, (int) -velocityY, 0, getMaxHorizontal(), 0,
                    getMaxVertical());
            ViewCompat.postInvalidateOnAnimation(ScrollableImageView.this);
            return true;
        }

        public boolean onScale(ScaleGestureDetector detector){
            float scaleFactor = detector.getScaleFactor()-1;
            factor+=scaleFactor;
//            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
            //          matrix.setScale(scaleFactor, scaleFactor);
            //        imageView.setImageMatrix(matrix);
            setScaleX(factor);
            setScaleY(factor);
            return true;
        }


        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            overScroller.forceFinished(true);
            // normalize scrolling distances to not overscroll the image
            int dx = (int) distanceX;
            int dy = (int) distanceY;
            int newPositionX = positionX + dx;
            int newPositionY = positionY + dy;
            if (newPositionX < 0) {
                dx -= newPositionX;
            } else if (newPositionX > getMaxHorizontal()) {
                dx -= (newPositionX - getMaxHorizontal());
            }
            if (newPositionY < 0) {
                dy -= newPositionY;
            } else if (newPositionY > getMaxVertical()) {
                dy -= (newPositionY - getMaxVertical());
            }
            overScroller.startScroll(positionX, positionY, dx, dy, 0);
            ViewCompat.postInvalidateOnAnimation(ScrollableImageView.this);
            return true;
        }
    };
}

