package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.SoftwareCompany;
import logical.User;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainVisual extends JFrame {

	private JPanel contentPane;
	private User user;
	private Dimension dimension;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainVisual frame = new MainVisual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainVisual(User user) {
		setTitle("Software Company");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
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
					writer.close();
					company.close();
				} catch (Exception e) {
					System.out.println("Error al guardar los datos" + e.toString());
				}
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
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnArchivo.add(mntmCerrar);
		
		JMenu mnTrabajadores = new JMenu("Trabajadores");
		menuBar.add(mnTrabajadores);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/worker30px.png")));
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WorkerRegistration registration = new WorkerRegistration(null);
				registration.setModal(true);
				registration.setVisible(true);
			}
		});
		mnTrabajadores.add(mntmRegistrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListWorker worker = new ListWorker();
				worker.setModal(true);
				worker.setVisible(true);
			}
		});
		mntmListar.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/user30.png")));
		mnTrabajadores.add(mntmListar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/user30px.png")));
		mntmRegistrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientRegistration registration = new ClientRegistration();
				registration.setModal(true);
				registration.setVisible(true);
			}
		});
		mnClientes.add(mntmRegistrar_1);
		
		JMenu mnProyectos = new JMenu("Proyectos");
		menuBar.add(mnProyectos);
		
		JMenuItem mntmRegistrar_2 = new JMenuItem("Registrar");
		mntmRegistrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectRegistration registration = new ProjectRegistration();
				registration.setModal(true);
				registration.setSize(1250, 700);
				registration.setResizable(false);
				registration.setLocationRelativeTo(null);
				registration.setVisible(true);
			}
		});
		mnProyectos.add(mntmRegistrar_2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
