package com.example.akshayjk.attempt1.Helper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.opengl.Matrix;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.akshayjk.attempt1.ClubSports_Activities.CS_Schedule;
import com.example.akshayjk.attempt1.ClubSports_Activities.ClubSports;
import com.example.akshayjk.attempt1.ClubSports_Activities.FormsList;
import com.example.akshayjk.attempt1.HFW_Activities.GroupExercise;
import com.example.akshayjk.attempt1.HFW_Activities.HFW;
import com.example.akshayjk.attempt1.IntraSports_Activities.IntraSports;
import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.Rec_Activities.RecFac;

import static android.view.MotionEvent.INVALID_POINTER_ID;

/**
 * Created by AkshayJk on 30-Nov-17.
 */

public class ImageViewer extends Activity {

    private android.graphics.Matrix matrix=new android.graphics.Matrix();
    private ScaleGestureDetector scaleGestureDetector;
    private ImageView imageView;
    private int mActivePointerId = INVALID_POINTER_ID;
    int windowwidth;
    int windowheight;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=null;
        Bundle bundle=getIntent().getExtras();
        int code=bundle.getInt("code");
        switch (code){
            case 1: intent=new Intent(ImageViewer.this, GroupExercise.class);
                break;
        }
        startActivity(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getIntent().getExtras();
        int file=bundle.getInt("file");
        windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        windowheight = getWindowManager().getDefaultDisplay().getHeight();
        setContentView(R.layout.activity_imageviewer);
        scaleGestureDetector=new ScaleGestureDetector(this, new ScaleListener());
        imageView=findViewById(R.id.fge_iv);
        switch (file){
            case 1: imageView.setImageDrawable(getResources().getDrawable(R.drawable.groupexcalenderfall));
                    break;
            case 2: imageView.setImageDrawable(getResources().getDrawable(R.drawable.groupexfinal));
                    break;
            case 3: imageView.setImageDrawable(getResources().getDrawable(R.drawable.gedesc));
                    break;
        }
    }

    private void setImageBitmap(Bitmap bitmap){
        imageView=new ScrollableImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(bitmap.getWidth(),bitmap.getHeight()));
        imageView.setImageBitmap(bitmap);
    }

    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
        }


    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        float factor;

        @Override
        public boolean onScale(ScaleGestureDetector detector){
            float scaleFactor = detector.getScaleFactor()-1;
            factor+=scaleFactor;
//            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
  //          matrix.setScale(scaleFactor, scaleFactor);
    //        imageView.setImageMatrix(matrix);
            imageView.setScaleX(factor);
            imageView.setScaleY(factor);
            return true;
        }
    }
}
