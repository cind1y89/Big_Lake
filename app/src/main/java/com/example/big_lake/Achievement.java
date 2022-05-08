package com.example.big_lake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Achievement extends GlobalCode {

    ImageView imageView_menu,imageView_ac1,imageView_ac2,imageView_ac3,imageView_ac4,imageView_ac5,imageView_ac6,imageView_ac7,imageView_ac8;
    GlobalVariable globalVariable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        imageView_menu=findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Achievement.this,Title.class);
                startActivity(intent);
                finish();
            }
        });

        imageView_ac1=findViewById(R.id.imageView_ac1);
        imageView_ac2=findViewById(R.id.imageView_ac2);
        imageView_ac3=findViewById(R.id.imageView_ac3);
        imageView_ac4=findViewById(R.id.imageView_ac4);
        imageView_ac5=findViewById(R.id.imageView_ac5);
        imageView_ac7=findViewById(R.id.imageView_ac7);

        globalVariable= (GlobalVariable) getApplicationContext();
        if(globalVariable!=null){
            if(globalVariable.getS1()!=null){
                Log.d("Test","1 "+globalVariable.getS1());
                if(globalVariable.getS1()){
                    imageView_ac1.setVisibility(View.VISIBLE);
                }
            }
            if(globalVariable.getS2()!=null){
                Log.d("Test","2 "+globalVariable.getS2());
                if(globalVariable.getS2()){
                    imageView_ac2.setVisibility(View.VISIBLE);
                }
            }
            if(globalVariable.getS3()!=null){
                Log.d("Test","3 "+globalVariable.getS3());
                if(globalVariable.getS3()){
                    imageView_ac3.setVisibility(View.VISIBLE);
                }
            }
            if(globalVariable.getS4()!=null){
                Log.d("Test","4 "+globalVariable.getS4());
                if(globalVariable.getS4()){
                    imageView_ac4.setVisibility(View.VISIBLE);
                }
            }
            if(globalVariable.getS5()!=null){
                Log.d("Test","5 "+globalVariable.getS5());
                if(globalVariable.getS5()){
                    imageView_ac5.setVisibility(View.VISIBLE);
                }
            }
            if(globalVariable.getS7()!=null){
                Log.d("Test","7 "+globalVariable.getS7());
                if(globalVariable.getS7()==true){
                    Log.d("Test","7 yes");
                    imageView_ac7.setVisibility(View.VISIBLE);
                }else{
                    Log.d("Test","7 wrong");
                }
            }
        }
    }
}