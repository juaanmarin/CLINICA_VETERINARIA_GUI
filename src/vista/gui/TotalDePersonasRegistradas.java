package vista.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
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

public class TotalDePersonasRegistradas extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextArea AreaResultado;
	private Coordinador miCoordinador;

	
	public TotalDePersonasRegistradas() {
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Total De Personas");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(135, 11, 168, 24);
		miPanel.add(etiTitulo);
		
		AreaResultado = new JTextArea();
		AreaResultado.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(AreaResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(29, 66, 375, 166);
		miPanel.add(scroll);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

}
