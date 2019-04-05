package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logical.Client;
import logical.SoftwareCompany;
import logical.User;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ListUser extends JDialog {

	private Validation validation = new Validation();
	private final JPanel contentPanel = new JPanel();
	private JComboBox cbxColumnChooser;
	private JTextField txtFiltro;
	private TableRowSorter<TableModel> sorter;
	private DefaultTableModel model;
	private Object[] rows;
	private int index = -1;
	private String code = "";
	private JTable tableUsuarios;
	private String[] headers = {"C�digo", "Cedula", "Nombre", "Tel�fono", "Correo", "Usuario", "Tipo", "Estado", "Creador", "Ultima Entrada"};
	private JButton btnModificar;
	private JButton btnActivar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListUser dialog = new ListUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListUser() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListUser.class.getResource("/Imgs/list30px.png")));
		setResizable(false);
		setBounds(100, 100, 1052, 437);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Filtrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 1012, 57);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("Filtrar por:");
				label.setFont(new Font("SansSerif", Font.PLAIN, 14));
				label.setBounds(10, 21, 73, 14);
				panel.add(label);
			}
			{
				cbxColumnChooser = new JComboBox();
				cbxColumnChooser.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						validation.setFocusBackground(cbxColumnChooser, true);
					}
					@Override
					public void focusLost(FocusEvent e) {
						validation.setFocusBackground(cbxColumnChooser, false);
					}
				});
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
			}
			{
				JLabel label = new JLabel("Filtro:");
				label.setFont(new Font("SansSerif", Font.PLAIN, 14));
				label.setBounds(302, 23, 45, 14);
				panel.add(label);
			}
			{
				txtFiltro = new JTextField();
				txtFiltro.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						validation.setFocusBackground(txtFiltro, true);
					}
					@Override
					public void focusLost(FocusEvent e) {
						validation.setFocusBackground(txtFiltro, false);
					}
				});
				try {
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
				} catch (Exception e) {
					// TODO: handle exception
				}
				txtFiltro.setEnabled(false);
				txtFiltro.setColumns(10);
				txtFiltro.setBounds(357, 20, 256, 20);
				panel.add(txtFiltro);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 77, 1012, 277);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					sorter = new TableRowSorter<TableModel>(model);
					model.setColumnCount(headers.length);
					model.setColumnIdentifiers(headers);
					tableUsuarios = new JTable();
					tableUsuarios.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if (tableUsuarios.getSelectedRow() >= 0) {
								index = tableUsuarios.getSelectedRow();
								code = tableUsuarios.getValueAt(index, 0).toString();
								btnModificar.setEnabled(true);
								btnActivar.setEnabled(true);
								btnModificar.setText("Modificar " + code);
								if (tableUsuarios.getValueAt(index, 7).toString().equalsIgnoreCase("Activo")) {
									btnActivar.setText("Desactivar " + code);
									btnActivar.setIcon(new ImageIcon(ListUser.class.getResource("/Imgs/block16.png")));
								} else {
									btnActivar.setText("Activar " + code);
									btnActivar.setIcon(new ImageIcon(ListUser.class.getResource("/Imgs/ok16.png")));
								}
							} else {
								index = -1;
								code = "";
								btnModificar.setEnabled(false);
							}
						}
					});
					tableUsuarios.setModel(model);
					tableUsuarios.setDefaultEditor(Object.class, null);
					tableUsuarios.setAutoCreateRowSorter(true);
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					centerRenderer.setHorizontalAlignment(JLabel.CENTER);
					for (int i = 0; i < headers.length; i++) {
						tableUsuarios.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
					}
					tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tableUsuarios.setRowSorter(sorter);
					loadtable();
					scrollPane.setViewportView(tableUsuarios);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnActivar = new JButton("Activar");
				btnActivar.setIcon(new ImageIcon(ListUser.class.getResource("/Imgs/ok16.png")));
				btnActivar.setFont(new Font("SansSerif", Font.PLAIN, 14));
				btnActivar.setEnabled(false);
				buttonPane.add(btnActivar);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setEnabled(false);
				btnModificar.setIcon(new ImageIcon(ListUser.class.getResource("/Imgs/iconfinder_Modify_132685.png")));
				btnModificar.setFont(new Font("SansSerif", Font.PLAIN, 14));
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setIcon(new ImageIcon(ListUser.class.getResource("/Imgs/exit.png")));
				btnSalir.setFont(new Font("SansSerif", Font.PLAIN, 14));
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
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
	
	private void loadtable() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (User aux : SoftwareCompany.getInstance().getUsers()) {
			addRow(aux);
		}
	}
	
	private void addRow(User aux) {
		rows[0] = aux.getCode();
		rows[1] = aux.getId();
		rows[2] = aux.getName() + " " + aux.getLast_name();
		rows[3] = aux.getAddress();
		rows[4] = aux.getPhone();
		model.addRow(rows);
	}
	
	private void normalState() {
		code = "";
		index = -1;
		btnModificar.setEnabled(false);
		btnActivar.setEnabled(false);
		btnModificar.setText("Modificar");
		btnActivar.setText("Activar");
		tableUsuarios.clearSelection();
		loadtable();
	}
}