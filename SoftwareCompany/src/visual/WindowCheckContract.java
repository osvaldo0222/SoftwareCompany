package visual;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

import logical.Boss;
import logical.Contract;
import logical.Designer;
import logical.Planner;
import logical.Programmer;
import logical.SoftwareCompany;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class WindowCheckContract extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTxtclientcod;
	private JTextField txtnamecleitn;
	private JTextField txtadress;
	private JTextField txttel;
	private JTextField txtodPro;
	private JTextField txtNamePro;
	private JTextField txtTipoPro;
	private JTextField txtDateSig;
	private JTextField txtLanguaje;
	private JTextField txtduedate;
	private JTextField txtbegindate;
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
	Date date=new Date();
	private DefaultListModel DLMWorkersSelected;
	private JList listWorkersOnPro;
	private Contract aux;
	Calendar fechaInicio = new GregorianCalendar(); 
	Calendar fechafin = new GregorianCalendar();
	Calendar c = Calendar.getInstance();
	private ButtonGroup bg=new ButtonGroup();
	private JTextField txtTotalAcordado;
	private JTextField txtTotalPagar;
	private JRadioButton radioProrroga;
	private JDateChooser dateChoserFinalDay;
	private Label totalAcordadoLabel;
	private JButton btnGenContract;
	private JRadioButton radioDeliver;
	private JButton okButton;
	private JPanel buttonPane;
	

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			WindowCheckContract dialog = new WindowCheckContract();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WindowCheckContract() {
		setBounds(100, 100, 1259, 621);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		DLMWorkersSelected=new DefaultListModel();
		 aux= SoftwareCompany.getInstance().searchContractByCode(ListProjects.codContractTable);
		 radioProrroga = new JRadioButton("Prorrogar Proyecto");
		 JTextPane bigContract = new JTextPane();
         dateChoserFinalDay = new JDateChooser();
          totalAcordadoLabel = new Label("Total Acordado:");
		JPanel InformacionGeneralPanel = new JPanel();
		InformacionGeneralPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "informaci\u00F3n contrato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InformacionGeneralPanel.setBounds(10, 11, 600, 143);
		contentPanel.add(InformacionGeneralPanel);
		InformacionGeneralPanel.setLayout(null);
		
		JLabel label_4 = new JLabel("Codigo:");
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_4.setBounds(10, 25, 82, 20);
		InformacionGeneralPanel.add(label_4);
		
		JLabel label_5 = new JLabel("Proyecto:");
		
		label_5.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_5.setBounds(10, 55, 82, 20);
		InformacionGeneralPanel.add(label_5);
		
		JLabel label_6 = new JLabel("Tipo:");
		label_6.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_6.setBounds(10, 85, 82, 20);
		InformacionGeneralPanel.add(label_6);
		
		JLabel label_7 = new JLabel("Fecha:");
		label_7.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_7.setBounds(311, 25, 82, 20);
		InformacionGeneralPanel.add(label_7);
		
		JLabel label_8 = new JLabel("Lenguaje:");
		label_8.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_8.setBounds(310, 85, 72, 20);
		InformacionGeneralPanel.add(label_8);
		
		txtodPro = new JTextField();
		txtodPro.setEditable(false);
		txtodPro.setBounds(102, 27, 199, 20);
		InformacionGeneralPanel.add(txtodPro);
		txtodPro.setColumns(10);
		
		txtNamePro = new JTextField();
		txtNamePro.setEditable(false);
		txtNamePro.setBounds(102, 57, 488, 20);
		InformacionGeneralPanel.add(txtNamePro);
		txtNamePro.setColumns(10);
		
		txtTipoPro = new JTextField();
		txtTipoPro.setEditable(false);
		txtTipoPro.setBounds(102, 87, 199, 20);
		InformacionGeneralPanel.add(txtTipoPro);
		txtTipoPro.setColumns(10);
		
		txtDateSig = new JTextField();
		txtDateSig.setEditable(false);
		txtDateSig.setBounds(377, 27, 213, 20);
		InformacionGeneralPanel.add(txtDateSig);
		txtDateSig.setColumns(10);
		
		txtLanguaje = new JTextField();
		txtLanguaje.setEditable(false);
		txtLanguaje.setBounds(377, 87, 213, 20);
		InformacionGeneralPanel.add(txtLanguaje);
		txtLanguaje.setColumns(10);
		
		JPanel TrabajadoresPanel = new JPanel();
		TrabajadoresPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Trabajadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		TrabajadoresPanel.setBounds(10, 165, 600, 271);
		contentPanel.add(TrabajadoresPanel);
		TrabajadoresPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 580, 229);
		TrabajadoresPanel.add(scrollPane);
		
		 listWorkersOnPro = new JList();
		scrollPane.setViewportView(listWorkersOnPro);
		listWorkersOnPro.setModel(DLMWorkersSelected);
		 radioDeliver = new JRadioButton("Entregar Proyecto");
		
		JPanel panelContractClient = new JPanel();
		panelContractClient.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "informaci\u00F3n Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelContractClient.setBounds(620, 11, 600, 143);
		contentPanel.add(panelContractClient);
		panelContractClient.setLayout(null);
		
		Label label = new Label("tel\u00E9fono:");
		label.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label.setBounds(10, 101, 82, 20);
		panelContractClient.add(label);
		
		Label label_1 = new Label("Direcci\u00F3n :");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_1.setBounds(10, 75, 82, 20);
		panelContractClient.add(label_1);
		
		Label label_2 = new Label("Nombre:");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_2.setBounds(10, 49, 82, 20);
		panelContractClient.add(label_2);
		
		Label label_3 = new Label("Cliente: ");
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_3.setBounds(10, 23, 82, 20);
		panelContractClient.add(label_3);
		
		txtTxtclientcod = new JTextField();
		txtTxtclientcod.setEditable(false);
		txtTxtclientcod.setBounds(98, 23, 316, 20);
		panelContractClient.add(txtTxtclientcod);
		txtTxtclientcod.setColumns(10);
		
		txtnamecleitn = new JTextField();
		txtnamecleitn.setEditable(false);
		txtnamecleitn.setBounds(98, 49, 316, 20);
		panelContractClient.add(txtnamecleitn);
		txtnamecleitn.setColumns(10);
		
		txtadress = new JTextField();
		txtadress.setEditable(false);
		txtadress.setBounds(98, 75, 316, 20);
		panelContractClient.add(txtadress);
		txtadress.setColumns(10);
		
		txttel = new JTextField();
		txttel.setEditable(false);
		txttel.setBounds(98, 101, 316, 20);
		panelContractClient.add(txttel);
		txttel.setColumns(10);
		JPanel panelTermsContract = new JPanel();
		panelTermsContract.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "T\u00E9rminos y Condiciones ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTermsContract.setBounds(620, 165, 600, 271);
		contentPanel.add(panelTermsContract);
		panelTermsContract.setLayout(null);
		
		
		Label label_9 = new Label("Fecha Inicio:");
		label_9.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_9.setBounds(10, 27, 94, 20);
		panelTermsContract.add(label_9);
		
		Label label_10 = new Label("Fecha Entrega:");
		label_10.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_10.setBounds(10, 58, 112, 20);
		panelTermsContract.add(label_10);
		//group.set
		
		
		txtduedate = new JTextField();
		txtduedate.setEditable(false);
		txtduedate.setBounds(128, 58, 145, 20);
		panelTermsContract.add(txtduedate);
		txtduedate.setColumns(10);
		
		txtbegindate = new JTextField();
		txtbegindate.setEditable(false);
		txtbegindate.setBounds(128, 27, 145, 20);
		panelTermsContract.add(txtbegindate);
		txtbegindate.setColumns(10);
		//txtDateOriginContract.setText(dateFormat.format(date));
		
		
		
		dateChoserFinalDay.setBounds(440, 27, 150, 20);
		panelTermsContract.add(dateChoserFinalDay);
		dateChoserFinalDay.setMinSelectableDate(aux.getDueDate());
		
		 btnGenContract = new JButton("Generar contrato");
		btnGenContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioProrroga.isSelected()) {
					radioDeliver.setSelected(false);
					
					
					
					//SoftwareCompany.getInstance().calcDays(aux.getDueDate(), dateChoserFinalDay.getDate());
					//System.out.println(SoftwareCompany.getInstance().calcDaysJustDate(aux.getDueDate(),dateChoserFinalDay.getDate()));
					//calcDaysJustDate(aux.getDueDate(), dateChoserFinalDay.getDate());
					//SoftwareCompany.getInstance().calcAmountDelayTime(aux.getId(), calcDaysJustDate(aux.getDueDate(), dateChoserFinalDay.getDate()));
					//System.out.println(SoftwareCompany.getInstance().calcAmountDelayTime(aux.getId(), calcDaysJustDate(aux.getDueDate(), dateChoserFinalDay.getDate())));
					bigContract.setText("Señores, "+txtnamecleitn.getText()+" dominicano, mayor de edad, soltero,"
		    				+ " portador  de la Cédula de Identidad y Electoral No."+SoftwareCompany.getInstance().clientById(txtTxtclientcod.getText()).getId()+" "
		    				+ "domiciliado y residente en "+txtadress.getText()+" quien en lo adelante y para todos los fines y consecuencias legales del presente "
		    				+ "acto se denominará   EL REPRESENTANTE,  LA PRIMERA PARTE o por su propio nombres y apellidos.\n\n"
		    				+ "-----------------------SE HA CONVENIDO Y PACTADO LO SIGUIENTE-----------------------"
		    				+ "PRIMERO: los señores "+txtnamecleitn.getText()+ ", por medio del presente acto autorizan y contratan a Empresa “La empresa” para el diseño"
		    				+ " y creación de "+ "que lleva por nombre "+txtNamePro.getText()+ "por un total de "+SoftwareCompany.getInstance().calcAmountDelayTime(aux.getId(), calcDaysJustDate(aux.getDueDate(), dateChoserFinalDay.getDate()))
		    						+ "\n");
					
					
					
					
					
				txtTotalAcordado.setText(String.valueOf(aux.getPrice()));
				txtTotalPagar.setText(String.valueOf(SoftwareCompany.getInstance().calcAmountDelayTime(aux.getId(), calcDaysJustDate(aux.getDueDate(), dateChoserFinalDay.getDate()))));
				
				}else if (radioDeliver.isSelected()) {
					radioProrroga.setSelected(false);
					
					
					bigContract.setText("Señores, "+txtnamecleitn.getText()+" dominicano, mayor de edad, soltero,"
		    				+ " portador  de la Cédula de Identidad y Electoral No."+SoftwareCompany.getInstance().clientById(txtTxtclientcod.getText()).getId()+" "
		    				+ "domiciliado y residente en "+txtadress.getText()+" quien en lo adelante y para todos los fines y consecuencias legales del presente "
		    				+ "acto se denominará   EL REPRESENTANTE,  LA PRIMERA PARTE o por su propio nombres y apellidos.\n\n"
		    				+ "-----------------------SE HA CONVENIDO Y PACTADO LO SIGUIENTE-----------------------"
		    				+ "PRIMERO: los señores "+txtnamecleitn.getText()+ ", por medio del presente acto autorizan y contratan a Empresa “La empresa” para el diseño"
		    				+ " y creación de "+ "que lleva por nombre "+txtNamePro.getText()+ "por un total de "+aux.getPrice()
		    						+ "\n");
					
					
				}
			}
		});
		btnGenContract.setBounds(440, 58, 150, 23);
		panelTermsContract.add(btnGenContract);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 97, 580, 133);
		panelTermsContract.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(bigContract);
		
		
		radioProrroga.setBounds(279, 27, 155, 23);
		panelTermsContract.add(radioProrroga);
		bg.add(radioDeliver);
		bg.add(radioProrroga);
		

		radioDeliver.setBounds(279, 55, 155, 23);
		panelTermsContract.add(radioDeliver);
		
		
		totalAcordadoLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		totalAcordadoLabel.setBounds(158, 241, 112, 22);
		panelTermsContract.add(totalAcordadoLabel);
		
		txtTotalAcordado = new JTextField();
		txtTotalAcordado.setEditable(false);
		txtTotalAcordado.setBounds(276, 243, 94, 20);
		panelTermsContract.add(txtTotalAcordado);
		txtTotalAcordado.setColumns(10);
		
		Label label_12 = new Label("Total a pagar:");
		label_12.setFont(new Font("SansSerif", Font.PLAIN, 13));
		label_12.setBounds(387, 241, 94, 22);
		panelTermsContract.add(label_12);
		
		txtTotalPagar = new JTextField();
		txtTotalPagar.setEditable(false);
		txtTotalPagar.setBounds(487, 243, 103, 20);
		panelTermsContract.add(txtTotalPagar);
		txtTotalPagar.setColumns(10);
		loadInfo();
		
		
		{
			 buttonPane = new JPanel();
			 
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
                  okButton = new JButton("Finalizar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
							if (aux.getProject().getState().equalsIgnoreCase("Terminado")) {
							
							dispose();
							
						}else if(!aux.getProject().getState().equalsIgnoreCase("Prorrogado") && !aux.getProject().getState().equalsIgnoreCase("Terminado")) {
						if (radioProrroga.isSelected() && !txtTotalPagar.equals("") && !txtTotalAcordado.equals("")) {
							aux.getProject().setState("Prorrogado");
							aux.setFinalDate(dateChoserFinalDay.getDate());
							JOptionPane.showMessageDialog(null, "Este Proyecto Fue prorrogado con exito", "Proyectos", JOptionPane.INFORMATION_MESSAGE);
							aux.setPrice(SoftwareCompany.getInstance().calcAmountDelayTime(aux.getId(), calcDaysJustDate(aux.getDueDate(), dateChoserFinalDay.getDate())));
						}else if(radioDeliver.isSelected()) {
							aux.getProject().setState("Terminado");
							aux.getProject().setEnded(true);
							JOptionPane.showMessageDialog(null, "Este Proyecto Fue concluido con exito", "Proyectos", JOptionPane.INFORMATION_MESSAGE);
						
						}
						
						}else {
							JOptionPane.showMessageDialog(null, "Este Proyecto ya fue prorrogado", "Proyectos", JOptionPane.ERROR_MESSAGE);

						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void loadInfo() {
		
		if (aux.getProject().getState().equalsIgnoreCase("Prorrogado")) {
			radioProrroga.setEnabled(false);
			txtTotalAcordado.setVisible(false);
			dateChoserFinalDay.setEnabled(false);
         	totalAcordadoLabel.setVisible(false);
			
			
			
			
		}else if(aux.getProject().getState().equalsIgnoreCase("Terminado")) {
			dateChoserFinalDay.setEnabled(false);
			btnGenContract.setEnabled(false);
			radioDeliver.setEnabled(false);
			radioProrroga.setEnabled(false);
			

			
			
			
		}
		
		
		txtTxtclientcod.setText(aux.getIdClient());
		txtTotalPagar.setText(Float.toString(aux.getPrice()));
		//SoftwareCompany.getInstance().searchClientByCode(aux.getIdClient());
		//System.out.println(SoftwareCompany.getInstance().clientById(aux.getIdClient()).getAddress());
		txtadress.setText(SoftwareCompany.getInstance().clientById(aux.getIdClient()).getAddress());
		txtbegindate.setText(dateFormat.format(aux.getDateBegin()));
		//txtbegindate.setText(dateFormat.format(date));
		txtDateSig.setText(aux.getSignoutDay());
		txtLanguaje.setText(aux.getProject().getLanguage());
		txtnamecleitn.setText(SoftwareCompany.getInstance().clientById(aux.getIdClient()).getName()+" "+SoftwareCompany.getInstance().clientById(aux.getIdClient()).getLast_name());
		txtNamePro.setText(aux.getProject().getName());
		txtodPro.setText(aux.getProject().getId());
		txttel.setText(SoftwareCompany.getInstance().clientById(aux.getIdClient()).getPhone());
		txtTipoPro.setText(aux.getProject().getType());
		txtduedate.setText(dateFormat.format(aux.getDueDate()));
		
		for (int i = 0; i < aux.getProject().getWorkers().size(); i++) {
			
			if (aux.getProject().getWorkers().get(i) instanceof Boss ) {
				DLMWorkersSelected.addElement(aux.getProject().getWorkers().get(i).getCode()+"->"+aux.getProject().getWorkers().get(i).getName()+" "+aux.getProject().getWorkers().get(i).getLast_name()+" |Jefe|");

			}else if (aux.getProject().getWorkers().get(i) instanceof Programmer ) {
				DLMWorkersSelected.addElement(aux.getProject().getWorkers().get(i).getCode()+"->"+aux.getProject().getWorkers().get(i).getName()+" "+aux.getProject().getWorkers().get(i).getLast_name()+" |Programador|");

			}else if (aux.getProject().getWorkers().get(i) instanceof Designer ) {
				DLMWorkersSelected.addElement(aux.getProject().getWorkers().get(i).getCode()+"->"+aux.getProject().getWorkers().get(i).getName()+" "+aux.getProject().getWorkers().get(i).getLast_name()+" |Diseñador|");

			}else if (aux.getProject().getWorkers().get(i) instanceof Planner ) {
				DLMWorkersSelected.addElement(aux.getProject().getWorkers().get(i).getCode()+" -> "+aux.getProject().getWorkers().get(i).getName()+" "+aux.getProject().getWorkers().get(i).getLast_name()+" |Planeador|");

			}	
		}
	}
	
public int calcDaysJustDate(Date d1,Date d2) {
		fechaInicio.setTime(d1);;
		fechafin.setTime(d2);
		
		System.out.println(fechafin.getTime().toString());
		
		c.setTimeInMillis(fechafin.getTime().getTime() - fechaInicio.getTime().getTime());
		
		return c.get(Calendar.DAY_OF_YEAR);
		
	}
}
