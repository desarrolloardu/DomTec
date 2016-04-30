package com.example.matiasdaniel.domtec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MatiasDaniel on 8/4/2016.
 */
public class TvActivity extends AppCompatActivity  {

    //TextView content;
   // public String ipArduino;
    public TvController tvController = new TvController("sanyo");

    private String BTadressTv = "98:D3:31:90:2C:00";
    Globals g = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        g = (Globals)getApplication();
        if (g.ConectarBluetooth(BTadressTv) < 0) {// hubo un error en la conexion
            Toast.makeText(getApplicationContext(),"Fallo la conexion", Toast.LENGTH_SHORT).show();
            g.DesconectarBluetooth();
        }

        else { //Se logro la conexion.
            setContentView(R.layout.activity_tv);
        }

        //region codigoViejo
/*
      //  ipArduino = String.valueOf(getIntent().getExtras().getString("ipArduino"));

        Button subircanal=(Button)findViewById(R.id.subircanal);
        Button bajarcanal=(Button)findViewById(R.id.bajarcanal);
        Button subirvolumen=(Button)findViewById(R.id.subirvolumen);
        Button bajarvolumen=(Button)findViewById(R.id.bajarvolumen);
        Button onoff=(Button)findViewById(R.id.onoff);
        Button mute=(Button)findViewById(R.id.mute);

        onoff.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                    // Toast.makeText(getApplicationContext(), "subiendo canal", Toast.LENGTH_LONG).show();
                    // CALL GetText method to make post method call
                    // GetText();
                    String onoff = tvController.getOnoff();
                    //Toast.makeText(getApplicationContext(), ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=68-38-" + subircanal, Toast.LENGTH_LONG).show();

                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                    // content.setText(" url exeption! " );
                }
            }
        });

        mute.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                    // CALL GetText method to make post method call
                    // GetText();
                    String mute = tvController.getMute();
                    //Toast.makeText(getApplicationContext(), ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=68-38-" + subircanal, Toast.LENGTH_LONG).show();

                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                    // content.setText(" url exeption! " );
                }
            }
        });

        subircanal.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                    // Toast.makeText(getApplicationContext(), "subiendo canal", Toast.LENGTH_LONG).show();
                    // CALL GetText method to make post method call
                    // GetText();
                    //String subircanal = "4600,4350,700,1500,700,1500,700,1550,700,450,650,400,700,450,650,450,700,400,700,1500,700,1550,650,1550,700,450,650,450,700,400,700,400,700,400,700,400,700,1550,700,400,700,400,700,1550,650,450,700,400,700,400,700,1550,650,450,650,1600,650,1550,650,450,700,1500,700,1500,700,1550,650;";
                    String subircanal = tvController.getSubircanal();
                    //Toast.makeText(getApplicationContext(), ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=68-38-" + subircanal, Toast.LENGTH_LONG).show();

                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                    // content.setText(" url exeption! " );
                }
            }
        });

        bajarcanal.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                    //Toast.makeText(getApplicationContext(), "bajando canal", Toast.LENGTH_LONG).show();
                    //String bajarcanal = "4650,4300,700,1550,700,1500,700,1550,700,400,700,400,700,400,700,450,650,450,650,1550,700,1500,700,1550,700,400,700,400,700,400,700,450,700,400,700,400,700,400,700,450,650,450,650,1550,700,400,700,450,650,400,700,1550,700,1500,700,1550,700,1500,700,400,700,1550,650,1550,700,1500,700;";
                    String bajarcanal = tvController.getBajarcanal();
                    // CALL GetText method to make post method call
                    // GetText();

                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_SHORT).show();
                    // content.setText(" url exeption! " );
                }
            }
        });

        subirvolumen.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                    //Toast.makeText(getApplicationContext(), "subiendo volumen", Toast.LENGTH_SHORT).show();
                    // CALL GetText method to make post method call
                    // GetText();
                    //String subirvolumen = "4600,4350,650,1550,700,1500,700,1550,700,400,700,400,700,450,650,450,700,400,700,1500,700,1550,650,1550,700,400,700,400,700,450,650,450,700,400,700,1500,700,1550,650,1550,700,400,700,450,700,400,700,400,700,400,700,450,650,450,650,450,650,1550,700,1500,700,1550,700,1500,700,1550,650;";
                    String subirvolumen = tvController.getSubirvolumen();

                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_SHORT).show();
                    // content.setText(" url exeption! " );
                }
            }
        });

        bajarvolumen.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                    //Toast.makeText(getApplicationContext(), "bajando volumen", Toast.LENGTH_SHORT).show();
                    //String bajarvolumen = "4600,4350,700,1550,650,1550,700,1500,700,450,650,450,700,400,700,400,700,400,700,1550,700,1500,700,1550,700,400,700,400,700,400,700,450,650,450,650,1550,700,1500,700,450,650,1550,700,400,700,400,700,450,700,400,700,400,700,400,700,1550,700,400,700,1500,700,1500,700,1550,700,1500,700;";
                    String bajarvolumen = tvController.getBajarvolumen();
                    // CALL GetText method to make post method call
                    // GetText();

                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                    // content.setText(" url exeption! " );
                }
            }
        });
        */
        //endregion
    }

    public void OnOffClick(View v)
    {

        Toast.makeText(getApplicationContext(), "ONOFF", Toast.LENGTH_SHORT).show();
        g.sendData(tvController.getOnoff());
    }

    public void SubirCanalClick(View v)
    {

        Toast.makeText(getApplicationContext(), "SubirCanalClick", Toast.LENGTH_SHORT).show();
        g.sendData(tvController.getSubircanal());

    }

    public void BajarVolumenClick(View v)
    {

        Toast.makeText(getApplicationContext(), "BajarVolumenClick", Toast.LENGTH_SHORT).show();
        g.sendData(tvController.getBajarvolumen());

    }

    public void MuteClick(View v)
    {

        Toast.makeText(getApplicationContext(), "MuteClick", Toast.LENGTH_SHORT).show();
        g.sendData(tvController.getMute());

    }

    public void SubirVolumenClick(View v)
    {

        Toast.makeText(getApplicationContext(), "SubirVolumenClick", Toast.LENGTH_SHORT).show();
        g.sendData(tvController.getSubirvolumen());

    }

    public void BajarCanalClick(View v)
    {

        Toast.makeText(getApplicationContext(), "BajarCanalClick", Toast.LENGTH_SHORT).show();
        g.sendData(tvController.getBajarcanal());

    }











}

