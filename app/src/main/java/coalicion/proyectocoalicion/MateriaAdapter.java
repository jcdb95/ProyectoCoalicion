package coalicion.proyectocoalicion;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by tomas on 20/04/17.
 */

public class MateriaAdapter extends ArrayAdapter<Materia> {

    public MateriaAdapter(Context context, ArrayList<Materia> materias) {
        super(context, 0, materias);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.materias_list_item, null);
        }

        Materia currentMateria = getItem(position);

        CheckBox checkbox = (CheckBox) listItemView.findViewById(R.id.materia_text_view);
        checkbox.setText(currentMateria.nombre());
        Log.d("DEBUG", "materia: " + currentMateria.nombre());
        checkbox.setChecked(currentMateria.aprobada());
        Log.d("DEBUG", "aprobada: " + currentMateria.aprobada());

        checkbox.setOnClickListener();

        return checkbox;
    }
}
