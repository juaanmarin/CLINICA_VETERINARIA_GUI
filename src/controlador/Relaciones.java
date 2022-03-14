package controlador;

import modelo.dao.MascotaDao;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;
import vista.gui.ConsultarMascotasGui;
import vista.gui.ConsultarPersonaGui;
import vista.gui.ConsultarProductosGui;
import vista.gui.RegistrarMascotasGui;
import vista.gui.RegistrarPersonasGui;
import vista.gui.RegistrarProductosGui;
import vista.gui.TotalDePersonasRegistradas;
import vista.gui.VentanaPrincipal;

public class Relaciones {
	
	VentanaPrincipal miVentanaPrincipal;
	
	public Relaciones() {
		
		Coordinador miCoordinador;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;
		ConsultarPersonaGui miColsultaPersonaGui;
		ConsultarMascotasGui miConsultarMascotasGui;
		ConsultarProductosGui miConsultarProductosGui;
		TotalDePersonasRegistradas miTotalDePersonasRegistradas;
		PersonaDao miPersonaDao;
		MascotaDao miMascotaDao;
		ProductoDao miProductoDao;
		NacimientoDao miNacimientoDao;
		PersonaProductoDao miPersonaProductoDao;
		
		// se instancia por unica ocasion las clases declaradas 
		
		miVentanaPrincipal= new VentanaPrincipal();
		miCoordinador= new Coordinador();
		miRegistrarPersonasGui = new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui = new RegistrarMascotasGui(miVentanaPrincipal, true, "");
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
		miColsultaPersonaGui=new ConsultarPersonaGui();
		miConsultarMascotasGui=new ConsultarMascotasGui();
		miConsultarProductosGui=new ConsultarProductosGui();
		miTotalDePersonasRegistradas=new TotalDePersonasRegistradas();
		miPersonaDao= new PersonaDao();
		miMascotaDao= new MascotaDao();
		miProductoDao= new ProductoDao();
		miNacimientoDao= new NacimientoDao();
		miPersonaProductoDao= new PersonaProductoDao();
		
		//Se establece la relación entre el coordinador y cada instancia unica
		//Al coordinador se le asigna el control de cada clase unica
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		miCoordinador.setConsultarPersonaGui(miColsultaPersonaGui);
		miCoordinador.setConsultarMascotaGui(miConsultarMascotasGui);
		miCoordinador.setConsultarProductosGui(miConsultarProductosGui);
		miCoordinador.setTotalDePersonasRegistradas(miTotalDePersonasRegistradas);
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setProductoDao(miProductoDao);
		miCoordinador.setNacimientoDao(miNacimientoDao);
		miCoordinador.setPersonaProductoDao(miPersonaProductoDao);
		
		//A cada clase unica se le asigna la unica instancia del coordinador
		
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miColsultaPersonaGui.setCoordinador(miCoordinador);
		miConsultarMascotasGui.setCoordinador(miCoordinador);
		miConsultarProductosGui.setCoordinador(miCoordinador);
		miTotalDePersonasRegistradas.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		miNacimientoDao.setCoordinador(miCoordinador);
		miPersonaProductoDao.setCoordinador(miCoordinador);
		

		//Se muestra la ventana principal.
		
	}
	
	public void iniciar() {
		miVentanaPrincipal.setVisible(true);
	}
}
