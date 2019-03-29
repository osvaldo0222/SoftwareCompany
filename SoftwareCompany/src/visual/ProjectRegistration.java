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
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import java.awt.Label;

public class ProjectRegistration extends JDialog {

	private final JPanel FirstPanel = new JPanel();
	private JTextField txtCodigoProyecto;
	private JTextField txtNombreProyecto;
	Validation VD=new Validation();
	private DefaultListModel DLM;
	private DefaultListModel DLMWorkersSelected;
	private JList listWorkers;
	private JComboBox comboBoxTipoWorkers;
	private JComboBox comboBoxLenguaje;
	private JComboBox comboBoxTipoProyecto;
	private JList listWorkersSelected ;
	private JTextField textField;
	private JPanel TrabajadoresPanel;
	private JTextField txtQueryCodClient;
	private JTextField txtQueryNameClient;
	private JTextField txtQueryAddress;
	private JTextField txtQueryTel;
	private JPanel panelContractClient;
	private JPanel panelTermsContract;
	private JButton btnAtras;

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
		setBounds(100, 100, 674, 631);
		getContentPane().setLayout(new BorderLayout());
		FirstPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(FirstPanel, BorderLayout.CENTER);
		FirstPanel.setLayout(null);
		
		comboBoxTipoProyecto = new JComboBox();
		 TrabajadoresPanel = new JPanel();
		
		comboBoxTipoProyecto.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    comboBoxLenguaje = new JComboBox();
	    
		
		
		comboBoxLenguaje.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBoxTipoWorkers = new JComboBox();
		
		
		comboBoxTipoWorkers.setFont(new Font("SansSerif", Font.PLAIN, 12));
		DLM=new DefaultListModel();
		DLMWorkersSelected=new DefaultListModel();
		
	    listWorkersSelected = new JList();
	    
		
		JPanel InformacionGeneralPanel = new JPanel();
		InformacionGeneralPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//InformacionGeneralPanel.setBounds(10, 11, 601, 221);
		InformacionGeneralPanel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		//InformacionGeneralPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InformacionGeneralPanel.setBounds(10, 11, 572, 132);

		FirstPanel.add(InformacionGeneralPanel);
		InformacionGeneralPanel.setLayout(null);
		
