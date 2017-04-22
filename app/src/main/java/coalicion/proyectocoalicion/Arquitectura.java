package coalicion.proyectocoalicion;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static coalicion.proyectocoalicion.R.id.list;


public class Arquitectura extends CarrerasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.materias_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.showOverflowMenu();

        final ArrayList<Materia> materias = new ArrayList<Materia>();

        materias.add(new Materia("Sociedad y Estado", false));
        materias.add(new Materia("Pepe", false));

        reloadAll(materias);

        // El Adapter busca la materia en el ArrayList y rellena el materias_list con la info del
        // ArrayList y el formato de materias_list_item

        final MateriaAdapter adapter = new MateriaAdapter(this, materias);
        ListView listView = (ListView) findViewById(list);
        listView.setAdapter(adapter);


        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView MateriaAdapter, View v, int position, long id) {
                Log.d("DEBUG", "onClickListener funcionando!");
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);

    }

    @Override
    public int getTotal() {
        return 41;
    }

}