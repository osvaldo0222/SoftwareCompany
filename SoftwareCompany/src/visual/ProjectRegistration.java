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

import logical.Boss;
import logical.Designer;
import logical.Planner;
import logical.Programmer;
import logical.SoftwareCompany;

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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ProjectRegistration extends JDialog {

	private final JPanel FirstPanel = new JPanel();
	private JTextField txtCodigoProyecto;
	private JTextField txtNombreProyecto;
	Validation VD=new Validation();
	private DefaultListModel DLM;
	private JList listWorkers;
	private JComboBox comboBoxTipoWorkers;
	private JComboBox comboBoxLenguaje;
	private JComboBox comboBoxTipoProyecto;

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
		setBounds(100, 100, 664, 530);
		getContentPane().setLayout(new BorderLayout());
		FirstPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(FirstPanel, BorderLayout.CENTER);
		FirstPanel.setLayout(null);
		
		comboBoxTipoProyecto = new JComboBox();
		
		comboBoxTipoProyecto.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    comboBoxLenguaje = new JComboBox();
		
		
		comboBoxLenguaje.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBoxTipoWorkers = new JComboBox();
		
		
		comboBoxTipoWorkers.setFont(new Font("SansSerif", Font.PLAIN, 12));
		DLM=new DefaultListModel();
		
		JPanel InformacionGeneralPanel = new JPanel();
		InformacionGeneralPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//InformacionGeneralPanel.setBounds(10, 11, 601, 221);
		InformacionGeneralPanel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		//InformacionGeneralPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InformacionGeneralPanel.setBounds(10, 81, 572, 132);

		FirstPanel.add(InformacionGeneralPanel);
		InformacionGeneralPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblCodigo.setBounds(23, 29, 82, 20);
		InformacionGeneralPanel.add(lblCodigo);
		{
			JLabel lblProyecto = new JLabel("Proyecto:");
			lblProyecto.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblProyecto.setBounds(23, 59, 82, 20);
			InformacionGeneralPanel.add(lblProyecto);
		}
		{
			JLabel lblLenguaje = new JLabel("Lenguaje:");
			lblLenguaje.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblLenguaje.setBounds(310, 89, 72, 20);
			InformacionGeneralPanel.add(lblLenguaje);
		}
		{
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblTipo.setBounds(23, 89, 82, 20);
			InformacionGeneralPanel.add(lblTipo);
		}
		
		txtCodigoProyecto = new JTextField();
		txtCodigoProyecto.setEditable(false);
		txtCodigoProyecto.setText("TRA-" + (SoftwareCompany.codProjects + 1));
		

		
		
		
		
		
		
		
		
		
		txtCodigoProyecto.setBounds(115, 29, 185, 20);
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
		comboBoxTipoProyecto.setBounds(115, 89, 185, 20);
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
		
		txtNombreProyecto.setBounds(115, 59, 447, 20);
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
		
		comboBoxLenguaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTipoWorkers.getSelectedItem().toString().equalsIgnoreCase("Programador")) {
					FuntioncomboTipoWorkers(comboBoxTipoWorkers, comboBoxLenguaje);
				}
			}
		});
		
		
		
		comboBoxLenguaje.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona un lenguaje>", "PHP", "Python", "Java", "RubyOnRails", "Swift", "C#", "VisualBasic", "Delphi", "C", "C++"}));
		comboBoxLenguaje.setBounds(392, 89, 170, 20);
		InformacionGeneralPanel.add(comboBoxLenguaje);
		
		JPanel TrabajadoresPanel = new JPanel();
		TrabajadoresPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Trabajadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		TrabajadoresPanel.setBounds(10, 224, 572, 157);
		FirstPanel.add(TrabajadoresPanel);
		TrabajadoresPanel.setLayout(null);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblBuscarPor.setBounds(10, 22, 96, 20);
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
		comboBoxTipoWorkers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Oyeeeeeee");
				FuntioncomboTipoWorkers(comboBoxTipoWorkers, comboBoxLenguaje);
				
				
			}
		});
		
		
		
		
		
		
		comboBoxTipoWorkers.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona>", "Dise\u00F1ador", "Jefe", "Planeador", "Programador"}));
		comboBoxTipoWorkers.setBounds(108, 23, 163, 20);
		TrabajadoresPanel.add(comboBoxTipoWorkers);
		
		JLabel lblSeleccionado = new JLabel("Seleccionados:");
		lblSeleccionado.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSeleccionado.setBounds(299, 22, 132, 20);
		TrabajadoresPanel.add(lblSeleccionado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 53, 243, 82);
		TrabajadoresPanel.add(scrollPane);
		
		listWorkers = new JList();
		scrollPane.setViewportView(listWorkers);
		listWorkers.setModel(DLM);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 53, 243, 82);
		TrabajadoresPanel.add(scrollPane_1);
		
		JList listWorkersSelected = new JList();
		scrollPane_1.setViewportView(listWorkersSelected);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 572, 59);
		FirstPanel.add(panel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						validateData();
						
						
					}
				});
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
	
	private boolean validateData() {
		boolean validate=false;
		String getTxtFromTxtNombreProjecto=txtNombreProyecto.getText();
		String getTxtFromTxtCodContract=txtCodigoProyecto.getText();
		String getTxtFromComboBoxTipoPro=(String) comboBoxTipoProyecto.getSelectedItem();
		System.out.println(getTxtFromComboBoxTipoPro);
		String getTxtFromComboBoxLanguaje=comboBoxLenguaje.getSelectedItem().toString();
		if (getTxtFromTxtNombreProjecto.equalsIgnoreCase("") && getTxtFromComboBoxTipoPro.equalsIgnoreCase("") && comboBoxTipoProyecto.getSelectedIndex()>0 && getTxtFromComboBoxLanguaje.equalsIgnoreCase("") && comboBoxLenguaje.getSelectedIndex()>0) {
			JOptionPane.showMessageDialog(null, "Rellena Todos los campos requeridos", "Registro Proyecto", JOptionPane.ERROR_MESSAGE);
			
		}
		else if(getTxtFromTxtNombreProjecto.equalsIgnoreCase("") && !getTxtFromComboBoxTipoPro.equalsIgnoreCase("") && !getTxtFromComboBoxLanguaje.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Escribe el nombre del proyecto", "Registro Proyecto", JOptionPane.ERROR_MESSAGE);

			
		}else if(!getTxtFromTxtNombreProjecto.equalsIgnoreCase("") && getTxtFromComboBoxTipoPro.equalsIgnoreCase("") && !getTxtFromComboBoxLanguaje.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Selecciona el tipo del proyecto", "Registro Proyecto", JOptionPane.ERROR_MESSAGE);

			
		}else if(!getTxtFromTxtNombreProjecto.equalsIgnoreCase("") && !getTxtFromComboBoxTipoPro.equalsIgnoreCase("") && getTxtFromComboBoxLanguaje.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Selecciona el lenguaje a usar", "Registro Proyecto", JOptionPane.ERROR_MESSAGE);

			
		}else {
			validate=true;
		}
		
		return validate;
	}
	
	
	private void FuntioncomboTipoWorkers(JComboBox comboBoxTipoWorkers, JComboBox comboBoxLenguaje) {
		if (comboBoxTipoWorkers.getSelectedItem().toString().equalsIgnoreCase("Programador") && !comboBoxLenguaje.getSelectedItem().toString().equalsIgnoreCase("<Selecciona un lenguaje>") ) {
			DLM.removeAllElements();
			for (int i = 0; i < SoftwareCompany.getInstance().getWorkers().size(); i++) {
				if (SoftwareCompany.getInstance().getWorkers().get(i) instanceof Programmer) {
					for (int j = 0; j < ((Programmer)SoftwareCompany.getInstance().getWorkers().get(i)).getLanguages().size(); j++) {
						if (((Programmer) SoftwareCompany.getInstance().getWorkers().get(i)).getLanguages().get(j).equalsIgnoreCase(comboBoxLenguaje.getSelectedItem().toString())) {
							
							DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getName()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());
						}
						}
					}
				}
			}else if (comboBoxTipoWorkers.getSelectedItem().toString().equalsIgnoreCase("Jefe")) {
				DLM.removeAllElements();
				for (int i = 0; i < SoftwareCompany.getInstance().getWorkers().size(); i++) {
					if (SoftwareCompany.getInstance().getWorkers().get(i) instanceof Boss) {
					
						DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getName()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());
						
					}
					
					
				}
				
				
			}else if(comboBoxTipoWorkers.getSelectedItem().toString().equalsIgnoreCase("Disenador")) {
				for (int i = 0; i < SoftwareCompany.getInstance().getWorkers().size(); i++) {
					if (SoftwareCompany.getInstance().getWorkers().get(i) instanceof Designer) {
						DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getName()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());
						
					}
					
					
				}
				
			}else if (comboBoxTipoWorkers.getSelectedItem().toString().equalsIgnoreCase("Planeador")) {
				for (int i = 0; i < SoftwareCompany.getInstance().getWorkers().size(); i++) {
					if (SoftwareCompany.getInstance().getWorkers().get(i) instanceof Planner) {
						DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getName()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());
						
					}
					
					
				}
			}
		
		
		
	}
	
}
