package coalicion.proyectocoalicion;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

import static coalicion.proyectocoalicion.R.id.list;


public class DI extends CarrerasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crear toolbar de arriba
        setContentView(R.layout.materias_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.showOverflowMenu();


        // Para cambiar el texto que aparece en la toolbar de arriba

        getSupportActionBar().setTitle("Diseño Industrial");

        // ArrayList de las materias de la carrera
        // Cada item toma como parametro el nombre de la materia y el estado aprobada o no

        final ArrayList<Materia> materias = new ArrayList<Materia>();

        //CBC
        materias.add(new Materia("Sociedad y el Estado", false));
        materias.add(new Materia("Pensamiento Científico", false));
        materias.add(new Materia("Proyectual I", false));
        materias.add(new Materia("Proyectual II", false));
        materias.add(new Materia("Matemática", false));
        materias.add(new Materia("Antropología", false));
        materias.add(new Materia("Taller de Dibujo", false));

        //Nivel 1
        materias.add(new Materia("Diseño Industrial I", false));
        materias.add(new Materia("Morfología", false));
        materias.add(new Materia("Tecnología I", false));
        materias.add(new Materia("Física I", false));
        materias.add(new Materia("Matemática I", false));
        materias.add(new Materia("Tipos Constructivos", false));
        materias.add(new Materia("Introducción al Diseño\n" +
                "y a la Arquitectura Moderna", false));

        //Nivel 2
        materias.add(new Materia("Diseño Industrial II", false));
        materias.add(new Materia("Morfología Especial I", false));
        materias.add(new Materia("Tecnología II", false));
        materias.add(new Materia("Construcciones I", false));
        materias.add(new Materia("Física II", false));
        materias.add(new Materia("Ergonomía", false));
        materias.add(new Materia("Historia del Diseño Industrial", false));

        //Nivel 3
        materias.add(new Materia("Diseño Industrial III", false));
        materias.add(new Materia("Morfología Especial II", false));
        materias.add(new Materia("Tecnología III", false));
        materias.add(new Materia("Tecnología III", false));
        materias.add(new Materia("Análisis de Productos", false));
        materias.add(new Materia("Industria Argentina", false));
        materias.add(new Materia("Optativa I", false));

        //Nivel 4
        materias.add(new Materia("Tecnología IV", false));
        materias.add(new Materia("Diseño Industrial IV", false));
        materias.add(new Materia("Diseño Industrial V", false));
        materias.add(new Materia("Legislación y Práctica Profesional", false));
        materias.add(new Materia("Metodología", false));
        materias.add(new Materia("Sociología aplicada al Diseño", false));
        materias.add(new Materia("Optativa II", false));

        reloadAll(materias);

        // El Adapter busca la materia en el ArrayList y rellena el materias_list con la info del
        // ArrayList y el formato de materias_list_item

        final MateriaAdapter adapter = new MateriaAdapter(this, materias);
        ListView listView = (ListView) findViewById(list);
        listView.setAdapter(adapter);

        // Asignar un click listener a cada materia creada

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View item, int position, long id) {
                for (Materia materia : materias) {
                    CheckBox cb = (CheckBox) item;
                    if (materia.nombre().equals(cb.getText())) {
                        materia.setAprobada(!materia.aprobada());
                        storeMateria(materia.nombre(), materia.aprobada());
                        reloadAll(materias);
                        break;
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getTotal() {
        return 32;
    }

}