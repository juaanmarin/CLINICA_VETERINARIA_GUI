package vista.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class ConsultarMascotasGui extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextField textDocumnto;
	private JTextField textNombre;
	private JTextField textRaza;
	private JTextField textSexo;
	private JTextField textColor;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private Coordinador miCoordinador;

	public ConsultarMascotasGui() {
		
		setBounds(100, 100, 453, 314);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultar.setBounds(246, 84, 107, 25);
		miPanel.add(btnConsultar);
		
		JLabel etiIdDuenio = new JLabel("Id de Due\u00F1o");
		etiIdDuenio.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiIdDuenio.setBounds(22, 85, 89, 23);
		miPanel.add(etiIdDuenio);
		
		textDocumnto = new JTextField();
		textDocumnto.setBounds(122, 88, 100, 20);
		miPanel.add(textDocumnto);
		textDocumnto.setColumns(10);
		
		JLabel etiTitulo = new JLabel("Gestion de mascotas");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(122, 11, 203, 23);
		miPanel.add(etiTitulo);
		
		JLabel etiNombre = new JLabel("Nombre:");
		etiNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiNombre.setBounds(22, 133, 66, 28);
		miPanel.add(etiNombre);
		
		JLabel etiRaza = new JLabel("Raza:");
		etiRaza.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiRaza.setBounds(246, 136, 50, 22);
		miPanel.add(etiRaza);
		
		textNombre = new JTextField();
		textNombre.setBounds(122, 139, 100, 20);
		miPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textRaza = new JTextField();
		textRaza.setBounds(306, 139, 117, 20);
		miPanel.add(textRaza);
		textRaza.setColumns(10);
		
		JLabel etiSexo = new JLabel("Sexo:");
		etiSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiSexo.setBounds(22, 175, 59, 28);
		miPanel.add(etiSexo);
		
		textSexo = new JTextField();
		textSexo.setBounds(122, 181, 100, 20);
		miPanel.add(textSexo);
		textSexo.setColumns(10);
		
		JLabel etiColor = new JLabel("Color:");
		etiColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiColor.setBounds(246, 175, 50, 28);
		miPanel.add(etiColor);
		
		textColor = new JTextField();
		textColor.setBounds(306, 181, 117, 20);
		miPanel.add(textColor);
		textColor.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(325, 241, 90, 23);
		miPanel.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(215, 241, 100, 23);
		miPanel.add(btnActualizar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
