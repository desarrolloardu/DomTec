package com.example.matiasdaniel.domtec;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by MatiasDaniel on 8/4/2016.
 */
public class OnOffActivity extends AppCompatActivity {

    //TextView content;
  //  public String ipArduino;
    private String BTadressOnOff = "98:D3:31:70:30:80";
    Globals g = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        g = (Globals)getApplication();
        if (g.ConectarBluetooth(BTadressOnOff) < 0) {// hubo un error en la conexion
            Toast.makeText(getApplicationContext(),"Fallo la conexion", Toast.LENGTH_SHORT).show();
            g.DesconectarBluetooth();
        }

        else { //Se logro la conexion.*/
            setContentView(R.layout.activity_on_off);
        }
     //   ipArduino = String.valueOf(getIntent().getExtras().getString("ipArduino"));
    }

    public void OffClick(View v)
    {

       // Toast.makeText(OnOffActivity.this, "OFF", Toast.LENGTH_SHORT).show();
        g.sendData(Integer.toString(0));
    /*
        AsyncHttpClient client = new AsyncHttpClient();
        //client.get("http://192.168.0.100:2000?onoff" + String.valueOf(getIntent().getExtras().getInt("posicion")) + "=off", new AsyncHttpResponseHandler() {
        client.get(ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) + "=OFF;", new AsyncHttpResponseHandler()
        {

        });
*/
    }

    public void OnClick(View v)
    {

       // Toast.makeText(OnOffActivity.this, "ON", Toast.LENGTH_SHORT).show();
        g.sendData(Integer.toString(1));
        /*
        Toast.makeText(OnOffActivity.this, String.valueOf(getIntent().getExtras().getString("ipArduino")) + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) + "=ON;", Toast.LENGTH_SHORT).show();
        AsyncHttpClient client = new AsyncHttpClient();

        //client.get("http://192.168.0.102:2000/?salida1=ON;", new AsyncHttpResponseHandler()
        client.get(ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) + "=ON;", new AsyncHttpResponseHandler()
        {

//    	    @Override
//    	    public void onSuccess(String response) {
//    	    	content.setText(response);
//    	       // System.out.println(response);
//    	    }
        });
*/
    }

}