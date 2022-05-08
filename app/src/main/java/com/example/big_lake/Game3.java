package com.example.big_lake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game3 extends AppCompatActivity {

    ImageView imageView_menu;
    Button button_go,button_yes,button_no,button_u;
    TextView textView_dis,textView_q;
    int i=0;
    GlobalVariable globalVariable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        imageView_menu=findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game3.this,Title.class);
                startActivity(intent);
                finish();
            }
        });
        button_go=findViewById(R.id.button_G3go);
        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    button_go.setVisibility(View.GONE);
                    i++;
                    game();
                }else {
                    globalVariable= (GlobalVariable) getApplicationContext();
                    globalVariable.setS3(true);
                    Intent intent=new Intent(Game3.this,Menu.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        textView_dis=findViewById(R.id.textView_G3dis);
        textView_q=findViewById(R.id.textView_G3q);
        button_yes=findViewById(R.id.button_yes);
        button_no=findViewById(R.id.button_no);
        button_u=findViewById(R.id.button_u);
    }

    String[] question={
            "沒有產季調節之下，火龍果是春季作物? ",
            "紅肉火龍果火龍果常見是紅色的皮，那白肉火龍果是白色的皮嗎?",
            "火龍果具有高度的「XXXX」，促進腸胃蠕動，請問「XXXX」是?",
            "吃完紅肉火龍果，排泄有淡淡的紅色是正常的?"};

    Boolean[] a={false,false,true,true};
    String[] answer={
            "你回答錯了你這個臭雷包\n\n火龍果正常產季為7~11月，若有透過燈光進行產季調節則可全年生產",
            "你回答錯了你可以再笨一點沒關係\n\n不論紅肉或白肉火龍果，台灣最主要的品種都是紅色果皮，另外也有一些特殊品種如黃色果皮的黃龍果、綠色果皮的青龍果等",
            "答錯了你超笨沒救了\n\n答案是膳食纖維，膳食纖維可促進腸胃蠕動，特別推薦給有輕微便秘問題的人，而紅肉火龍果具有的是甜菜紅素，並非花青素",
            "答錯了果園旁邊有水溝請跳下去\n\n紅肉火龍果含天然色素，吃完後會有色素沉積，在排尿、大便時會有淡淡的粉紅色，屬正常現象，別誤以為是血便"};
    int index=0;
    Boolean t=false;

    private void game() {
        textView_dis.setVisibility(View.GONE);
        textView_q.setVisibility(View.VISIBLE);
        button_yes.setVisibility(View.VISIBLE);
        button_no.setVisibility(View.VISIBLE);

        button_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test","index "+index);
                if(index==0 || index==1){
                    right();
                }else if(index==2 || index==3){
                    wrong();
                }

            }
        });
        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test","index "+index);
                if(index==0 || index==1){
                    wrong();
                }else if(index==2 || index==3 ){
                    right();
                }
            }
        });
    }

    private void wrong() {
        button_yes.setText("YES");
        button_no.setText("NO");
        if(index>0){
            index--;
        }
        button_no.setVisibility(View.GONE);
        button_yes.setVisibility(View.GONE);
        button_u.setVisibility(View.VISIBLE);
        button_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_no.setVisibility(View.VISIBLE);
                button_yes.setVisibility(View.VISIBLE);
                button_u.setVisibility(View.GONE);
                textView_q.setText(answer[index]);
            }
        });

    }

    private void right() {
        index++;
        button_yes.setText("YES");
        button_no.setText("NO");
        if(index==2){
            button_yes.setText("膳食纖維");
            button_no.setText("花青素");
        }
        if(index==4){
            textView_q.setVisibility(View.GONE);
            button_yes.setVisibility(View.GONE);
            button_no.setVisibility(View.GONE);

            textView_dis.setVisibility(View.INVISIBLE);
            button_go.setVisibility(View.VISIBLE);
            button_go.setText("回上頁");
        }else{
            textView_q.setText(question[index]);
        }
    }
}