package modelo;

public class Materia {
    private int idMateria;
    private String nombre;
    private int anio;

    public Materia(int idMateria, String nombre, int anio) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anio = anio;
    }

    public int getIdMateria() { return idMateria; }
    public void setIdMateria(int idMateria) { this.idMateria = idMateria; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Materia)) return false;
        Materia m = (Materia) obj;
        return this.idMateria == m.idMateria;
    }

    @Override
    public int hashCode() {
        return idMateria;
    }

    @Override
    public String toString() {
        return nombre + " (" + anio + "º año)";
    }
}
