import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {

    private JFrame frame;
    private JPanel panel;
    private JButton agregarButton;
    private JTextArea nombreTextArea;
    private JComboBox<Integer>[] propiedadesComboBoxes;

    public Interfaz() {
        frame = new JFrame("Sistema de Gestión de Personas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // botones
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton agregarPersonasButton = new JButton("Agregar Personas");
        agregarPersonasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarInterfazAgregarPersonas();
            }
        });
        buttonsPanel.add(agregarPersonasButton);

        JButton visualizarDatosButton = new JButton("Visualizar Datos");
        visualizarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Visualizar Datos seleccionado.");
            }
        });
        buttonsPanel.add(visualizarDatosButton);

        frame.add(buttonsPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    private void mostrarInterfazAgregarPersonas() {
        JFrame agregarPersonaFrame = new JFrame("Agregar Persona");
        agregarPersonaFrame.setSize(400, 300);

        panel = new JPanel(new GridBagLayout());
        agregarPersonaFrame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel nombreLabel = new JLabel("Nombre:");
        panel.add(nombreLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        nombreTextArea = new JTextArea(2, 20);
        JScrollPane nombreScrollPane = new JScrollPane(nombreTextArea);
        nombreScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        nombreScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(nombreScrollPane, gbc);

        String[] intereses = {
        	    "Interés por los deportes",
        	    "Interés por la música",
        	    "Interés por las noticias del espectáculo",
        	    "Interés por la ciencia"
        	    
        	};
        propiedadesComboBoxes = new JComboBox[4]; 
        for (int i = 0; i < 4; i++) {
        	   gbc.gridx = 0;
        	   gbc.gridy = i + 1;
        	   JLabel interesLabel = new JLabel(intereses[i]); 
        	   panel.add(interesLabel, gbc);

        	   gbc.gridx = 1;
        	   propiedadesComboBoxes[i] = new JComboBox<>();
        	   for (int j = 1; j <= 5; j++) {
        	       propiedadesComboBoxes[i].addItem(j);
            }
            panel.add(propiedadesComboBoxes[i], gbc);
       	}

        // boton "Agregar Persona"
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        agregarButton = new JButton("Agregar Persona");
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextArea.getText();
                int[] puntuaciones = new int[4];
                for (int i = 0; i < 4; i++) {
                    puntuaciones[i] = (int) propiedadesComboBoxes[i].getSelectedItem();
                }
                // guarda la info
                System.out.println("Nombre: " + nombre);
                for (int i = 0; i < 4; i++) {
                    System.out.println(intereses[i] + ": " + puntuaciones[i]);
                }
            }
        });
        panel.add(agregarButton, gbc);

        panel.setBorder(BorderFactory.createTitledBorder("Agregar Persona"));
        panel.setBackground(new Color(230, 230, 250));

        agregarPersonaFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz());
    }
}