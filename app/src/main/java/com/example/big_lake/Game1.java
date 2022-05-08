package com.example.big_lake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game1 extends AppCompatActivity {

    ImageView imageView_menu,imageView_p1,imageView_p2,imageView_p3,imageView_p4,imageView_p5,imageView_p6,imageView_p7,imageView_p8;
    Button button_go;
    TextView textView_dis,textView_timer;

    int i=0;
    GlobalVariable globalVariable;
    boolean s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);


        imageView_menu=findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game1.this,Title.class);
                startActivity(intent);
                finish();
            }
        });
        button_go=findViewById(R.id.button_G1go);
        textView_dis=findViewById(R.id.textView_G1dis);
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
                    globalVariable.setS1(s);
                    Intent intent=new Intent(Game1.this,Menu.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


        textView_timer=findViewById(R.id.textView_G1timer);
        imageView_p1=findViewById(R.id.imageView_p1);
        imageView_p2=findViewById(R.id.imageView_p2);
        imageView_p3=findViewById(R.id.imageView_p3);
        imageView_p4=findViewById(R.id.imageView_p4);
        imageView_p5=findViewById(R.id.imageView_p5);
        imageView_p6=findViewById(R.id.imageView_p6);
        imageView_p7=findViewById(R.id.imageView_p7);
        imageView_p8=findViewById(R.id.imageView_p8);
    }

    boolean turn=false;
    ImageView imageView_tmp;

    private void game() {

        textView_timer.setVisibility(View.VISIBLE);
        imageView_p1.setVisibility(View.VISIBLE);
        imageView_p2.setVisibility(View.VISIBLE);
        imageView_p3.setVisibility(View.VISIBLE);
        imageView_p4.setVisibility(View.VISIBLE);
        imageView_p5.setVisibility(View.VISIBLE);
        imageView_p6.setVisibility(View.VISIBLE);
        imageView_p7.setVisibility(View.VISIBLE);
        imageView_p8.setVisibility(View.VISIBLE);

        new CountDownTimer(30000,1000){
            public void onTick(long millisUntilFinished) {
                textView_timer.setText(""+millisUntilFinished / 1000);
                if(correct==4){
                    s=true;
                    imageView_p1.setVisibility(View.GONE);
                    imageView_p2.setVisibility(View.GONE);
                    imageView_p3.setVisibility(View.GONE);
                    imageView_p4.setVisibility(View.GONE);
                    imageView_p5.setVisibility(View.GONE);
                    imageView_p6.setVisibility(View.GONE);
                    imageView_p7.setVisibility(View.GONE);
                    imageView_p8.setVisibility(View.GONE);

                    textView_timer.setText("0");

                    textView_dis.setVisibility(View.VISIBLE);
                    textView_dis.setText("Congratulate");

                    button_go.setVisibility(View.VISIBLE);
                    button_go.setText("回上頁");
                }
            }
            public void onFinish() {
                s=false;
                imageView_p1.setVisibility(View.GONE);
                imageView_p2.setVisibility(View.GONE);
                imageView_p3.setVisibility(View.GONE);
                imageView_p4.setVisibility(View.GONE);
                imageView_p5.setVisibility(View.GONE);
                imageView_p6.setVisibility(View.GONE);
                imageView_p7.setVisibility(View.GONE);
                imageView_p8.setVisibility(View.GONE);

                textView_timer.setText("0");

                textView_dis.setVisibility(View.VISIBLE);
                textView_dis.setText("TIMES UP");

                button_go.setVisibility(View.VISIBLE);
                button_go.setText("回上頁");
            }
        }.start();

        imageView_p1.setOnClickListener(clickListener);
        imageView_p2.setOnClickListener(clickListener);
        imageView_p3.setOnClickListener(clickListener);
        imageView_p4.setOnClickListener(clickListener);
        imageView_p5.setOnClickListener(clickListener);
        imageView_p6.setOnClickListener(clickListener);
        imageView_p7.setOnClickListener(clickListener);
        imageView_p8.setOnClickListener(clickListener);

    }

    int correct=0;
    View.OnClickListener clickListener =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            imply((ImageView) view);
        }
    };

    private void imply(ImageView imageView) {

        if(!turn){
            imageView_tmp=imageView;
            if(imageView==imageView_p1||imageView==imageView_p4){
                imageView.setImageResource(R.drawable.game1_b1);
            }else if(imageView==imageView_p3||imageView==imageView_p8){
                imageView.setImageResource(R.drawable.game1_b2);
            }else if(imageView==imageView_p2||imageView==imageView_p5){
                imageView.setImageResource(R.drawable.game1_b3);
            }else if(imageView==imageView_p6||imageView==imageView_p7){
                imageView.setImageResource(R.drawable.game1_b4);
            }
            turn=true;
        }else{
            if(imageView!=imageView_tmp){
                if((imageView_tmp==imageView_p1 && imageView==imageView_p4)
                 ||(imageView_tmp==imageView_p4 && imageView==imageView_p1)){
                    imageView.setImageResource(R.drawable.game1_b1);
                    correct++;
                }else if((imageView_tmp==imageView_p3 && imageView==imageView_p8)
                        ||(imageView_tmp==imageView_p8 && imageView==imageView_p3)){
                    imageView.setImageResource(R.drawable.game1_b2);
                    correct++;
                }else if((imageView_tmp==imageView_p2 && imageView==imageView_p5)
                        ||(imageView_tmp==imageView_p5 && imageView==imageView_p2)){
                    imageView.setImageResource(R.drawable.game1_b3);
                    correct++;
                }else if((imageView_tmp==imageView_p6 && imageView==imageView_p7)
                        ||(imageView_tmp==imageView_p7 && imageView==imageView_p6)){
                    imageView.setImageResource(R.drawable.game1_b4);
                    correct++;
                }else{
                    Toast.makeText(Game1.this, "不對喔", Toast.LENGTH_SHORT).show();
                    imageView.setOnClickListener(null);
                    if(imageView==imageView_p1||imageView==imageView_p4){
                        imageView.setImageResource(R.drawable.game1_b1);
                    }else if(imageView==imageView_p2||imageView==imageView_p5){
                        imageView.setImageResource(R.drawable.game1_b3);
                    }else if(imageView==imageView_p3||imageView==imageView_p8){
                        imageView.setImageResource(R.drawable.game1_b2);
                    }else if(imageView==imageView_p6||imageView==imageView_p7){
                        imageView.setImageResource(R.drawable.game1_b4);
                    }

                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageResource(R.drawable.game1_back);
                            imageView_tmp.setImageResource(R.drawable.game1_back);
                            imageView.setOnClickListener(clickListener);
                        }
                    },1000);
                }
                turn=false;
            }else{
                Toast.makeText(Game1.this, "不要戳同一個人拉", Toast.LENGTH_SHORT).show();
            }

        }



    }
}