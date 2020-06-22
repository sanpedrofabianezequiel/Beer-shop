package com.example.appmarzo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variables globales




    Button _continuar;                  //
    Spinner _spinermedida;              //
    TextView mostrarCapacidad;          //
                                        //
    Button _cervezaRoja;                //      Objetos
    Button _cervezaNegra;               //
    Button _cervezaRubia;               //
                                        //
    CheckBox _checkbox4;                //
    CheckBox _checkbox2;                //
    CheckBox _checkbox3;                //

                                                                //
    @Override                                                   //
    protected void onCreate(Bundle savedInstanceState) {        //Main
        super.onCreate(savedInstanceState);                     //
        setContentView(R.layout.activity_main);                 //



        _continuar=(Button) findViewById(R.id.continuar_1);                    //
                                                                                //
        _spinermedida=(Spinner) findViewById(R.id.spinnermedida_);               //
        mostrarCapacidad=(TextView) findViewById(R.id.capacidadId);               //
                                                                                   //REFERENCIAS XML
        _cervezaRoja=(Button) findViewById(R.id.cervezaRoja);                       //
        _cervezaNegra=(Button) findViewById(R.id.cervesaNegra);                      //
        _cervezaRubia=(Button) findViewById(R.id.cervezaRubia);                       //
                                                                                       //
                                                                                        //
        _checkbox4=(CheckBox) findViewById(R.id.checkBox4 );                             //
        _checkbox3=(CheckBox) findViewById(R.id.checkBox3);                               //
        _checkbox2=(CheckBox) findViewById(R.id.checkBox2);                                //

/////////////////////////////////////////////////////////////////////////////////////
        _cervezaRoja.setOnClickListener(new View.OnClickListener() {                //
            @Override                                                               //
            public void onClick(View v) {                                    //
                            if(v.isClickable()){                                    //
                                _checkbox4.setChecked(true);                        //
                                _checkbox3.setChecked(false);                       //
                                _checkbox2.setChecked(false);                       //
                            }                                                       //
            }                                                                       //
        });                                                                      //
        _cervezaNegra.setOnClickListener(new View.OnClickListener() {               //
            @Override                                                               //CheckBox+Buton Cervezas
            public void onClick(View v) {                                    //
                    if(v.isClickable()){                                            //
                        _checkbox4.setChecked(false);                               //
                        _checkbox3.setChecked(true);                                //
                        _checkbox2.setChecked(false);                               //
                    }                                                               //
            }                                                                       //
        });                                                                     //
        _cervezaRubia.setOnClickListener(new View.OnClickListener() {               //
            @Override                                                               //
            public void onClick(View v) {                                   //
                if(v.isClickable()){                                                //
                    _checkbox4.setChecked(false);                                   //
                    _checkbox3.setChecked(false);                                   //
                    _checkbox2.setChecked(true);                                    //
                                                                                    //
                }                                                                   //
            }                                                                       //
        });                                                                     //
                                                                                    //
////////////////////////////////////////////////////////////////////////////////////////////
                                                                                            //
                                                                                           //
        _continuar.setOnClickListener(new View.OnClickListener() {                          //
            @Override                                                                       //
            public void onClick(View v) {                                              //
                                                                                            // BOTON NEXT ACTIVITY +
                Intent i= new Intent(MainActivity.this,Main2Activity.class);  //   Intent a MAIN2activity
                //i.putExtra ("MEDIDA",mostrarCapacidad.getText().toString());              //
                if ( _checkbox4.isChecked()){                                               //
                    String cervezaTipoRoja="Cerveza ";                                       //
                    String color="Roja";                                                    //
                    String tapa="Tapa Roja";                                                //
                    String gradoAlimenticio="0.0 g";                                        //
                    String Grafica="Ovalada";                                               //
                    i.putExtra("MEDIDA",mostrarCapacidad.getText().toString());       //
                    i.putExtra("TIPO",cervezaTipoRoja);                               //
                    i.putExtra("COLOR",color);                                        //
                    i.putExtra("TAPA",tapa);                                         //
                    i.putExtra("GRADO",gradoAlimenticio);                             //
                    i.putExtra("GRAFICA",Grafica);                                    //

                                                                                            //
                }else if(_checkbox3.isChecked()){                                           //
                    String cervezaTipoNegra="Cerveza ";                                     //
                    String color="Negra";                                                   //
                    String tapa="Tapa Negra";                                               //
                    String gradoAlimenticio="0.0 g";                                        //
                    String Grafica="Redonda";                                               //
                    i.putExtra("MEDIDA",mostrarCapacidad.getText().toString());      //
                    i.putExtra("TIPO",cervezaTipoNegra);                             //
                    i.putExtra("COLOR",color);                                       //
                    i.putExtra("TAPA",tapa);
                    i.putExtra("GRADO",gradoAlimenticio);                             //
                    i.putExtra("GRAFICA",Grafica);                                    //
                }else if(_checkbox2.isChecked()){                                           //
                    String cervezaTipoRubia="Cerveza ";                                     //
                    String color="Rubia";                                                   //
                    String tapa="Tapa Rubia";                                               //
                    String gradoAlimenticio="0.0 g";                                        //
                    String Grafica="Cuadrada";                                               //
                    i.putExtra("MEDIDA",mostrarCapacidad.getText().toString());       //
                    i.putExtra("TIPO",cervezaTipoRubia);                              //
                    i.putExtra("COLOR",color);                                        //
                    i.putExtra("TAPA",tapa);                                         //
                    i.putExtra("GRADO",gradoAlimenticio);                             //
                    i.putExtra("GRAFICA",Grafica);                                    //
                }                                                                           //
                                                                                            //
                if(_checkbox4.isChecked() || _checkbox3.isChecked() || _checkbox2.isChecked())//
                {                                                                            //
                startActivity(i);                                                           //
                }                                                                            //
                                                                                             //
            }                                                                               //
        });                                                                              //
/////////////////////////////////////////////////////////////////////////////////////////////
        ///1-adaptador para el array adaptar                                                    //
        //2- inicializarlo                                                                        //
        //3 -from resource: crea el arreglo desde el recurso y envio los parametros                 //
        //(contexto*this,R.array.name,R.layout.nameplantilla)                                         //
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,               //
                R.array.arreglo_medida_cerveza,R.layout.support_simple_spinner_dropdown_item);            //
                                                                                                            //
        //como interecatua el adaptador con el array                                                          //
        //objeto.setDropDownViewResource(R.leyaou.....dropdown..)
        //
         adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);                        //
         //mostrartar o setear el adapatador hacia al spiner                                                    //
         _spinermedida.setAdapter(adapter);                                                                     //
         //////////////////////fin adapter////////////////////////////////////////// //////////////////         //

        _spinermedida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {                      //
            @Override                                                                                           //ADAPTER  + SNIPER (LISTA DE MEDIDAS)
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {               //
                                                                                                                //
                String lisMedida;                                                                               //
                lisMedida=_spinermedida.getSelectedItem().toString();                                           //
                mostrarCapacidad.setText(lisMedida);                                                            //
                                                                                                                //
            }                                                                                                   //
                                                                                                                //
            @Override                                                                                           //
            public void onNothingSelected(AdapterView<?> parent) {                                              //
                                                                                                                //
            }                                                                                                   //
        });                                                                                                     //
///// //////////////////////////////////////////////////////////////////////////////////////////////////////////









    }
}
