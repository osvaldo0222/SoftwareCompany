package visual;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainVisual {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainVisual window = new MainVisual();
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    int height = screenSize.height;
				    int width = screenSize.width;
				    window.frame.setSize(width, height-43);
				    window.frame.setLocationRelativeTo(null);
				    
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainVisual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenu mnProyectos = new JMenu("Proyectos");
		menuBar.add(mnProyectos);
		
		JMenuItem mntmNuevoProyecto = new JMenuItem("Nuevo Proyecto");
		mntmNuevoProyecto.setIcon(new ImageIcon(MainVisual.class.getResource("/Imgs/newProject30.png")));
		mntmNuevoProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectRegistration dialog = new ProjectRegistration();
				
			   dialog.setSize(640, 530);
			   dialog.setLocationRelativeTo(null);
				
				dialog.setVisible(true);
			}
		});
		mnProyectos.add(mntmNuevoProyecto);
	}

}
