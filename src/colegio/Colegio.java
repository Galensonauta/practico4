package colegio;

import java.util.HashSet;
import javax.swing.*;
import modelo.Alumno;
import modelo.Materia;
import vistas.*;

public class Colegio extends JFrame {

    public static HashSet<Alumno> alumnos = new HashSet<>();
    public static HashSet<Materia> materias = new HashSet<>();

    private JDesktopPane escritorio;

    public Colegio() {
        setTitle("Sistema Colegio - TP4");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        escritorio = new JDesktopPane();
        setContentPane(escritorio);

        JMenuBar barra = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(e -> System.exit(0));
        menuArchivo.add(salir);

        JMenu menuAlumnos = new JMenu("Alumnos");
        JMenuItem altaAlumnos = new JMenuItem("Gestionar Alumnos");
        altaAlumnos.addActionListener(e -> {
            VistaAlumnos va = new VistaAlumnos(alumnos);
            escritorio.add(va);
            va.setVisible(true);
        });
        menuAlumnos.add(altaAlumnos);

        JMenu menuMaterias = new JMenu("Materias");
        JMenuItem altaMaterias = new JMenuItem("Gestionar Materias");
        altaMaterias.addActionListener(e -> {
            VistaMaterias vm = new VistaMaterias(materias);
            escritorio.add(vm);
            vm.setVisible(true);
        });
        menuMaterias.add(altaMaterias);

        JMenu menuInscripcion = new JMenu("Inscripciones");
        JMenuItem inscribir = new JMenuItem("Formulario Inscripción");
        inscribir.addActionListener(e -> {
            VistaInscripcion vi = new VistaInscripcion(alumnos, materias);
            escritorio.add(vi);
            vi.setVisible(true);
        });
        menuInscripcion.add(inscribir);

        barra.add(menuArchivo);
        barra.add(menuAlumnos);
        barra.add(menuMaterias);
        barra.add(menuInscripcion);

        setJMenuBar(barra);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Colegio().setVisible(true));
    }
}
