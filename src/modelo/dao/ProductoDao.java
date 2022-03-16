package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.ProductoVo;

public class ProductoDao {

	private Coordinador miCoordinador;
	
	public String registrarProductos(ProductoVo miProducto, int id) {
		
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		String consulta = "INSERT INTO productos(id_producto,nombre_producto,precio_producto)"
				+ " VALUES (?,?,?)";
		String consulta2 = "INSERT INTO personas_productos(persona_id,producto_id)"
				+ "VALUES (?,?)";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, miProducto.getIdProducto());
			preStatement.setString(2, miProducto.getNombreProducto());
			preStatement.setDouble(3, miProducto.getPrecioProducto());
			preStatement.execute();
			
			preStatement = connection.prepareStatement(consulta2);
			preStatement.setLong(1, id);
			preStatement.setLong(2, miProducto.getIdProducto());
			preStatement.execute();
			
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("No se pudo registrar el Producto, verifique que el ID del producto no se repita: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar El Producto";
		}
		catch (Exception e) {
			System.out.println("No se pudo registrar El Producto: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar El Producto";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
		
	}
	
	
	

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

}
