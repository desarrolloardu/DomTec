package com.example.matiasdaniel.domtec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by MatiasDaniel on 8/4/2016.
 */
public class AireActivity extends AppCompatActivity {

 //   public String ipArduino;
    public AireController aireController = new AireController("philco");
    public String modo = "frio";
    public int temperatura = 24;
    String IRtemperatura = aireController.getFrio24();  //IRtemperatura va guardando la temperatura actual del aire
    public ImageView tempimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aire);

    //    ipArduino = String.valueOf(getIntent().getExtras().getString("ipArduino"));

        Button subirtemperatura=(Button)findViewById(R.id.subirtemperatura);
        Button bajartemperatura=(Button)findViewById(R.id.bajartemperatura);
        Button frio=(Button)findViewById(R.id.frio);
        Button calor=(Button)findViewById(R.id.calor);
        Button onoff=(Button)findViewById(R.id.onoff);
        tempimg = (ImageView)findViewById(R.id.temperatura);


        calor.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                    //String onoff = aireController.getOn();
                    if(modo == "frio")
                    {
                        //Toast.makeText(getApplicationContext(), ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=276-38-" + onoff, Toast.LENGTH_LONG).show();
/*
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.get(ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=276-38-" + IRtemperatura, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(String response) {
                            }
                        });
*/
                        modo = "calor";
                    }

                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                }
            }
        });

        frio.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                    //String onoff = aireController.getOn();
                    if(modo == "calor")
                    {
                        //Toast.makeText(getApplicationContext(), ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=276-38-" + onoff, Toast.LENGTH_LONG).show();
/*
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.get(ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=276-38-" + IRtemperatura, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(String response) {
                            }
                        });
*/
                        modo = "frio";
                    }

                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                }
            }
        });


        onoff.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                    String onoff = aireController.getOn();
                    //Toast.makeText(getApplicationContext(), ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=276-38-" + onoff, Toast.LENGTH_LONG).show();
