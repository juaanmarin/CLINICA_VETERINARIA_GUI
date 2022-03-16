package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;
import modelo.vo.ProductoVo;

public class PersonaProductoDao {

	private Coordinador miCoordinador;

	
	public PersonaVo obtenerIdPersona(int idPersona) {
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result=null;
		
		connection = conexion.getConnection();

		PersonaVo miPersona = null;
		
		String consulta="SELECT * FROM persona where id_persona=? ";
		
		try {
			
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idPersona);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					
					miPersona= new PersonaVo();
					miPersona.setIdPersona(result.getInt("id_persona"));
				}
				conexion.desconectar();
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: " +e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error en la consulta de la persona: " +e.getMessage());
		}
		return  miPersona;
	}
	
	
	public ProductoVo obtenerIdProducto(int idProductos) {
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result=null;
		
		connection = conexion.getConnection();
		
		ProductoVo miProducto = null;
	
		String consulta="SELECT * FROM producto where id_producto= ? ";
		
		try {
			
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idProductos);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					
					miProducto = new ProductoVo();
					miProducto.setIdProducto(result.getInt("id_producto"));
					
				}
				conexion.desconectar();
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: " +e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error en la consulta de la persona: " +e.getMessage());
		}
		return  miProducto;
	}
	
	
	
	

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

}
