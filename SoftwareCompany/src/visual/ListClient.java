package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logical.Boss;
import logical.Client;
import logical.Designer;
import logical.Programmer;
import logical.SoftwareCompany;
import logical.Worker;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class ListClient extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbxColumnChooser;
	private JTextField txtFiltro;
	private TableRowSorter<TableModel> sorter;
	private DefaultTableModel model;
	private Object[] rows;
	private int index = -1;
	private String code = "";
	private JTable tableClients;
	private String[] headers = {"Código", "Cedula", "Nombre", "Dirección", "Teléfono", "P. Activos", "Registro"};

	public ListClient() {
		setResizable(false);
		setTitle("Lista de Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListClient.class.getResource("/Imgs/listclient30.png")));
		setBounds(100, 100, 998, 437);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Filtrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 972, 57);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Filtrar por:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 21, 73, 14);
		panel.add(lblNewLabel);
		
		cbxColumnChooser = new JComboBox();
		cbxColumnChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxColumnChooser.getSelectedIndex() > 0) {
					txtFiltro.setEnabled(true);
					txtFiltro.requestFocus();
				} else {
					txtFiltro.setText("");
					txtFiltro.setEnabled(false);
					sorter.setRowFilter(null);
				}
			}
		});
		ArrayList<String> combo = new ArrayList<>();
		combo.add("<Seleccione>");
		for (String string : headers ) {
			combo.add(string);
		}
		cbxColumnChooser.setModel(new DefaultComboBoxModel(combo.toArray()));
		cbxColumnChooser.setBounds(93, 20, 199, 20);
		panel.add(cbxColumnChooser);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblFiltro.setBounds(302, 23, 45, 14);
		panel.add(lblFiltro);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!txtFiltro.isEnabled()) {
					return;
				}
				for (int i = 0; i < model.getColumnCount(); i++) {
					if (model.getColumnName(i).equalsIgnoreCase(cbxColumnChooser.getSelectedItem().toString())) {
						tableFilter(txtFiltro.getText(), i);
					}
				}
			}
		});
		txtFiltro.setEnabled(false);
		txtFiltro.setBounds(357, 20, 256, 20);
		panel.add(txtFiltro);
		txtFiltro.setColumns(10);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 79, 972, 277);
			contentPanel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			
			model = new DefaultTableModel();
			sorter = new TableRowSorter<TableModel>(model);
			model.setColumnCount(headers.length);
			model.setColumnIdentifiers(headers);
			tableClients = new JTable();
			tableClients.setModel(model);
			tableClients.setDefaultEditor(Object.class, null);
			tableClients.setAutoCreateRowSorter(true);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			for (int i = 0; i < headers.length; i++) {
				tableClients.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			}
			tableClients.getColumnModel().getColumn(0).setPreferredWidth(30);
			tableClients.getColumnModel().getColumn(2).setPreferredWidth(250);
			tableClients.getColumnModel().getColumn(3).setPreferredWidth(150);
			tableClients.getColumnModel().getColumn(5).setPreferredWidth(15);
			tableClients.getColumnModel().getColumn(6).setPreferredWidth(25);
			tableClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableClients.setRowSorter(sorter);
			loadtable();
			scrollPane.setViewportView(tableClients);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Modificar");
				okButton.setEnabled(false);
				okButton.setIcon(new ImageIcon(ListClient.class.getResource("/Imgs/icons8-edit-file-16.png")));
				okButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setIcon(new ImageIcon(ListClient.class.getResource("/Imgs/exit.png")));
				cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void tableFilter(String text, int column_index) {
	    RowFilter<TableModel, Object> filter = null;
	    try {
	    	filter = RowFilter.regexFilter(text.toUpperCase(), column_index);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(filter);
	}
	
	private void loadtable() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Client aux : SoftwareCompany.getInstance().getClients()) {
			addRow(aux);
		}
	}

	private void addRow(Client aux) {
		rows[0] = aux.getCode();
		rows[1] = aux.getId();
		rows[2] = aux.getName() + " " + aux.getLast_name();
		rows[3] = aux.getAddress();
		rows[4] = aux.getPhone();
		rows[5] = aux.getCant_projects();
		rows[6] = (new SimpleDateFormat("dd/MM/yyyy")).format(aux.getRegistration_date());
		model.addRow(rows);
	}
}
