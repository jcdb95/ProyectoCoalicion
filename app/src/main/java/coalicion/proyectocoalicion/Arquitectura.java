package coalicion.proyectocoalicion;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class Arquitectura extends CarrerasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arquitectura);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.showOverflowMenu();
        reloadAll();
    }


    @Override
    public int getTotal() {
        return 41;
    }

}