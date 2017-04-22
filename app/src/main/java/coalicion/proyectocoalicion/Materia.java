package coalicion.proyectocoalicion;

/**
 * Created by tomas on 20/04/17.
 */

public class Materia {

    // Parametros

    private String mNombre;
    private boolean mAprobada;

    // Constructor de Objetos

    public Materia(String nombreMateria, boolean aprobada) {

        mNombre = nombreMateria;
        mAprobada = aprobada;
    }

    // Metodos

    public String nombre() {
        return mNombre;
    }

    public boolean aprobada() {
        return mAprobada;
    }

    public void setAprobada(Boolean aprobada) {
        this.mAprobada = aprobada;
    }
}
