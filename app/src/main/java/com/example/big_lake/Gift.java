package com.example.big_lake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Gift extends AppCompatActivity {

    ImageView imageView_menu,imageView_spinner;
    Button button_spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift);

        imageView_menu=findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Gift.this,Title.class);
                startActivity(intent);
                finish();
            }
        });

        imageView_spinner=findViewById(R.id.imageView_spinner);
        button_spin=findViewById(R.id.button_giftgo);

        button_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView_spinner.setRotation(0f); //歸正
                int r = new Random().nextInt(361); //隨機度數
                float f = 360+r;
                imageView_spinner.animate().rotation(f).setDuration(2000).start(); //轉
                Log.d("Test",""+r);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // Actions to do after 2 seconds
                        if(r>180){
                            Toast.makeText(Gift.this, "恭喜獲得火龍果果凍", Toast.LENGTH_SHORT).show();
                        }else if(r>135){
                            Toast.makeText(Gift.this, "恭喜獲得果醋", Toast.LENGTH_SHORT).show();
                        }else if(r>0){
                            Toast.makeText(Gift.this, "恭喜獲得鳳梨豆腐乳", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 2000);

            }
        });
    }
}