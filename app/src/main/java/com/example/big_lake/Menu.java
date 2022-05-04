package com.example.big_lake;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu extends GlobalCode {

    ImageView imageView_menu;
    TextView textView_g1,textView_g2,textView_g3,textView_g4,textView_g5,textView_g6,textView_g7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        imageView_menu=findViewById(R.id.imageView_menu);
        textView_g1=findViewById(R.id.textView_g1);
        textView_g2=findViewById(R.id.textView_g2);
        textView_g3=findViewById(R.id.textView_g3);
        textView_g4=findViewById(R.id.textView_g4);
        textView_g5=findViewById(R.id.textView_g5);
        textView_g6=findViewById(R.id.textView_g6);
        textView_g7=findViewById(R.id.textView_g7);

        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Title.class);
                startActivity(intent);
                finish();
            }
        });

        textView_g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Game1.class);
                startActivity(intent);
                finish();
            }
        });
        textView_g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Game2.class);
                startActivity(intent);
                finish();
            }
        });
        textView_g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Game3.class);
                startActivity(intent);
                finish();
            }
        });
        textView_g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Game4.class);
                startActivity(intent);
                finish();
            }
        });
        textView_g5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Game5.class);
                startActivity(intent);
                finish();
            }
        });
        textView_g6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Game6.class);
                startActivity(intent);
                finish();
            }
        });
        textView_g7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Game7.class);
                startActivity(intent);
                finish();
            }
        });

    }
}