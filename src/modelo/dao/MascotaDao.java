package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.MascotaVo;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;

public class MascotaDao {

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	
	public String registrarMascota(MascotaVo miMascota) {
		
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		String consulta = "INSERT INTO mascota(color,nombre,raza,sexo,persona_id)"
				+ " VALUES (?,?,?,?,?)";
		
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miMascota.getColorMascota());
			preStatement.setString(2, miMascota.getNombre());
			preStatement.setString(3, miMascota.getRaza());	
			preStatement.setString(4, miMascota.getSexo());
			preStatement.setLong(5, miMascota.getIdMascota());
			preStatement.execute();
			
			resultado = "ok";
			
			
		} catch (SQLException e) {
			System.out.println("no se pudo registrar la Mascota, verifique la mascota no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la mascota";
		}
		catch (Exception e) {
			System.out.println("No se pudo registrar la mascota: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la mascota";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
	}
	
	public String eliminarMascota(Long idPersona) {
		
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		
		try {
			String consulta = "DELETE FROM mascota WHERE persona_id = ?";
			
			preStatement = connection.prepareStatement(consulta);
			
			
			preStatement.setLong(1, idPersona);
			System.out.println("XXXXXXXXXXXXX"+"MASCOTA:  "+idPersona+"XXXXXXXXXXXXXXX");
			preStatement.executeUpdate();
			
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("no se pudo eliminar la mascota, verifique el documento no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar la mascota";
		}
		catch (Exception e) {
			System.out.println("No se pudo eliminar la mascota: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar la mascota";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
		
	}
	
	public MascotaVo consultarMascota(Long idMascota, String nombreMasc) {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		MascotaVo miMascota=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM mascota where persona_id= ? and nombre= ?";
		System.out.println("*********************************************");
		try {
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idMascota);
				statement.setString(2, nombreMasc);
				result=statement.executeQuery();
				
				while(result.next()==true){
					miMascota=new MascotaVo();
					miMascota.setIdMascota(result.getLong("persona_id"));
					miMascota.setNombre(result.getString("nombre"));
					
					miMascota.setColorMascota(result.getString("color"));
					miMascota.setRaza(result.getString("raza"));
					miMascota.setSexo(result.getString("sexo"));
				}
				
				miConexion.desconectar();
			}
			else {
				miMascota=null;
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona" +e.getMessage());
		}
		
		return miMascota;
	}

	public String eliminarMascota(long idLong, String nombre) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		
		try {
			String consulta = "DELETE FROM mascota WHERE persona_id = ? and nombre = ?";
			
			preStatement = connection.prepareStatement(consulta);
			
			
			preStatement.setLong(1, idLong);
			preStatement.setString(2, nombre);
			System.out.println("XXXXXXXXXXXXX"+idLong+ ""+ nombre+ "XXXXXXXXXXXXXXX");
			preStatement.executeUpdate();
			
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("no se pudo eliminar la mascota, verifique el documento no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar la mascota";
		}
		catch (Exception e) {
			System.out.println("No se pudo eliminar la mascota: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar la mascota";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
	}
	
	public String actualizarMascota(MascotaVo miMascota,long idLong, String nombre) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		
		try {
			String consulta = "UPDATE mascota "
					+ "SET color = ? , "
					+ "nombre = ? ,"
					+ "raza = ? , "
					+ "sexo = ? "
					+ "WHERE persona_id = ? and nombre = ? ;";
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setString(1, miMascota.getColorMascota());
			preStatement.setString(2, miMascota.getNombre());
			preStatement.setString(3, miMascota.getRaza());
			preStatement.setString(4, miMascota.getSexo());
			
			preStatement.setLong(5, idLong);
			preStatement.setString(6, nombre);
			System.out.println("XXXXXXXXXXXXX"+idLong+ ""+ nombre +"XXXXXXXXXXXXXXX");
			preStatement.executeUpdate();
			
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("no se pudo Actualizar la mascota, verifique el documento no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo Actualizar la mascota";
		}
		catch (Exception e) {
			System.out.println("No se pudo Actualizar la mascota: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo Actualizar la mascota";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
	}
	
	

}
