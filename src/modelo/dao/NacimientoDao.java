package modelo.dao;

import controlador.Coordinador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;


public class NacimientoDao {

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	public Long registrarNacimiento(NacimientoVo miNacimiento) {
		Long idNacimiento=null;
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		ResultSet result=null;
		
		connection = conexion.getConnection();
		
		String consulta = "INSERT INTO nacimiento (ciudad_nacimiento,departamento_nacimiento,fecha_nacimiento,pais_nacimiento)"
				+ " VALUES (?,?,?,?)";
		
		try {
			preStatement =connection.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);

			preStatement.setString(1, miNacimiento.getCiudadNacimiento());
			preStatement.setString(2, miNacimiento.getDepartamentoNacimiento());
			preStatement.setString(3, miNacimiento.getFechaNacimiento().toString());

			preStatement.setString(4, miNacimiento.getPaisNacimiento());
			preStatement.execute();
			result=preStatement.getGeneratedKeys();
			if (result.next()) {
				idNacimiento=result.getLong(1);
			}
			
		} catch (SQLException e) {
			System.out.println("No se pudo registrar los datos del nacimiento: "+ e.getMessage());
			e.printStackTrace();
			idNacimiento = null;
		}catch (Exception e) {
			System.out.println("No se pudo registrar los datos del nacimiento: "+ e.getMessage());

			e.printStackTrace();
			idNacimiento = null;
		}
		finally {
			conexion.desconectar();
		}
		System.out.println("El ID del Nacimiento es: "+idNacimiento);
		return idNacimiento;	
	}
	
	public static NacimientoVo consultarNacimiento(Long idNacimiento) {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		connection=miConexion.getConnection();
		
		NacimientoVo miNacimiento = null;
		
		String consulta="SELECT * FROM nacimiento where id_nacimiento= ? ";
		
		try {
			
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idNacimiento);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					
					miNacimiento=new NacimientoVo();
					
					miNacimiento.setIdNacimiento(result.getLong("id_nacimiento"));
					miNacimiento.setCiudadNacimiento(result.getString("ciudad_nacimiento"));
					miNacimiento.setDepartamentoNacimiento(result.getString("departamento_nacimiento"));
					miNacimiento.setPaisNacimiento(result.getString("pais_nacimiento"));
					miNacimiento.setFechaNacimiento(LocalDate.parse(result.getDate("fecha_nacimiento")+""));
				}
				miConexion.desconectar();
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: " +e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error en la consulta de la persona: " +e.getMessage());
		}
		return miNacimiento;
	}
	
	public NacimientoVo obtenerIdNacimiento(int idPersona) {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		connection=miConexion.getConnection();
		
		NacimientoVo miNacimiento = null;
		
		String consulta="SELECT nacimiento_id FROM persona where id_persona= ? ";
		
		try {
			
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idPersona);
				
				result=statement.executeQuery();
				
				if ( result.next()) {
					miNacimiento = new NacimientoVo();
					miNacimiento.setIdNacimiento(result.getInt("nacimiento_id"));
				}
				miConexion.desconectar();
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: " +e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error en la consulta de la persona: " +e.getMessage());
		}

		return miNacimiento;
	}

	public String actualizarNacimiento(NacimientoVo miNacimiento) {

		System.out.println("XxxxxxxXXX"+miNacimiento.getIdNacimiento()+"XXXxxxxxX");
		long idNacimiento=miNacimiento.getIdNacimiento();
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		String resp = "";
		
		connection = conexion.getConnection();
		
		try {
			String consulta = "UPDATE nacimiento "
					+ "SET ciudad_nacimiento = ? ,"
					+ "departamento_nacimiento = ? ,"
					+ "fecha_nacimiento = ? ,"
					+ "pais_nacimiento= ?  "
					+ "WHERE id_nacimiento = ?;";
			
			preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, miNacimiento.getCiudadNacimiento());
			preStatement.setString(2, miNacimiento.getDepartamentoNacimiento());
			preStatement.setString(3, miNacimiento.getFechaNacimiento().toString());
			preStatement.setString(4, miNacimiento.getPaisNacimiento());
			
			preStatement.setLong(5, miNacimiento.getIdNacimiento());
			
			preStatement.executeUpdate();
			
			resp = "ok";
			
			
		} catch (SQLException e) {
			System.out.println("No se pudo Actualizar los datos del nacimiento: "+ e.getMessage());
			e.printStackTrace();
			resp = null;
		}catch (Exception e) {
			System.out.println("No se pudo Actualizar los datos del nacimiento: "+ e.getMessage());

			e.printStackTrace();
			resp = null;
		}
		finally {
			conexion.desconectar();
		}
		System.out.println("El ID del Nacimiento es: "+idNacimiento);
		return resp;	
	}
	
	

	public String eliminarNacimiento(Long idUsuario) {
		
		System.out.println("XxxxxxxXXX"+idUsuario+"XXXxxxxxX");
		
		long idNacimiento=idUsuario;
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		String resp = "";
		
		connection = conexion.getConnection();
		
		try {
			String consulta = "DELETE FROM nacimiento WHERE id_nacimiento = ?";
			
			preStatement = connection.prepareStatement(consulta);

			preStatement.setLong(1, idUsuario);
			
			preStatement.executeUpdate();
			
			resp = "ok";
			
			
		} catch (SQLException e) {
			System.out.println("No se pudo Eliminar los datos del nacimiento: "+ e.getMessage());
			e.printStackTrace();
			resp = null;
		}catch (Exception e) {
			System.out.println("No se pudo Eliminar los datos del nacimiento: "+ e.getMessage());

			e.printStackTrace();
			resp = null;
		}
		finally {
			conexion.desconectar();
		}
		System.out.println("El ID del Nacimiento es: "+idNacimiento);
		return resp;	
	}
}
