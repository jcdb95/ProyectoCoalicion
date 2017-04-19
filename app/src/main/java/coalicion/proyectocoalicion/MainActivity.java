package coalicion.proyectocoalicion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirArquitectura (View view) {
        startActivity(new Intent(this, Arquitectura.class));

    }

    public void abrirDisenoGrafico (View view) {
        startActivity(new Intent(this, DG.class));

    }

    public void abrirDisenoImgYSonido (View view) {
        startActivity(new Intent(this, DIS.class));

    }

    public void abrirDisenoIndYText (View view) {
        startActivity(new Intent(this, DIT.class));

    }

    public void abrirDisenoIndustrial (View view) {
        startActivity(new Intent(this, DI.class));

    }

    public void abrirPaisajismo (View view) {
        startActivity(new Intent(this, DPAIS.class));

    }



}