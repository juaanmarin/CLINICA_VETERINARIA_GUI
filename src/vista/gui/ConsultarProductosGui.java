package vista.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ConsultarProductosGui extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextArea AreaResultado;
	private JTextField textId;
	private Coordinador miCoordinador;

	
	public ConsultarProductosGui() {
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Gestion Productos");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(127, 11, 176, 20);
		miPanel.add(etiTitulo);
		
		AreaResultado = new JTextArea();
		AreaResultado.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(AreaResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(25, 63, 380, 116);
		miPanel.add(scroll);
		
		JLabel etiId = new JLabel("Id:");
		etiId.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiId.setBounds(25, 214, 26, 20);
		miPanel.add(etiId);
		
		textId = new JTextField();
		textId.setBounds(61, 216, 86, 20);
		miPanel.add(textId);
		textId.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(155, 215, 89, 23);
		miPanel.add(btnEliminar);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

}
