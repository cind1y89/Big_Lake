package com.example.big_lake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Title extends GlobalCode {

    TextView textView_start,textView_achievement,textView_map,textView_gift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        textView_start=findViewById(R.id.textView_start);
        textView_achievement=findViewById(R.id.textView_achievement);
        textView_map=findViewById(R.id.textView_map);
        textView_gift=findViewById(R.id.textView_gift);

        textView_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Title.this,Menu.class);
                startActivity(intent);
                finish();
            }
        });

        textView_achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Title.this,Achievement.class);
                startActivity(intent);
                finish();
            }
        });

        textView_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent=new Intent(Title.this,Map.class);
                startActivity(intent);
                finish();
            }
        });

        textView_gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Title.this,Gift.class);
                startActivity(intent);
                finish();
            }
        });



    }
}