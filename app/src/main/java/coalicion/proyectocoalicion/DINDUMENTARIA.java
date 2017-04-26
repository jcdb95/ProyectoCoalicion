package coalicion.proyectocoalicion;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

import static coalicion.proyectocoalicion.R.id.list;

public class DINDUMENTARIA extends CarrerasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materias_list);


        // Crear toolbar de arriba
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.showOverflowMenu();


        // Para cambiar el texto que aparece en la toolbar de arriba

        getSupportActionBar().setTitle("Diseño de Indumentaria");

        // ArrayList de las materias de la carrera
        // Cada item toma como parametro el nombre de la materia y el estado aprobada o no

        final ArrayList<Materia> materias = new ArrayList<Materia>();

        //CBC
        materias.add(new Materia("Sociedad y el Estado", false));
        materias.add(new Materia("Pensamiento Científico", false));
        materias.add(new Materia("Proyectual I", false));
        materias.add(new Materia("Proyectual II", false));
        materias.add(new Materia("Matemática", false));
        materias.add(new Materia("Semiología", false));
        materias.add(new Materia("Taller de Dibujo ", false));

        //Nivel 1
        materias.add(new Materia(" Medios Expresivos I", false));
        materias.add(new Materia("Fundamentos Geométricos del Modelaje", false));
        materias.add(new Materia("Introducción al Proyecto", false));
        materias.add(new Materia("Historia del Diseño de Indumentaria y Textil I", false));
        materias.add(new Materia("Análisis del Diseño de Indumentaria y Textil I", false));
        materias.add(new Materia("Técnicas de Producción e Industria Nacional I", false));
        materias.add(new Materia("Técnicas de Producción e Industria Nacional II", false));

        //Nivel 2
        materias.add(new Materia("Proyecto de Indumentaria I", false));
        materias.add(new Materia("Medios Expresivos II", false));
        materias.add(new Materia("Materialización de Proyecto", false));
        materias.add(new Materia("Técnicas de Producción de Indumentaria I", false));
        materias.add(new Materia("Historia del Diseño de Indumentaria y Textil II", false));
        materias.add(new Materia("Análisis del Diseño de Indumentaria y Textil II", false));
        materias.add(new Materia("Técnicas de Producción de Indumentaria II", false));

        //Nivel 3
        materias.add(new Materia("Proyecto de Indumentaria II", false));
        materias.add(new Materia("Proyecto de Indumentaria III", false));
        materias.add(new Materia("Proyecto de Accesorios I", false));
        materias.add(new Materia("Comunicación y Crítica", false));
        materias.add(new Materia("Sociología", false));
        materias.add(new Materia("Comercialización y Mercado I", false));
        materias.add(new Materia("Técnicas de Producción de Indumentaria III", false));
        materias.add(new Materia("Comercialización y Mercado II", false));
        materias.add(new Materia("Técnicas de Producción de Indumentaria IV", false));

        //Nivel 4
        materias.add(new Materia("Proyecto de Indumentaria IV", false));
        materias.add(new Materia("Proyecto de Accesorios II", false));
        materias.add(new Materia("Ética Profesional", false));
        materias.add(new Materia("Optativa I", false));
        materias.add(new Materia("Optativa II", false));
        materias.add(new Materia("Trabajo Final de Carrera", false));

        reloadAll(materias);

        // El Adapter busca la materia en el ArrayList y rellena el materias_list con la info del
        // ArrayList y el formato de materias_list_item

        final MateriaAdapter adapter = new MateriaAdapter(this, materias);
        ListView listView = (ListView) findViewById(R.id.list);
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
        return 36;
    }
}