package coalicion.proyectocoalicion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class CarrerasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.directory, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void abrirEntregas(MenuItem mi) {
        setContentView(R.layout.entregas);
    }


    public void calificarApp (MenuItem mi){
        Toast.makeText(this, "PROXIMAMENTE...", Toast.LENGTH_SHORT).show();
    }

    public void compartirApp (MenuItem mi){
    }
    
    public void sugerenciaApp (MenuItem mi){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: buromar.it@gmail.com")); // only email apps should handle this
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void clickeada(View view) {
        CheckBox checkBox = (CheckBox) view;
        storeMateria(String.valueOf(checkBox.getId()), checkBox.isChecked());
        reloadAll();

        // TODO Codigo para correlatividades

        CheckBox SyE = (CheckBox) findViewById(R.id.SociedadYEstado);
        CheckBox PensCientif = (CheckBox) findViewById(R.id.PensamientoCientifico);
        if(SyE.isChecked()){
            PensCientif.setEnabled(true);
        } else {
            PensCientif.setEnabled(false);
        }
    }

    public void storeMateria(String idMateria, Boolean state) {
        SharedPreferences pref = getMySharedPreferences();
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(idMateria, state);
        editor.apply();
    }


    public int getTotal() {
        return 0;
    }

    public void reloadAll() {
        SharedPreferences pref = getMySharedPreferences();
        int Aprobadas = 0;
        for (Map.Entry<String, ?> entry : pref.getAll().entrySet()) {
            String materia = entry.getKey();
            Boolean aprobada = (Boolean) entry.getValue();
            Aprobadas += (aprobada ? 1 : 0);
            CheckBox cb = (CheckBox) findViewById(Integer.valueOf(materia));
            cb.setChecked(aprobada);
        }
        setAprobadas(Aprobadas);
        setRestantes(getTotal() - Aprobadas);
        setPorcentaje(Float.valueOf(Aprobadas) / Float.valueOf(getTotal()));
    }

    private SharedPreferences getMySharedPreferences() {
        return getSharedPreferences(getLocalClassName(), MODE_PRIVATE);
    }

    private void setAprobadas(int number) {
        TextView aprobadasTextView = (TextView) findViewById(R.id.aprobadas_text_view);
        aprobadasTextView.setText("Aprobadas: " + number);
    }

    private void setRestantes(int number) {
        TextView restantesTextView = (TextView) findViewById(R.id.restantes_text_view);
        restantesTextView.setText("Restantes: " + number);
    }

    private void setPorcentaje(float number) {
        // Actualize porcentaje numerico y barra
        int porcentajeInt = (int) Math.round(number * 100);
        TextView porcentajeTextView = (TextView) findViewById(R.id.porcentaje_text_view);
        porcentajeTextView.setText(porcentajeInt + " %");

        ProgressBar laBarrita = (ProgressBar) findViewById(R.id.progressBarView);
        laBarrita.setProgress(porcentajeInt);
    }


}
