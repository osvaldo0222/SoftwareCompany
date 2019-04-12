package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;
import com.sun.glass.ui.Application;
import com.toedter.calendar.JDateChooser;


import javafx.scene.control.TableRow;

import logical.Contract;
import logical.SoftwareCompany;
import logical.User;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.border.EtchedBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Label;
import java.awt.Rectangle;

public class MainVisual extends JFrame implements Runnable {

	private JPanel contentPane;
	private User user;
	private Dimension dimension;
	private JTable table;
	private DefaultTableModel model;
	private final String[] headers = {"Proyecto", "Contrato", "Trabajadores", "Cliente", "F. Entrega", "Estado", "Proceso"};
	private Object[] rows;
	private Thread projects;
	private JPanel panelPieProjectStatus;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	private Thread pieThread;
	private JPanel panelLineGraph;
	private String[] split;
	private int hora;
	private int minutos;
	private int dia;
	private int mes;
	private int year;
	private Label labelforDate;
	private JFreeChart lineChart;
	private PdfPTable tabla;
	private JPanel panelForBar;
	private ChartPanel panelBarGraph;
	private PDFGraphics2D g2;
	private PDFDocument pdfDoc;
	private Image foto;
	private Image Bar;
	private Image Lost;

	
	public MainVisual(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainVisual.class.getResource("/Imgs/main-visual-icon.png")));
		setTitle("Software Company");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				saveData();
				System.exit(0);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dimension = super.getToolkit().getScreenSize();
		super.setSize(dimension.width, (dimension.height - 40));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		pieThread=new Thread();
		pieThread.start();
		
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/folder30pc.png")));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrar = new JMenuItem("Salir");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveData();
				dispose();
				System.exit(0);
			}
		});
		
		JMenuItem mntmImprimirEstadisticas = new JMenuItem("Imprimir Estad\u00EDsticas\r\n");
		mntmImprimirEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openSavePdf();
			}
		});
		mntmImprimirEstadisticas.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/icons8-print-30.png")));
		mnArchivo.add(mntmImprimirEstadisticas);
		mntmCerrar.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/exit30.png")));
		mnArchivo.add(mntmCerrar);
		
		JMenu mnTrabajadores = new JMenu("Trabajadores");
		mnTrabajadores.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/worker30px.png")));
		menuBar.add(mnTrabajadores);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar Trabajadores");
		mntmRegistrar.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/user30px.png")));
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WorkerRegistration registration = new WorkerRegistration(null);
				registration.setModal(true);
				registration.setVisible(true);
			}
		});
		mnTrabajadores.add(mntmRegistrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar Trabajadores");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListWorker worker = new ListWorker();
				worker.setModal(true);
				worker.setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		mnTrabajadores.add(separator);
		mntmListar.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/list30px.png")));
		mnTrabajadores.add(mntmListar);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/user30.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar Clientes");
		mntmRegistrar_1.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/user30px.png")));
		mntmRegistrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientRegistration registration = new ClientRegistration(null);
				registration.setModal(true);
				registration.setVisible(true);
			}
		});
		mnClientes.add(mntmRegistrar_1);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar Clientes");
		mntmListar_1.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/list30px.png")));
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListClient listClient = new ListClient();
				listClient.setModal(true);
				listClient.setVisible(true);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnClientes.add(separator_1);
		mnClientes.add(mntmListar_1);
		
		JMenu mnProyectos = new JMenu("Proyectos");
		mnProyectos.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/icons8-training-30.png")));
		menuBar.add(mnProyectos);
		
		JMenuItem mntmRegistrar_2 = new JMenuItem("Registrar Proyectos");
		mntmRegistrar_2.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/new_project30.png")));
		mntmRegistrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProjectRegistration registration = new ProjectRegistration();
				registration.setModal(true);
				registration.setSize(625, 450);
				registration.setResizable(false);
				registration.setLocationRelativeTo(null);
				registration.setVisible(true);
				loadtable();
				graphPie();
			}
		});
		mnProyectos.add(mntmRegistrar_2);
		
		JMenuItem mntmListarProyectos = new JMenuItem("Listar Proyectos");
		mntmListarProyectos.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/list30px.png")));
		mntmListarProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListProjects listPro=new ListProjects();
				listPro.setModal(true);
				listPro.setVisible(true);
				loadtable();
				graphPie();
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		mnProyectos.add(separator_2);
		mnProyectos.add(mntmListarProyectos);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/userssss30.png")));
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmRegistrar_3 = new JMenuItem("Registrar Usuarios");
		mntmRegistrar_3.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/user30px.png")));
		mntmRegistrar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserRegistration registration = new UserRegistration(user, null);
				registration.setModal(true);
				registration.setVisible(true);
			}
		});
		
		JMenuItem mntmListar_2 = new JMenuItem("Listar Usuarios");
		mntmListar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListUser listUser = new ListUser();
				listUser.setModal(true);
				listUser.setVisible(true);
			}
		});
		mntmListar_2.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/list30px.png")));
		if (user.getType().equalsIgnoreCase("ADMINISTRADOR")) {
			mnUsuarios.add(mntmRegistrar_3);
			JSeparator separator_3 = new JSeparator();
			mnUsuarios.add(separator_3);
			mnUsuarios.add(mntmListar_2);
			JSeparator separator_4 = new JSeparator();
			mnUsuarios.add(separator_4);
		}
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Seguro que desea cerrar la sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					Login login = new Login();
					dispose();
					saveData();
					login.setVisible(true);
				}
			}
		});
		mntmCerrarSesion.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/log_out30.png")));
		mnUsuarios.add(mntmCerrarSesion);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panelAux = new JPanel();
		panel.add(panelAux);
		panelAux.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panelAux.add(panel_1);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Proyectos Activos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnCount(headers.length);
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		table.setAutoCreateRowSorter(true);
		table.setDefaultEditor(Object.class, null);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
	    loadtable();
		projects = new Thread(this);
		projects.start();
		scrollPane.setViewportView(table);
		
		
		JPanel panelEstadisticaContainer = new JPanel();
		panelAux.add(panelEstadisticaContainer);
		panelEstadisticaContainer.setBackground(Color.WHITE);
		panelEstadisticaContainer.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Estatus de Proyectos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEstadisticaContainer.setLayout(new BorderLayout(0, 0));
	    panelPieProjectStatus = new JPanel();
	    panelEstadisticaContainer.add(panelPieProjectStatus);
	    panelPieProjectStatus.setLayout(new BorderLayout(0, 0));
	    graphPie();
	 // Crear el Panel del Grafico con ChartPanel
        chartPanel = new ChartPanel(chart);
      
       // panelPieProjectStatus.removeAll();
        panelPieProjectStatus.add(chartPanel);
        
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panelAux.add(panel_3);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Perdidas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		 panelForBar = new JPanel();
		panel_3.add(panelForBar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Ingresos Mensuales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAux.add(panel_2);
		 panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		 panelLineGraph = new JPanel();
		panel_2.add(panelLineGraph);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("<html><p style=\"text-align:center;\">Registrar<br/>Trabajadores</p></html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerRegistration registration = new WorkerRegistration(null);
				registration.setModal(true);
				registration.setVisible(true);
			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/worker30px.png")));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<html><p style=\"text-align:center;\">Registrar<br/>Clientes</p></html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientRegistration registration = new ClientRegistration(null);
				registration.setModal(true);
				registration.setVisible(true);
			}
		});
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/user30.png")));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<html><p style=\"text-align:center;\">Registrar<br/>Proyectos</p></html>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectRegistration registration = new ProjectRegistration();
				registration.setModal(true);
				registration.setSize(625, 450);
				registration.setResizable(false);
				registration.setLocationRelativeTo(null);
				registration.setVisible(true);
				loadtable();
			}
		});
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_2.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/icons8-training-30.png")));
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveData();
				dispose();
				System.exit(0);
			}
		});
		
		JButton btnNewButton_4 = new JButton("<html><p style=\"text-align:center;\">Finalizar/Posponer<br/>Proyecto</p></html>");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListProjects listPro=new ListProjects();
				listPro.setModal(true);
				listPro.setVisible(true);
				loadtable();
				
			}
		});
		btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_4.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/icons8-training-30.png")));
		btnNewButton_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_4.add(btnNewButton_4);
		
		JButton btnImprimirEstadoFinanciero = new JButton("<html><p style=\\\"text-align:center;\\\">Imprimir<br/>Estad\u00EDsticas</p></html>");
		btnImprimirEstadoFinanciero.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openSavePdf();
			}
		});
		btnImprimirEstadoFinanciero.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnImprimirEstadoFinanciero.setHorizontalTextPosition(SwingConstants.CENTER);
		btnImprimirEstadoFinanciero.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/icons8-print-30.png")));
		btnImprimirEstadoFinanciero.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_4.add(btnImprimirEstadoFinanciero);
		btnNewButton_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/exit30.png")));
		btnNewButton_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_4.add(btnNewButton_3);
		
		JPanel panelFouUserBar = new JPanel();
		panelFouUserBar.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelFouUserBar, BorderLayout.SOUTH);
		panelFouUserBar.setLayout(new BoxLayout(panelFouUserBar, BoxLayout.X_AXIS));
		
		Label labelType = new Label("");
		labelType.setFont(new Font("SansSerif", Font.PLAIN, 14));
		labelType.setText(user.getType());
		panelFouUserBar.add(labelType);
		
		JPanel panel_13 = new JPanel();
		panelFouUserBar.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panelFouUserBar.add(panel_14);
		
		JPanel panel_7 = new JPanel();
		panelFouUserBar.add(panel_7);
		
		Label labeluser = new Label("Usuario:");
		labeluser.setAlignment(Label.CENTER);
		labeluser.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panelFouUserBar.add(labeluser);
		
		Label labelSetUser = new Label("");
		labelSetUser.setFont(new Font("SansSerif", Font.PLAIN, 14));
		labelSetUser.setText(user.getUsername());
		panelFouUserBar.add(labelSetUser);
		
		Label fecha = new Label("Fecha:");
		fecha.setAlignment(Label.CENTER);
		fecha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panelFouUserBar.add(fecha);
		 
		 labelforDate = new Label("");
		 labelforDate.setFont(new Font("SansSerif", Font.PLAIN, 13));
		 panelFouUserBar.add(labelforDate);
		graphPie();
		lineGraph();
		graphBar();
	
		
		
		
	}
	
	private void saveData() {
		FileOutputStream company;
		ObjectOutputStream writer;
		try {
			company = new FileOutputStream("SoftwareCompany.dat");
			writer = new ObjectOutputStream(company);
			writer.writeObject(SoftwareCompany.getInstance());
			writer.writeInt(SoftwareCompany.codWorkers);
			writer.writeInt(SoftwareCompany.codProjects);
			writer.writeInt(SoftwareCompany.codClients);
			writer.writeInt(SoftwareCompany.codUsers);
			writer.writeInt(SoftwareCompany.codContract);
			writer.close();
			company.close();
		} catch (Exception e) {
			System.out.println("Error al guardar los datos" + e.toString());
		}
	}
	
	private void loadtable() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Contract aux : SoftwareCompany.getInstance().getContracts()) {
			if (!aux.getProject().isEnded()) {
				if (aux.getDateBegin().before(new Date()) && aux.getFinalDate().after(new Date()) && !aux.getProject().getState().equalsIgnoreCase("Prorrogado") ) {
					aux.getProject().setState("En Proceso");
				} else if (!aux.getDateBegin().before(new Date())) {
					aux.getProject().setState("Nuevo");
				} else if (!aux.getProject().getState().equalsIgnoreCase("Prorrogado") && aux.getFinalDate().before(new Date())) {
					aux.getProject().setState("Atrasado");
				}
				addRow(aux);
			}
		}
		Render render = new Render(5);
		table.setDefaultRenderer(Object.class, render);
		render.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < headers.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(render);
		}	
		javax.swing.table.TableColumn column = table.getColumnModel().getColumn(6);
		column.setCellRenderer(new ProgressRenderer());
	}

	private void addRow(Contract aux) {
		rows[0] = aux.getProject().getId();
		rows[1] = aux.getId();
		rows[2] = aux.getProject().getWorkers().size();
		rows[3] = aux.getIdClient();
		rows[4] = (new SimpleDateFormat("dd/MM/yyyy")).format(aux.getDueDate());
		rows[5] = aux.getProject().getState();
		rows[6] = progressCalc(aux);
		model.addRow(rows);
	}
	
	private int progressCalc(Contract aux) {
		JDateChooser dateBegin = new JDateChooser();
		JDateChooser finalDate = new JDateChooser();
		JDateChooser actualDate = new JDateChooser();
		dateBegin.setDate(aux.getDateBegin());
		finalDate.setDate(aux.getFinalDate());
		actualDate.setDate(new Date());
		int progressDays = SoftwareCompany.getInstance().calcDays(dateBegin, actualDate);
		int totalDays = SoftwareCompany.getInstance().calcDays(dateBegin, finalDate);
		int porcentage = (int) (((float) progressDays)/((float) totalDays) * 100);
		if (porcentage >= 100) {
			porcentage = 100;
		}
		return porcentage;
	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		int time = 0;
		while(ct == projects) {
			if (time >= 30) {
				loadtable();
			}
			try {
				Thread.sleep(1000);
				time = (time == 30) ? 0 : (time + 1);
				calcTime();
				if (minutos < 10) {
					labelforDate.setText(dia+"/"+mes+"/"+year+" "+hora+":0" + minutos);
				} else {
					labelforDate.setText(dia+"/"+mes+"/"+year+" "+hora+":" + minutos);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public void graphBar() {
		DefaultCategoryDataset datasetForBar = new DefaultCategoryDataset( );  
		float aux=0;
		
		/*for (int i = 0; i < SoftwareCompany.getInstance().getContracts().size(); i++) {
			aux+=SoftwareCompany.getInstance().getContracts().get(i).getPrice()-SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice();
		}*/
		float[] amountByMonth= {0,0,0,0,0,0,0,0,0,0,0,0};
		
		for (int i = 0; i < SoftwareCompany.getInstance().getContracts().size(); i++) {
			 split=SoftwareCompany.getInstance().getContracts().get(i).getFinalDate().toString().split(" ");
			if (split[1].equalsIgnoreCase("Jan") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[0]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Feb") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[1]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Mar") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[2]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Apr") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[3]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("May") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[4]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Jun") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[5]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Jul") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[6]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Aug") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[7]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Sep") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[8]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Oct") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[9]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Nov") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[10]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}else if (split[1].equalsIgnoreCase("Dec") && SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				amountByMonth[11]+=SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice()-SoftwareCompany.getInstance().getContracts().get(i).getPrice();
			}
			
		}
		datasetForBar.addValue( amountByMonth[0] , "Meses" , "Ene" );
		datasetForBar.addValue( amountByMonth[1] , "Meses" , "Feb" );
		datasetForBar.addValue( amountByMonth[2] , "Meses" , "Mar" );
		datasetForBar.addValue( amountByMonth[3] , "Meses" , "Abr" );
		datasetForBar.addValue( amountByMonth[4] , "Meses" , "May" );
		datasetForBar.addValue( amountByMonth[5] , "Meses" , "Jun" );
		datasetForBar.addValue( amountByMonth[6] , "Meses" , "Jul" );
		datasetForBar.addValue( amountByMonth[7] , "Meses" , "Ago" );
		datasetForBar.addValue( amountByMonth[8] , "Meses" , "Sep" );
		datasetForBar.addValue( amountByMonth[9] , "Meses" , "Oct" );
		datasetForBar.addValue( amountByMonth[10] , "Meses" , "Nov" );
		datasetForBar.addValue( amountByMonth[11] , "Meses" , "Dic" );
		
	    
	   
	    JFreeChart chartBar=ChartFactory.createBarChart( "Perdidas Mensuales",
	        "Mes", // Category axis
	        "Cantidad Dinero", // Value axis
	        datasetForBar,
	        PlotOrientation.VERTICAL,
	        true,true,false
	       );
	    
	    /* panelLineGraph.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	            
	    	      chartPanel = new ChartPanel( lineChart );
	    	    
	    	      panelLineGraph.add(chartPanel);*/
	    panelForBar.setLayout(new BoxLayout(panelForBar, BoxLayout.X_AXIS));

	    panelBarGraph=new ChartPanel(chartBar);
	    panelForBar.add(panelBarGraph);
	    panelBarGraph.setPreferredSize( new java.awt.Dimension( 532 , 285 ) );
	    panelBarGraph.setLayout(new BorderLayout(0, 0));
	    //panelBar.setPreferredSize( new java.awt.Dimension( 532 , 300 ) );
	    
	    try {
			ChartUtilities.saveChartAsJPEG(new File("graphBar.jpg"), chartBar, 500,500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}
	
	public void graphPie() {
		
		for (int i = 0; i < SoftwareCompany.getInstance().getContracts().size(); i++) {
			System.out.println("Precio Real  "+SoftwareCompany.getInstance().getContracts().get(i).getPrice() +"Precio a pagar "+SoftwareCompany.getInstance().getContracts().get(i).getCopyPrice());
			
		}
		
		 DefaultPieDataset data = new DefaultPieDataset();
		 int proFin=0;
		 int proInProces=0;
		 int proProrrogado=0;
		 int nuevo=0;
		 
		 for (int i = 0; i < SoftwareCompany.getInstance().getProjects().size(); i++) {
			 if (SoftwareCompany.getInstance().getProjects().get(i).getState().equalsIgnoreCase("Terminado")) {
				 proFin++;
			}else if(SoftwareCompany.getInstance().getProjects().get(i).getState().equalsIgnoreCase("En Proceso")) {
				proInProces++;
			}else if(SoftwareCompany.getInstance().getProjects().get(i).getState().equalsIgnoreCase("Prorrogado")) {
				proProrrogado++;
			}else if(SoftwareCompany.getInstance().getProjects().get(i).getState().equalsIgnoreCase("Nuevo")) {
				nuevo++;
			}
			
		}
		 
		 
		 	data.setValue("Proyectos Terminados", proFin);
	        data.setValue("Proyectos En Proceso", proInProces);
	        data.setValue("Proyectos Prorrogados", proProrrogado);
	        data.setValue("Proyectos Nuevo", nuevo);
	 
	        
	         chart = ChartFactory.createPieChart3D(
	         "Grafica Status Proyectos", 
	         data, 
	         true, 
	         true, 
	         false);
	       //chart.setBackgroundPaint(new Color(222, 222, 255));
	      // chart.setBorderPaint(Color.WHITE);
	      
	       PiePlot plot = (PiePlot) chart.getPlot();
	       plot.setSectionPaint("Proyectos Terminados", new Color( 130, 224, 170 ));
	       plot.setSectionPaint("Proyectos Prorrogados", new Color( 236, 112, 99 ));
	       plot.setSectionPaint("Proyectos En Proceso", new Color( 247, 220, 111 ));
	       plot.setSectionPaint("Proyectos Nuevo", new Color( 133, 193, 233 ));
	       plot.setBackgroundPaint(Color.WHITE);
	       
	       try {
				ChartUtilities.saveChartAsJPEG(new File("graficopie.jpg"), chart, 500, 500);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       

	        
	}
	public void lineGraph() {
		
		float[] amountByMonth= {0,0,0,0,0,0,0,0,0,0,0,0};
		
		
		
		for (int i = 0; i < SoftwareCompany.getInstance().getContracts().size(); i++) {
			split=SoftwareCompany.getInstance().getContracts().get(i).getFinalDate().toString().split(" ");
			if (SoftwareCompany.getInstance().getContracts().get(i).getProject().isEnded()==true) {
				if (split[1].equalsIgnoreCase("Jan")) {
					amountByMonth[0]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Feb")) {
					amountByMonth[1]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Mar")) {
					amountByMonth[2]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Apr")) {
					amountByMonth[3]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("May")) {
					amountByMonth[4]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Jun")) {
					amountByMonth[5]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Jul")) {
					amountByMonth[6]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Aug")) {
					amountByMonth[7]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Sep")) {
					amountByMonth[8]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Oct")) {
					amountByMonth[9]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Nov")) {
					amountByMonth[10]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}else if (split[1].equalsIgnoreCase("Dec")) {
					amountByMonth[11]+=SoftwareCompany.getInstance().getContracts().get(i).getPrice();
				}
			}
		}
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      dataset.addValue( amountByMonth[0] , "Meses" , "Ene" );
	      dataset.addValue( amountByMonth[1] , "Meses" , "Feb" );
	      dataset.addValue( amountByMonth[2] , "Meses" , "Mar" );
	      dataset.addValue( amountByMonth[3] , "Meses" , "Abr" );
	      dataset.addValue( amountByMonth[4] , "Meses" , "May" );
	      dataset.addValue( amountByMonth[5] , "Meses" , "Jun" );
	      dataset.addValue( amountByMonth[6] , "Meses" , "Jul" );
	      dataset.addValue( amountByMonth[7] , "Meses" , "Ago" );
	      dataset.addValue( amountByMonth[8] , "Meses" , "Sep" );
	      dataset.addValue( amountByMonth[9] , "Meses" , "Oct" );
	      dataset.addValue( amountByMonth[10] , "Meses" , "Nov" );
	      dataset.addValue( amountByMonth[11] , "Meses" , "Dic" );
	      
	      
	             lineChart = ChartFactory.createLineChart3D(
	    	         "Ingresos Mensuales",
	    	         "Meses","Ingresos",
	    	         dataset,
	    	         PlotOrientation.VERTICAL,
	    	         true,true,false);
	    	      panelLineGraph.setLayout(new BoxLayout(panelLineGraph, BoxLayout.X_AXIS));
	            
	    	      chartPanel = new ChartPanel( lineChart );
	    	    
	    	      panelLineGraph.add(chartPanel);
	    	      chartPanel.setPreferredSize( new java.awt.Dimension( 532 , 285 ) );
	    	      
	    	      try {
	  				ChartUtilities.saveChartAsJPEG(new File("graphLine.jpg"), lineChart, 500, 500);
	  			} catch (IOException e) {
	  				// TODO Auto-generated catch block
	  				e.printStackTrace();
	  			}
	    	
	}
	
	public void calcTime() {
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        dia=calendario.get(Calendar.DAY_OF_MONTH);
        mes=calendario.get(Calendar.MONTH) + 1;
        year=calendario.get(Calendar.YEAR);
    }
	
	public void createPdf(String ruta) {
		try {
			 // Se crea el documento
    	     Document documento = new Document();
    	     //crear foto
    	    
    	     
    	     
    	  // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
    	     if (!ruta.endsWith(".pdf")) {
    	    	ruta += ".pdf";
			}
    	     
    	     FileOutputStream ficheroPdf = new FileOutputStream(ruta);
    	     System.out.println(ruta);

    	    // Se asocia el documento al OutputStream y se indica que el espaciado entre
    	    // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
    	    PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

    	    // Se abre el documento.
    	    
    	    documento.open();
    	    documento.add(new Paragraph("Reporte completo actividad en 'SoftwareCompany'\n",
    				FontFactory.getFont("Sans-serif",   // fuente
    				14,                            // tamaño
    				Font.BOLD,                   // estilo
    				BaseColor.BLACK)));

    	    documento.add(new Paragraph("Estadística de los ultimos meses \n",
    	    				FontFactory.getFont("Sans-serif",   // fuente
    	    				13,                            // tamaño
    	    				BaseColor.BLACK)));             // color
    	    
    	    documento.add(new Paragraph("Reporte en la Fecha :"+mes+"/"+dia+"/"+year+"\n",
    				FontFactory.getFont("Sans-serif",   // fuente
    				13,                            // tamaño
    				BaseColor.BLACK))); 
    	    /* documento.add(new Paragraph("Usuario :"+user.getName()+" "+user.getLast_name()+"\n",
    				FontFactory.getFont("Sans-serif",   // fuente
    				13,                            // tamaño
    				BaseColor.BLACK))); */
    	    
    	    documento.add(new Paragraph("Rendimiento global :\n\n",
    				FontFactory.getFont("Sans-serif",   // fuente
    				14,                            // tamaño
    				BaseColor.BLACK))); 
    	    
    	     tabla = new PdfPTable(ListProjects.getInstance().getTableProjects().getColumnCount());
    	     //PdfPCell cell=new PdfPCell();
    	   
    	     
    	     //cell.setBackgroundColor(BaseColor.GREEN);
    	     
    	     //cell.equals(ListProjects.getInstance().getHeaders()[0].toString());
    	     
    	    // cell.addElement();
    	     
    	    
    	    //System.out.println("Tabla"+ ListProjects.getInstance().getTableProjects().getRowCount());
			//tabla.addCell(ListProjects.getInstance().getHeaders().toString());
//{"ID Contrato", "ID Cliente", "Nombre Cliente", "ID Proyecto", "Tipo Proyecto","Firma Contrato", "Fecha Inicio", "Fecha de entrega", "Total a pagar","Estado","Fecha Prorrogado","Trabajadores"};

    		tabla.addCell( ListProjects.getInstance().getHeaders()[0].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[1].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[2].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[3].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[4].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[5].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[6].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[7].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[8].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[9].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[10].toString());
    		tabla.addCell( ListProjects.getInstance().getHeaders()[11].toString());
    	     
    	    /* tabla.addCell("ID Proyecto");
    	     tabla.addCell("ID Contrato");
    	     tabla.addCell("Trabajadores");
    	     tabla.addCell("ID Cliente");
    	     tabla.addCell("Fecha Entrega");
    	     tabla.addCell("Estado");
    	     tabla.addCell("Completado");*/
    	     
    	    
    		

    	 for (int i = 0; i <  ListProjects.getInstance().getTableProjects().getRowCount(); i++) {
    	    	
    	    	for (int j = 0; j <  ListProjects.getInstance().getTableProjects().getColumnCount(); j++) {
    	    		
    	    		tabla.addCell(ListProjects.getInstance().getTableProjects().getValueAt(i, j).toString());
					
				}
				
			}
    	    tabla.setWidthPercentage(100);
    	    
    	    try
    	    {
    	    	 foto = Image.getInstance("graficopie.jpg");
    	    	 
    	    	foto.scaleToFit(500, 500);
    	    	foto.setAlignment(Chunk.ALIGN_CENTER);
    	    	
    	    	Bar = Image.getInstance("graphBar.jpg");
    	    	Bar.scaleToFit(500, 500);
    	    	Bar.setAlignment(Chunk.ALIGN_CENTER);
    	    	
    	    	Lost = Image.getInstance("graphLine.jpg");
    	    	Lost.scaleToFit(500, 500);
    	    	Lost.setAlignment(Chunk.ALIGN_CENTER);
    	    	
    	    	
    	    	
    	    }
    	    catch ( Exception e )
    	    {
    	    	e.printStackTrace();
    	    }
    	    documento.add(tabla);
    	    documento.add(foto);
    	    documento.add(Bar);
    	   
    	    documento.add(Lost);
    	    
    	    
    	    documento.close();
 
		} catch (Exception e) {
			
		}	
	}
	
	private void openSavePdf() {
		JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".pdf", "pdf");
        file.addChoosableFileFilter(filter);
        file.setFileFilter(filter);
        file.setAcceptAllFileFilterUsed(false);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
        	File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            createPdf(path);
        }
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	
}
