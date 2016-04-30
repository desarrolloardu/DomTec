package com.example.matiasdaniel.domtec;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private ListView lista; //la lista de ambientes visual
    ArrayList<Objeto> listaActividades = new ArrayList<Objeto>();

/*
    private BluetoothAdapter BA;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;
    //////////////////////////////////////
    private static final UUID MY_UUID =
            UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static String address = "98:D3:31:60:0E:AA";  //la mac del arduino Bluetooth
//////////////////////////////////////
*/
  //  private String ipArduino = "http://192.168.0.102:2000";


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"RESUME",Toast.LENGTH_SHORT).show();

        ((Globals)getApplication()).DesconectarBluetooth();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Globals g = (Globals)getApplication();
        g.BA = BluetoothAdapter.getDefaultAdapter();
        TurnBluetoothOn();

       // g.DesconectarBluetooth();

        setContentView(R.layout.listado);

        listaActividades.add(new OnOff(R.drawable.luz, "On - Off 1", "Controlar Dispositivo 1", 1));
        listaActividades.add(new Dimmer(R.drawable.luz, "Luz Dimmer 1", "Controlar Luz Dimmer 1", 2));
        listaActividades.add(new OnOff(R.drawable.luz, "On - Off 2", "Controlar Dispositivo 2", 5));
        listaActividades.add(new Dimmer(R.drawable.luz, "Luz Dimmer 2", "Controlar Luz Dimmer 2", 6));
        listaActividades.add(new Tv(R.drawable.television, "Television", "Controlar Television", 3));
        listaActividades.add(new Aire(R.drawable.aire, "Aire Acondicionado", "Aire Acondicionado", 3));
        RefrescarListado();

    }

    private void TurnBluetoothOn(){
        if (!((Globals)getApplication()).BA.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            Toast.makeText(getApplicationContext(),"Turned on",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Already on", Toast.LENGTH_SHORT).show();
        }
    }



/*
    private int ConectarBluetooth(){

        int falla = 0;
        Globals g = (Globals)getApplication();
         //Toast.makeText(getApplicationContext(), "Conectando", Toast.LENGTH_SHORT).show();

        // Set up a pointer to the remote node using it's address.
        BluetoothDevice device = g.BA.getRemoteDevice(g.address);

        Toast.makeText(getApplicationContext(), "Conectando a:" + device.getAddress(), Toast.LENGTH_SHORT).show();

        // Two things are needed to make a connection:
        //   A MAC address, which we got above.
        //   A Service ID or UUID.  In this case we are using the
        //     UUID for SPP.
        try {
            g.btSocket = device.createRfcommSocketToServiceRecord(g.MY_UUID);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Fatal Error - socket create failed: " + e.getMessage() + ".", Toast.LENGTH_SHORT).show();
            falla = -1;
        }catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Fatal Error - socket create failed: " + ex.getMessage() + ".", Toast.LENGTH_SHORT).show();
            falla = -1;
        }

        // Discovery is resource intensive.  Make sure it isn't going on
        // when you attempt to connect and pass your message.
        g.BA.cancelDiscovery();

        try {
            g.btSocket.connect();
            Toast.makeText(getApplicationContext(), "Conecto OK a:" + device.getAddress(), Toast.LENGTH_SHORT).show();

            try {
                g.outStream = g.btSocket.getOutputStream();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "Output stream creation failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                falla = -2;
            }catch (Exception ex) {
                Toast.makeText(getApplicationContext(), "Fatal Error - socket create failed: " + ex.getMessage() + ".", Toast.LENGTH_SHORT).show();
                falla = -2;
            }

        } catch (IOException e) {
            try {
                g.btSocket.close();
            } catch (IOException e2) {
                Toast.makeText(getApplicationContext(), "Fatal Error - unable to close socket during connection failure: " + e2.getMessage() + ".", Toast.LENGTH_SHORT).show();
                falla = -3;
            }catch (Exception ex) {
                Toast.makeText(getApplicationContext(), "Fatal Error - socket create failed: " + ex.getMessage() + ".", Toast.LENGTH_SHORT).show();
                falla = -3;
            }

            Toast.makeText(getApplicationContext(), "Fatal Error - socket connection failed: " + e.getMessage() + ".", Toast.LENGTH_SHORT).show();
            falla = -4;
        }

        return falla;
    }
*/

    private void RefrescarListado()
    {
        lista = (ListView) findViewById(R.id.ListView_listado);

        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, listaActividades) {

            @Override
            public void onEntrada(Object entrada, View view) {

                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Objeto) entrada).get_textoEncima());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Objeto) entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Objeto) entrada).get_idImagen());
                }

            }


        });

        lista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Objeto elegido = (Objeto) pariente.getItemAtPosition(posicion);

                switch (elegido.getTipo()) {
                    case "Dimmer":
                        Intent intent = new Intent(getApplicationContext(), DimmerActivity.class);
                        intent.putExtra("posicion", ((Dimmer)elegido).getPosicion());
                      //  intent.putExtra("ipArduino", getIpArduino());
                        startActivity(intent);
                        break;
                    case "Tv":
                        Intent intentTv = new Intent(getApplicationContext(), TvActivity.class);
                    //    intentTv.putExtra("ipArduino", getIpArduino());
                        intentTv.putExtra("posicion", ((Tv)elegido).getPosicion());
                        startActivity(intentTv);
                        break;
                    case "Aire":
                        Intent intentAire = new Intent(getApplicationContext(), AireActivity.class);
                    //    intentAire.putExtra("ipArduino", getIpArduino());
                        intentAire.putExtra("posicion", ((Aire)elegido).getPosicion());
                        startActivity(intentAire);
                        break;
                    case "OnOff":
                      //  Toast.makeText(getApplicationContext(), "Llamando a SendData", Toast.LENGTH_SHORT).show();
                      //  Globals g = (Globals)getApplication();
                     //   g.sendData("D");
                      //  Toast.makeText(getApplicationContext(), "LLAMO a SendData", Toast.LENGTH_SHORT).show();

                        Intent intentOnOff = new Intent(getApplicationContext(), OnOffActivity.class);
                        intentOnOff.putExtra("posicion", ((OnOff) elegido).getPosicion());
                    //    intentOnOff.putExtra("ipArduino", getIpArduino());
                        startActivity(intentOnOff);

                        break;
                    default:

                        CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                        Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                        toast.show();

                        break;

                }
            }
        });

    }

  //  public String getIpArduino() {
      //  return ipArduino;
  //  }
}
