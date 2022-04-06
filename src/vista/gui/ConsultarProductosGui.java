package vista.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.ProductoVo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ConsultarProductosGui extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextArea AreaResultado;
	private JTextField textId;
	private Coordinador miCoordinador;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JButton btnCancelar;

	
	public ConsultarProductosGui() {
		setBounds(100, 100, 474, 300);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Gestion Productos");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(150, 11, 176, 20);
		miPanel.add(etiTitulo);
		
		AreaResultado = new JTextArea();
		AreaResultado.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(AreaResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(25, 63, 423, 116);
		miPanel.add(scroll);
		
		JLabel etiId = new JLabel("Id:");
		etiId.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiId.setBounds(25, 214, 26, 20);
		miPanel.add(etiId);
		
		textId = new JTextField();
		textId.setBounds(61, 216, 86, 20);
		miPanel.add(textId);
		textId.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(155, 215, 93, 23);
		btnEliminar.addActionListener(this);
		miPanel.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(258, 215, 100, 23);
		btnConsultar.addActionListener(this);
		miPanel.add(btnConsultar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(362, 215, 86, 23);
		btnCancelar.addActionListener(this);
		miPanel.add(btnCancelar);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource() == btnConsultar) {
			
			ArrayList<ProductoVo> productos=miCoordinador.consultarTodosLosProductos();
			AreaResultado.setText(""+productos);
		}	
		
		else if(e.getSource() == btnEliminar) {
			
			if(textId.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor llene el Campo de ID","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				long idLong = Long.parseLong(textId.getText());
				
				String resul = miCoordinador.eliminarUnProductoConId(idLong);
				
				if(resul.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Eliminacion Exitosa!");
					textId.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo Eliminar la Mascota" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
				}
			}	
		}
			
		else if (e.getSource() == btnCancelar) {
			setVisible(false);
		}	
	}
		
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;	
	}
}
