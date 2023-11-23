package interfaz;

import javax.swing.*;
import Presenter.Presenter;
import model.Model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Interfaz {

    private JFrame frame;
    private JPanel leftPanel;
    
    private JButton agregarButton;
    private JComboBox<Integer>[] propiedadesComboBoxes;
    private String[] intereses = {"Interés por los deportes", "Interés por la música", "Interés por las noticias del espectáculo", "Interés por la ciencia"};
    private JTextField nombreTextField;
    private JLabel mensajeLabel;
    private Timer timer;
    
    private JButton generarGruposButton;
    
    private DefaultListModel<String> personasListModel;
    private JList<String> personasList;
 
    private Presenter presenter;

    public Interfaz() 
    {
        generarFrame();
        GridBagConstraints gbcLeft = generarLeftPanel();
        generarCampoNombre(gbcLeft);
        generarCampoIntereses(gbcLeft);
        generarBotonAgregarPersona(gbcLeft);
        JScrollPane listScrollPane = generarLista();
        generarMensajePersonaAgregada(gbcLeft);
        generarGruposButton(gbcLeft);

        timer = new Timer(1000, e -> limpiarMensaje()); 
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, listScrollPane);
        frame.add(splitPane);

        frame.setVisible(true);
    }
    
    
    
    
    
    
    
    
	private void generarFrame() 
	{
		frame = new JFrame("Clustering Humano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300); 
	}
	
	
	
	
	private GridBagConstraints generarLeftPanel() 
	{
		// Crear el panel izquierdo para el formulario
        leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.insets = new Insets(5, 5, 5, 5);

        leftPanel.setPreferredSize(new Dimension(300, 300)); // Ajusta el tamaño según tus necesidades
		return gbcLeft;
	}
	
	
	
	private void generarCampoNombre(GridBagConstraints gbcLeft) 
	{
		// Etiqueta y campo de texto para el nombre
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.anchor = GridBagConstraints.WEST;
        JLabel nombreLabel = new JLabel("Nombre:");
        leftPanel.add(nombreLabel, gbcLeft);

        gbcLeft.gridx = 1;
        gbcLeft.gridy = 0;
        gbcLeft.weightx = 1.0; // Establece el peso para expandir el área horizontalmente
        gbcLeft.gridwidth = 2; // Amplía el ancho de la celda
        gbcLeft.fill = GridBagConstraints.HORIZONTAL;

        nombreTextField = new JTextField(20);
        leftPanel.add(nombreTextField, gbcLeft);
	}

	
	private void generarCampoIntereses(GridBagConstraints gbcLeft) 
	{
        propiedadesComboBoxes = new JComboBox[4];
        for (int i = 0; i < 4; i++) {
            gbcLeft.gridx = 0;
            gbcLeft.gridy = i + 1;
            gbcLeft.anchor = GridBagConstraints.WEST;
            JLabel interesLabel = new JLabel(intereses[i]);
            leftPanel.add(interesLabel, gbcLeft);

            gbcLeft.gridx = 1;
            gbcLeft.gridy = i + 1;
            gbcLeft.gridwidth = 1; 
            propiedadesComboBoxes[i] = new JComboBox<>();
            for (int j = 1; j <= 5; j++) {
                propiedadesComboBoxes[i].addItem(j);
            }
            leftPanel.add(propiedadesComboBoxes[i], gbcLeft);
        }
	}
	
	
	
	private void generarBotonAgregarPersona(GridBagConstraints gbcLeft) 
	{
        gbcLeft.gridx = 1;
        gbcLeft.gridy = 6;
        gbcLeft.gridwidth = 2;  
        gbcLeft.fill = GridBagConstraints.HORIZONTAL;
        
        agregarButton = new JButton("Agregar Persona");
        agregarButton.setEnabled(false); // Deshabilita el botón inicialmente
        
        agregarButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String nombre = nombreTextField.getText().trim();
                int[] puntuaciones = new int[4];
                
                if(validarNombre(nombre))
                {
                	for (int i = 0; i < 4; i++) 
                	{
                		puntuaciones[i] = (int) propiedadesComboBoxes[i].getSelectedItem();
                	}
                	
                	 // Creamos una cadena que incluye el nombre y los intereses
                    StringBuilder personaInfo = new StringBuilder(nombre + ": ");
                    personaInfo.append("Di").append(" - ").append(puntuaciones[0]).append(" ");
                    personaInfo.append("Mi").append(" - ").append(puntuaciones[1]).append(" ");
                    personaInfo.append("Ei").append(" - ").append(puntuaciones[2]).append(" ");
                    personaInfo.append("Ci").append(" - ").append(puntuaciones[3]).append(" ");
                    
                    // Actualizamos la lista de personas
                    personasListModel.addElement(personaInfo.toString());

                    // Limpiamos el campo del nombre
                    nombreTextField.setText("");
     

                    // Deshabilitamos el botón nuevamente después de agregar una persona
                    agregarButton.setEnabled(false);
                    
                    mensajeLabel.setText("Persona agregada");
                    timer.restart();
                    
                    // Habilitamos el botón "Generar Grupos" cuando se agrega al menos una persona
                    generarGruposButton.setEnabled(true);
                    presenter.agregarPersona(nombre, puntuaciones[0], puntuaciones[1], puntuaciones[2], puntuaciones[3]);
                }
                else 
                {
                    JOptionPane.showMessageDialog(frame, "Nombre inválido. Asegúrate de ingresar solo letras.", "Error", JOptionPane.ERROR_MESSAGE);
                }   
            }
        });
        
        // Agregamos un listener para habilitar/deshabilitar el botón según el contenido del nombre
        nombreTextField.getDocument().addDocumentListener((DocumentListener) new DocumentListener() 
        {
        	@Override
        	public void insertUpdate(DocumentEvent e) {
        		actualizarEstadoBoton();
        	}

        	@Override
        	public void removeUpdate(DocumentEvent e) {
        		actualizarEstadoBoton();
        	}

        	@Override
        	public void changedUpdate(DocumentEvent e) {
        		actualizarEstadoBoton();
        	}
        });
        
        gbcLeft.gridx = 1;
        gbcLeft.gridy = 7; // Incrementa el índice de la fila
        leftPanel.add(agregarButton, gbcLeft);

        leftPanel.setBorder(BorderFactory.createTitledBorder("Agregar Persona"));
        leftPanel.setBackground(new Color(230, 230, 250));
	}
	
	private boolean validarNombre(String nombre) 
	{
	    return nombre.matches("^[a-zA-Z ]+$");
	}

	private void actualizarEstadoBoton() 
	{
	    agregarButton.setEnabled(!nombreTextField.getText().isEmpty());
	}

	
	
	
	private JScrollPane generarLista() 
	{
        personasListModel = new DefaultListModel<>();
        personasList = new JList<>(personasListModel);
        JScrollPane listScrollPane = new JScrollPane(personasList);
		return listScrollPane;
	}
	
	
	
	
	private void generarMensajePersonaAgregada(GridBagConstraints gbcLeft) 
	{
        mensajeLabel = new JLabel(" ");
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 7; // Incrementa el índice de la fila
        gbcLeft.gridwidth = 2;  // Ajusta el ancho del JLabel
        leftPanel.add(mensajeLabel, gbcLeft);
	}


	private void generarGruposButton(GridBagConstraints gbcLeft) 
	{
		    gbcLeft.gridx = 0;
		    gbcLeft.gridy = 8; 
		    gbcLeft.gridwidth = 2; 
		    generarGruposButton = new JButton("Generar Grupos");
		    generarGruposButton.setEnabled(false); // Deshabilita el botón inicialmente hasta que se agrege una persona
		    
		    generarGruposButton.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	int opcion = JOptionPane.showConfirmDialog(frame, "Una vez que se generen los grupos no se podrán agregar más personas. ¿Está seguro de continuar?", "Confirmar Generación de Grupos", JOptionPane.YES_NO_OPTION);

	            	if (opcion == JOptionPane.YES_OPTION) 
	            	{
	            		bloquearInterfaz();

	            		presenter.generarGrupos();
		                String grupo1 = presenter.obtenerGrupo1();  
		                String grupo2 = presenter.obtenerGrupo2(); 
		              
		                timer.restart();
		                
		                actualizarInterfazConInfoDeGrupo(grupo1, grupo2);
	            	}
	            	else 
	            	{
	            		 return;
	            	}
	            }
	        });
	        leftPanel.add(generarGruposButton, gbcLeft);
	}
	
	private void bloquearInterfaz() 
	{
	    nombreTextField.setEnabled(false);
	    for (JComboBox<Integer> comboBox : propiedadesComboBoxes) {
	        comboBox.setEnabled(false);
	    }
	    agregarButton.setEnabled(false);
	    generarGruposButton.setEnabled(false);
	}
	
	private void actualizarInterfazConInfoDeGrupo(String grupo1Info, String grupo2Info) 
	{
        JTextArea grupo1TextArea = new JTextArea(grupo1Info);
        JTextArea grupo2TextArea = new JTextArea(grupo2Info);
        
        grupo1TextArea.setEditable(false);
        grupo2TextArea.setEditable(false);
        
        JPanel grupo1Panel = new JPanel(new BorderLayout());
        JPanel grupo2Panel = new JPanel(new BorderLayout());
      
        grupo1Panel.add(new JScrollPane(grupo1TextArea), BorderLayout.CENTER);
        grupo2Panel.add(new JScrollPane(grupo2TextArea), BorderLayout.CENTER);

        JFrame gruposFrame = new JFrame("Grupos Generados");

        gruposFrame.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                frame.dispose(); // Cierra la ventana principal cuando la ventana emergente se cierra
            }
        });
        
        GridLayout gridLayout = new GridLayout(1, 2);
        gruposFrame.setLayout(gridLayout);
        
        gruposFrame.add(grupo1Panel);
        gruposFrame.add(grupo2Panel);

        gruposFrame.setSize(600, 300);
        gruposFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        gruposFrame.setVisible(true);
    }

	
	
	public void setPresenter(Presenter presenter) 
	{
        this.presenter = presenter;
    }

	private void limpiarMensaje() 
    {
        mensajeLabel.setText(" ");
    }
	  
}
