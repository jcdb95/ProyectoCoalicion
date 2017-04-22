package coalicion.proyectocoalicion;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class DIT extends CarrerasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dit);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.showOverflowMenu();
    }
    @Override
    public int getTotal() {
        return 24;
    }
}