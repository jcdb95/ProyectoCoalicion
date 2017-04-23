package coalicion.proyectocoalicion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CarrerasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Maneja la barra de arriba / toolbar

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.directory, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void abrirEntregas(MenuItem mi) {
        setContentView(R.layout.entregas);
    }

    public void calificarApp(MenuItem mi) {
        Toast.makeText(this, "PROXIMAMENTE...", Toast.LENGTH_SHORT).show();
    }

    public void compartirApp(MenuItem mi) {
        Toast.makeText(this, "PROXIMAMENTE...", Toast.LENGTH_SHORT).show();
    }

    public void sugerenciaApp(MenuItem mi) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: buromar.it@gmail.com")); // only email apps should handle this
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // Maneja el estado de las checkbox y guarda la informacion en las SharedPreferences

    public void storeMateria(String idMateria, Boolean state) {
        SharedPreferences pref = getMySharedPreferences();
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(idMateria, state);
        editor.apply();
    }

    public int getTotal() {
        return 0;
    }

    public void reloadAll(ArrayList<Materia> materias) {
        SharedPreferences pref = getMySharedPreferences();
        int aprobadas = 0;
        for (Materia materia : materias) {
            String materiaId = materia.nombre();
            Boolean aprobada = pref.getBoolean(materiaId, false);
            materia.setAprobada(aprobada);
            aprobadas += (aprobada ? 1 : 0);
        }
        setAprobadas(aprobadas);
        setRestantes(getTotal() - aprobadas);
        setPorcentaje(Float.valueOf(aprobadas) / Float.valueOf(getTotal()));
    }

    private SharedPreferences getMySharedPreferences() {
        return getSharedPreferences(getLocalClassName(), MODE_PRIVATE);
    }

    // Maneja los numeros de materias aprobadas y restantes y la barra de progreso

    private void setAprobadas(int number) {
        TextView aprobadasTextView = (TextView) findViewById(R.id.aprobadas_text_view);
        aprobadasTextView.setText("Aprobadas: " + number);
    }

    private void setRestantes(int number) {
        TextView restantesTextView = (TextView) findViewById(R.id.restantes_text_view);
        restantesTextView.setText("Restantes: " + number);
    }

    private void setPorcentaje(float number) {
        int porcentajeInt = (int) Math.round(number * 100);
        TextView porcentajeTextView = (TextView) findViewById(R.id.porcentaje_text_view);
        porcentajeTextView.setText(porcentajeInt + " %");
        ProgressBar laBarrita = (ProgressBar) findViewById(R.id.progressBarView);
        laBarrita.setProgress(porcentajeInt);
    }


}
