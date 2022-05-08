package com.example.big_lake;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game6c extends GlobalCode {


    TextView textView_timer;
    int count;
    ImageView imageView_menu;
    ImageView imageView, imageView_home, imageView3, imageView4, imageView5, imageView6;
    Button button_go;
    GlobalVariable globalVariable;
    boolean s;
    boolean stop=false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game6c);

        imageView_menu = findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game6c.this, Title.class);
                startActivity(intent);
                finish();
            }
        });


        textView_timer = findViewById(R.id.textView_timer);
        imageView = findViewById(R.id.imageView);
        imageView_home = findViewById(R.id.imageView_home);
        imageView3 = findViewById(R.id.imageView_G6b1);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        button_go = findViewById(R.id.button2);

        imageView3.setOnTouchListener(imgListener_right);
        imageView4.setOnTouchListener(imgListener_right);
        imageView5.setOnTouchListener(imgListener_right);
        imageView6.setOnTouchListener(imgListener_right);

        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalVariable = (GlobalVariable) getApplicationContext();
                globalVariable.setS6(s);
                Intent intent = new Intent(Game6c.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });


        new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView_timer.setText("" + millisUntilFinished / 1000);
                if (count == 4) {
                    cancel();
                    textView_timer.setText("0");
                    button_go.setVisibility(View.VISIBLE);
                    s = true;
                }
            }

            public void onFinish() {
                textView_timer.setText("0");
                button_go.setVisibility(View.VISIBLE);
                s = false;
            }
        }.start();

    }


    View.OnTouchListener imgListener_right = new View.OnTouchListener() {
        private float x, y;    // 原本圖片存在的X,Y軸位置
        private int mx, my; // 圖片被拖曳的X ,Y軸距離長度

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {          //判斷觸控的動作

                case MotionEvent.ACTION_DOWN:// 按下圖片時
                    x = event.getX();                  //觸控的X軸位置
                    y = event.getY();                  //觸控的Y軸位置
                    image_pos(imageView_home);

                case MotionEvent.ACTION_MOVE:// 移動圖片時

                    // getX()：是獲取當前控件(View)的座標
                    // getRawX()：是獲取相對顯示螢幕左上角的座標
                    // -300因為constraint layout
                    mx = (int) (x-v.getX());
                    my = (int) (y-v.getY());
                    v.setX(event.getX()-mx);
                    v.setY(event.getY()-my);

                    Log.d("Test","posX "+((right-left)/3+left-100)+" "+(event.getX()-mx)+" "+((right-left)/3+left+100)+"");
                    Log.d("Test","posY "+((button-top)/2+top-100)+" "+(event.getY()-my)+" "+((button-top)/2+top+100)+"");

                    if (((right - left) /3 + left - 100) <= (event.getX() - mx) && (event.getX() - mx) <= ((right - left) / 3 + left + 100)) {
                        if (((button - top) / 2 + top - 100) <= (event.getY() - my) && (event.getY() - my) <= ((button - top) / 2 + top + 100)) {
                            if(v.getVisibility()==View.VISIBLE){
                                v.setVisibility(View.GONE);
                                count++;
                            }
                        }
                    }
                    break;
            }
            return true;
        }
    };

    //題目位置
    int top,button,left,right;
    private void image_pos(ImageView imageView) {
        top=imageView.getTop();
        button=imageView.getBottom();
        left=imageView.getLeft();
        right=imageView.getRight();
        Log.d("Test","getLeft "+imageView.getLeft());
        Log.d("Test","getRight "+imageView.getRight());
        Log.d("Test","getTop "+imageView.getTop());
        Log.d("Test","getBottom "+imageView.getBottom());
    }


}
