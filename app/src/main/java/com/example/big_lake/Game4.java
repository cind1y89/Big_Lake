package com.example.big_lake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game4 extends GlobalCode {

    ImageView imageView_menu,imageView_a1,imageView_a2,imageView_a3,imageView_a4;
    Button button_go;
    TextView textView_q,textView_dis;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);

        imageView_menu=findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game4.this,Title.class);
                startActivity(intent);
                finish();
            }
        });
        button_go=findViewById(R.id.button_G4go);
        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    button_go.setVisibility(View.GONE);
                    i++;
                    game();
                }else {
                    Intent intent=new Intent(Game4.this,Menu.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        imageView_a1=findViewById(R.id.imageView_G4a1);
        imageView_a2=findViewById(R.id.imageView_G4a2);
        imageView_a3=findViewById(R.id.imageView_G4a3);
        imageView_a4=findViewById(R.id.imageView_G4a4);
        textView_q=findViewById(R.id.textView_G4q);
        textView_dis=findViewById(R.id.textView_G4dis);

    }

    private void game() {

        textView_dis.setVisibility(View.GONE);
        imageView_a1.setVisibility(View.VISIBLE);
        imageView_a2.setVisibility(View.VISIBLE);
        imageView_a3.setVisibility(View.VISIBLE);
        imageView_a4.setVisibility(View.VISIBLE);
        textView_q.setVisibility(View.VISIBLE);

        imageView_a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Game4.this, "燈等，你答錯了", Toast.LENGTH_SHORT).show();
            }
        });
        imageView_a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Game4.this, "燈等，你答錯了", Toast.LENGTH_SHORT).show();
            }
        });
        imageView_a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Game4.this, "沒錯，你超棒", Toast.LENGTH_SHORT).show();
                button_go.setVisibility(View.VISIBLE);
                button_go.setText("回上頁");
            }
        });
        imageView_a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Game4.this, "燈等，你答錯了", Toast.LENGTH_SHORT).show();
            }
        });

    }
}