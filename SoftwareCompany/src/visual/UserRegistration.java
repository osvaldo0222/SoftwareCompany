package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logical.SoftwareCompany;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;

public class UserRegistration extends JDialog {

	private Validation validation = new Validation();
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtCorreo;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JButton btnGuardar;
	private JButton btnSalir;
	private JComboBox cbxGenero;
	private JSpinner spnEdad;
	
	public UserRegistration() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserRegistration.class.getResource("/Imgs/user.png")));
		setTitle("Registrar Usuarios");
		setBounds(100, 100, 438, 519);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 402, 421);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label.setBounds(138, 25, 57, 19);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nombres:");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_1.setBounds(10, 141, 68, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Apellidos:");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_2.setBounds(10, 181, 68, 19);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Cedula:");
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_3.setBounds(138, 64, 57, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n:");
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_4.setBounds(10, 222, 68, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Tel\u00E9fono:");
		label_5.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_5.setBounds(138, 104, 68, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Correo:");
		label_6.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_6.setBounds(10, 260, 57, 14);
		panel.add(label_6);
		
		txtCodigo = new JTextField();
		txtCodigo.setToolTipText("C\u00F3digo");
		txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(208, 24, 101, 20);
		txtCodigo.setText("USER-" + (SoftwareCompany.codUsers + 1));
		panel.add(txtCodigo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 342, 68, 19);
		panel.add(lblUsuario);
		
		MaskFormatter formatCedula = null;
		try {
			formatCedula = new MaskFormatter("###-#######-#");
			formatCedula.setPlaceholderCharacter('_');
			txtCedula = new JFormattedTextField(formatCedula);				
			txtCedula.setToolTipText("Cedula");
		} catch (Exception e) {
			txtCedula = new JTextField();
		}
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
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
		txtCedula.setToolTipText("Cedula");
		txtCedula.setColumns(10);
		txtCedula.setBounds(208, 63, 125, 20);
		panel.add(txtCedula);
		
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
		txtTelefono.setToolTipText("Tel\u00E9fono o Celular");
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(208, 103, 184, 20);
		panel.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validation.toUpperCase(e);
			}
		});
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
		txtDireccion.setToolTipText("Direcci\u00F3n");
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(103, 221, 289, 20);
		panel.add(txtDireccion);
		
		txtNombres = new JTextField();
		txtNombres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validation.justLetters(e);
			}
		});
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
		txtNombres.setToolTipText("Nombres");
		txtNombres.setEditable(false);
		txtNombres.setColumns(10);
		txtNombres.setBounds(103, 140, 289, 20);
		panel.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validation.justLetters(e);
			}
		});
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
		txtApellidos.setToolTipText("Apellidos");
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(103, 182, 289, 20);
		panel.add(txtApellidos);
		
		JLabel lblImagen = new JLabel("<Imagen>");
		lblImagen.setToolTipText("Doble click para seleccionar imagen...");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setEnabled(false);
		lblImagen.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblImagen.setIcon(new ImageIcon(UserRegistration.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		lblImagen.setBounds(10, 25, 118, 97);
		panel.add(lblImagen);
		
		txtCorreo = new JTextField();
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
		txtCorreo.setToolTipText("Correo Electr\u00F3nico");
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(103, 259, 289, 20);
		panel.add(txtCorreo);
		
		txtUsuario = new JTextField();
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				validation.setFocusBackground(txtUsuario, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				validation.setFocusBackground(txtUsuario, false);
			}
		});
		txtUsuario.setToolTipText("Nombre de Usuario");
		txtUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(103, 343, 289, 20);
		panel.add(txtUsuario);
		
		JButton btnEditCedula = new JButton("");
		btnEditCedula.setIcon(new ImageIcon(UserRegistration.class.getResource("/Imgs/iconfinder_Modify_132685.png")));
		btnEditCedula.setToolTipText("Editar Cedula");
		btnEditCedula.setEnabled(false);
		btnEditCedula.setBounds(343, 64, 49, 23);
		panel.add(btnEditCedula);
		
		JLabel label_10 = new JLabel("G\u00E9nero:");
		label_10.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_10.setBounds(10, 301, 68, 19);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Edad:");
		label_11.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_11.setBounds(233, 302, 49, 17);
		panel.add(label_11);
		
		cbxGenero = new JComboBox();
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino"}));
		cbxGenero.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				validation.setFocusBackground(cbxGenero, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				validation.setFocusBackground(cbxGenero, false);
			}
		});
		cbxGenero.setToolTipText("G\u00E9nero");
		cbxGenero.setEnabled(false);
		cbxGenero.setBounds(103, 302, 110, 20);
		panel.add(cbxGenero);
		
		spnEdad = new JSpinner();
		spnEdad.setToolTipText("Edad");
		spnEdad.setEnabled(false);
		spnEdad.setBounds(292, 302, 100, 20);
		panel.add(spnEdad);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblContrasea.setBounds(10, 383, 83, 19);
		panel.add(lblContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				validation.setFocusBackground(txtPassword, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				validation.setFocusBackground(txtPassword, false);
			}
		});
		txtPassword.setToolTipText("Contrase\u00F1a");
		txtPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPassword.setEditable(false);
		txtPassword.setColumns(10);
		txtPassword.setBounds(103, 384, 289, 20);
		panel.add(txtPassword);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.setIcon(new ImageIcon(UserRegistration.class.getResource("/Imgs/save.png")));
				btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 14));
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnSalir.setIcon(new ImageIcon(UserRegistration.class.getResource("/Imgs/exit.png")));
				btnSalir.setFont(new Font("SansSerif", Font.PLAIN, 14));
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}
}
