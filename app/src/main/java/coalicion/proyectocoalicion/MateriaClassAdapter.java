package coalicion.proyectocoalicion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tomas on 20/04/17.
 */

public class MateriaClassAdapter extends ArrayAdapter<MateriaClass> {

    public MateriaClassAdapter(Context context, ArrayList<MateriaClass> materias) {
        super(context, 0, materias);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.materias_list_item, false);
            )
        }

        MateriaClass currentMateria = getItem(position);

        CheckBox materiaTextView = (CheckBox) listItemView.findViewById(R.id.materia_text_view);
        materiaTextView.setText(currentMateria.getNombreMateria());

        return materiaTextView;
    }
}
