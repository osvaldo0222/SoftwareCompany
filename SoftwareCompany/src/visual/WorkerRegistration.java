package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import logical.Boss;
import logical.Designer;
import logical.Planner;
import logical.Programmer;
import logical.SoftwareCompany;
import logical.Worker;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Label;

public class WorkerRegistration extends JDialog {

	private String[] languajesDisponibles = {"<Lenguajes Disponibles>", "C", "C++", "C#", "Java", "JavaScript", "Python", "Visual Basic", "Go", "Angular JS", "PHP", "HTML", "CSS", "Verilog"};
	private String[] lenguajesDominados = {"<Lenguajes Dominados>"};
	private final JPanel contentPanel = new JPanel();
	private Validation validation = new Validation();
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtSalario;
	private JTextField txtAsociados;
	private JComboBox cbxEspecialidad;
	private JComboBox cbxGenero;
	private JSpinner spnFrecPlani;
	private JSpinner spnExperencia;
	private JSpinner spnEdad;
	private DefaultListModel modelListDisponibles;
	private DefaultListModel modelListDominados;
	private JList listLengDisponibles;
	private JList listLengDominados;
	private JButton btnJefe;
	private JButton btnProgramador;
	private JButton btnDisenador;
	private JButton btnPlanificador;
	private JButton btnModificarCedula;
	private JButton btnSalir;
	private JButton btnGuardar;
	private JTabbedPane tabbedPaneTipos;
	private JPanel panelJefe;
	private JPanel panelProgramador;
	private JPanel panelDisenador;
	private JPanel panelPlanificador;
	private Worker worker;
	private JLabel lblImage;
	private short selectedType = 0;
	private Label label;
	private JTextField txtCorreo;
	private boolean flagModifying = false;

