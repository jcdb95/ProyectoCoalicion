package coalicion.proyectocoalicion;

import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class Arquitectura extends CarrerasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.showOverflowMenu();
        reloadAll();


        setContentView(R.layout.materias_list);

        final ArrayList<MateriaClass> materias = new ArrayList<MateriaClass>();
        materias.add(new MateriaClass("Sociedad y Estado"));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));
        materias.add(new MateriaClass(""));





        MateriaClassAdapter adapter = new MateriaClassAdapter(this, materias);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }


    @Override
    public int getTotal() {
        return 41;
    }

}