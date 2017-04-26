package coalicion.proyectocoalicion;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

import static coalicion.proyectocoalicion.R.id.list;

public class DPAIS extends CarrerasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Crear toolbar de arriba
        setContentView(R.layout.materias_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.showOverflowMenu();

        // Para cambiar el texto que aparece en la toolbar de arriba

        getSupportActionBar().setTitle("Paisajismo");

        // ArrayList de las materias de la carrera
        // Cada item toma como parametro el nombre de la materia y el estado aprobada o no

        final ArrayList<Materia> materias = new ArrayList<Materia>();

        //CBC
        materias.add(new Materia("Sociedad y el Estado", false));
        materias.add(new Materia("Pensamiento Científico", false));
        materias.add(new Materia("Proyectual I", false));
        materias.add(new Materia("Proyectual II", false));
        materias.add(new Materia("Matemática", false));
        materias.add(new Materia("Biología", false));
        materias.add(new Materia("Taller de Dibujo", false));

        //Nivel 1
        materias.add(new Materia("Planificación y Diseño del Paisaje I", false));
        materias.add(new Materia("Sistemas de Representación Geométrica", false));
        materias.add(new Materia("Química General", false));
        materias.add(new Materia("Botánica General", false));
        materias.add(new Materia("Física Aplicada", false));
        materias.add(new Materia("Química Biológica", false));
        materias.add(new Materia("Botánica Sistemática", false));
        materias.add(new Materia("Materiales, Elementos y Procedimientos\n" +
                "de Construcción", false));
        materias.add(new Materia("Vegetación I", false));

        //Nivel 2
        materias.add(new Materia("Planificación y Diseño del Paisaje II", false));
        materias.add(new Materia("Vegetación II", false));
        materias.add(new Materia("Fisiología Vegetal", false));
        materias.add(new Materia("Edafología", false));
        materias.add(new Materia("Instalaciones y Equipamientos", false));
        materias.add(new Materia("Climatología y Fenología", false));
        materias.add(new Materia("Topografía", false));
        materias.add(new Materia("Morfología y Comunicación I", false));

        //Nivel 3
        materias.add(new Materia("Planificación y Diseño del Paisaje III", false));
        materias.add(new Materia("Historia de la Arquitectura Paisajística I", false));
        materias.add(new Materia("Morfología y Comunicación II", false));
        materias.add(new Materia("Manejo del Suelo y la Vegetación", false));
        materias.add(new Materia("Ecología", false));
        materias.add(new Materia("Geografía", false));
        materias.add(new Materia("Fitogeografía", false));
        materias.add(new Materia("Asignaturas Optativas", false));

        //Nivel 4
        materias.add(new Materia("Planificación y Diseño del Paisaje IV", false));
        materias.add(new Materia("Historia de la Arquitectura Paisajística II", false));
        materias.add(new Materia("Planeamiento Urbano y Regional", false));
        materias.add(new Materia("Ecología del Paisaje", false));
        materias.add(new Materia("Trabajo Final", false));
        materias.add(new Materia("Práctica Profesional", false));
        materias.add(new Materia("Asignaturas Optativas", false));

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
        return 39;
    }
}