	public WorkerRegistration(Worker aux) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WorkerRegistration.class.getResource("/Imgs/user.png")));
		if (aux != null) {
			setTitle("Modificar Trabajador: " + aux.getId());
			worker = aux;
			flagModifying = true;
		} else {
			setTitle("Registro de Trabajadores");
		}
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
			panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			contentPanel.add(panel);
			{
				btnProgramador = new JButton("Programador");
				btnProgramador.setToolTipText("Tipo Programador");
				btnProgramador.setEnabled(false);
				btnProgramador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selectedType = 1;
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
				btnJefe.setToolTipText("Tipo Jefe de Proyecto");
				btnJefe.setEnabled(false);
				btnJefe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						selectedType = 0;
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
				btnDisenador.setToolTipText("Tipo Dise\u00F1ador");
				btnDisenador.setEnabled(false);
				btnDisenador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selectedType = 2;
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
				btnPlanificador.setToolTipText("Tipo Planificador");
				btnPlanificador.setEnabled(false);
				btnPlanificador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selectedType = 3;
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
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 11, 380, 325);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			lblImage = new JLabel("<Imagen>");
			lblImage.setToolTipText("Doble click para seleccionar imagen...");
			lblImage.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")));
			lblImage.setEnabled(false);
			lblImage.setBackground(Color.WHITE);
			lblImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (!lblImage.isEnabled()) {
						return;
					}
					JFileChooser file = new JFileChooser();
			        file.setCurrentDirectory(new File(System.getProperty("user.home")));
			        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpeg", "jpg", "gif", "png");
			        file.addChoosableFileFilter(filter);
			        file.setFileFilter(filter);
			        file.setAcceptAllFileFilterUsed(false);
			        int result = file.showSaveDialog(null);
			        if(result == JFileChooser.APPROVE_OPTION){
			        	File selectedFile = file.getSelectedFile();
			            String path = selectedFile.getAbsolutePath();
			            lblImage.setIcon(ResizeImage(path));
			        }
				}
			});
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblImage.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			lblImage.setBounds(10, 21, 118, 97);
			panel_1.add(lblImage);
			
			JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
			lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(138, 21, 54, 19);
			panel_1.add(lblNewLabel_1);
			
			txtCodigo = new JTextField();
			txtCodigo.setToolTipText("C\u00F3digo");
			txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(202, 21, 118, 20);
			txtCodigo.setText("TRA-" + (SoftwareCompany.codWorkers + 1));
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
			
			MaskFormatter formatCedula = null;
			try {
				formatCedula = new MaskFormatter("###-#######-#");
				formatCedula.setPlaceholderCharacter('_');
				txtCedula = new JFormattedTextField(formatCedula);				
				txtCedula.setToolTipText("Cedula");
			} catch (Exception e) {
				txtCedula = new JTextField();
			}
			txtCedula.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					validation.setFocusBackground(txtCedula, true);
				}
				@Override
				public void focusLost(FocusEvent e) {
					validation.setFocusBackground(txtCedula, false);
				}
			});
			txtCedula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (!(e.getKeyChar() == 13 || (e.getKeyChar() >= 48 && e.getKeyChar()  <= 57))) {
						return;
					}
					String cedula = txtCedula.getText();
					if (!cedula.contains("_")) {
						txtCedula.setEditable(false);
						btnModificarCedula.setEnabled(true);
						btnGuardar.setEnabled(true);
						worker = SoftwareCompany.getInstance().workerById(cedula);
						if (worker != null) {
							completeInformation();
							setTitle("Modificar Trabajador: " + worker.getId());
							btnGuardar.setText("Modificar");
							txtDireccion.requestFocus();
							return;
						} else {
							clearCamps();
							enableCamps();
							txtCorreo.requestFocus();
							return;
						}
					}
				}
			});
			txtCedula.setBounds(202, 61, 118, 20);
			panel_1.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombres = new JTextField();
			txtNombres.setToolTipText("Nombres");
			txtNombres.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					validation.setFocusBackground(txtNombres, true);
				}
				@Override
				public void focusLost(FocusEvent e) {
					validation.setFocusBackground(txtNombres, false);
				}
			});
			txtNombres.setEditable(false);
			txtNombres.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					validation.justLetters(arg0);
				}
			});
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
				txtApellidos.setToolTipText("Apellidos");
				txtApellidos.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						validation.setFocusBackground(txtApellidos, true);
					}
					@Override
					public void focusLost(FocusEvent e) {
						validation.setFocusBackground(txtApellidos, false);
					}
				});
				txtApellidos.setEditable(false);
				txtApellidos.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						validation.justLetters(e);
					}
				});
				txtApellidos.setBounds(85, 170, 285, 20);
				panel_1.add(txtApellidos);
				txtApellidos.setColumns(10);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setToolTipText("Direcci\u00F3n");
				txtDireccion.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						validation.setFocusBackground(txtDireccion, true);
					}
					@Override
					public void focusLost(FocusEvent e) {
						validation.setFocusBackground(txtDireccion, false);
					}
				});
				txtDireccion.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						validation.toUpperCase(e);
					}
				});
				txtDireccion.setEditable(false);
				txtDireccion.setBounds(85, 210, 285, 20);
				panel_1.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			{
				JLabel lblGenero = new JLabel("G\u00E9nero:");
				lblGenero.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblGenero.setBounds(10, 251, 65, 19);
				panel_1.add(lblGenero);
			}
			
			cbxGenero = new JComboBox();
			cbxGenero.setToolTipText("G\u00E9nero");
			cbxGenero.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					validation.setFocusBackground(cbxGenero, true);
				}
				@Override
				public void focusLost(FocusEvent e) {
					validation.setFocusBackground(cbxGenero, false);
				}
			});
			cbxGenero.setEnabled(false);
			cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino"}));
			cbxGenero.setBounds(85, 252, 107, 20);
			panel_1.add(cbxGenero);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblEdad.setBounds(212, 251, 54, 19);
			panel_1.add(lblEdad);
			
			spnEdad = new JSpinner();
			spnEdad.setToolTipText("Edad");
			spnEdad.setBackground(Color.WHITE);
			spnEdad.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					validation.setFocusBackground(spnEdad, true);
				}
				@Override
				public void focusLost(FocusEvent e) {
					validation.setFocusBackground(spnEdad, false);
				}
			});
			spnEdad.setEnabled(false);
			spnEdad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			JFormattedTextField formato1 = ((JSpinner.DefaultEditor) spnEdad.getEditor()).getTextField();
			((NumberFormatter) formato1.getFormatter()).setAllowsInvalid(false);
			spnEdad.setBounds(272, 252, 98, 20);
			panel_1.add(spnEdad);
			{
				JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
				lblTelfono.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblTelfono.setBounds(10, 292, 65, 19);
				panel_1.add(lblTelfono);
			}
			{
				
				MaskFormatter formatTelefono = null;
				try {
					formatTelefono = new MaskFormatter("(###) ###-####");
					formatTelefono.setPlaceholderCharacter('_');
					txtTelefono = new JFormattedTextField(formatTelefono);
					txtTelefono.setToolTipText("Tel\u00E9fono o Celular");
				} catch (Exception e) {
					txtTelefono = new JTextField();
				}
				txtTelefono.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						validation.setFocusBackground(txtTelefono, true);
					}
					@Override
					public void focusLost(FocusEvent e) {
						validation.setFocusBackground(txtTelefono, false);
					}
				});
				txtTelefono.setEditable(false);
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
				txtSalario.setToolTipText("Salario por hora");
				txtSalario.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						validation.setFocusBackground(txtSalario, true);
					}
					@Override
					public void focusLost(FocusEvent e) {
						validation.setFocusBackground(txtSalario, false);
					}
				});
				txtSalario.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						validation.justFloatNumbers(e, txtSalario.getText());
					}
				});
				txtSalario.setHorizontalAlignment(SwingConstants.RIGHT);
				txtSalario.setEditable(false);
				txtSalario.setBounds(272, 293, 98, 20);
				panel_1.add(txtSalario);
				txtSalario.setColumns(10);
			}
			
			btnModificarCedula = new JButton("");
			btnModificarCedula.setToolTipText("Editar Cedula");
			btnModificarCedula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					disableAllCamps();
					txtCedula.setEditable(true);
					btnGuardar.setEnabled(false);
					txtCedula.requestFocus();
					txtCedula.selectAll();
				}
			});
			btnModificarCedula.setEnabled(false);
			btnModificarCedula.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/Imgs/iconfinder_Modify_132685.png")));
			btnModificarCedula.setBounds(326, 60, 44, 20);
			panel_1.add(btnModificarCedula);
			{
				label = new Label("Correo:");
				label.setFont(new Font("SansSerif", Font.PLAIN, 14));
				label.setBounds(138, 96, 62, 22);
				panel_1.add(label);
			}
			{
				txtCorreo = new JTextField();
				txtCorreo.setToolTipText("Correo Electr\u00F3nico");
				txtCorreo.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						validation.justMailCharacter(e);
					}
				});
				txtCorreo.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						validation.setFocusBackground(txtCorreo, true);
					}
					@Override
					public void focusLost(FocusEvent e) {
						validation.setFocusBackground(txtCorreo, false);
					}
				});
				txtCorreo.setEditable(false);
				txtCorreo.setBounds(202, 98, 168, 20);
				panel_1.add(txtCorreo);
				txtCorreo.setColumns(10);
			}
		}
		
		tabbedPaneTipos = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneTipos.setBounds(10, 347, 380, 160);
		panel.add(tabbedPaneTipos);
		
		panelJefe = new JPanel();
		tabbedPaneTipos.addTab("Jefe de Proyecto", null, panelJefe, null);
		panelJefe.setLayout(null);
		
		JLabel lblAsociados = new JLabel("Asociados:");
		lblAsociados.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblAsociados.setBounds(10, 11, 74, 19);
		panelJefe.add(lblAsociados);
		
		txtAsociados = new JTextField();
		txtAsociados.setToolTipText("Trabajadores asociados a sus proyectos");
		txtAsociados.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAsociados.setText("0");
		txtAsociados.setEditable(false);
		txtAsociados.setBounds(10, 41, 157, 20);
		panelJefe.add(txtAsociados);
		txtAsociados.setColumns(10);
		
		JLabel lblAosDeExperencia = new JLabel("A\u00F1os de Experencia:");
		lblAosDeExperencia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblAosDeExperencia.setBounds(207, 11, 139, 19);
		panelJefe.add(lblAosDeExperencia);
		
		spnExperencia = new JSpinner();
		spnExperencia.setToolTipText("Experencia");
		spnExperencia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				validation.setFocusBackground(spnExperencia, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				validation.setFocusBackground(spnExperencia, false);
			}
		});
		spnExperencia.setEnabled(false);
		spnExperencia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		JFormattedTextField formato = ((JSpinner.DefaultEditor) spnExperencia.getEditor()).getTextField();
		((NumberFormatter) formato.getFormatter()).setAllowsInvalid(false);
		spnExperencia.setBounds(207, 41, 157, 20);
		panelJefe.add(spnExperencia);
		
		panelProgramador = new JPanel();
		panelProgramador.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 183, 121);
		panelProgramador.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		modelListDisponibles = new DefaultListModel();
		for (String string : languajesDisponibles) {
			modelListDisponibles.addElement(string);
		}
		listLengDisponibles = new JList();
		listLengDisponibles.setEnabled(false);
		listLengDisponibles.setToolTipText("Click sobre el lenguaje para añadir...");
		listLengDisponibles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (listLengDisponibles.getSelectedIndex() > 0) {
					addLanguaje();
				}
			}
		});
		listLengDisponibles.setModel(modelListDisponibles);
		listLengDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listLengDisponibles);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(203, 11, 162, 121);
		panelProgramador.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		modelListDominados = new DefaultListModel();
		for (String string : lenguajesDominados) {
			modelListDominados.addElement(string);
		}
		listLengDominados = new JList();
		listLengDominados.setEnabled(false);
		listLengDominados.setToolTipText("Click sobre el lenguaje para remover...");
		listLengDominados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (listLengDominados.getSelectedIndex() > 0) {
					removeLanguaje();
				}
			}
		});
		listLengDominados.setModel(modelListDominados);
		listLengDominados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		scrollPane_1.setViewportView(listLengDominados);
		
		panelDisenador = new JPanel();
		panelDisenador.setLayout(null);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblEspecialidad.setBounds(10, 11, 91, 19);
		panelDisenador.add(lblEspecialidad);
		
		cbxEspecialidad = new JComboBox();
		cbxEspecialidad.setToolTipText("Especialidad del diseñador...");
		cbxEspecialidad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				validation.setFocusBackground(cbxEspecialidad, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				validation.setFocusBackground(cbxEspecialidad, false);
			}
		});
		cbxEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "App. Escritorio", "Paginas WEB", "Movil"}));
		cbxEspecialidad.setBounds(10, 41, 157, 20);
		cbxEspecialidad.setEnabled(false);
		panelDisenador.add(cbxEspecialidad);
		
		panelPlanificador = new JPanel();
		panelPlanificador.setLayout(null);
		
		JLabel lblFrecuenciaDePlanificacin = new JLabel("Frecuencia de planificaci\u00F3n:");
		lblFrecuenciaDePlanificacin.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblFrecuenciaDePlanificacin.setBounds(10, 11, 198, 19);
		panelPlanificador.add(lblFrecuenciaDePlanificacin);
		
		spnFrecPlani = new JSpinner();
		spnFrecPlani.setToolTipText("Frecuencia con que planifica las tareas...");
		spnFrecPlani.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				validation.setFocusBackground(spnFrecPlani, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				validation.setFocusBackground(spnFrecPlani, false);
			}
		});
		spnFrecPlani.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnFrecPlani.setBounds(10, 41, 157, 20);
		JFormattedTextField formato1 = ((JSpinner.DefaultEditor) spnExperencia.getEditor()).getTextField();
		((NumberFormatter) formato1.getFormatter()).setAllowsInvalid(false);
		spnFrecPlani.setEnabled(false);
		panelPlanificador.add(spnFrecPlani);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT));
			getContentPane().add(buttonPane, BorderLayout.NORTH);
			{
				if (aux != null) {
					btnGuardar = new JButton("Modificar");
				} else {
					btnGuardar = new JButton("Guardar");
				}
				btnGuardar.setToolTipText("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (validateCamps()) {
							String cod = txtCodigo.getText(), cedula = txtCedula.getText(), nombres = txtNombres.getText(), apellidos = txtApellidos.getText(), direccion = txtDireccion.getText(), genero = cbxGenero.getSelectedItem().toString(), telefono = txtTelefono.getText(); 
							int edad = Integer.parseInt(spnEdad.getValue().toString());
							float salario = (txtSalario.getText().equalsIgnoreCase(""))?0:Float.parseFloat(txtSalario.getText());
							Worker aux = null;
							
							switch (selectedType) {
							case 0:
								if (Integer.parseInt(spnExperencia.getValue().toString()) >= 0) {
									int anos_experencia = Integer.parseInt(spnExperencia.getValue().toString());
									aux = new Boss(cod, cedula, nombres, apellidos, direccion, genero, edad, telefono, salario, 0, anos_experencia);
								} else {
									JOptionPane.showMessageDialog(null, "Revise los años de experencia del jefe de proyecto", "Trabajadores", JOptionPane.ERROR_MESSAGE);
									return;
								}
								break;
							case 1:
								if (modelListDominados.getSize() > 1) {
									ArrayList<String> lenguajes = new ArrayList<>();
									for (int i = 1; i < modelListDominados.getSize() ; i++) {
										lenguajes.add((String) modelListDominados.get(i));
									}
									aux = new Programmer(cod, cedula, nombres, apellidos, direccion, genero, edad, telefono, salario);
									for (String string : lenguajes) {
										((Programmer) aux).insertLanguages(string);
									}
								} else {
									JOptionPane.showMessageDialog(null, "Debe elegir, por lo menos, un lenguaje de programación", "Trabajadores", JOptionPane.ERROR_MESSAGE);
									return;
								}
								break;
							case 2:
								if (cbxEspecialidad.getSelectedIndex() >= 0) {
									String especilidad = cbxEspecialidad.getSelectedItem().toString();
									aux = new Designer(cod, cedula, nombres, apellidos, direccion, genero, edad, telefono, salario, especilidad);
								} else {
									JOptionPane.showMessageDialog(null, "Seleccione la especialidad del diseñador", "Trabajadores", JOptionPane.ERROR_MESSAGE);
									return;
								}
								break;
							case 3:
								if (Integer.parseInt(spnFrecPlani.getValue().toString()) >= 1) {
									int frecPlani = Integer.parseInt(spnFrecPlani.getValue().toString());
									aux = new Planner(cod, cedula, nombres, apellidos, direccion, genero, edad, telefono, salario, frecPlani);
								} else {
									JOptionPane.showMessageDialog(null, "Revise la frecuencia de planificación de los proyectos", "Trabajadores", JOptionPane.ERROR_MESSAGE);
									return;
								}
								break;
							}
							aux.setPicture((ImageIcon) lblImage.getIcon());
							aux.setMail(txtCorreo.getText());
							if (worker == null) {
								SoftwareCompany.getInstance().insertWorker(aux);
							} else {
								worker.setPicture(aux.getPicture());
								worker.setAddress(aux.getAddress());
								worker.setPhone(aux.getPhone());
								worker.setAge(aux.getAge());
								worker.setSalary(aux.getSalary());
								worker.setMail(aux.getMail());
								
								if (aux instanceof Boss) {
									((Boss) worker).setExperience_years(((Boss) aux).getExperience_years());
								} else if (aux instanceof Programmer) {
									((Programmer) worker).setLanguages(((Programmer) aux).getLanguages());
								} else if (aux instanceof Designer) {
									((Designer) worker).setMaster(((Designer) aux).getMaster());
								} else {
									((Planner) worker).setCant_days(((Planner) aux).getCant_days());
								}
							}
							if (flagModifying) {
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Operación Exitosa", "Trabajadores", JOptionPane.INFORMATION_MESSAGE);
								clearCamps();
								disableAllCamps();
								disableTipos();
								btnModificarCedula.setEnabled(false);
								btnGuardar.setEnabled(false);
								txtCedula.setText("");
								txtCedula.setEditable(true);
								txtCedula.requestFocus();
							}
						}
					}
				});
				btnGuardar.setEnabled(false);
				btnGuardar.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/Imgs/save.png")));
				btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 14));
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.setToolTipText("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnSalir.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/Imgs/exit.png")));
				btnSalir.setFont(new Font("SansSerif", Font.PLAIN, 14));
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
			//Con estas lineas que estan aqui puedo modificar un trabajador pasado por el constructor
			if (aux != null) {
				completeInformation();
				txtCedula.setText(aux.getId());
				txtCedula.validate();
				txtCedula.setEditable(false);
				btnGuardar.setEnabled(true);
			}
		}
	}
	
	private void removeLastTab() {
		if (tabbedPaneTipos.getTabCount() > 0) {
			tabbedPaneTipos.removeTabAt(0);
		}
	}
	
	private void addLanguaje() {
		modelListDominados.addElement(listLengDisponibles.getSelectedValue());
		modelListDisponibles.remove(listLengDisponibles.getSelectedIndex());
	}
	
	private void removeLanguaje() {
		modelListDisponibles.addElement(listLengDominados.getSelectedValue());
		modelListDominados.remove(listLengDominados.getSelectedIndex());
	}
	
	private void completeInformation() {
		disableTipos();
		removeLastTab();
		txtCodigo.setText(worker.getCode());
		if (worker.getPicture().equals(new ImageIcon(WorkerRegistration.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")))) {
			lblImage.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")));
			lblImage.setText("<Imagen>");
		} else {
			lblImage.setIcon(worker.getPicture());
		}
		lblImage.setEnabled(true);
		txtCorreo.setText(worker.getMail());
		txtCorreo.setEditable(true);
		txtNombres.setText(worker.getName());
		txtApellidos.setText(worker.getLast_name());
		txtDireccion.setText(worker.getAddress());
		txtDireccion.setEditable(true);
		cbxGenero.setSelectedItem(worker.getGender());
		spnEdad.setValue(worker.getAge());
		spnEdad.setEnabled(true);
		txtTelefono.setText(worker.getPhone());
		txtTelefono.setEditable(true);
		txtSalario.setText(worker.getSalary() + "");
		txtSalario.setEditable(true);
		if (worker instanceof Boss) {
			selectedType = 0;
			tabbedPaneTipos.addTab("Jefe de Proyecto", null, panelJefe, null);
			txtAsociados.setText(((Boss) worker).getCant_workers() + "");
			spnExperencia.setValue(((Boss) worker).getExperience_years());
			spnExperencia.setEnabled(true);
		} else if(worker instanceof Programmer) {
			selectedType = 1;
			tabbedPaneTipos.addTab("Programador", null, panelProgramador, null);
			for (String languaje : ((Programmer) worker).getLanguages()) {
				modelListDominados.addElement(languaje);
				modelListDisponibles.removeElement(languaje);
			}
			listLengDisponibles.setEnabled(true);
			listLengDominados.setEnabled(true);
		} else if(worker instanceof Designer) {
			selectedType = 2;
			tabbedPaneTipos.addTab("Diseñador", null, panelDisenador, null);
			cbxEspecialidad.setSelectedItem(((Designer) worker).getMaster());
			cbxEspecialidad.setEnabled(true);
		} else {
			selectedType = 3;
			tabbedPaneTipos.addTab("Planificador", null, panelPlanificador, null);
			spnFrecPlani.setValue(((Planner) worker).getCant_days());
			spnFrecPlani.setEnabled(true);
		}
	}
	
	private void disableAllCamps(){
		txtCodigo.setEditable(false);
		txtCorreo.setEditable(false);
		lblImage.setEnabled(false);
		txtNombres.setEditable(false);
		txtApellidos.setEditable(false);
		txtDireccion.setEditable(false);
		cbxGenero.setEnabled(false);
		spnEdad.setEnabled(false);
		txtTelefono.setEditable(false);
		txtSalario.setEditable(false);
		listLengDisponibles.setEnabled(false);
		listLengDominados.setEnabled(false);
		txtAsociados.setEditable(false);
		spnExperencia.setEnabled(false);
		cbxEspecialidad.setEnabled(false);
		spnFrecPlani.setEnabled(false);
	}
	
	private void disableTipos() {
		btnJefe.setEnabled(false);
		btnProgramador.setEnabled(false);
		btnDisenador.setEnabled(false);
		btnPlanificador.setEnabled(false);
	}
	
	private void enableCamps() {
		txtCodigo.setEditable(false);
		txtCorreo.setEditable(true);
		lblImage.setEnabled(true);
		txtNombres.setEditable(true);
		txtApellidos.setEditable(true);
		txtDireccion.setEditable(true);
		cbxGenero.setEnabled(true);
		spnEdad.setEnabled(true);
		txtTelefono.setEditable(true);
		txtSalario.setEditable(true);
		listLengDisponibles.setEnabled(true);
		listLengDominados.setEnabled(true);
		spnExperencia.setEnabled(true);
		cbxEspecialidad.setEnabled(true);
		spnFrecPlani.setEnabled(true);
	}
	
	private void clearCamps() {
		setTitle("Registrar Trabajador");
		btnGuardar.setText("Guardar");
		txtCodigo.setText("TRA-" + (SoftwareCompany.codWorkers + 1));
		lblImage.setIcon(new ImageIcon(WorkerRegistration.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")));
		lblImage.setText("<Imagen>");
		txtCorreo.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		cbxGenero.setSelectedIndex(0);
		spnEdad.setValue(1);
		txtTelefono.setText("");
		txtSalario.setText("");
		txtAsociados.setText("0");
		spnExperencia.setValue(0);
		modelListDisponibles.clear();
		modelListDominados.clear();
		for (String string : languajesDisponibles) {
			modelListDisponibles.addElement(string);
		}
		for (String string : lenguajesDominados) {
			modelListDominados.addElement(string);
		}
		cbxEspecialidad.setSelectedIndex(0);
		spnFrecPlani.setValue(1);
		selectedType = 0;
		removeLastTab();
		tabbedPaneTipos.addTab("Jefe de Proyecto", null, panelJefe, null);
		btnJefe.setEnabled(false);
		btnPlanificador.setEnabled(true);
		btnDisenador.setEnabled(true);
		btnProgramador.setEnabled(true);
	}
	
	private ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
	
	private boolean validateCamps() {
		boolean validate = false;
		String cod = txtCodigo.getText(), cedula = txtCedula.getText(), nombres = txtNombres.getText(), apellidos = txtApellidos.getText(), direccion = txtDireccion.getText(), genero = cbxGenero.getSelectedItem().toString(), telefono = txtTelefono.getText(); 
		int edad = Integer.parseInt(spnEdad.getValue().toString());
		float salario = (txtSalario.getText().equalsIgnoreCase(""))?0:Float.parseFloat(txtSalario.getText());
		if (!cod.equalsIgnoreCase("") && !cedula.equalsIgnoreCase("") && !cedula.contains("_") && !nombres.equalsIgnoreCase("") && !apellidos.equalsIgnoreCase("") && !direccion.equalsIgnoreCase("") && !genero.equalsIgnoreCase("") && cbxGenero.getSelectedIndex() > 0 && !telefono.equalsIgnoreCase("") && !telefono.contains("_") && edad > 0 && salario > 0) {
			validate = true;
		} else if(cedula.equalsIgnoreCase("") && cedula.contains("_")) {
			JOptionPane.showMessageDialog(null, "Cedula Incorrecta", "Trabajadores", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Revise los campos", "Trabajadores", JOptionPane.ERROR_MESSAGE);
		}
		return validate;
	}
}