package coalicion.proyectocoalicion;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

import static coalicion.proyectocoalicion.R.id.list;

public class Arquitectura extends CarrerasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crear toolbar de arriba

        setContentView(R.layout.materias_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.showOverflowMenu();

        // Para cambiar el texto que aparece en la toolbar de arriba

        getSupportActionBar().setTitle("Arquitectura");

        // ArrayList de las materias de la carrera
        // Cada item toma como parametro el nombre de la materia y el estado aprobada o no

        final ArrayList<Materia> materias = new ArrayList<Materia>();

        //CBC
        materias.add(new Materia("Sociedad y el Estado", false));
        materias.add(new Materia("Pensamiento Científico", false));
        materias.add(new Materia("Proyectual I", false));
        materias.add(new Materia("Proyectual II", false));
        materias.add(new Materia("Matemática", false));
        materias.add(new Materia("Filosofía", false));
        materias.add(new Materia("Taller de Dibujo", false));

        //Nivel 1
        materias.add(new Materia("Arquitectura I", false));
        materias.add(new Materia("Matemática II", false));
        materias.add(new Materia("Sistemas de Representación Geométrica", false));
        materias.add(new Materia("Física Aplicada a la Arquitectura", false));
        materias.add(new Materia("Arquitectura Contemporánea", false));
        materias.add(new Materia("Tipos Constructivos", false));
        materias.add(new Materia("Tipos Estructurales", false));

        //Nivel 2
        materias.add(new Materia("Arquitectura II", false));
        materias.add(new Materia("Estructuras I", false));
        materias.add(new Materia("Historia I", false));
        materias.add(new Materia("Construcciones I", false));
        materias.add(new Materia("Instalaciones I", false));
        materias.add(new Materia("Morfología I", false));
        materias.add(new Materia("Representación Arquitectónica", false));
        materias.add(new Materia("Diseño Asistido por Computadora\n" +
                "/ Diseño por Computadora (materia optativa)", false));

        //Nivel 3
        materias.add(new Materia("Arquitectura III", false));
        materias.add(new Materia("Estructuras II", false));
        materias.add(new Materia("Historia II", false));
        materias.add(new Materia("Construcciones II", false));
        materias.add(new Materia("Instalaciones II", false));
        materias.add(new Materia("Morfología II", false));
        materias.add(new Materia("Materialización de Proyectos", false));

        //Nivel 4
        materias.add(new Materia("Arquitectura IV", false));
        materias.add(new Materia("Estructuras III", false));
        materias.add(new Materia("Planificación Urbana", false));
        materias.add(new Materia("Construcciones III", false));
        materias.add(new Materia("Instalaciones III", false));
        materias.add(new Materia("Historia III", false));
        materias.add(new Materia("Teoría de la Arquitectura", false));
        materias.add(new Materia("Materias Optativas", false));

        //Nivel 5
        materias.add(new Materia("Dirección y Legislación de Obra", false));
        materias.add(new Materia("Proyecto Urbano", false));
        materias.add(new Materia("Proyecto Arquitectónico", false));
        materias.add(new Materia("Materias Optativas", false));

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

    // Total de materias de la carrera

    @Override
    public int getTotal() {
        return 41;
    }

}