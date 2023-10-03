import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class PersonasTable extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTable table;
	private ListaDePersonas listaDePersonas;
	private Object EXIT_ON_CLOSE;
	
	public PersonasTable(ListaDePersonas listaDePersonas2) {
		// TODO Auto-generated constructor stub
	}

	public void MPCTestFrame() {
		
		setSize(400,300);
		setName("PeronasPorInterés");
		
		initData();
		initUI();
		
		setVisible(true);
		

	}

	private void initData() {
		// TODO Auto-generated method stub
		listaDePersonas=new ListaDePersonas();
		
		//Datos ejemplo
		listaDePersonas.agregarPersona(new Persona("Julio",3,4,2,5));
		listaDePersonas.agregarPersona(new Persona("Micaela",2,5,3,4));
		//Podemos agregar más personas según sus necesidadaes
		
	}
	private void initUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getRootPane().setLayout(new BorderLayout(5,5));
		
		TableModel tablemod=(TableModel) new PersonasTable(listaDePersonas);
		table=new JTable(tablemod);
		
		JScrollPane tableScrollPane=new JScrollPane(table);
		getRootPane().add(tableScrollPane,BorderLayout.CENTER);
		
	
		
	}

	private void setDefaultCloseOperation(Object eXIT_ON_CLOSE2) {
		// TODO Auto-generated method stub
		
	}

}
