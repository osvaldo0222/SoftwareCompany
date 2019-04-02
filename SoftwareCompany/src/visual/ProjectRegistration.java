package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logical.Boss;
import logical.Contract;
import logical.Designer;
import logical.Planner;
import logical.Programmer;
import logical.Project;
import logical.SoftwareCompany;
import logical.Worker;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.AbstractButton;
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
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;

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
	private JTextField txtDateOriginContract;
	private JPanel TrabajadoresPanel;
	private JTextField txtQueryCodClient;
	private JTextField txtQueryNameClient;
	private JTextField txtQueryAddress;
	private JTextField txtQueryTel;
	private JPanel panelContractClient;
	private JPanel panelTermsContract;
	private JButton btnAtras;
	private int cont=0;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
	Date date=new Date();
	private int days;
	private JTextPane BigTxtContract;
	private Object formatCedula;
	

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
		setBounds(100, 100, 1200, 747);
		getContentPane().setLayout(new BorderLayout());
		FirstPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(FirstPanel, BorderLayout.CENTER);
		FirstPanel.setLayout(null);
		
		comboBoxTipoProyecto = new JComboBox();
		 TrabajadoresPanel = new JPanel();
		
		comboBoxTipoProyecto.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    comboBoxLenguaje = new JComboBox();
	    JButton btnFinalizar = new JButton("Finalizar");
	  
	    
	    addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				DLMWorkersSelected.removeAllElements();
				listWorkersSelected.removeAll();
				
			}
		});
		
		
		comboBoxLenguaje.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBoxTipoWorkers = new JComboBox();
		JButton sigButton = new JButton("Siguiente");
		
		
		comboBoxTipoWorkers.setFont(new Font("SansSerif", Font.PLAIN, 12));
		DLM=new DefaultListModel();
		DLMWorkersSelected=new DefaultListModel();
		
	    listWorkersSelected = new JList();
	    panelTermsContract = new JPanel();
	    panelTermsContract.setBounds(10, 154, 572, 201);
	    FirstPanel.add(panelTermsContract);
	    panelTermsContract.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "T\u00E9rminos y Condiciones ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panelTermsContract.setLayout(null);
	    
	    Label label_5 = new Label("Fecha Inicio:");
	    label_5.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    label_5.setBounds(12, 29, 94, 20);
	    panelTermsContract.add(label_5);
	    
	    JDateChooser dateBegin = new JDateChooser();
	    dateBegin.setBounds(112, 29, 90, 20);
	    panelTermsContract.add(dateBegin);
	    
	    Label label_6 = new Label("Fecha Entrega:");
	    label_6.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    label_6.setBounds(208, 29, 112, 20);
	    panelTermsContract.add(label_6);
	    
	    JDateChooser dateEnd = new JDateChooser();
	    dateEnd.setBounds(326, 29, 90, 20);
	    panelTermsContract.add(dateEnd);
	    
	    JButton btnGenerar = new JButton("Generar Contrato");
	    btnGenerar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		btnFinalizar.setEnabled(true);
	    		btnFinalizar.setVisible(true);
	    		calcDays(dateBegin, dateEnd);
	    	}
	    });
	    btnGenerar.setBounds(426, 29, 132, 20);
	    panelTermsContract.add(btnGenerar);
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    scrollPane_2.setBounds(12, 73, 546, 117);
	    panelTermsContract.add(scrollPane_2);
	    
	     BigTxtContract = new JTextPane();
	     scrollPane_2.setViewportView(BigTxtContract);
	     BigTxtContract.setFont(new Font("SansSerif", Font.PLAIN, 13));
	     BigTxtContract.setEditable(false);
	     panelTermsContract.setVisible(false);
		
	    panelContractClient = new JPanel();
	    panelContractClient.setBounds(10, 11, 572, 132);
	    FirstPanel.add(panelContractClient);
	    panelContractClient.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "informaci\u00F3n Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panelContractClient.setVisible(false);
	    panelContractClient.setLayout(null);
	    
	    Label label = new Label("Cliente: ");
	    label.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    label.setBounds(23, 15, 82, 20);
	    panelContractClient.add(label);
	    MaskFormatter formatCedula = null;
		try {
			formatCedula = new MaskFormatter("###-#######-#");
			formatCedula.setPlaceholderCharacter('_');
		} catch (Exception e) {
			txtQueryCodClient = new JTextField();
		}
	    txtQueryCodClient = new JFormattedTextField(formatCedula);	
	    
	    txtQueryCodClient.addFocusListener(new FocusAdapter() {
	    	@Override
	    	public void focusGained(FocusEvent e) {
	    		VD.setFocusBackground(txtQueryCodClient, true);
	    	}
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    		VD.setFocusBackground(txtQueryCodClient, false);
	    	}
	    });
	    
	    txtQueryCodClient.setHorizontalAlignment(SwingConstants.LEFT);
	    txtQueryCodClient.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    txtQueryCodClient.setBounds(115, 15, 185, 20);
	    panelContractClient.add(txtQueryCodClient);
	    txtQueryCodClient.setColumns(10);
	    
	    
		
		//txtQueryCodClient = new JTextField();
		txtQueryCodClient.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
	    	VD.justInt(e);
	    }
		}); 
		
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
				
				String auxCodQuery=txtQueryCodClient.getText();
				if (SoftwareCompany.getInstance().clientById(auxCodQuery)!=null) {
					txtQueryNameClient.setText(SoftwareCompany.getInstance().clientById(auxCodQuery).getName()+" "+SoftwareCompany.getInstance().clientById(auxCodQuery).getLast_name());
					//txt.setText(SoftwareCompany.getInstance().clientById(auxCodQuery).getLast_name());
					txtQueryAddress.setText(SoftwareCompany.getInstance().clientById(auxCodQuery).getAddress());
					txtQueryTel.setText(SoftwareCompany.getInstance().clientById(auxCodQuery).getPhone());
					
					
					
					//BigTxtContract.setText("Yo "+SoftwareCompany.getInstance().clientById(auxCodQuery).getName()+" "+SoftwareCompany.getInstance().clientById(auxCodQuery).getLast_name()+" en virtud de esta prueba"+SoftwareCompany.getInstance().clientById(auxCodQuery).getId());
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Cliente no existe", "Buscar Cliente", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		button.setIcon(new ImageIcon(ProjectRegistration.class.getResource("/Imgs/search.png")));
		button.setBounds(306, 15, 88, 20);
		panelContractClient.add(button);
	    
		
		JPanel InformacionGeneralPanel = new JPanel();
		InformacionGeneralPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//InformacionGeneralPanel.setBounds(10, 11, 601, 221);
		InformacionGeneralPanel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		//InformacionGeneralPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InformacionGeneralPanel.setBounds(10, 11, 572, 132);

		FirstPanel.add(InformacionGeneralPanel);
		InformacionGeneralPanel.setLayout(null);
	    btnAtras = new JButton("Atras");
	    btnAtras.addActionListener(new ActionListener() {
	    	

			public void actionPerformed(ActionEvent e) {
	    		btnFinalizar.setEnabled(false);
	    	
	    		sigButton.setEnabled(true);
				sigButton.setVisible(true);
	    		comboBoxLenguaje.setEnabled(true);
				comboBoxTipoProyecto.setEnabled(true);
				comboBoxTipoWorkers.setEnabled(true);
				listWorkers.setEnabled(true);
				listWorkersSelected.setEnabled(true);
	    		panelContractClient.setVisible(false);
	    		panelTermsContract.setVisible(false);
	    		btnAtras.setVisible(false);
	    	}
	    });
	    btnAtras.setVisible(false);
		
		
		
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
				VD.setFocusBackground(comboBoxTipoProyecto, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				VD.setFocusBackground(comboBoxTipoProyecto, false);
			}
		});
		
		
		comboBoxTipoProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona un tipo de App>", "App. Escritorio", "Movil", "Paginas WEB"}));
		comboBoxTipoProyecto.setBounds(115, 89, 185, 20);
		InformacionGeneralPanel.add(comboBoxTipoProyecto);
		comboBoxTipoProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!comboBoxTipoProyecto.equals("<Selecciona un tipo de App>") && !comboBoxLenguaje.equals("<Selecciona un lenguaje>")) {
					comboBoxTipoWorkers.setEnabled(true);
					FuntioncomboTipoWorkers();
				}
				
				
				
			
			}
		});
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNombreProyecto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				VD.justLetters(e);
			}
		});
		txtNombreProyecto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				VD.setFocusBackground(txtNombreProyecto, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				VD.setFocusBackground(txtNombreProyecto, false);
			}
		});
		
		txtNombreProyecto.setBounds(115, 59, 447, 20);
		InformacionGeneralPanel.add(txtNombreProyecto);
		txtNombreProyecto.setColumns(10);
		
		
		comboBoxLenguaje.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				VD.setFocusBackground(comboBoxLenguaje, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				VD.setFocusBackground(comboBoxLenguaje, false);
			}
		});
		
		comboBoxLenguaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTipoWorkers.getSelectedItem().toString().equalsIgnoreCase("Programador")) {
					if (!comboBoxTipoProyecto.equals("<Selecciona un tipo de App>") && !comboBoxLenguaje.equals("<Selecciona un lenguaje>")) {
						comboBoxTipoWorkers.setEnabled(true);
						listWorkers.setEnabled(true);
						FuntioncomboTipoWorkers();
					}
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
		
		txtDateOriginContract = new JTextField();
		txtDateOriginContract.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDateOriginContract.setEditable(false);
		txtDateOriginContract.setBounds(392, 29, 170, 20);
		InformacionGeneralPanel.add(txtDateOriginContract);
		txtDateOriginContract.setColumns(10);
		txtDateOriginContract.setText(dateFormat.format(date));
		
		
		TrabajadoresPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Trabajadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
				VD.setFocusBackground(comboBoxTipoWorkers, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				VD.setFocusBackground(comboBoxTipoWorkers, false);
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
		comboBoxTipoWorkers.setSelectedIndex(0);
		comboBoxTipoWorkers.setEnabled(false);
		
		JLabel lblSeleccionado = new JLabel("Seleccionados:");
		lblSeleccionado.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSeleccionado.setBounds(299, 22, 132, 20);
		TrabajadoresPanel.add(lblSeleccionado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 53, 243, 137);
		TrabajadoresPanel.add(scrollPane);
		
		listWorkers = new JList();
		listWorkers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listWorkers);
		listWorkers.setModel(DLM);
		
		listWorkers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (DLM.size()==0) {
					return;
				}
				if (comboBoxTipoWorkers.getSelectedItem().equals("Jefe")) {
					
					addBoss();
					
				}else if(comboBoxTipoWorkers.getSelectedItem().equals("<Selecciona>")) {
					
					String[] codSplit=listWorkers.getSelectedValue().toString().split(" ");
					
						if (SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Boss) {
							addBoss();
					}
						
						
						else {
						addLanguaje();
					}
					
					/*for (int i = 0; i < DLMWorkersSelected.size(); i++) {
				String[] codSplit=DLMWorkersSelected.getElementAt(i).toString().split(" ");
				if (SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Boss) {
					contBoss++;
				}*/
					
				}else {
					addLanguaje();
				}	
			}
		});
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 53, 243, 137);
		TrabajadoresPanel.add(scrollPane_1);
		
		
		listWorkersSelected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(listWorkersSelected);
		listWorkersSelected.setModel(DLMWorkersSelected);
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
				
				sigButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (validateData()==true && validateLits()==true && !comboBoxTipoProyecto.getSelectedItem().equals("<Selecciona un tipo de App>") && !comboBoxLenguaje.getSelectedItem().equals("<Selecciona un lenguaje>")) {
							sigButton.setEnabled(false);
							sigButton.setVisible(false);
							comboBoxLenguaje.setEnabled(false);
							comboBoxTipoProyecto.setEnabled(false);
							comboBoxTipoWorkers.setEnabled(false);
							listWorkers.setEnabled(false);
							listWorkersSelected.setEnabled(false);
							panelContractClient.setVisible(true);
							panelTermsContract.setVisible(true);
							btnAtras.setVisible(true);
						
						}
						
						
					}
				});
				
				
				btnAtras.setFont(new Font("SansSerif", Font.PLAIN, 14));
				btnAtras.setIcon(new ImageIcon(ProjectRegistration.class.getResource("/Imgs/goback16.png")));
				buttonPane.add(btnAtras);
				sigButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				sigButton.setIcon(new ImageIcon(ProjectRegistration.class.getResource("/Imgs/next.png")));
				sigButton.setActionCommand("OK");
				buttonPane.add(sigButton);
				getRootPane().setDefaultButton(sigButton);
			}
			
			
			
			btnFinalizar.setIcon(new ImageIcon(ProjectRegistration.class.getResource("/Imgs/ok16.png")));
			btnFinalizar.setFont(new Font("SansSerif", Font.PLAIN, 14));
			btnFinalizar.setVisible(false);
			buttonPane.add(btnFinalizar);
			  btnFinalizar.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		if (!txtQueryNameClient.getText().equalsIgnoreCase("") && days>0) {
			    			String codPro=txtCodigoProyecto.getText();
			    			String dateSigContract=txtDateOriginContract.getText();
			    			String namePRo=txtNombreProyecto.getText();
			    			String tipoPro=comboBoxTipoProyecto.getSelectedItem().toString();
			    			String langujae=comboBoxLenguaje.getSelectedItem().toString();
			    			String clientId=txtQueryCodClient.getText();
			    			//String beginD=dateBegin.getDateFormatString();
			    			//String dateFinish=dateEnd.getDateFormatString();
			    			String CodContra=("CONT-"+SoftwareCompany.codContract+1);
			    			Date beginD=dateBegin.getDate();
			    			Date dateFinish=dateEnd.getDate();
			    			String sigDate=txtDateOriginContract.getText();
			    			
			    			Project pro1=new Project(codPro, namePRo,tipoPro, langujae, "Nuevo");
			    			Worker worker=null;
			    			float price=calcAmountOfMoney(days);
			    			for (int i = 0; i < DLMWorkersSelected.size(); i++) {
			    				String[] split=DLMWorkersSelected.getElementAt(i).toString().split(" ");
			    				System.out.println("Split"+split[0]);
			    				
			    				pro1.inserWorker(SoftwareCompany.getInstance().searchWorkerByCode(split[0]));
			    			
							}
			    			Contract c1=new Contract(CodContra, beginD, dateFinish, clientId, pro1, price,sigDate);
							JOptionPane.showMessageDialog(null, "Contrato Registrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
							SoftwareCompany.getInstance().insertProject(pro1);
							SoftwareCompany.getInstance().insertContract(c1);
							
							SoftwareCompany.codProjects++;
						}else {
							JOptionPane.showMessageDialog(null, "Revise sus datos", "Error", JOptionPane.ERROR_MESSAGE);

						}
			    		
			    		
			    	}
			    });
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				cancelButton.setIcon(new ImageIcon(ProjectRegistration.class.getResource("/Imgs/exit.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				loadWorkers();
				
			}
		}
	}
	
	public float calcAmountOfMoney(int days) {
		float aux=0;
		float amount=0;
		float percent=0;
		
		for (int i = 0; i < DLMWorkersSelected.size(); i++) {
			String[] codSplit=DLMWorkersSelected.getElementAt(i).toString().split(" ");
			aux=SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]).getSalary()*8*days;
			amount+=aux;
			aux=0;
		}
		percent=(float) (amount*0.25);
		amount+=percent;
		return amount;
		
	}
	
	public void loadWorkers() {
		for (int i = 0; i < SoftwareCompany.getInstance().getWorkers().size(); i++) {
			if (SoftwareCompany.getInstance().getWorkers().get(i) instanceof Boss &&  SoftwareCompany.getInstance().getWorkers().get(i).getProjects().size()<3) {
				DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name()+"->Jefe");

			}else if(SoftwareCompany.getInstance().getWorkers().get(i) instanceof Programmer &&  SoftwareCompany.getInstance().getWorkers().get(i).getProjects().size()==0) {
				DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name()+"->Programador");

			}else if(SoftwareCompany.getInstance().getWorkers().get(i) instanceof Designer &&  SoftwareCompany.getInstance().getWorkers().get(i).getProjects().size()<3) {
				DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name()+"->Diseñador");

			}else if(SoftwareCompany.getInstance().getWorkers().get(i) instanceof Planner) {
				DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name()+"->Planeador");

			}
			
		}
		
	}
	
	public void calcDays(JDateChooser dateBegin, JDateChooser dateEnd ) {
		days=0;
		
		if (dateBegin.getDate()!=null && dateEnd.getDate()!=null) {
			Calendar init=dateBegin.getCalendar();
			Calendar end=dateEnd.getCalendar();
		
			while(init.before(end) || init.equals(end)) {
				days++;
				init.add(Calendar.DATE, 1);
			}
			
			System.out.println(calcAmountOfMoney(days));
			
		}else {
			JOptionPane.showMessageDialog(null, "Selecciona fecha inicio y fecha final", "Error", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println(days);
		BigTxtContract.setText("Señores, "+txtQueryNameClient.getText()+" dominicano, mayor de edad, soltero,"
				+ " portador  de la Cédula de Identidad y Electoral No."+SoftwareCompany.getInstance().clientById(txtQueryCodClient.getText()).getId()+" "
				+ "domiciliado y residente en "+txtQueryAddress.getText()+" quien en lo adelante y para todos los fines y consecuencias legales del presente "
				+ "acto se denominará   EL REPRESENTANTE,  LA PRIMERA PARTE o por su propio nombres y apellidos.\n\n"
				+ "-----------------------SE HA CONVENIDO Y PACTADO LO SIGUIENTE-----------------------"
				+ "PRIMERO: los señores "+txtQueryNameClient.getText()+ ", por medio del presente acto autorizan y contratan a Empresa “La empresa” para el diseño"
				+ " y creación de "+ "que lleva por nombre "+txtNombreProyecto.getText()+ "por un total de "+calcAmountOfMoney(days)
						+ "\n");
		
		
	}
	
	
	public void addBoss() {
		int aux=-1;
	
		
		System.out.println(DLMWorkersSelected.size()+"---->"+cont);
		
			if (cont>=1) {
					
					JOptionPane.showMessageDialog(null, "No puede tener mas de un jefe por proyecto", "Registro Proyecto", JOptionPane.ERROR_MESSAGE);
			}else{
					for (int i = 0; i < DLMWorkersSelected.size();i++) {
						String[] codSplit=DLMWorkersSelected.getElementAt(i).toString().split(" ");
							if (SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Boss && cont==0) {
								cont++;
								System.out.println("Entrada1");
								DLMWorkersSelected.addElement(listWorkers.getSelectedValue());
								DLM.remove(listWorkers.getSelectedIndex());
								break;
							}
			
					}
					
					if (DLMWorkersSelected.size()==0) {
						String[] codSplit=listWorkers.getSelectedValue().toString().split(" ");
						if (SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Boss) {
							cont++;
							DLMWorkersSelected.addElement(listWorkers.getSelectedValue());
							DLM.remove(listWorkers.getSelectedIndex());
						}
						
					}
					if (cont==0) {
						cont++;
						DLMWorkersSelected.addElement(listWorkers.getSelectedValue());
						DLM.remove(listWorkers.getSelectedIndex());
						
					}
			}	
		
		
	}
	private void addLanguaje() {
		int contadorlang=0;
		String[] code=listWorkers.getSelectedValue().toString().split(" ");
		for (int i = 0; i < DLMWorkersSelected.size(); i++) {
			String[] codSplit=DLMWorkersSelected.getElementAt(i).toString().split(" ");
			if (code[0].equals(codSplit[0])) {
				contadorlang++;
			}
			
		}
		if (contadorlang==0) {
			DLMWorkersSelected.addElement(listWorkers.getSelectedValue());
			DLM.remove(listWorkers.getSelectedIndex());
			
		}
		
			
		
	}
	private void removeLanguaje() {
		
		if (DLMWorkersSelected.size()==0) {
			return;
		}else {
			
			String[] auxSlip=listWorkersSelected.getSelectedValue().toString().split(" ");
			if (SoftwareCompany.getInstance().searchWorkerByCode(auxSlip[0]) instanceof Boss && cont>0) {
				cont=0;
				DLM.addElement(listWorkersSelected.getSelectedValue());
				DLMWorkersSelected.remove(listWorkersSelected.getSelectedIndex());
			}else {
				DLM.addElement(listWorkersSelected.getSelectedValue());
				DLMWorkersSelected.remove(listWorkersSelected.getSelectedIndex());
			}
			

		}
		
			}
	
	private boolean validateWorkerPanel() {
		boolean validate=false;
		
		return validate;
	}
	private boolean validateLits() {
		boolean aux=false;
		int contBoss=-1;
		int contDesigner=-1;
		int contPlanner=-1;
		int contProgrammer=-1;
			for (int i = 0; i < DLMWorkersSelected.size(); i++) {
				String[] codSplit=DLMWorkersSelected.getElementAt(i).toString().split(" ");
				if (SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Boss) {
					contBoss++;
				}else if(SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Designer) {
					contDesigner++;
				}
				else if(SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Planner) {
					contPlanner++;
				}else if(SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]) instanceof Programmer) {
					contProgrammer++;
				}
				

			}
			
			if (contBoss==-1 || contDesigner==-1 || contPlanner==-1 || contProgrammer==-1) {
				JOptionPane.showMessageDialog(null, "Debe existir 1 Jefe por proyecto y al menos un diseñador, Revise sus datos", "Registro Proyecto", JOptionPane.ERROR_MESSAGE);

				
				aux=false;
				
			}else {
				aux=true;
			}
		
		
		
		return aux;
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
			
		}
		
		return validate;
	}
	
	
	private void FuntioncomboTipoWorkers() {
		if (!comboBoxTipoProyecto.getSelectedItem().equals("<Selecciona un tipo de App>") && !comboBoxLenguaje.getSelectedItem().equals("<Selecciona un lenguaje>")  ) {
		DLM.removeAllElements();
			if (!comboBoxTipoWorkers.getSelectedItem().equals("<Selecciona>")) {
				DLM.removeAllElements();
				
				
				for (int i = 0; i < SoftwareCompany.getInstance().getWorkers().size(); i++) {
					if (SoftwareCompany.getInstance().getWorkers().get(i) instanceof Programmer && comboBoxTipoWorkers.getSelectedItem().equals("Programador") && SoftwareCompany.getInstance().getWorkers().get(i).getProjects().size()==0) {
						for (int j = 0; j < ((Programmer)SoftwareCompany.getInstance().getWorkers().get(i)).getLanguages().size(); j++) {
							if (((Programmer)SoftwareCompany.getInstance().getWorkers().get(i)).getLanguages().get(j).equals(comboBoxLenguaje.getSelectedItem().toString())) {
								
								DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+""+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());
							}
						}
						
					}else if(SoftwareCompany.getInstance().getWorkers().get(i) instanceof Designer && comboBoxTipoWorkers.getSelectedItem().equals("Diseñador") ) {
						if (((Designer)SoftwareCompany.getInstance().getWorkers().get(i)).getMaster().equals(comboBoxTipoProyecto.getSelectedItem().toString())) {
							
							DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+""+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());

						}
					}else if(SoftwareCompany.getInstance().getWorkers().get(i) instanceof Boss && comboBoxTipoWorkers.getSelectedItem().equals("Jefe") && SoftwareCompany.getInstance().getWorkers().get(i).getProjects().size()<3) {
						DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+""+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());
					}else if(SoftwareCompany.getInstance().getWorkers().get(i) instanceof Planner && comboBoxTipoWorkers.getSelectedItem().equals("Planeador")) {
						DLM.addElement(SoftwareCompany.getInstance().getWorkers().get(i).getCode()+" "+SoftwareCompany.getInstance().getWorkers().get(i).getName()+""+SoftwareCompany.getInstance().getWorkers().get(i).getLast_name());

						
					}
				}
				
			
				
				
			}
			
			
			
		}
		
		
		
		
		
	}
}
