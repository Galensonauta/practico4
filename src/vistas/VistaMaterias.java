package vistas;

import javax.swing.*;
import modelo.Materia;
import java.util.HashSet;

public class VistaMaterias extends JInternalFrame {
    private HashSet<Materia> materias;

    public VistaMaterias(HashSet<Materia> materias) {
        super("Alta de Materias", true, true, true, true);
        this.materias = materias;
        setSize(400,300);

        JPanel panel = new JPanel();
        JLabel l1 = new JLabel("ID:");
        JTextField t1 = new JTextField(5);
        JLabel l2 = new JLabel("Nombre:");
        JTextField t2 = new JTextField(10);
        JLabel l3 = new JLabel("Año:");
        JTextField t3 = new JTextField(5);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(t1.getText());
            String nom = t2.getText();
            int anio = Integer.parseInt(t3.getText());

            Materia m = new Materia(id, nom, anio);
            materias.add(m);
            JOptionPane.showMessageDialog(this, "Materia agregada!");
        });

        panel.add(l1); panel.add(t1);
        panel.add(l2); panel.add(t2);
        panel.add(l3); panel.add(t3);
        panel.add(btnAgregar);

        add(panel);
    }
}
