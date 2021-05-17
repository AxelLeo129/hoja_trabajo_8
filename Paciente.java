public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private String enfermedad;
    private String prioridad;

    public Paciente(String nombre, String enfermedad, String prioridad) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Paciente o) {
        int comparador = this.prioridad.compareTo(o.getPrioridad());
        if(comparador < 0)
            return -1;
        else if(comparador > 0)
            return 1;
        return 0;
    }

}
