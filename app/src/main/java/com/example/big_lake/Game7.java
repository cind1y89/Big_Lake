package com.example.big_lake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game7 extends GlobalCode {

    TextView textView_dis,textView_title,textView_subtitle,textView_tdis,textView_a;
    Button button_go,button_a1,button_a2,button_a3,button_a4;
    ImageView imageView_dis,imageView_menu;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game7);

        imageView_menu=findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game7.this,Title.class);
                startActivity(intent);
                finish();
            }
        });
        button_go=findViewById(R.id.button_G7go);
        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    button_go.setVisibility(View.GONE);
                    i++;
                    game();
                }else {
                    Intent intent=new Intent(Game7.this,Menu.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


        textView_dis=findViewById(R.id.textView_G7dis);
        textView_title=findViewById(R.id.textView_game7title);
        textView_subtitle=findViewById(R.id.textView_game7subtitle);
        textView_tdis=findViewById(R.id.textView_game7dis);
        imageView_dis=findViewById(R.id.imageView_game7dis);
        textView_a=findViewById(R.id.textview_g7a);
        button_a1=findViewById(R.id.button_g7a1);
        button_a2=findViewById(R.id.button_g7a2);
        button_a3=findViewById(R.id.button_g7a3);
        button_a4=findViewById(R.id.button_g7a4);



    }

    String[] title={"不要裝蒜","薑薑薑薑五十分","你這個小騷貨","看上你就衝了"};
    String[] subtitle={"吃醋指數:40%","吃醋指數：50%","吃醋指數：75%","吃醋指數：89%"};
    String[] tdis={
            "你不輕易吃醋，因爲你認爲愛情是你的就是你的，不是你的強留也沒用，所以你對感情不會採取纏人盯人的態度。\n這樣子的你，建議你偶爾吃點小醋，才不會讓愛人感受不到你的愛意喔 推薦不愛吃醋的你-蜂蜜醋，讓愛人感覺到你平淡愛意裡的醋味吧。",
            "對於愛人和別人無傷大雅的打情罵俏，你不會很計較；但是，如果愛人因此而認爲你不會吃醋，或愛情觀念開放，那可就大錯特錯了！其實，你是絕對不能容忍與他人「分享」愛人的。\n這樣子的你，推薦蜜釀菊花醋，多層次的口感，豐富的香精油和菊色素可促進新陳代謝",
            "對於你來說，如果有第三者想要打你愛人的主意，從你手中奪走你心愛的人，這不僅是引發愛情之戰，更是挑戰你的面子、你的尊嚴，你是絕對不會無動於衷的。\n當然，你的愛人最好也要小心爲妙。\n這樣子的你，推薦金棗醋，豐富的維他命C，酸中帶甜的金棗正適合你的愛情觀。",
            "你是一個溫暖的人，充滿熱情，對朋友大方慷慨，但是在愛情上，你是一個善妒的人，心愛的人要是和別的異性多說上兩句話，或是多看異性幾眼，你的醋罎子立刻就會打翻了，不爽的心情蔓延到臉上，甚至氣得臉色發青。\n這樣子的你，推薦檸檬醋，含豐富的枸櫞酸及維他命C，對於常常被愛人氣得半死的你具有養顏美容的妙用呦。"};


    private void game() {
        textView_dis.setVisibility(View.GONE);

        textView_a.setVisibility(View.VISIBLE);
        button_a1.setVisibility(View.VISIBLE);
        button_a2.setVisibility(View.VISIBLE);
        button_a3.setVisibility(View.VISIBLE);
        button_a4.setVisibility(View.VISIBLE);

        button_a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(0);
            }
        });
        button_a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(1);
            }
        });
        button_a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(2);
            }
        });
        button_a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(3);
            }
        });
    }

    private void show(int i) {
        textView_a.setVisibility(View.GONE);
        button_a1.setVisibility(View.GONE);
        button_a2.setVisibility(View.GONE);
        button_a3.setVisibility(View.GONE);
        button_a4.setVisibility(View.GONE);

        textView_title.setVisibility(View.VISIBLE);
        textView_subtitle.setVisibility(View.VISIBLE);
        textView_tdis.setVisibility(View.VISIBLE);
        imageView_dis.setVisibility(View.VISIBLE);

        textView_title.setText(title[i]);
        textView_subtitle.setText(subtitle[i]);
        textView_tdis.setText(tdis[i]);
        if(i==0){
            imageView_dis.setImageResource(R.drawable.game7a1);
        }else if(i==1){
            imageView_dis.setImageResource(R.drawable.game7a2);
        }else if(i==2){
            imageView_dis.setImageResource(R.drawable.game7a3);
        }else if(i==3){
            imageView_dis.setImageResource(R.drawable.game7a4);
        }

        button_go.setVisibility(View.VISIBLE);
        button_go.setText("回上頁");
    }
}