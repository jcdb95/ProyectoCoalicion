package coalicion.proyectocoalicion;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

import static coalicion.proyectocoalicion.R.id.list;


public class DIS extends CarrerasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Crear toolbar de arriba

        setContentView(R.layout.materias_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.showOverflowMenu();

        // Para cambiar el texto que aparece en la toolbar de arriba

        getSupportActionBar().setTitle("Imagen y Sonido");

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
        materias.add(new Materia("Taller de Dibujo", false));

        //Nivel 1
        materias.add(new Materia("Proyecto Audiovisual I", false));
        materias.add(new Materia("Sonido I ", false));
        materias.add(new Materia("Montaje I", false));
        materias.add(new Materia("Narrativas Audiovisuales", false));
        materias.add(new Materia("Escrituras Audiovisuales I", false));
        materias.add(new Materia("Dibujo y Representación Audiovisual", false));
        materias.add(new Materia("Iluminación y Cámara I", false));
        materias.add(new Materia("Estética", false));
        materias.add(new Materia("Soc. Sociología", false));

        //Nivel 2
        materias.add(new Materia("Proyecto Audiovisual II", false));
        materias.add(new Materia("Sonido II ", false));
        materias.add(new Materia("Escrituras Audiovisuales II", false));
        materias.add(new Materia("Producción y Planificación", false));
        materias.add(new Materia("Técnicas Audiovisuales", false));
        materias.add(new Materia("Iluminación y Cámara II", false));
        materias.add(new Materia("Historia Analítica de los Medios Audiovisuales I", false));
        materias.add(new Materia("Teorías Audiovisuales", false));

        //Nivel 3
        materias.add(new Materia("Proyecto Audiovisual III", false));
        materias.add(new Materia("Montaje II", false));
        materias.add(new Materia("Difusión y Comercialización de los Medios", false));
        materias.add(new Materia("Historia Analítica de los Medios Audiovisuales II", false));
        materias.add(new Materia("Teoría y Estética de los Medios", false));
        materias.add(new Materia("Asignaturas Electivas", false));

        //Nivel 4
        materias.add(new Materia("Proyecto Audiovisual IV", false));
        materias.add(new Materia("Asignaturas Electivas", false));




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
        return 31;
    }


}