package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Application;
import com.toedter.calendar.JDateChooser;


import javafx.scene.control.TableRow;

import logical.Contract;
import logical.SoftwareCompany;
import logical.User;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
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

public class MainVisual extends JFrame implements Runnable {

	private JPanel contentPane;
	private User user;
	private Dimension dimension;
	private JTable table;
	private DefaultTableModel model;
	private final String[] headers = {"Proyecto", "Contrato", "Trabajadores", "Cliente", "F. Entrega", "Estado", "Proceso"};
	private Object[] rows;
	Thread projects;

	public MainVisual(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainVisual.class.getResource("/Imgs/main-visual-icon.png")));
		setTitle("Software Company");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				saveData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dimension = super.getToolkit().getScreenSize();
		super.setSize(dimension.width, (dimension.height - 40));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/folder30pc.png")));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveData();
				dispose();
			}
		});
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
			}
		});
		mnProyectos.add(mntmRegistrar_2);
		
		JMenuItem mntmListarProyectos = new JMenuItem("Listar Proyectos");
		mntmListarProyectos.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/list30px.png")));
		mntmListarProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListProjects listPro=new ListProjects();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				listPro.setModal(true);
				int height = screenSize.height;
			    int width = screenSize.width;
			    listPro.setSize(width, height-45);
				//listPro.setSize(1250, 700);
				listPro.setResizable(false);
				listPro.setLocationRelativeTo(null);
				listPro.setVisible(true);
				
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
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Proyectos Activos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 601, 329);
		panel.add(panel_1);
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
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < headers.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		javax.swing.table.TableColumn column = table.getColumnModel().getColumn(6);
	    column.setCellRenderer(new ProgressRenderer());
	    loadtable();
		scrollPane.setViewportView(table);
		projects = new Thread(this);
		projects.start();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Estadisticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(621, 11, 564, 635);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Perdidas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 351, 601, 295);
		panel.add(panel_3);
		
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
			}
		});
		
		JButton btnNewButton_4 = new JButton("<html><p style=\"text-align:center;\">Finalizar/Posponer<br/>Proyecto</p></html>");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListProjects listPro=new ListProjects();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				listPro.setModal(true);
				int height = screenSize.height;
			    int width = screenSize.width;
			    listPro.setSize(width, height-45);
				//listPro.setSize(1250, 700);
				listPro.setResizable(false);
				listPro.setLocationRelativeTo(null);
				listPro.setVisible(true);
			}
		});
		btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_4.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/icons8-training-30.png")));
		btnNewButton_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_4.add(btnNewButton_4);
		btnNewButton_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/exit30.png")));
		btnNewButton_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_4.add(btnNewButton_3);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
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
				addRow(aux);
			}
		}
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
		return porcentage;
	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		while(ct == projects) {
			int count = model.getRowCount();
			for (int i = 0; i < count; i++) {
				int porcentage = progressCalc(SoftwareCompany.getInstance().searchContractByCode(table.getValueAt(i, 1).toString()));
				table.setValueAt(porcentage, i, 6);
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
