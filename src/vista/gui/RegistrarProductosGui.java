package vista.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controlador.Coordinador;
import modelo.vo.NacimientoVo;
import modelo.vo.ProductoVo;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarProductosGui extends JDialog implements ActionListener {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JTextField txtidProducto;
	private JTextField textIdPersona;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public RegistrarProductosGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 235);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTIONAR PRODUCTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 76, 380, 109);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 11, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 11, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(214, 11, 71, 21);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(271, 11, 86, 20);
		panel.add(txtPrecio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 43, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(271, 66, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(172, 66, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		JLabel etiProducto = new JLabel("Id Producto:");
		etiProducto.setBounds(195, 49, 75, 21);
		contentPanel.add(etiProducto);
		
		txtidProducto = new JTextField();
		txtidProducto.setColumns(10);
		txtidProducto.setBounds(280, 49, 86, 20);
		contentPanel.add(txtidProducto);
		
		JLabel etiIdPersona = new JLabel("Id Persona:");
		etiIdPersona.setBounds(30, 49, 75, 21);
		contentPanel.add(etiIdPersona);
		
		textIdPersona = new JTextField();
		textIdPersona.setColumns(10);
		textIdPersona.setBounds(92, 49, 86, 20);
		contentPanel.add(textIdPersona);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnRegistrar) {
			if(textIdPersona.getText().equals("") || txtidProducto.getText().equals("") || txtNombre.getText().equals("") || txtPrecio.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor llene todos los campos","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				ProductoVo miProducto = new ProductoVo();
				int id = Integer.parseInt(textIdPersona.getText());
				miProducto.setIdProducto(Long.parseLong(txtidProducto.getText()));
				miProducto.setNombreProducto(txtNombre.getText());
				miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
				
				String veri = miCoordinador.comprobarIdUsuario(id);
				
				if ( veri.equals("ok") ) {
					String res = miCoordinador.registrarProducto(miProducto, id);
					
					if (res.equals("ok")) {
						JOptionPane.showMessageDialog(null, "Registro Exitoso!");
						limpiar();
					}else {
						JOptionPane.showMessageDialog(null,"El ID del producto ya está registrado, intente con otro número","ERROR",JOptionPane.ERROR_MESSAGE );
					}
				}else {
					JOptionPane.showMessageDialog(null,"El documento no está registrado","ERROR",JOptionPane.ERROR_MESSAGE );
				}

			}
			
		}
		
		else if(e.getSource() == btnCancelar) {
			setVisible(false);
		}
		
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
	
	public void limpiar() {
		txtidProducto.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
	}
}
