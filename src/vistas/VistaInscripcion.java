package vistas;

import javax.swing.*;
import modelo.Alumno;
import modelo.Materia;
import java.util.HashSet;

public class VistaInscripcion extends JInternalFrame {
    private HashSet<Alumno> alumnos;
    private HashSet<Materia> materias;

    public VistaInscripcion(HashSet<Alumno> alumnos, HashSet<Materia> materias) {
        super("Formulario de Inscripción", true, true, true, true);
        this.alumnos = alumnos;
        this.materias = materias;
        setSize(500,300);

        JPanel panel = new JPanel();
        JComboBox<Alumno> comboAlumnos = new JComboBox<>(alumnos.toArray(new Alumno[0]));
        JComboBox<Materia> comboMaterias = new JComboBox<>(materias.toArray(new Materia[0]));

        JButton btnInscribir = new JButton("Inscribir");
        btnInscribir.addActionListener(e -> {
            Alumno a = (Alumno) comboAlumnos.getSelectedItem();
            Materia m = (Materia) comboMaterias.getSelectedItem();
            if (a != null && m != null) {
                boolean agregado = a.agregarMateria(m);
                if (agregado) {
                    JOptionPane.showMessageDialog(this, "Inscripción realizada!");
                } else {
                    JOptionPane.showMessageDialog(this, "⚠ El alumno ya está inscripto en esa materia.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnMostrar = new JButton("Ver materias por alumno");
        btnMostrar.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Alumno a : alumnos) {
                sb.append(a).append(" → ").append(a.cantidadMaterias()).append(" materias\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString(), "Cantidad de materias", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(new JLabel("Alumno:"));
        panel.add(comboAlumnos);
        panel.add(new JLabel("Materia:"));
        panel.add(comboMaterias);
        panel.add(btnInscribir);
        panel.add(btnMostrar);

        add(panel);
    }
}
