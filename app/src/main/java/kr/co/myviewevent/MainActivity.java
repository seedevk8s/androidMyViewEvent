package kr.co.myviewevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        MyView myView = new MyView(this);
        setContentView(myView);
    }

    private class MyView extends View {

        int key;
        String str;
        int x, y;

        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.BLUE);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Log.i("MyViewEvent","onTouchEvent");
            x = (int) event.getX(0);
            y = (int) event.getY(0);
            invalidate();
            return super.onTouchEvent(event);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Log.i("MyViewEvent","onDraw");

            Paint paint = new Paint();
            paint.setTextSize(50);
            canvas.drawCircle(x, y, 30, paint);
            canvas.drawText("(" +x+ ", " +y+ ") 에서 터치 이벤트가 발생하였음.", x, y + 100, paint);
        }
    }
}




















