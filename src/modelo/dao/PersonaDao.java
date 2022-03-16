package modelo.dao;

import controlador.Coordinador;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public String actualizarPersona(PersonaVo miPersona) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		
		try {
			String consulta = "UPDATE persona "
					+ "SET nombre_persona = ? , "
					+ "profesion_persona = ? ,"
					+ "telefono_persona = ? , "
					+ "tipo_persona = ? "
					+ "WHERE id_persona = ?;";
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setString(1, miPersona.getNombre());
			preStatement.setString(2, miPersona.getProfesion());
			preStatement.setString(3, miPersona.getTelefono());
			preStatement.setInt(4, miPersona.getTipo());
			
			preStatement.setLong(5, miPersona.getIdPersona());
			System.out.println("XXXXXXXXXXXXX"+miPersona.getIdPersona()+"XXXXXXXXXXXXXXX");
			preStatement.executeUpdate();
			
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("no se pudo Actualizar la persona, verifique el documento no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo Actualizar la persona";
		}
		catch (Exception e) {
			System.out.println("No se pudo Actualizar la persona: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo Actualizar la persona";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
	}

	public ArrayList<PersonaVo> consultarTodasLasPersonas() {
		ArrayList<PersonaVo> todosLosDatos=new ArrayList<>();
		
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
					miNacimiento=miCoordinador.consultarNacimiento(miNacimiento.getIdNacimiento());
					miNacimiento.setFechaNacimiento(miNacimiento.getFechaNacimiento());
					miNacimiento.setCiudadNacimiento(miNacimiento.getCiudadNacimiento());
					miNacimiento.setDepartamentoNacimiento(miNacimiento.getDepartamentoNacimiento());
					miNacimiento.setPaisNacimiento(miNacimiento.getPaisNacimiento());
					
					miPersona.setNacimiento(miNacimiento);	
					todosLosDatos.add(miPersona);
				}
				
			}
			else {
				miPersona=null;
			}
			
		}
		catch (SQLException e) {
			System.out.println("Error en traer toda la lista de personas" +e.getMessage());
		}
		finally {
			miConexion.desconectar();
			System.out.println(todosLosDatos);
		}
		
		return todosLosDatos;
	
	}

	public String eliminarPersona(long idLong) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		
		try {
			String consulta = "DELETE FROM persona WHERE id_persona = ?";
			
			preStatement = connection.prepareStatement(consulta);
			
			
			preStatement.setLong(1, idLong);
			System.out.println("XXXXXXXXXXXXX"+idLong+"XXXXXXXXXXXXXXX");
			preStatement.executeUpdate();
			
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("no se pudo eliminar la persona, verifique el documento no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar la persona";
		}
		catch (Exception e) {
			System.out.println("No se pudo eliminar la persona: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar la persona";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
	}

}
