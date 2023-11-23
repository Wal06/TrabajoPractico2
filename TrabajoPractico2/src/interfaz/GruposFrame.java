package interfaz;

import javax.swing.*;
import java.awt.*;

public class GruposFrame extends JFrame {
    private JSplitPane splitPane;

    public GruposFrame() {
        setTitle("Grupos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        add(splitPane);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mostrarGrupos(JPanel grupo1, JPanel grupo2) {
        // Configurar el JSplitPane
        splitPane.setTopComponent(crearPanelSuperior());
        splitPane.setBottomComponent(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(grupo1), new JScrollPane(grupo2)));
    }

    private JPanel crearPanelSuperior() {
        JPanel panelSuperior = new JPanel(new BorderLayout());

        // Añadir etiquetas de título a los paneles superiores
        JLabel etiquetaGrupo1 = new JLabel("Grupo 1", SwingConstants.CENTER);
        JLabel etiquetaGrupo2 = new JLabel("Grupo 2", SwingConstants.CENTER);

        panelSuperior.add(etiquetaGrupo1, BorderLayout.WEST);
        panelSuperior.add(etiquetaGrupo2, BorderLayout.EAST);

        return panelSuperior;
    }
}
