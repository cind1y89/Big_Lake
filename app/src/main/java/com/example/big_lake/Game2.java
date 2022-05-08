package com.example.big_lake;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Game2 extends GlobalCode {

    ImageView imageView_menu,imageView_ch;
    FrameLayout imageView_d1,imageView_d2,imageView_d3,imageView_d4,imageView_d5;
    TextView textView_timer,textView_dis;
    Button button_go;
    ProgressBar progressBar_d1,progressBar_d2,progressBar_d3,progressBar_d4,progressBar_d5;
    int i =0;
    GlobalVariable globalVariable;
    boolean s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        imageView_menu=findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game2.this,Title.class);
                startActivity(intent);
                finish();
            }
        });

        imageView_d1=findViewById(R.id.frameLayout_d1);
        imageView_d2=findViewById(R.id.frameLayout_d2);
        imageView_d3=findViewById(R.id.frameLayout_d3);
        imageView_d4=findViewById(R.id.frameLayout_d4);
        imageView_d5=findViewById(R.id.frameLayout_d5);
        imageView_ch=findViewById(R.id.imageView_G2ch);
        progressBar_d1=findViewById(R.id.progressBar_d1);
        progressBar_d2=findViewById(R.id.progressBar_d2);
        progressBar_d3=findViewById(R.id.progressBar_d3);
        progressBar_d4=findViewById(R.id.progressBar_d4);
        progressBar_d5=findViewById(R.id.progressBar_d5);
        textView_timer=findViewById(R.id.textView_G2timer);
        textView_dis=findViewById(R.id.textView_G2dis);
        button_go=findViewById(R.id.button_G2go);


        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    button_go.setVisibility(View.GONE);
                    //3sec倒數
                    new CountDownTimer(4000,1000){
                        public void onTick(long millisUntilFinished) {
                            if((millisUntilFinished / 1000)==0){
                                textView_dis.setText("Start");
                            }else{
                                textView_dis.setText(""+millisUntilFinished / 1000);
                            }
                        }
                        public void onFinish() {
                            textView_dis.setVisibility(View.GONE);
                            game();
                        }
                    }.start();
                    i++;
                }else{
                    globalVariable= (GlobalVariable) getApplicationContext();
                    globalVariable.setS2(s);
                    Intent intent=new Intent(Game2.this,Menu.class);
                    startActivity(intent);
                    finish();
                }

            }
        });




    }

    private void game() {

        imageView_ch.setVisibility(View.VISIBLE);
        //30 Secs
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView_timer.setText(""+millisUntilFinished / 1000);

                //掉落計算
                drop_pos(imageView_d1,0);
                drop_pos(imageView_d2,1);
                drop_pos(imageView_d3,2);
                drop_pos(imageView_d4,3);
                drop_pos(imageView_d5,4);

                //間格掉落
                if((millisUntilFinished / 1000)==29){
                    image_pos(imageView_ch);//底圖位置
                    imageView_d1.setVisibility(View.VISIBLE);
                    image_drop(imageView_d1);
                }
                if((millisUntilFinished / 1000)==26){
                    imageView_d5.setVisibility(View.VISIBLE);
                    image_drop(imageView_d5);
                }
                if((millisUntilFinished / 1000)==23){
                    imageView_d3.setVisibility(View.VISIBLE);
                    image_drop(imageView_d3);
                }
                if((millisUntilFinished / 1000)==15){
                    imageView_d4.setVisibility(View.VISIBLE);
                    image_drop(imageView_d4);
                }
                if((millisUntilFinished / 1000)==10){
                    imageView_d2.setVisibility(View.VISIBLE);
                    image_drop(imageView_d2);
                }


                //判斷界線
                if(judgement(progressBar_d1,0)){
                    cancel();
                }else if(judgement(progressBar_d2,1)){
                    cancel();
                }else if(judgement(progressBar_d3,2)){
                    cancel();
                }else if(judgement(progressBar_d4,3)){
                    cancel();
                }else if(judgement(progressBar_d5,4)){
                    cancel();
                }

            }
            public void onFinish() {
                s=true;
                textView_timer.setText("0");

                textView_dis.setVisibility(View.VISIBLE);
                textView_dis.setText("Congratulation");

                button_go.setVisibility(View.VISIBLE);
                button_go.setText("回上頁");
            }
        }.start();

        image_click(imageView_d1,progressBar_d1);
        image_click(imageView_d2,progressBar_d2);
        image_click(imageView_d3,progressBar_d3);
        image_click(imageView_d4,progressBar_d4);
        image_click(imageView_d5,progressBar_d5);

    }

    private Boolean judgement(ProgressBar progressBar,int i) {
        Log.d("judge","drop:"+image_y[0]);
        Log.d("judge","limitline:"+(top+200));
//        Log.d("judge","limitline button:"+button);
//        Log.d("judge","limitline top:"+top);

        if(image_y[i]>(top+200) && progressBar.getProgress()<100){
            s=false;
            textView_timer.setText("0");
            textView_dis.setVisibility(View.VISIBLE);
            textView_dis.setText("GAMEOVER");
            button_go.setVisibility(View.VISIBLE);
            button_go.setText("回上頁");
            return true;
        }else{
            return false;
        }
    }


    private void image_click(FrameLayout imageView,ProgressBar progressBar) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int progress=progressBar.getProgress();
                if(progress<100){
                    int r =  new Random().nextInt(11) ;
                    progress+=(r*2);
                    progressBar.setProgress(progress);
                }else{
                    imageView.setVisibility(View.GONE);
                }
            }
        });
    }

    private void image_drop(FrameLayout imageView) {
        imageView.setVisibility(View.VISIBLE);
        ObjectAnimator animation = ObjectAnimator.ofFloat(imageView, "translationY", 2000f);
        animation.setDuration(10000);
        animation.start();
    }

    //圖片位置
    int top,button;
    private void image_pos(ImageView imageView) {
        top=imageView.getTop();
        button=imageView.getBottom();
        Log.d("Test","getTop "+imageView.getTop());
        Log.d("Test","getBottom "+imageView.getBottom());

    }

    // 掉落位置
    int[] image_y={0,0,0,0,0};
    private void drop_pos (FrameLayout frameLayout,int i) {
        int[] image_location;
        image_location= new int[2];
        frameLayout.getLocationOnScreen(image_location);
        image_y[i] = image_location[1];
    }
}