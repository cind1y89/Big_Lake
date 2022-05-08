package com.example.big_lake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Map extends AppCompatActivity {

    ImageView imageView_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        imageView_menu=findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Map.this,Title.class);
                startActivity(intent);
                finish();
            }
        });
    }
}