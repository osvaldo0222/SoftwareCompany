package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import logical.Contract;
import logical.SoftwareCompany;
import logical.User;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Frame;

public class Login extends JFrame {

	private Validation validation = new Validation();
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream company;
				FileOutputStream outputStream;
				ObjectInputStream reader;
				try {
					company = new FileInputStream("SoftwareCompany.dat");
					reader = new ObjectInputStream(company);
					SoftwareCompany.setSoftwareCompany((SoftwareCompany) reader.readObject());
					SoftwareCompany.codWorkers = reader.readInt();
					SoftwareCompany.codProjects = reader.readInt();
					SoftwareCompany.codClients = reader.readInt();
					SoftwareCompany.codUsers = reader.readInt();
					reader.close();
					company.close();
				} catch (Exception e) {
					try {
						outputStream = new FileOutputStream("SoftwareCompany.dat");
						User user = new User("USER-1", "ADMIN", "ADMIN", "", "", "", 0, "", "admin", "admin");
						SoftwareCompany.getInstance().insertUser(user);
						outputStream.close();
					} catch (Exception e2) {
						System.out.println("Error al crear fichero!");
					}
				}
				try {
					Login dialog = new Login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setSize(300,330);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Exit(e);
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Exit(e);
			}
		});
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imgs/login48icon.png")));
		setResizable(false);
		setUndecorated(true);
		setBounds(100, 100, 301, 329);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Exit(e);
			}
		});
		contentPanel.setBackground(new Color(245, 245, 245));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Exit(e);
			}
		});
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 360, 96);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setFont(new Font("SansSerif", Font.PLAIN, 42));
		lblLogin.setIcon(new ImageIcon(Login.class.getResource("/Imgs/maleUser80.png")));
		lblLogin.setBounds(10, 11, 80, 74);
		panel.add(lblLogin);
		
		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin_1.setFont(new Font("SansSerif", Font.PLAIN, 42));
		lblLogin_1.setBounds(10, 11, 340, 74);
		panel.add(lblLogin_1);
		
		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Exit(e);
			}
		});
		txtUsername.setToolTipText("Nombre de usuario");
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				validation.setFocusBackground(txtUsername, true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				validation.setFocusBackground(txtUsername, false);
			}
		});
		txtUsername.setBounds(54, 149, 217, 25);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Exit(e);
			}
		});
		txtPassword.setToolTipText("Contrase\u00F1a");
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
		txtPassword.setBounds(54, 186, 217, 25);
		contentPanel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label.setIcon(new ImageIcon(Login.class.getResource("/Imgs/lock20.png")));
		label.setBounds(29, 185, 25, 26);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/Imgs/user20.png")));
		label_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_1.setBounds(29, 148, 25, 26);
		contentPanel.add(label_1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Exit(e);
			}
		});
		btnEntrar.setToolTipText("Entrar al sistema");
		btnEntrar.setIcon(new ImageIcon(Login.class.getResource("/Imgs/login16_Enter.png")));
		btnEntrar.setActionCommand("OK");
		getRootPane().setDefaultButton(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=txtUsername.getText();
				String password=txtPassword.getText();
				
				if (!username.equalsIgnoreCase("") && !password.equalsIgnoreCase("")) {
					User userAux = SoftwareCompany.getInstance().searchUserByUsername(username, password);
					if (userAux!=null) {
						MainVisual mainVisual = new MainVisual(userAux);
						dispose();
						mainVisual.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Login", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Complete los campos", "Login", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEntrar.setBounds(158, 246, 113, 23);
		contentPanel.add(btnEntrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Exit(e);
			}
		});
		btnCancelar.setToolTipText("Salir");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/Imgs/exit.png")));
		btnCancelar.setBounds(29, 246, 113, 23);
		btnCancelar.setActionCommand("Cancel");
		contentPanel.add(btnCancelar);
	}
	
	private void Exit(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			dispose();
		}
	}
}
