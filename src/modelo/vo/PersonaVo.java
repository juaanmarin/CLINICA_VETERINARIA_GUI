package modelo.vo;

import java.util.List;
import java.util.ArrayList;

public class PersonaVo {

	private long idPersona;
	private String nombre;
	private String telefono;
	private String profesion;
	private int tipo;
	
	private NacimientoVo nacimiento;
	private List<MascotaVo> listaMascotas;
	
	public PersonaVo() {
		this.listaMascotas = new ArrayList<MascotaVo>();
	}

	public PersonaVo(long idPersona, String nombre, String telefono, String profesion, int tipo, NacimientoVo nacimiento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.profesion = profesion;
		this.tipo = tipo;
		this.nacimiento = nacimiento;
		this.listaMascotas = new ArrayList<MascotaVo>();
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public NacimientoVo getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(NacimientoVo nacimiento) {
		this.nacimiento = nacimiento;
	}

	public List<MascotaVo> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<MascotaVo> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}

	@Override
	public String toString() {
		return "idPersona: "+idPersona+"\nnombre: "+nombre+"\ntelefono: "+telefono+"\nprofesion: "+profesion+"\ntipo: "+tipo+
				"\nnacimiento: "+nacimiento+"\n\n";
	}
	
	
	
}
