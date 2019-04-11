package visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logical.Client;
import logical.SoftwareCompany;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ListProjects extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableProjects;
	public static Object[] fila;
	private DefaultTableModel model;
	public static String codContractTable;
	private JTextField txtfiltrer;
	private TableRowSorter<TableModel> sorter;
	private String[] headers = {"ID Contrato", "ID Cliente", "Nombre Cliente", "ID Proyecto", "Tipo Proyecto", "Firma Contrato", "Fecha Inicio","Fecha de Entrega","Total a pagar","Estado","Fecha Prorrogado","Cant Pro"};
	private static int cont;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private Render render;
	private static ListProjects listPro=null;
	
	public static ListProjects getInstance() {
		if (listPro==null) {
			listPro=new ListProjects();
		}
		return listPro;
	}
	
	/*public static SoftwareCompany getInstance() {
		if (softwareCompany == null) {
			softwareCompany = new SoftwareCompany();
		}
		return softwareCompany;
	}*/
	 


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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListProjects.class.getResource("/Imgs/list30px.png")));
		setTitle("Listar Proyectos");
		setBounds(100, 100, 1269, 803);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		model = new DefaultTableModel();
		sorter = new TableRowSorter<TableModel>(model);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(10, 106, 1233, 574);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tableProjects = new JTable();
		
		//tableProjects.setDefaultRenderer(Object.class, render);
		tableProjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				   int row=tableProjects.getSelectedRow();
			        codContractTable= String.valueOf(model.getValueAt(row, 0));	
			        System.out.println(codContractTable);
			    	WindowCheckContract newWindowCont=new WindowCheckContract();
					newWindowCont.setModal(true);
					newWindowCont.setSize(1240, 520);
					newWindowCont.setResizable(false);
					newWindowCont.setLocationRelativeTo(null);
					newWindowCont.setVisible(true);
					loadUser();
					
				
			}
		});
		
		String [] header = {"ID Contrato", "ID Cliente", "Nombre Cliente", "ID Proyecto", "Tipo Proyecto","Firma Contrato", "Fecha Inicio", "Fecha de entrega", "Total a pagar","Estado","Fecha Prorrogado","Cant Pro"};
		
		model.setColumnIdentifiers(header);
		tableProjects.setModel(model);
		tableProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProjects.setModel(model);
		
		
		
		
		 TableColumnModel columnModel = tableProjects.getColumnModel();
		 tableProjects.setAutoCreateRowSorter(true);
		 columnModel.getColumn(0).setPreferredWidth(50);
		 columnModel.getColumn(3).setPreferredWidth(50);
		 columnModel.getColumn(3).setPreferredWidth(75);
		 columnModel.getColumn(9).setPreferredWidth(40);
		 columnModel.getColumn(11).setPreferredWidth(40);
		 tableProjects.setRowSorter(sorter);
		
		/*
		 * 
		 TableColumnModel columnModel = tabla.getColumnModel();
columnModel.getColumn(2).setPreferredWidth(200);
		 * */
		
		
		loadUser();
		scrollPane.setViewportView(tableProjects);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Filtrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 1233, 78);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		Label label = new Label("Filtrar Por:");
		label.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label.setBounds(10, 29, 86, 22);
		panel_1.add(label);
		
		JComboBox comboBoxFiltrer = new JComboBox();
		
		comboBoxFiltrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBoxFiltrer.getSelectedIndex() > 0) {
					txtfiltrer.setEnabled(true);
					txtfiltrer.requestFocus();
				} else {
					txtfiltrer.setText("");
					txtfiltrer.setEnabled(false);
					sorter.setRowFilter(null);
				}
				
				
			}
		});
		comboBoxFiltrer.setBounds(102, 31, 183, 20);
		panel_1.add(comboBoxFiltrer);
		
		ArrayList<String> combo = new ArrayList<>();
		combo.add("<Seleccione>");
		for (String string : headers ) {
			combo.add(string);
		}
		
		comboBoxFiltrer.setModel(new DefaultComboBoxModel(combo.toArray()));
		
		
		Label label_1 = new Label("Filtro:");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_1.setBounds(291, 29, 62, 22);
		panel_1.add(label_1);
		
		txtfiltrer = new JTextField();
		try {
			txtfiltrer.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (!txtfiltrer.isEnabled()) {
						return;
					}
					for (int i = 0; i < model.getColumnCount(); i++) {
						if (model.getColumnName(i).equalsIgnoreCase(comboBoxFiltrer.getSelectedItem().toString())) {
							tableFilter(txtfiltrer.getText(), i);
						}
					}
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		txtfiltrer.setBounds(359, 31, 203, 20);
		panel_1.add(txtfiltrer);
		txtfiltrer.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setIcon(new ImageIcon(ListProjects.class.getResource("/Imgs/ok16.png")));
				okButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public void loadUser() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
	
		//"ID Contrato", "ID Cliente", "Nombre Cliente", "ID Proyecto", "Tipo Proyecto", "Fecha Inicio", "Fecha de entrega", "Total a pagar"};
		render=new Render(9);
		tableProjects.setDefaultRenderer(Object.class,render);
		render.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < headers.length; i++) {
			tableProjects.getColumnModel().getColumn(i).setCellRenderer(render);
		}	
		
		for (int i = 0; i <SoftwareCompany.getInstance().getContracts().size(); i++) {
			fila[0]=SoftwareCompany.getInstance().getContracts().get(i).getId();
			fila[1]=SoftwareCompany.getInstance().getContracts().get(i).getIdClient();
			Client aux=SoftwareCompany.getInstance().clientById(SoftwareCompany.getInstance().getContracts().get(i).getIdClient());
			fila[2]=aux.getName();
			fila[3]=SoftwareCompany.getInstance().getContracts().get(i).getProject().getId();
			fila[4]=SoftwareCompany.getInstance().getContracts().get(i).getProject().getType();
			fila[5]=SoftwareCompany.getInstance().getContracts().get(i).getSignoutDay();
			fila[6]=dateFormat.format(SoftwareCompany.getInstance().getContracts().get(i).getDateBegin());
			fila[7]=dateFormat.format(SoftwareCompany.getInstance().getContracts().get(i).getDueDate());
			fila[8]=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			fila[9]=SoftwareCompany.getInstance().getContracts().get(i).getProject().getState();
			fila[10]="N/A";
			fila[11]=SoftwareCompany.getInstance().getContracts().get(i).getProject().getWorkers().size();
			model.addRow(fila);
		}
		
		
	}
	
	private void tableFilter(String text, int column_index) {
	    RowFilter<TableModel, Object> filter = null;
	    try {
	    	filter = RowFilter.regexFilter("(?i)" + text, column_index);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(filter);
	}
	public JTable getTableProjects() {
		return tableProjects;
	}
	public void setTableProjects(JTable tableProjects) {
		this.tableProjects = tableProjects;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}
}
