package vistas;

import javax.swing.*;
import modelo.Alumno;
import java.util.HashSet;

public class VistaAlumnos extends JInternalFrame {
    private HashSet<Alumno> alumnos;

    public VistaAlumnos(HashSet<Alumno> alumnos) {
        super("Alta de Alumnos", true, true, true, true);
        this.alumnos = alumnos;
        setSize(400,300);

        JPanel panel = new JPanel();
        JLabel l1 = new JLabel("Legajo:");
        JTextField t1 = new JTextField(10);
        JLabel l2 = new JLabel("Apellido:");
        JTextField t2 = new JTextField(10);
        JLabel l3 = new JLabel("Nombre:");
        JTextField t3 = new JTextField(10);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> {
            int legajo = Integer.parseInt(t1.getText());
            String ape = t2.getText();
            String nom = t3.getText();

            Alumno a = new Alumno(legajo, ape, nom);
            alumnos.add(a);
            JOptionPane.showMessageDialog(this, "Alumno agregado!");
        });

        panel.add(l1); panel.add(t1);
        panel.add(l2); panel.add(t2);
        panel.add(l3); panel.add(t3);
        panel.add(btnAgregar);

        add(panel);
    }
}
