package com.example.appmarzo;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {



    boolean verificacionFecha1;         // Variable para pasar a la suiguiente actividad
    boolean verificacionFecha2;         //
    boolean verificacionFecha3;         //
    boolean verificacionFecha4;         //
    Button continuar__2;             //
    Button next;                     //
    ImageButton _back1;              //
    Switch _OnOff;                   //
    Switch _OnOff2;                  //
    TextView _Visor1;               //Creacion de Objetos
    Button _Calendario1;            //
    TextView _Visor2;               //
    Button _Calendario2;            //
    TextView _Visor3;               //
    Button _Calendario3;            //
    TextView _Visor4;               //
    Button _Calendario4;            //

    TextView _recibidorMedida;       //
    TextView _recibidorTipoCerveza;  //Objeto Recibidores
    TextView _recibidorColor;        //
    TextView _recibidorTapa;         //
    TextView _recibidorGrado;        //
    TextView _recibidorGrafica;      //



 ////////////////////////////////////////////////////////////////////
    private static final  String CERO="0";                         //
    private static  final String BARRA="/";                        //Variables y punteros o cursor
    static int Manejador;                                          // para dirigir la informacion al cuadro de fecha correcto
                                                                   //
    //Import la clase calendario +  =Calendar.getInstance          //
    //NO CREAR UN OBJTEO DE CALENDAR SOLO IGUALAR                  //
    public final Calendar c= Calendar.getInstance();               //simil Puntero o cursor en Sql       Instancio un Objeto de la clase Calendar
                                                                    //
    final int mes =c.get(Calendar.MONTH);                           //Almecenar en variable el cursor. Simil var=c.execute(Drop Table)
    final int dia =c.get(Calendar.DAY_OF_MONTH);                    //
    final int anio =c.get(Calendar.YEAR);                           //
/////////////////////////////////////////////////////////////////////


    @Override                                                          //
    protected void onCreate(Bundle savedInstanceState) {                 //
        super.onCreate(savedInstanceState);                                //Oncreate del Main
        setContentView(R.layout.activity_main2);                             //

                                                                        //
        continuar__2=(Button) findViewById(R.id.continuar_2);            //Referencias con XML Buton Continuar/next/back
         next=(Button) findViewById(R.id.obtenerFecha);                    //
         _back1=(ImageButton) findViewById(R.id.back_3);                    //
                                                                             //
             _OnOff=(Switch) findViewById(R.id.OnOff_1);                      //
             _OnOff2=(Switch) findViewById(R.id.OnOff_2);                      //

        _Visor1=(TextView) findViewById(R.id.Visor_1);                     //
        _Calendario1=(Button) findViewById(R.id.obtenerFecha);              //Referencias con XML Calendario
                                                                             //
        _Visor2=(TextView) findViewById(R.id.Visor_2);                        //
        _Calendario2=(Button)  findViewById(R.id.obtenerFecha2);               //
                                                                                //
        _Visor3=(TextView) findViewById(R.id.Visor_3);                           //
        _Calendario3=(Button) findViewById(R.id.obtenerFecha3);                   //
                                                                                   //
        _Visor4=(TextView) findViewById(R.id.Visor_4);                              //
        _Calendario4=(Button) findViewById(R.id.obtenerFecha4);                      //


        _recibidorMedida=(TextView) findViewById(R.id.recibidorMedidaID);                //
        _recibidorTipoCerveza=(TextView) findViewById(R.id.recibidorTipoID);               //      Recibidores
        _recibidorColor=(TextView) findViewById(R.id.colorID);                              //
        _recibidorTapa=(TextView) findViewById(R.id.recibidorTapaID);                        //
        _recibidorGrado=(TextView) findViewById(R.id.recibidorGradoID);                        //
        _recibidorGrafica=(TextView) findViewById(R.id.recibidorGraficaID);                     //

        Bundle x=getIntent().getExtras();                   //
        if(x != null){                                       //
            String medida=x.getString("MEDIDA");         //
            _recibidorMedida.setText(medida);                  // BUNDLE main1activity recibidor DEL main1Activity
                                                                //
            String tipoCerveza=x.getString("TIPO");         //
            _recibidorTipoCerveza.setText(tipoCerveza);           //
                                                                   //
            String color=x.getString("COLOR");                 //
            _recibidorColor.setText(color);                          //
                                                                       //
            String tapa=x.getString("TAPA");                       //
            _recibidorTapa.setText(tapa);                                //
                                                                          //
            String grado=x.getString("GRADO");                        //
            _recibidorGrado.setText(grado);                                 //
                                                                             //
            String grafica=x.getString("GRAFICA");                       //
            _recibidorGrafica.setText(grafica);                                //
                                                                                //
        }                                                                        //


        _Calendario1.setOnClickListener(this);                  //
        _Calendario2.setOnClickListener(this);                  //escuchador del selector de fechas/calendario
        _Calendario3.setOnClickListener(this);                  //
        _Calendario4.setOnClickListener(this);                  //

 /////////////////////////////////////////////////////////////////////////////////////////////////

        continuar__2.setOnClickListener(new View.OnClickListener() {                             //
            @Override                                                                             //
            public void onClick(View v) {                                                           //
                                                                                                     //
              //intent                                                                                //      ESCUCHADOR + INTENT
                Intent i= new Intent(Main2Activity.this,Main3Activity.class);           //     Esuchador de boton continuar+ envio de informacion a Main3
                    if(_OnOff.isChecked()){                                                             //
                        String pedidoConvencional="Entrega en 7o 15 o 30 dias Habiles";                  //
                        i.putExtra("MEDIDA",_recibidorMedida.getText().toString());                 //
                        i.putExtra("TIPO",_recibidorTipoCerveza.getText().toString());               //
                        i.putExtra("DISPONIBILIDAD",pedidoConvencional);                              //
                        i.putExtra("COLOR",_recibidorColor.getText().toString());                       //
                        i.putExtra("TAPA",_recibidorTapa.getText().toString());                          //
                        i.putExtra("GRADO",_recibidorGrado.getText().toString());                         //
                        i.putExtra("GRAFICA",_recibidorGrafica.getText().toString());                      //
                    }else if(_OnOff2.isChecked()){                                                                 //
                        String  pedidoConUrgencia="Entrega en 48hs";                                                //
                        i.putExtra("MEDIDA",_recibidorMedida.getText().toString());                           //
                        i.putExtra("TIPO",_recibidorTipoCerveza.getText().toString());                         //
                        i.putExtra("DISPONIBILIDAD",pedidoConUrgencia);                                         //
                        i.putExtra("COLOR",_recibidorColor.getText().toString());                                //
                        i.putExtra("TAPA",_recibidorTapa.getText().toString());                                   //
                        i.putExtra("GRADO",_recibidorGrado.getText().toString());                                 //
                        i.putExtra("GRAFICA",_recibidorGrafica.getText().toString());                              //
                    }

                    if(_OnOff.isChecked()||_OnOff2.isChecked() )              //
                    {                                                          //   Condicionales para pasar a la siguiente actividad
                                                                                //
                       if(verificacionFecha1==true &&                            //
                               verificacionFecha2==true &&                        //
                                 verificacionFecha3==true &&                       //
                                     verificacionFecha4==true ){                    //
                                 startActivity(i);                                   //
                       }                                                              //
                    }                                                                  //
                                                                                        //
                }                                                                        //
        });                                                                      //


        _back1.setOnClickListener(new View.OnClickListener() {                                   //
            @Override                                                                             //
            public void onClick(View v) {                                                          //   back ACTIVITY
                //intent                                                                            //
                Intent i= new Intent(Main2Activity.this,MainActivity.class);           //
                startActivity(i);                                                                     //
            }                                                                                          //
        });                                                                                         //
//////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                                //
        _OnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {         //
            @Override                                                                             //
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {                             //
                        if(isChecked){                                                              //escuchador del  primer switch
                            _OnOff2.setChecked(false);                                               //
                        }else{                                                                        //
                            _OnOff2.setChecked(true);                                                  //
                        }                                                                               //
            }                                                                                            //
        });                                                                                           //

        _OnOff2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {          //
            @Override                                                                               //
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {             //
                if(isChecked){                                                                        // escucahdor del segundo switch
                    _OnOff.setChecked(false);                                                          //
                }else{                                                                                  //
                    _OnOff.setChecked(true);                                                             //
                }                                                                                         //
            }                                                                                              //
        });                                                                                                  //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //END ONCREATE//END ONCREATE//END ONCREATE//END ONCREATE//END ONCREATE//END ONCREATE//END ONCREATE//END ONCREATE
    }
