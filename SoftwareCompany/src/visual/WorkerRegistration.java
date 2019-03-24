package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.CardLayout;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkerRegistration extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtSalario;
	private JTextField txtAsociados;
	private JComboBox cbxEspecialidad;
	private JSpinner spnFrecPlani;
	private DefaultListModel modelList;
	private JButton btnJefe;
	private JButton btnProgramador;
	private JButton btnDisenador;
	private JButton btnPlanificador;
	private JTabbedPane tabbedPaneTipos;
	private JPanel panelJefe;
	private JPanel panelProgramador;
	private JPanel panelDisenador;
	private JPanel panelPlanificador;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WorkerRegistration dialog = new WorkerRegistration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WorkerRegistration() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WorkerRegistration.class.getResource("/Imgs/Workers.png")));
		setTitle("Registro de Trabajadores");
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		setResizable(false);
		setBounds(100, 100, 591, 604);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 160, 518);
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			contentPanel.add(panel);
			{
				btnProgramador = new JButton("Programador");
				btnProgramador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						removeLastTab();
						tabbedPaneTipos.addTab("Programador", null, panelProgramador, null);
						btnJefe.setEnabled(true);
						btnPlanificador.setEnabled(true);
						btnDisenador.setEnabled(true);
						btnProgramador.setEnabled(false);
					}
				});
				btnProgramador.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/Imgs/Programmer.png")));
				btnProgramador.setFont(new Font("SansSerif", Font.PLAIN, 14));
			}
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				btnJefe = new JButton("Jefe Proyecto");
				btnJefe.setEnabled(false);
				btnJefe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						removeLastTab();
						tabbedPaneTipos.addTab("Jefe de Proyecto", null, panelJefe, null);
						btnJefe.setEnabled(false);
						btnPlanificador.setEnabled(true);
						btnDisenador.setEnabled(true);
						btnProgramador.setEnabled(true);
					}
				});
				btnJefe.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/Imgs/Boss.png")));
				btnJefe.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panel.add(btnJefe);
			}
			panel.add(btnProgramador);
			{
				btnDisenador = new JButton("Dise\u00F1ador");
				btnDisenador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						removeLastTab();
						tabbedPaneTipos.addTab("Diseñador", null, panelDisenador, null);
						btnJefe.setEnabled(true);
						btnPlanificador.setEnabled(true);
						btnDisenador.setEnabled(false);
						btnProgramador.setEnabled(true);
					}
				});
				btnDisenador.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/Imgs/icons8-man-in-blue-shirt-pencil-50.png")));
				btnDisenador.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panel.add(btnDisenador);
			}
			{
				btnPlanificador = new JButton("Planificador");
				btnPlanificador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						removeLastTab();
						tabbedPaneTipos.addTab("Planificador", null, panelPlanificador, null);
						btnJefe.setEnabled(true);
						btnPlanificador.setEnabled(false);
						btnDisenador.setEnabled(true);
						btnProgramador.setEnabled(true);
					}
				});
				btnPlanificador.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/Imgs/icons8-intelligence-40.png")));
				btnPlanificador.setFont(new Font("SansSerif", Font.PLAIN, 14));
				panel.add(btnPlanificador);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(175, 5, 400, 518);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 11, 380, 325);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblImage = new JLabel("<Imagen>");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblImage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			lblImage.setBounds(10, 21, 118, 97);
			panel_1.add(lblImage);
			
			JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
			lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(138, 21, 54, 19);
			panel_1.add(lblNewLabel_1);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(202, 21, 118, 20);
			panel_1.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblCedula.setBounds(138, 60, 54, 19);
			panel_1.add(lblCedula);
			
			JLabel lblNombres = new JLabel("Nombres:");
			lblNombres.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblNombres.setBounds(10, 129, 65, 19);
			panel_1.add(lblNombres);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(202, 61, 168, 20);
			panel_1.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombres = new JTextField();
			txtNombres.setBounds(85, 130, 285, 20);
			panel_1.add(txtNombres);
			txtNombres.setColumns(10);
			{
				JLabel lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblApellidos.setBounds(10, 169, 65, 19);
				panel_1.add(lblApellidos);
			}
			{
				JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
				lblDireccion.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblDireccion.setBounds(10, 209, 65, 19);
				panel_1.add(lblDireccion);
			}
			{
				txtApellidos = new JTextField();
				txtApellidos.setBounds(85, 170, 285, 20);
				panel_1.add(txtApellidos);
				txtApellidos.setColumns(10);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setBounds(85, 210, 285, 20);
				panel_1.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			{
				JLabel lblGenero = new JLabel("Genero:");
				lblGenero.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblGenero.setBounds(10, 251, 65, 19);
				panel_1.add(lblGenero);
			}
			
			JComboBox cbxGenero = new JComboBox();
			cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino"}));
			cbxGenero.setBounds(85, 252, 107, 20);
			panel_1.add(cbxGenero);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblEdad.setBounds(212, 251, 54, 19);
			panel_1.add(lblEdad);
			
			JSpinner spnEdad = new JSpinner();
			spnEdad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnEdad.setBounds(272, 252, 98, 20);
			panel_1.add(spnEdad);
			{
				JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
				lblTelfono.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblTelfono.setBounds(10, 292, 65, 19);
				panel_1.add(lblTelfono);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setBounds(85, 293, 107, 20);
				panel_1.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				JLabel lblSalario = new JLabel("Salario:");
				lblSalario.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblSalario.setBounds(212, 292, 54, 19);
				panel_1.add(lblSalario);
			}
			{
				txtSalario = new JTextField();
				txtSalario.setBounds(272, 293, 98, 20);
				panel_1.add(txtSalario);
				txtSalario.setColumns(10);
			}
		}
		
		tabbedPaneTipos = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneTipos.setBounds(10, 347, 380, 160);
		panel.add(tabbedPaneTipos);
		
		panelJefe = new JPanel();
		tabbedPaneTipos.addTab("Jefe", null, panelJefe, null);
		panelJefe.setLayout(null);
		
		JLabel lblAsociados = new JLabel("Asociados:");
		lblAsociados.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblAsociados.setBounds(10, 11, 74, 19);
		panelJefe.add(lblAsociados);
		
		txtAsociados = new JTextField();
		txtAsociados.setEditable(false);
		txtAsociados.setBounds(10, 41, 157, 20);
		panelJefe.add(txtAsociados);
		txtAsociados.setColumns(10);
		
		JLabel lblAosDeExperencia = new JLabel("A\u00F1os de Experencia:");
		lblAosDeExperencia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblAosDeExperencia.setBounds(207, 11, 139, 19);
		panelJefe.add(lblAosDeExperencia);
		
		JSpinner spnExperencia = new JSpinner();
		spnExperencia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnExperencia.setBounds(207, 41, 157, 20);
		panelJefe.add(spnExperencia);
		
		panelProgramador = new JPanel();
		//tabbedPane.addTab("Programador", null, panelProgramador, null);
		panelProgramador.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 183, 121);
		panelProgramador.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JList listLengDisponibles = new JList();
		listLengDisponibles.setModel(new AbstractListModel() {
			String[] values = new String[] {"<Lenguajes Disponibles>", "C", "C++", "C#", "Java", "JavaScript", "Python", "Visual Basic", "Go", "Angular JS", "PHP", "HTML", "CSS", "Verilog", ""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listLengDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listLengDisponibles);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(203, 11, 151, 121);
		panelProgramador.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		JList listLengDominados = new JList();
		listLengDominados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLengDominados.setModel(new AbstractListModel() {
			String[] values = new String[] {"<Lenguajes Dominados>"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(listLengDominados);
		
		panelDisenador = new JPanel();
		//tabbedPane.addTab("Dise\u00F1ador", null, panelDisenador, null);
		panelDisenador.setLayout(null);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblEspecialidad.setBounds(10, 11, 91, 19);
		panelDisenador.add(lblEspecialidad);
		
		cbxEspecialidad = new JComboBox();
		cbxEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "App. Escritorio", "Paginas WEB", "Movil"}));
		cbxEspecialidad.setBounds(10, 41, 157, 20);
		panelDisenador.add(cbxEspecialidad);
		
		panelPlanificador = new JPanel();
		//tabbedPane.addTab("Planificador", null, panelPlanificador, null);
		panelPlanificador.setLayout(null);
		
		JLabel lblFrecuenciaDePlanificacin = new JLabel("Frecuencia de planificaci\u00F3n:");
		lblFrecuenciaDePlanificacin.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblFrecuenciaDePlanificacin.setBounds(10, 11, 198, 19);
		panelPlanificador.add(lblFrecuenciaDePlanificacin);
		
		spnFrecPlani = new JSpinner();
		spnFrecPlani.setBounds(10, 41, 157, 20);
		panelPlanificador.add(spnFrecPlani);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT));
			getContentPane().add(buttonPane, BorderLayout.NORTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/Imgs/save.png")));
				okButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/Imgs/exit.png")));
				cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void removeLastTab() {
		if (tabbedPaneTipos.getTabCount() > 0) {
			tabbedPaneTipos.removeTabAt(0);
		}
	}
}
