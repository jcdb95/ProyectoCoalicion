package coalicion.proyectocoalicion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Arquitectura OnClickListener
        TextView arquitectura = (TextView) findViewById(R.id.carrera_arquitectura);
        arquitectura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arquitecturaIntent = new Intent(MainActivity.this, Arquitectura.class);
                startActivity(arquitecturaIntent);
            }
        });

        // Diseno Grafico OnClickListener
        TextView diseno_grafico = (TextView) findViewById(R.id.carrera_disenografico);
        diseno_grafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disenograficoIntent = new Intent(MainActivity.this, DG.class);
                startActivity(disenograficoIntent);
            }
        });

        // Imagen y Sonido OnClickListener
        TextView imagenysonido = (TextView) findViewById(R.id.carrera_imagenysonido);
        imagenysonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imagenysonidoIntent = new Intent(MainActivity.this, DIS.class);
                startActivity(imagenysonidoIntent);
            }
        });

        // Diseno de Indumentaria OnClickListener
        TextView disenoindumentaria = (TextView) findViewById(R.id.carrera_disenoindumentaria);
        disenoindumentaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disenoindumentariaIntent = new Intent(MainActivity.this, DIT.class);
                startActivity(disenoindumentariaIntent);
            }
        });

        // Diseno Industrial OnClickListener
        TextView disenoindustrial = (TextView) findViewById(R.id.carrera_disenoindustrial);
        disenoindustrial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disenoindustrialIntent = new Intent(MainActivity.this, DI.class);
                startActivity(disenoindustrialIntent);
            }
        });

        // Paisajismo OnClickListener
        TextView paisajismo = (TextView) findViewById(R.id.carrera_paisajismo);
        paisajismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paisajismoIntent = new Intent(MainActivity.this, DPAIS.class);
                startActivity(paisajismoIntent);
            }
        });


    }
}