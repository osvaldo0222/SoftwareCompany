package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import logical.Client;
import logical.SoftwareCompany;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListProjects extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableProjects;
	public static Object[] fila;
	private DefaultTableModel model;


	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			ListProjects dialog = new ListProjects();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListProjects() {
		setBounds(100, 100, 1250, 482);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(10, 65, 1214, 293);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1194, 271);
		panel.add(scrollPane);
		
		tableProjects = new JTable();
		String [] header = {"ID Contrato", "ID Cliente", "Nombre Cliente", "ID Proyecto", "Tipo Proyecto","Fecha Firma Contrato", "Fecha Inicio", "Fecha de entrega", "Total a pagar"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(header);
		tableProjects.setModel(model);
		tableProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProjects.setModel(model);
		loadUser();
		scrollPane.setViewportView(tableProjects);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void loadUser() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		int exist=-1;
		//"ID Contrato", "ID Cliente", "Nombre Cliente", "ID Proyecto", "Tipo Proyecto", "Fecha Inicio", "Fecha de entrega", "Total a pagar"};

		for (int i = 0; i <SoftwareCompany.getInstance().getContracts().size(); i++) {
			fila[0]=SoftwareCompany.getInstance().getContracts().get(i).getId();
			fila[1]=SoftwareCompany.getInstance().getContracts().get(i).getIdClient();
			Client aux=SoftwareCompany.getInstance().clientById((String) fila[1]);
			fila[2]=aux.getName();
			fila[3]=SoftwareCompany.getInstance().getContracts().get(i).getProject().getId();
			fila[4]=SoftwareCompany.getInstance().getContracts().get(i).getProject().getType();
			fila[5]=SoftwareCompany.getInstance().getContracts().get(i).getSignoutDay();
			fila[6]=SoftwareCompany.getInstance().getContracts().get(i).getDateBegin();
			fila[7]=SoftwareCompany.getInstance().getContracts().get(i).getDueDate();
			fila[8]=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			model.addRow(fila);
		}
		
	}
}