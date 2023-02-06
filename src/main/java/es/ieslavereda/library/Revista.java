package es.ieslavereda.library;

public class Revista extends Publicacion{

    private String nombre;
    private String tematica;
    private Periodicidad periodicidad;


    public Revista(String editorial, int numPaginas, boolean enColor, String nombre, String tematica, Periodicidad periodicidad) {
        super(editorial, numPaginas, enColor);
        this.nombre = nombre;
        this.tematica = tematica;
        this.periodicidad = periodicidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTematica() {
        return tematica;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    @Override
    public String toString() {
        return super.toString() + "\n - Revista: " + "nombre=" + nombre + ", periodicidad=" + periodicidad;
    }

    enum Periodicidad{
        SEMANAL("semanal"),
        MENSUAL("mensual"),
        TRIMESTRAL("trimestral");

        String periodicidad;

        Periodicidad(String periodicidad){
            this.periodicidad = periodicidad;
        }

        public String getPeriodicidad() {
            return periodicidad;
        }

        @Override
        public String toString() {
            return periodicidad;
        }
    }

}
