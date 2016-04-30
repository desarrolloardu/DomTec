package com.example.matiasdaniel.domtec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by MatiasDaniel on 8/4/2016.
 */
public class AmbienteActivity extends AppCompatActivity {

    private ListView lista;
    private String nombreAmbiente = "Ambiente";
    private String ipAmbiente = "IP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_ambiente);

        nombreAmbiente = getIntent().getStringExtra("nombre");
        ipAmbiente = getIntent().getStringExtra("ip");
        setTitle(nombreAmbiente + "-" + ipAmbiente);

        ArrayList<Objeto> datos = new ArrayList<Objeto>();

     //   datos.add(new Dimmer(R.drawable.luz, "Luz Principal Dimmerizada", "Activar/Desactivar luz principal", 2));
     //   datos.add(new Dimmer(R.drawable.luz, "Luz Secundaria Dimmerizada", "Activar/Desactivar luz secundaria", 4));
        datos.add(new Objeto(R.drawable.television, "Television", "Manejar Television"));

        lista = (ListView) findViewById(R.id.ListView_listado_ambiente);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada_ambiente, datos){
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
/*
                if (elegido.getTipo() == "Dimmer")
                {
                    Intent intent = new Intent(getApplicationContext(), DimmerActivity.class);
                    String titulo = getTitle().toString();
                    intent.putExtra("nombre", titulo.substring(0, titulo.indexOf("-")));
                    intent.putExtra("ip", titulo.substring(titulo.indexOf("-"), titulo.length()));
                    startActivity(intent);
                }
                else
                {*/
                    CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                    Toast toast = Toast.makeText(AmbienteActivity.this, texto, Toast.LENGTH_LONG);
                    toast.show();
/*                }*/

            }
        });

/*
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		*/
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ambiente, menu);
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
