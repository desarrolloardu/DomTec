package com.example.matiasdaniel.domtec;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * Created by MatiasDaniel on 8/4/2016.
 * 
 */
public class DimmerActivity extends AppCompatActivity {

    SeekBar barra;
    TextView enviando;
    private String BTadress = "98:D3:31:60:0E:AA";
 //   public String ipArduino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Globals g = (Globals)getApplication();
        if (g.ConectarBluetooth(BTadress) < 0) {// hubo un error en la conexion
            Toast.makeText(getApplicationContext(),"Fallo la conexion", Toast.LENGTH_SHORT).show();
            g.DesconectarBluetooth();
        }

        else { //Se logro la conexion.
            setContentView(R.layout.dimmer);

            //       ipArduino = String.valueOf(getIntent().getExtras().getString("ipArduino"));
            enviando = (TextView) findViewById(R.id.enviando);
            barra = (SeekBar) findViewById(R.id.seekBar1);

            barra.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    int intensidad = seekBar.getProgress() / 5;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                    //add here your implementation
                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {

                    int intensidad = progress / 5;

                    Globals g = (Globals) getApplication();
                    g.sendData(Integer.toString(intensidad) + ";");

                    // Toast.makeText(getApplicationContext(), "Global data = " + g.getData(), Toast.LENGTH_SHORT).show();
                    enviando.setText(Integer.toString(intensidad));

                    //texto.setText(progress);
                    //add here your implementation
                }
            });
        }
    }

}

