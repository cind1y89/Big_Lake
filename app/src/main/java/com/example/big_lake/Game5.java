package com.example.big_lake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game5 extends AppCompatActivity {

    ImageView imageView_menu,imageView_t1,imageView_t2,imageView_t3,imageView_t4,imageView_fruit,imageView_back;
    Button button_go;
    TextView textView_dis;
    int i=0;
    GlobalVariable globalVariable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5);

        imageView_menu=findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game5.this,Title.class);
                startActivity(intent);
                finish();
            }
        });
        button_go=findViewById(R.id.button_G5go);
        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    button_go.setVisibility(View.GONE);
                    i++;
                    game();
                }else {
                    globalVariable= (GlobalVariable) getApplicationContext();
                    globalVariable.setS5(true);
                    Intent intent=new Intent(Game5.this,Menu.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        imageView_back=findViewById(R.id.imageView_G5back);
        imageView_fruit=findViewById(R.id.imageView_G5f);
        imageView_t1=findViewById(R.id.imageView_G5t1);
        imageView_t2=findViewById(R.id.imageView_G5t2);
        imageView_t3=findViewById(R.id.imageView_G5t3);
        imageView_t4=findViewById(R.id.imageView_G5t4);
        textView_dis=findViewById(R.id.textView_G5dis);
    }

    private void game() {
        textView_dis.setVisibility(View.GONE);

        imageView_t1.setVisibility(View.VISIBLE);
        imageView_t2.setVisibility(View.VISIBLE);
        imageView_t3.setVisibility(View.VISIBLE);
        imageView_t4.setVisibility(View.VISIBLE);
        imageView_back.setVisibility(View.VISIBLE);

        imageView_t1.setOnTouchListener(touchListener);
        imageView_t2.setOnTouchListener(touchListener);
        imageView_t3.setOnTouchListener(touchListener);
        imageView_t4.setOnTouchListener(touchListener);



    }

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

    //圖片移動
    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        private float x, y;  // 原本圖片存在的 X,Y軸位置
        private float mx, my;  // 圖片被拖曳的 X,Y軸距離長度

        @Override public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN: {
                    x = event.getX();                  //觸控的X軸位置
                    y = event.getY();                  //觸控的Y軸位置
                    image_pos(imageView_back);            //題目位置
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    mx = x-view.getX();
                    my = y-view.getY();
                    view.setX(event.getX()-mx);
                    view.setY(event.getY()-my);

                    Log.d("Test","view.setX "+(event.getX()-mx));
                    Log.d("Test","view.setY "+(event.getY()-my));

                    if(((right-left)/2+left-100)<=(event.getX()-mx) && (event.getX()-mx)<=((right-left)/2+left+100)){
                        if(((button-top)/2+top-100)<=(event.getY()-my) && (event.getY()-my)<=((button-top)/2+top+100)){

                            if(view==imageView_t1 &&
                               imageView_t2.getVisibility()==View.VISIBLE &&
                               imageView_t3.getVisibility()==View.VISIBLE &&
                               imageView_t4.getVisibility()==View.VISIBLE ) {
                                view.setVisibility(View.GONE);
                            }

                            if(view==imageView_t2 &&
                                    imageView_t1.getVisibility()==View.GONE &&
                                    imageView_t3.getVisibility()==View.VISIBLE &&
                                    imageView_t4.getVisibility()==View.VISIBLE ) {
                                view.setVisibility(View.GONE);
                                imageView_fruit.setVisibility(View.VISIBLE);
                            }

                            if(view==imageView_t3 &&
                                    imageView_t2.getVisibility()==View.GONE &&
                                    imageView_t1.getVisibility()==View.GONE &&
                                    imageView_t4.getVisibility()==View.VISIBLE ) {
                                view.setVisibility(View.GONE);
                                imageView_fruit.setImageResource(R.drawable.game5_ch3);
                            }

                            if(view==imageView_t4 &&
                                    imageView_t2.getVisibility()==View.GONE &&
                                    imageView_t1.getVisibility()==View.GONE &&
                                    imageView_t3.getVisibility()==View.GONE ) {
                                view.setVisibility(View.GONE);
                                imageView_back.setVisibility(View.GONE);
                                Toast toast =Toast.makeText(Game5.this,"恭喜，好大一顆鳳梨",Toast.LENGTH_SHORT);
                                toast.show();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        toast.cancel();
                                        textView_dis.setVisibility(View.INVISIBLE);
                                        button_go.setVisibility(View.VISIBLE);
                                        button_go.setText("回上頁");
                                    }
                                }, 1500);
                            }
                        }
                    }
                    break;
                }
            }
            return true;
        }
    };
}