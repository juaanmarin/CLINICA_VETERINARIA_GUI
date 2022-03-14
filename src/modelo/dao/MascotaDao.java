package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.MascotaVo;

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


}
