package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JList;

public class ProjectRegistration extends JDialog {

	private final JPanel FirstPanel = new JPanel();
	private JTextField txtCodigoProyecto;
	private JTextField txtNombreProyecto;
	Validation VD=new Validation();

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			ProjectRegistration dialog = new ProjectRegistration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProjectRegistration() {
		setFont(new Font("SansSerif", Font.PLAIN, 16));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProjectRegistration.class.getResource("/Imgs/newProject.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Nuevo Proyecto");
		setBounds(100, 100, 648, 529);
		getContentPane().setLayout(new BorderLayout());
		FirstPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(FirstPanel, BorderLayout.CENTER);
		FirstPanel.setLayout(null);
		
		JComboBox comboBoxTipoProyecto = new JComboBox();
		
		comboBoxTipoProyecto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		JComboBox comboBoxLenguaje = new JComboBox();
		
		comboBoxLenguaje.setFont(new Font("SansSerif", Font.PLAIN, 12));
		JComboBox comboBoxTipoWorkers = new JComboBox();
		
		comboBoxTipoWorkers.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(20, 204, 113, 32);
		FirstPanel.add(panel_1);
		
		JLabel lblTrabajadores = new JLabel("Trabajadores");
		lblTrabajadores.setBounds(14, 11, 108, 14);
		panel_1.add(lblTrabajadores);
		lblTrabajadores.setFont(new Font("SansSerif", Font.ITALIC, 14));
		
		JLabel lblNewLabel = new JLabel("Informaci\u00F3n General");
		lblNewLabel.setBounds(34, 11, 141, 19);
		FirstPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
		
		JPanel InformacionGeneralPanel = new JPanel();
		InformacionGeneralPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		//InformacionGeneralPanel.setBounds(10, 11, 601, 221);
		InformacionGeneralPanel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		//InformacionGeneralPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InformacionGeneralPanel.setBounds(10, 26, 601, 170);

		FirstPanel.add(InformacionGeneralPanel);
		InformacionGeneralPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, -16, 159, 27);
		InformacionGeneralPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblCodigo.setBounds(23, 22, 82, 26);
		InformacionGeneralPanel.add(lblCodigo);
		{
			JLabel lblProyecto = new JLabel("Proyecto:");
			lblProyecto.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblProyecto.setBounds(23, 63, 82, 26);
			InformacionGeneralPanel.add(lblProyecto);
		}
		{
			JLabel lblLenguaje = new JLabel("Lenguaje:");
			lblLenguaje.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblLenguaje.setBounds(310, 104, 72, 26);
			InformacionGeneralPanel.add(lblLenguaje);
		}
		{
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblTipo.setBounds(23, 104, 82, 26);
			InformacionGeneralPanel.add(lblTipo);
		}
		
		txtCodigoProyecto = new JTextField();
		txtCodigoProyecto.setEditable(false);
		
		txtCodigoProyecto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCodigoProyecto.setBackground(Color.YELLOW);
				txtNombreProyecto.setBackground(Color.WHITE);
				comboBoxLenguaje.setBackground(Color.WHITE);
				comboBoxTipoProyecto.setBackground(Color.WHITE);
				comboBoxTipoWorkers.setBackground(Color.WHITE);
				
			}
		});
		
		
		
		
		
		
		
		
		
		txtCodigoProyecto.setBounds(115, 24, 185, 26);
		InformacionGeneralPanel.add(txtCodigoProyecto);
		txtCodigoProyecto.setColumns(10);
		
		
		comboBoxTipoProyecto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCodigoProyecto.setBackground(Color.WHITE);
				txtNombreProyecto.setBackground(Color.WHITE);
				comboBoxLenguaje.setBackground(Color.WHITE);
				comboBoxTipoProyecto.setBackground(Color.YELLOW);
				comboBoxTipoWorkers.setBackground(Color.WHITE);
			}
		});
		
		
		comboBoxTipoProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona un tipo de App>", "Mobile", "Web", "Desktop"}));
		comboBoxTipoProyecto.setBounds(115, 106, 185, 26);
		InformacionGeneralPanel.add(comboBoxTipoProyecto);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					VD.justLetters(e);
			}
		});
		txtNombreProyecto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCodigoProyecto.setBackground(Color.WHITE);
				txtNombreProyecto.setBackground(Color.YELLOW);
				comboBoxLenguaje.setBackground(Color.WHITE);
				comboBoxTipoProyecto.setBackground(Color.WHITE);
				comboBoxTipoWorkers.setBackground(Color.WHITE);
			}
		});
		
		txtNombreProyecto.setBounds(115, 65, 447, 26);
		InformacionGeneralPanel.add(txtNombreProyecto);
		txtNombreProyecto.setColumns(10);
		
		
		comboBoxLenguaje.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCodigoProyecto.setBackground(Color.WHITE);
				txtNombreProyecto.setBackground(Color.WHITE);
				comboBoxLenguaje.setBackground(Color.YELLOW);
				comboBoxTipoProyecto.setBackground(Color.WHITE);
				comboBoxTipoWorkers.setBackground(Color.WHITE);
			}
		});
		
		comboBoxLenguaje.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona un lenguaje>", "PHP", "Python", "Java", "RubyOnRails", "Swift", "C#", "VisualBasic", "Delphi", "C", "C++"}));
		comboBoxLenguaje.setBounds(392, 106, 170, 26);
		InformacionGeneralPanel.add(comboBoxLenguaje);
		
		JPanel TrabajadoresPanel = new JPanel();
		TrabajadoresPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		TrabajadoresPanel.setBounds(10, 223, 601, 203);
		FirstPanel.add(TrabajadoresPanel);
		TrabajadoresPanel.setLayout(null);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblBuscarPor.setBounds(10, 27, 96, 26);
		TrabajadoresPanel.add(lblBuscarPor);
		
		
		
		comboBoxTipoWorkers.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCodigoProyecto.setBackground(Color.WHITE);
				txtNombreProyecto.setBackground(Color.WHITE);
				comboBoxLenguaje.setBackground(Color.WHITE);
				comboBoxTipoProyecto.setBackground(Color.WHITE);
				comboBoxTipoWorkers.setBackground(Color.YELLOW);
			}
		});
		
		comboBoxTipoWorkers.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona>", "Dise\u00F1ador", "Jefe", "Planeador", "Programador"}));
		comboBoxTipoWorkers.setBounds(118, 27, 163, 26);
		TrabajadoresPanel.add(comboBoxTipoWorkers);
		
		JLabel lblSeleccionado = new JLabel("Seleccionados:");
		lblSeleccionado.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSeleccionado.setBounds(317, 27, 132, 26);
		TrabajadoresPanel.add(lblSeleccionado);
		
		JList list = new JList();
		list.setBounds(19, 64, 271, 128);
		TrabajadoresPanel.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(309, 64, 271, 128);
		TrabajadoresPanel.add(list_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
				okButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				okButton.setIcon(new ImageIcon(ProjectRegistration.class.getResource("/Imgs/next.png")));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				cancelButton.setIcon(new ImageIcon(ProjectRegistration.class.getResource("/Imgs/exit.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