/*
                    AsyncHttpClient client = new AsyncHttpClient();
                    client.get(ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=276-38-" + onoff, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(String response) {
                        }
                    });
*/
                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                }
            }
        });


        bajartemperatura.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{

                    if(temperatura > 16)
                    {
                        temperatura--;
                        switch (temperatura) {
                            case 16:
                                tempimg.setImageResource(R.drawable.temp16);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio16();
                                else
                                    IRtemperatura = aireController.getCalor16();
                                break;
                            case 17:
                                tempimg.setImageResource(R.drawable.temp17);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio17();
                                else
                                    IRtemperatura = aireController.getCalor17();
                                break;
                            case 18:
                                tempimg.setImageResource(R.drawable.temp18);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio18();
                                else
                                    IRtemperatura = aireController.getCalor18();
                                break;
                            case 19:
                                tempimg.setImageResource(R.drawable.temp19);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio19();
                                else
                                    IRtemperatura = aireController.getCalor19();
                                break;
                            case 20:
                                tempimg.setImageResource(R.drawable.temp20);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio20();
                                else
                                    IRtemperatura = aireController.getCalor20();
                                break;
                            case 21:
                                tempimg.setImageResource(R.drawable.temp21);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio21();
                                else
                                    IRtemperatura = aireController.getCalor21();
                                break;
                            case 22:
                                tempimg.setImageResource(R.drawable.temp22);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio22();
                                else
                                    IRtemperatura = aireController.getCalor22();
                                break;
                            case 23:
                                tempimg.setImageResource(R.drawable.temp23);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio23();
                                else
                                    IRtemperatura = aireController.getCalor23();
                                break;
                            case 24:
                                tempimg.setImageResource(R.drawable.temp24);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio24();
                                else
                                    IRtemperatura = aireController.getCalor24();
                                break;
                            case 25:
                                tempimg.setImageResource(R.drawable.temp25);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio25();
                                else
                                    IRtemperatura = aireController.getCalor25();
                                break;
                            case 26:
                                tempimg.setImageResource(R.drawable.temp26);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio26();
                                else
                                    IRtemperatura = aireController.getCalor26();
                                break;
                            case 27:
                                tempimg.setImageResource(R.drawable.temp27);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio27();
                                else
                                    IRtemperatura = aireController.getCalor27();
                                break;
                            case 28:
                                tempimg.setImageResource(R.drawable.temp28);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio28();
                                else
                                    IRtemperatura = aireController.getCalor28();
                                break;
                            case 29:
                                tempimg.setImageResource(R.drawable.temp29);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio29();
                                else
                                    IRtemperatura = aireController.getCalor29();
                                break;
                            case 30:
                                tempimg.setImageResource(R.drawable.temp30);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio30();
                                else
                                    IRtemperatura = aireController.getCalor30();
                                break;
                            default:
                                tempimg.setImageResource(R.drawable.temp24);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio24();
                                else
                                    IRtemperatura = aireController.getCalor24();
                                break;
                        }
/*
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.get(ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=276-38-" + IRtemperatura, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(String response) {
                            }
                        });
 */

                    }
                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                }
            }
        });


        subirtemperatura.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{

                    if(temperatura < 30)
                    {
                        temperatura++;
                        switch (temperatura) {
                            case 16:
                                tempimg.setImageResource(R.drawable.temp16);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio16();
                                else
                                    IRtemperatura = aireController.getCalor16();
                                break;
                            case 17:
                                tempimg.setImageResource(R.drawable.temp17);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio17();
                                else
                                    IRtemperatura = aireController.getCalor17();
                                break;
                            case 18:
                                tempimg.setImageResource(R.drawable.temp18);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio18();
                                else
                                    IRtemperatura = aireController.getCalor18();
                                break;
                            case 19:
                                tempimg.setImageResource(R.drawable.temp19);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio19();
                                else
                                    IRtemperatura = aireController.getCalor19();
                                break;
                            case 20:
                                tempimg.setImageResource(R.drawable.temp20);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio20();
                                else
                                    IRtemperatura = aireController.getCalor20();
                                break;
                            case 21:
                                tempimg.setImageResource(R.drawable.temp21);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio21();
                                else
                                    IRtemperatura = aireController.getCalor21();
                                break;
                            case 22:
                                tempimg.setImageResource(R.drawable.temp22);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio22();
                                else
                                    IRtemperatura = aireController.getCalor22();
                                break;
                            case 23:
                                tempimg.setImageResource(R.drawable.temp23);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio23();
                                else
                                    IRtemperatura = aireController.getCalor23();
                                break;
                            case 24:
                                tempimg.setImageResource(R.drawable.temp24);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio24();
                                else
                                    IRtemperatura = aireController.getCalor24();
                                break;
                            case 25:
                                tempimg.setImageResource(R.drawable.temp25);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio25();
                                else
                                    IRtemperatura = aireController.getCalor25();
                                break;
                            case 26:
                                tempimg.setImageResource(R.drawable.temp26);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio26();
                                else
                                    IRtemperatura = aireController.getCalor26();
                                break;
                            case 27:
                                tempimg.setImageResource(R.drawable.temp27);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio27();
                                else
                                    IRtemperatura = aireController.getCalor27();
                                break;
                            case 28:
                                tempimg.setImageResource(R.drawable.temp28);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio28();
                                else
                                    IRtemperatura = aireController.getCalor28();
                                break;
                            case 29:
                                tempimg.setImageResource(R.drawable.temp29);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio29();
                                else
                                    IRtemperatura = aireController.getCalor29();
                                break;
                            case 30:
                                tempimg.setImageResource(R.drawable.temp30);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio30();
                                else
                                    IRtemperatura = aireController.getCalor30();
                                break;
                            default:
                                tempimg.setImageResource(R.drawable.temp24);
                                if(modo == "frio")
                                    IRtemperatura = aireController.getFrio24();
                                else
                                    IRtemperatura = aireController.getCalor24();
                                break;
                        }
/*
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.get(ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=276-38-" + IRtemperatura, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(String response) {
                            }
                        });
*/
                    }
                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                }
            }
        });

        /*  VER LO DE REFLECTION COMO HACERLO!!
        subirtemperatura.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                	temperatura++;

                	Method m = aireController.getClass().getMethod("getFrio21", AireController.class);

                	m.invoke(aireController, null);

                	String temp = aireController.getOn();
                	//Toast.makeText(getApplicationContext(), ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=68-38-" + subircanal, Toast.LENGTH_LONG).show();

                	AsyncHttpClient client = new AsyncHttpClient();
                	client.get(ipArduino + "?salida" + String.valueOf(getIntent().getExtras().getInt("posicion")) +"=276-38-" + onoff, new AsyncHttpResponseHandler() {
                	    @Override
                	    public void onSuccess(String response) {
                	    }
                	});

                 }
                catch(Exception ex)
                 {
                	Toast.makeText(getApplicationContext(), " ERROR! ", Toast.LENGTH_LONG).show();
                 }
            }
        });
        */

    }


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.aire, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/

}