package modelo;

import java.util.HashSet;

public class Alumno {
    private int legajo;
    private String apellido;
    private String nombre;
    private HashSet<Materia> materias;

    public Alumno(int legajo, String apellido, String nombre) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.materias = new HashSet<>();
    }

    // devuelve true si se agregó, false si ya estaba
    public boolean agregarMateria(Materia m) {
        return materias.add(m);
    }

    public int cantidadMaterias() {
        return materias.size();
    }

    public int getLegajo() { return legajo; }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public HashSet<Materia> getMaterias() { return materias; }

    @Override
    public String toString() {
        return legajo + " - " + apellido + " " + nombre;
    }
}
