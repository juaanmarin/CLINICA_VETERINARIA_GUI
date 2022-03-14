package controlador;

import modelo.dao.MascotaDao;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;
import vista.gui.ConsultarMascotasGui;
import vista.gui.ConsultarPersonaGui;
import vista.gui.ConsultarProductosGui;
import vista.gui.RegistrarMascotasGui;
import vista.gui.RegistrarPersonasGui;
import vista.gui.RegistrarProductosGui;
import vista.gui.TotalDePersonasRegistradas;
import vista.gui.VentanaPrincipal;

public class Coordinador {

	private VentanaPrincipal miVentanaPrincipal;
	private RegistrarPersonasGui miRegistrarPersonasGui;
	private RegistrarMascotasGui miRegistrarMascotasGui;
	private RegistrarProductosGui miRegistrarProductosGui;
	private PersonaDao miPersonaDao;
	private MascotaDao miMascotaDao;
	private NacimientoDao miNacimientoDao;
	private ProductoDao miProductoDao;
	private PersonaProductoDao miPersonaProductoDao;
	private ConsultarPersonaGui miColsultaPersonaGui;
	private ConsultarMascotasGui miConsultarMascotasGui;
	private ConsultarProductosGui miConsultarProductosGui;
	private TotalDePersonasRegistradas miTotalDePersonasRegistradas;

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal=miVentanaPrincipal;
		
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		this.miRegistrarPersonasGui=miRegistrarPersonasGui;
		
	}

	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		this.miRegistrarMascotasGui=miRegistrarMascotasGui;
		
	}

	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui) {
		this.miRegistrarProductosGui=miRegistrarProductosGui;
		
	}

	public void setPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao=miPersonaDao;
		
	}

	public void setMascotaDao(MascotaDao miMascotaDao) {
		this.miMascotaDao=miMascotaDao;
		
	}

	public void setNacimientoDao(NacimientoDao miNacimientoDao) {
		this.miNacimientoDao=miNacimientoDao;
		
	}

	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao=miProductoDao;
		
	}

	public void setPersonaProductoDao(PersonaProductoDao miPersonaProductoDao) {
		this.miPersonaProductoDao=miPersonaProductoDao;
		
	}
	
	public void setConsultarMascotaGui(ConsultarMascotasGui miConsultarMascotasGui) {
		this.miConsultarMascotasGui=miConsultarMascotasGui;
	}
	
	public void setConsultarPersonaGui(ConsultarPersonaGui miColsultaPersonaGui) {
		this.miColsultaPersonaGui=miColsultaPersonaGui;
	}
	
	public void setConsultarProductosGui(ConsultarProductosGui miConsultarProductosGui) {
		this.miConsultarProductosGui=miConsultarProductosGui;
		
	}

	public void setTotalDePersonasRegistradas(TotalDePersonasRegistradas miTotalDePersonasRegistradas) {
		this.miTotalDePersonasRegistradas=miTotalDePersonasRegistradas;
		
	}
	
	public void mostrarVentanaRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
	}

	public void mostrarVentanaRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
		
	}
	
	public void mostrarVentanaConsultaPersona() {
		miColsultaPersonaGui.setVisible(true);
	}
	
	public void mostrarVentanaConsultaMascotas() {
		miConsultarMascotasGui.setVisible(true);
	}
	
	public void mostrarVentanaConsultarProductos() {
		miConsultarProductosGui.setVisible(true);
	}
	
	public void mostrarVentanaTotalDePersonasRegistradas() {
		miTotalDePersonasRegistradas.setVisible(true);
	}
	

	public String registrarPersona(PersonaVo miPersona) {
		return miPersonaDao.registrarPersona(miPersona);
		
	}

	public Long registrarNacimiento(PersonaVo miPersona) {
		return miNacimientoDao.registrarNacimiento(miPersona.getNacimiento());
	}
	
	public PersonaVo setConsultarPersona(Long idDocumento) {
		return miPersonaDao.consultarPersona(idDocumento);
	}

	public NacimientoVo consultarNacimiento(long idNacimiento) {
		
		return NacimientoDao.consultarNacimiento(idNacimiento);
	}
	public PersonaVo consultarTodasLasPersonas() {
		return miPersonaDao.consultarTodasLasPersonas();
	}

	

	

	

	
	

	

}
