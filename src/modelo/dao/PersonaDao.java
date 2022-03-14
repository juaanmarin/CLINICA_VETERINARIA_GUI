package modelo.dao;

import controlador.Coordinador;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controlador.Coordinador;
import modelo.conexion.Conexion;

public class PersonaDao {

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

	public String registrarPersona(PersonaVo miPersona) {
		
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		String consulta = "INSERT INTO persona(id_persona,nombre_persona,profesion_persona,telefono_persona,tipo_persona,nacimiento_id)"
				+ " VALUES (?,?,?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, miPersona.getIdPersona());
			preStatement.setString(2, miPersona.getNombre());
			preStatement.setString(3, miPersona.getProfesion());
			preStatement.setString(4, miPersona.getTelefono());
			preStatement.setInt(5, miPersona.getTipo());
			preStatement.setLong(6, miPersona.getNacimiento().getIdNacimiento());
			preStatement.execute();
			
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("no se pudo registrar la persona, verifique el documento no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la persona";
		}
		catch (Exception e) {
			System.out.println("No se pudo registrar la persona: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la persona";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
	}
	
	public PersonaVo consultarPersona(Long idDocumento) {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miPersona=null;
		NacimientoVo miNacimiento=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM persona where id_persona= ? ";
		System.out.println("*********************************************");
		try {
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idDocumento);
				result=statement.executeQuery();
				
				while(result.next()==true){
					miPersona=new PersonaVo();
					miPersona.setIdPersona(result.getLong("id_persona"));
					miPersona.setNombre(result.getString("nombre_persona"));
					
					miPersona.setProfesion(result.getString("profesion_persona"));
					miPersona.setTelefono(result.getString("telefono_persona"));
					miPersona.setTipo(result.getInt("tipo_persona"));
					
					miNacimiento =new NacimientoVo();
					miNacimiento.setIdNacimiento(Long.parseLong(result.getString("nacimiento_id")));
					miPersona.setNacimiento(miNacimiento);	
				}
				
				miConexion.desconectar();
			}
			else {
				miPersona=null;
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona" +e.getMessage());
		}
		
		return miPersona;
	}
	
	public void ActualizarPersona() {
		
	}
	
	public PersonaVo consultarTodasLasPersonas() {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miPersona=null;
		NacimientoVo miNacimiento=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM persona";
		System.out.println("*********************************************");
		try {
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);
				//statement.setLong(1, idDocumento);
				result=statement.executeQuery();
				
				while(result.next()==true){
					miPersona=new PersonaVo();
					miPersona.setIdPersona(result.getLong("id_persona"));
					miPersona.setNombre(result.getString("nombre_persona"));
					
					miPersona.setProfesion(result.getString("profesion_persona"));
					miPersona.setTelefono(result.getString("telefono_persona"));
					miPersona.setTipo(result.getInt("tipo_persona"));
					
					miNacimiento =new NacimientoVo();
					miNacimiento.setIdNacimiento(Long.parseLong(result.getString("nacimiento_id")));
					miPersona.setNacimiento(miNacimiento);	
				}
				
				miConexion.desconectar();
			}
			else {
				miPersona=null;
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona" +e.getMessage());
		}
		
		return miPersona;
	
	}

}