//////////////////////////////////////////////////////////////
///metodo implentado luego del IMPLEMENTS                   //
// View.OnclickListener                                     //
// en el Main                                               //
    @Override                                               //
    public void onClick(View v) {                           //DatePickerDialog
                                                            //
                    switch (v.getId()){                     //
                            case R.id.obtenerFecha:         //
                                obtenerFecha();             //Switch cuando se hace click sobre el selector de fechas llama  a la funcion OBTENER FECHA
                                Manejador=1;                //
                                verificacionFecha1=true;     //
                                break;                      //
                            case R.id.obtenerFecha2:        //
                                obtenerFecha();             //
                                Manejador=2;                //
                                verificacionFecha2=true;     //
                                break;                      //
                            case R.id.obtenerFecha3:        //
                                obtenerFecha();             //
                                Manejador=3;                //
                                verificacionFecha3=true;     //
                                break;                      //
                            case R.id.obtenerFecha4:        //
                                obtenerFecha();             //
                                Manejador=4;                //
                                verificacionFecha4=true;     //
                                break;                      //
                    }                                       //
    }                                                       //
                                                            //////////////////////////////////////////////////////////////////////
                                                                                                                                //
    public void obtenerFecha(){                                                                                                 //
        //uso la classe importada DatePickerDialog                                                                              //
        //Creo un objeto de la Clase DataPickerDialog                                                                           //
        //Enviarles parametros contexto=THIS, nuevo objeto de DatePickerDialog + funcion.OnDateSetListener(){}                  //
        DatePickerDialog recogerFecha= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {            //
            @Override                                                                                                           //
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {                   //
                                                                                                                                //
                            final int mesActual=month+1;  //sumo 1 ya que comienzo de 0=enero                                   //

                            String diaFormateado=(dayOfMonth<10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);   //formateo de fecha
                            String mesFormateado=(mesActual<10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);        //

                            switch (Manejador){                                                                                 //
                                case 1:                                                                                         //
                                    _Visor1.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);                      //Mostrar fecha en el formato nuevo en el visor o textview su objeto
                                            break;                                                                              //
                                case 2:                                                                                         //
                                    _Visor2.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);                      //
                                            break;                                                                              //
                                case 3:                                                                                         //
                                    _Visor3.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);                      //
                                    break;                                                                                      //
                                case 4:                                                                                         //
                                    _Visor4.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);                      //
                                    break;                                                                                      //
                            }                                                                                                   //
            }                                                                                                                   //
        },anio,mes,dia); //este es el orden correcto,sino no compila (estos parametros se encargan de cuando se abre el calendario aplique las funciones de Calendar previamente definidas en el HEAD(c.get...))
                                                                                                                                //
         recogerFecha.show();                                                                                                   //
    }                                                                                                                           //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    //main
}
