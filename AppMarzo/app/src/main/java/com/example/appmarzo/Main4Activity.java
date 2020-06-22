package com.example.appmarzo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.Calendar;
import java.util.Date;

public class Main4Activity extends AppCompatActivity {

    //CREACION DE OBJETOS
    ImageButton _Back3;
    Switch _switch3;
    Switch _switch4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //Referencias
       _Back3=(ImageButton) findViewById(R.id.back_3);    //
        _switch3=(Switch) findViewById(R.id.switch3) ;     // //REFERENCIAS XML
        _switch4=(Switch) findViewById(R.id.switch4);       //


        /////////////////////////////////switch con escuchador

        _switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    _switch4.setChecked(false);
                }else{
                    _switch4.setChecked(true);
                }

            }
        });

        _switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    _switch3.setChecked(false);
                }else {
                    _switch3.setChecked(true);
                }
            }
        });
        ////////////////////////////////////////////////////////////
        //calendario



       //////////////////////////////////////////////////////////////////
        //////////////////////escuchador

        _Back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Main4Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });



    }
}
