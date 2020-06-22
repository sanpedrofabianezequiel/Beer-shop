package com.example.appmarzo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {



    ImageView imagenClip; //Creacion de objetos
    ImageView imageFlecha; //
    Button _validar;        //
    ImageButton _back2;       //
                                //
                                   //
    EditText _recibidorProducto;     //
    EditText _recibidorDisponibilidad;//
    EditText _recibidorColor;           //
    EditText _recibidorTapa;              //
    EditText _recibidorGrado;               //
    EditText _recibidorGrafica;               //
    TextView _textViewCantidad;                 //

    ConstraintLayout guardado;                      //
    ConstraintLayout _menu;                           //
    ConstraintLayout enviarMenu;                        //

    Button _si;                                             //
    Button _no;                                              //
    Button  _enviado;                                         //
    Button  _noEnviado;                                         //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        imagenClip = (ImageView) findViewById(R.id.clipView);      // guardar
        imageFlecha=(ImageView) findViewById(R.id.clipView2);       //flecha de enviar

        imagenClip.setImageResource(R.drawable.clip);   //seteo la imagen del clip

                                                                          //referencias XML
        _validar=(Button) findViewById(R.id.validar_);                     //
        _back2=(ImageButton) findViewById(R.id.back_2);                     //
        _textViewCantidad=(TextView) findViewById(R.id.textViewCantidad);    //
        _recibidorProducto=(EditText) findViewById(R.id.editText5);           //
        _recibidorDisponibilidad=(EditText) findViewById(R.id.editText14);     //
        _recibidorColor=(EditText) findViewById(R.id.editText19);               //
        _recibidorTapa=(EditText) findViewById(R.id.editText16);                 //
        _recibidorGrado=(EditText) findViewById(R.id.editText17);                 //
        _recibidorGrafica=(EditText) findViewById(R.id.editText15);                //



        guardado=(ConstraintLayout) findViewById(R.id.guardarID);
        _menu=(ConstraintLayout) findViewById(R.id.menuID);
        _si=(Button) findViewById(R.id.siID);
        _no=(Button) findViewById(R.id.noID);

        enviarMenu=(ConstraintLayout) findViewById(R.id.enviarID);
        _enviado=(Button) findViewById(R.id.siEnviarID);
        _noEnviado=(Button) findViewById(R.id.noEnviarID);

        Bundle x=getIntent().getExtras();                           //
        if(x != null){                                                //
            String medida=x.getString("MEDIDA");                  //
            _textViewCantidad.setText(medida);                          // BUNDLE main2activity recibidor
                                                                         //
            String producto=x.getString("TIPO");                     //
            _recibidorProducto.setText(producto);                          //
                                                                            //
            String  disponibilidaCerveza=x.getString("DISPONIBILIDAD"); //
            _recibidorDisponibilidad.setText(disponibilidaCerveza);           //
                                                                                //
            String  color=x.getString("COLOR");                             //
            _recibidorColor.setText(color);                                       //
                                                                                   //
            String tapa=x.getString("TAPA");                                   //
            _recibidorTapa.setText(tapa);                                            //
                                                                                      //
            String grado=x.getString("GRADO");                                    //
            _recibidorGrado.setText(grado);                                             //
                                                                                         //
            String grafica=x.getString("GRAFICA");                                   //
            _recibidorGrafica.setText(grafica);                                           //
        }                                                                                  //

        imagenClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {               //
                guardado.setVisibility(View.VISIBLE);       //
                _menu.setVisibility(View.INVISIBLE);        //
                                                            //GUARDAR INFORMACION SQL
                if(imagenClip.isPressed()){                 //
                    guardar();                              //
                    noGuardar();                            //
                }

            }
        });
        //////////////////////////////////////
        imageFlecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {           //
                enviarMenu.setVisibility(View.VISIBLE);     ///
                _menu.setVisibility(View.INVISIBLE);            // Enviar informacion (SQL)

                if (imageFlecha.isPressed()){                       //
                    enviado();                                          //
                    noEnviado();                                            //
                }
            }
        });


//////////////////////////////////////////////////////////////////////////////////////////////////
        _validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                                      //
                Intent x= new Intent(Main3Activity.this,Main4Activity.class);     //
                startActivity(x);                                                               //escuchadores e Intent
            }
        });                                                                                     //
        _back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                                       //
                Intent i= new Intent(Main3Activity.this,Main2Activity.class);     //
                startActivity(i);                                                               //
            }
        });                                                                                     //
//////////////////////////////////////////////////////////////////////////////////////////////////
        //main




    }

                    public void guardar(){

                        _si.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                guardado.setVisibility(View.INVISIBLE);
                                _menu.setVisibility(View.VISIBLE);
                            }
                        });

                    }
                    public void noGuardar(){
                        _no.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                guardado.setVisibility(View.INVISIBLE);
                                _menu.setVisibility(View.VISIBLE);
                            }
                        });

                    }

                    public void enviado(){
                            _enviado.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    enviarMenu.setVisibility(View.INVISIBLE);
                                    _menu.setVisibility(View.VISIBLE);
                                }
                            });

                    }
                    public void  noEnviado(){
                            _noEnviado.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    enviarMenu.setVisibility(View.INVISIBLE);
                                    _menu.setVisibility(View.VISIBLE);
                                }
                            });
                    }






}