	    panelContractClient = new JPanel();
	    panelContractClient.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "informaci\u00F3n Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    btnAtras = new JButton("Atras");
	    btnAtras.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panelContractClient.setVisible(false);
	    		panelTermsContract.setVisible(false);
	    		btnAtras.setVisible(false);
	    	}
	    });
	    btnAtras.setVisible(false);
	    panelContractClient.setVisible(false);
		panelContractClient.setBounds(0, 0, 572, 132);
		InformacionGeneralPanel.add(panelContractClient);
		panelContractClient.setLayout(null);
		
		Label label = new Label("Cliente: ");
		label.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label.setBounds(23, 15, 82, 20);
		panelContractClient.add(label);
		
		txtQueryCodClient = new JTextField();
		txtQueryCodClient.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				VD.justInt(e);
			}
		});
		txtQueryCodClient.setHorizontalAlignment(SwingConstants.LEFT);
		txtQueryCodClient.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtQueryCodClient.setBounds(115, 15, 185, 20);
		panelContractClient.add(txtQueryCodClient);
		txtQueryCodClient.setColumns(10);
		
		Label label_1 = new Label("Nombre:");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_1.setBounds(23, 45, 82, 20);
		panelContractClient.add(label_1);
		
		txtQueryNameClient = new JTextField();
		txtQueryNameClient.setHorizontalAlignment(SwingConstants.LEFT);
		txtQueryNameClient.setEditable(false);
		txtQueryNameClient.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtQueryNameClient.setColumns(10);
		txtQueryNameClient.setBounds(115, 45, 279, 20);
		panelContractClient.add(txtQueryNameClient);
		
		Label label_2 = new Label("Direcci\u00F3n :");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_2.setBounds(23, 75, 82, 20);
		panelContractClient.add(label_2);
		
		txtQueryAddress = new JTextField();
		txtQueryAddress.setHorizontalAlignment(SwingConstants.LEFT);
		txtQueryAddress.setEditable(false);
		txtQueryAddress.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtQueryAddress.setColumns(10);
		txtQueryAddress.setBounds(115, 75, 279, 20);
		panelContractClient.add(txtQueryAddress);
		
		Label label_3 = new Label("tel\u00E9fono:");
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_3.setBounds(23, 105, 82, 20);
		panelContractClient.add(label_3);
		
		txtQueryTel = new JTextField();
		txtQueryTel.setHorizontalAlignment(SwingConstants.LEFT);
		txtQueryTel.setEditable(false);
		txtQueryTel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtQueryTel.setColumns(10);
		txtQueryTel.setBounds(115, 105, 279, 20);
		panelContractClient.add(txtQueryTel);
		
		Label label_4 = new Label("New label");
		label_4.setBounds(420, 19, 118, 97);
		panelContractClient.add(label_4);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int auxClient=-1;
				if (!txtQueryCodClient.getText().equals("")) {
					for (int i = 0; i < SoftwareCompany.getInstance().getClients().size(); i++) {
						if (SoftwareCompany.getInstance().getClients().get(i).getCode().equalsIgnoreCase(txtQueryCodClient.getText())) {
							auxClient=i;
							break;
						}	
					}	
				}
				if (auxClient!=-1) {
					txtQueryNameClient.setText(SoftwareCompany.getInstance().getClients().get(auxClient).getName());
					txtQueryAddress.setText(SoftwareCompany.getInstance().getClients().get(auxClient).getAddress());
					txtQueryTel.setText(SoftwareCompany.getInstance().getClients().get(auxClient).getPhone());
					
				}else {
					JOptionPane.showMessageDialog(null, "Cliente no existe", "Buscar Cliente", JOptionPane.ERROR_MESSAGE);

					
				}
				
				
			}
		});
		button.setIcon(new ImageIcon(ProjectRegistration.class.getResource("/Imgs/search.png")));
		button.setBounds(306, 15, 88, 20);
		panelContractClient.add(button);
		
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
		txtCodigoProyecto.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCodigoProyecto.setEditable(false);
		txtCodigoProyecto.setText("PRO-" + (SoftwareCompany.codProjects + 1));
		
		
		
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
		
		
		comboBoxTipoProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona un tipo de App>", "App. Escritorio", "Movil", "Paginas WEB"}));
		comboBoxTipoProyecto.setBounds(115, 89, 185, 20);
		InformacionGeneralPanel.add(comboBoxTipoProyecto);
		comboBoxTipoProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FuntioncomboTipoWorkers();
				
			
			}
		});
		
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
					
					FuntioncomboTipoWorkers();
				}
			}
		});
		
		
		
		comboBoxLenguaje.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona un lenguaje>", "PHP", "Python", "Java", "RubyOnRails", "Swift", "C#", "VisualBasic", "Delphi", "C", "C++"}));
		comboBoxLenguaje.setBounds(392, 89, 170, 20);
		InformacionGeneralPanel.add(comboBoxLenguaje);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblFecha.setBounds(324, 29, 82, 20);
		InformacionGeneralPanel.add(lblFecha);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(392, 29, 170, 20);
		InformacionGeneralPanel.add(textField);
		textField.setColumns(10);
		
		
		TrabajadoresPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Trabajadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		TrabajadoresPanel.setBounds(10, 154, 572, 201);
		FirstPanel.add(TrabajadoresPanel);
		TrabajadoresPanel.setLayout(null);
		
		JLabel lblBuscarPor = new JLabel("Filtro:");
		lblBuscarPor.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblBuscarPor.setBounds(27, 22, 71, 20);
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
				DLM.removeAllElements();
				FuntioncomboTipoWorkers();
				
				
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
		scrollPane.setBounds(28, 53, 243, 137);
		TrabajadoresPanel.add(scrollPane);
		
		listWorkers = new JList();
		listWorkers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (DLM.size()==0) {
					return;
				}
				if (comboBoxTipoWorkers.getSelectedItem().equals("Jefe")) {
					addBoss();
					
				}else {
					addLanguaje();
				}	
			}
		});
		listWorkers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listWorkers);
		listWorkers.setModel(DLM);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 53, 243, 137);
		TrabajadoresPanel.add(scrollPane_1);
		
		
		listWorkersSelected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(listWorkersSelected);
		listWorkersSelected.setModel(DLMWorkersSelected);
		panelTermsContract = new JPanel();
		panelTermsContract.setBounds(20, 350, 572, 201);
		FirstPanel.add(panelTermsContract);
		panelTermsContract.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "T\u00E9rminos y Condiciones ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTermsContract.setVisible(false);
		listWorkersSelected.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		removeLanguaje();
	    		
	    	}
	    });
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
				
				
				btnAtras.setFont(new Font("SansSerif", Font.PLAIN, 14));
				btnAtras.setIcon(new ImageIcon(ProjectRegistration.class.getResource("/Imgs/goback16.png")));
				buttonPane.add(btnAtras);
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
	public void addBoss() {
		int aux=-1;
		int cont=0;
		
		System.out.println(DLMWorkersSelected.size());
		
		if (comboBoxTipoWorkers.getSelectedItem().equals("Jefe")) {
			if(DLMWorkersSelected.size()!=0){
			
			for (int i = 0; i < DLMWorkersSelected.size(); i++) {
				String[] codSplit=DLMWorkersSelected.getElementAt(i).toString().split(" ");
				if (SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Boss && cont==0) {
					cont++;
					DLMWorkersSelected.addElement(listWorkers.getSelectedValue());
					DLM.remove(listWorkers.getSelectedIndex());
					
					
				}else if(SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Boss && cont>=1) {
					JOptionPane.showMessageDialog(null, "No puede tener mas de un jefe por proyecto", "Registro Proyecto", JOptionPane.ERROR_MESSAGE);
	
				}
			
		}}else {
			DLMWorkersSelected.addElement(listWorkers.getSelectedValue());
			DLM.remove(listWorkers.getSelectedIndex());
		}
		
		
		}else {
			DLMWorkersSelected.addElement(listWorkers.getSelectedValue());
			DLM.remove(listWorkers.getSelectedIndex());
		}
		
	}
	private void addLanguaje() {
		
			DLMWorkersSelected.addElement(listWorkers.getSelectedValue());
			DLM.remove(listWorkers.getSelectedIndex());
		
	}
	private void removeLanguaje() {
		
		if (DLMWorkersSelected.size()==0) {
			return;
		}else {
			DLM.addElement(listWorkersSelected.getSelectedValue());
			DLMWorkersSelected.remove(listWorkersSelected.getSelectedIndex());

		}
		
			}
	
	private boolean validateWorkerPanel() {
		boolean validate=false;
		
		return validate;
	}
	private boolean validateData() {
		boolean validate = false;
		String getTxtFromTxtNombreProjecto = txtNombreProyecto.getText();
		String getTxtFromTxtCodContract=txtCodigoProyecto.getText();
		String getTxtFromComboBoxTipoPro=(String) comboBoxTipoProyecto.getSelectedItem();
		System.out.println(getTxtFromComboBoxTipoPro);
		String getTxtFromComboBoxLanguaje=comboBoxLenguaje.getSelectedItem().toString();
		if (!getTxtFromTxtCodContract.equalsIgnoreCase("") && getTxtFromTxtNombreProjecto.equalsIgnoreCase("") && getTxtFromComboBoxTipoPro.equalsIgnoreCase("") && comboBoxTipoProyecto.getSelectedIndex()>0 && getTxtFromComboBoxLanguaje.equalsIgnoreCase("") && comboBoxLenguaje.getSelectedIndex()>0) {
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
			panelContractClient.setVisible(true);
			panelTermsContract.setVisible(true);
			btnAtras.setVisible(true);
		
		
			
		}
		
		return validate;
	}
	
	
	private void FuntioncomboTipoWorkers() {
		if (!comboBoxTipoProyecto.getSelectedItem().equals("<Selecciona un tipo de App>") && !comboBoxLenguaje.getSelectedItem().equals("<Selecciona un lenguaje>")  ) {
		DLM.removeAllElements();
			if (!comboBoxTipoWorkers.getSelectedItem().equals("<Selecciona>")) {
				DLM.removeAllElements();
				
				
				for (int i = 0; i < SoftwareCompany.getInstance().getWorkers().size(); i++) {
					if (SoftwareCompany.getInstance().getWorkers().get(i) instanceof Programmer && comboBoxTipoWorkers.getSelectedItem().equals("Programador")) {
						for (int j = 0; j < ((Programmer)SoftwareCompany.getInstance().getWorkers().get(i)).getLanguages().size(); j++) {
							if (((Programmer)SoftwareCompany.getInstance().getWorkers().get(i)).getLanguages().get(j).equals(comboBoxLenguaje.getSelectedItem().toString())) {
								
								DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+""+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());
							}
						}
						
					}else if(SoftwareCompany.getInstance().getWorkers().get(i) instanceof Designer && comboBoxTipoWorkers.getSelectedItem().equals("Diseñador")) {
						if (((Designer)SoftwareCompany.getInstance().getWorkers().get(i)).getMaster().equals(comboBoxTipoProyecto.getSelectedItem().toString())) {
							
							DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+""+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());

						}
					}else if(SoftwareCompany.getInstance().getWorkers().get(i) instanceof Boss && comboBoxTipoWorkers.getSelectedItem().equals("Jefe")) {
						DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+""+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());
					}else if(SoftwareCompany.getInstance().getWorkers().get(i) instanceof Planner && comboBoxTipoWorkers.getSelectedItem().equals("Planeador")) {
						DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+""+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());

						
					}
				}
				
			
				
				
			}
			
			
			
		}
		
		
		
		
		
	}
}
