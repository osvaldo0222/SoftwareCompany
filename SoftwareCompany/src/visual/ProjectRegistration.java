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

public class ProjectRegistration extends JDialog {

	private final JPanel FirstPanel = new JPanel();
	private JTextField txtCodigoProyecto;
	private JTextField txtNombreProyecto;
	private JTable WorkersTable;
	private JTable SelectedWorkersTable;

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
		setBounds(100, 100, 637, 479);
		getContentPane().setLayout(new BorderLayout());
		FirstPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(FirstPanel, BorderLayout.CENTER);
		FirstPanel.setLayout(null);
		
		JPanel InformacionGeneralPanel = new JPanel();
		InformacionGeneralPanel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		InformacionGeneralPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InformacionGeneralPanel.setBounds(10, 29, 601, 203);
		FirstPanel.add(InformacionGeneralPanel);
		InformacionGeneralPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCodigo.setBounds(21, 31, 82, 26);
		InformacionGeneralPanel.add(lblCodigo);
		{
			JLabel lblProyecto = new JLabel("Proyecto:");
			lblProyecto.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblProyecto.setBounds(21, 88, 82, 26);
			InformacionGeneralPanel.add(lblProyecto);
		}
		{
			JLabel lblLenguaje = new JLabel("Lenguaje:");
			lblLenguaje.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblLenguaje.setBounds(303, 145, 82, 26);
			InformacionGeneralPanel.add(lblLenguaje);
		}
		{
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblTipo.setBounds(21, 145, 82, 26);
			InformacionGeneralPanel.add(lblTipo);
		}
		
		txtCodigoProyecto = new JTextField();
		txtCodigoProyecto.setBounds(118, 31, 170, 26);
		InformacionGeneralPanel.add(txtCodigoProyecto);
		txtCodigoProyecto.setColumns(10);
		
		JComboBox comboBoxTipoProyecto = new JComboBox();
		comboBoxTipoProyecto.setBounds(118, 145, 170, 26);
		InformacionGeneralPanel.add(comboBoxTipoProyecto);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setBounds(118, 88, 447, 26);
		InformacionGeneralPanel.add(txtNombreProyecto);
		txtNombreProyecto.setColumns(10);
		
		JComboBox comboBoxLenguaje = new JComboBox();
		comboBoxLenguaje.setBounds(395, 145, 170, 26);
		InformacionGeneralPanel.add(comboBoxLenguaje);
		
		JPanel TrabajadoresPanel = new JPanel();
		TrabajadoresPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selecci\u00F3nde Trabajadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		TrabajadoresPanel.setBounds(10, 243, 601, 153);
		FirstPanel.add(TrabajadoresPanel);
		TrabajadoresPanel.setLayout(null);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblBuscarPor.setBounds(10, 27, 96, 26);
		TrabajadoresPanel.add(lblBuscarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(118, 27, 163, 26);
		TrabajadoresPanel.add(comboBox);
		
		JPanel panelForTable = new JPanel();
		panelForTable.setBounds(10, 64, 271, 78);
		TrabajadoresPanel.add(panelForTable);
		panelForTable.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelForTable.add(scrollPane, BorderLayout.CENTER);
		
		WorkersTable = new JTable();
		scrollPane.setViewportView(WorkersTable);
		
		JPanel SelectedWorkersPanel = new JPanel();
		SelectedWorkersPanel.setBounds(317, 64, 274, 78);
		TrabajadoresPanel.add(SelectedWorkersPanel);
		SelectedWorkersPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		SelectedWorkersPanel.add(scrollPane_1, BorderLayout.CENTER);
		
		SelectedWorkersTable = new JTable();
		scrollPane_1.setViewportView(SelectedWorkersTable);
		
		JLabel lblSeleccionado = new JLabel("Seleccionados:");
		lblSeleccionado.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblSeleccionado.setBounds(317, 27, 132, 26);
		TrabajadoresPanel.add(lblSeleccionado);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
}
