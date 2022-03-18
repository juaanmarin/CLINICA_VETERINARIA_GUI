package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;
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
	
	public String idUsuario(int id) {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		ProductoDao miProducto = null; 
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM persona where id_persona = ? ";
		String resp = "";
		try {
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX_--------------_XXXXXXXXXXXXXXXXXXXXXX");
			System.out.println(id);
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, id);
				result=statement.executeQuery();
				while(result.next()==true){
					Long a = result.getLong("id_persona");
					return "ok";
				}
			}
			
		} 
		catch (SQLException e) {
			System.out.println("Error en la consulta del producto" +e.getMessage());
		} 
		finally {
			miConexion.desconectar();
		}

		
		return resp;
	}
	
	public String eliminarProducto(Long idPersona) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		
		try {
			
			String consulta = "DELETE FROM personas_productos WHERE persona_id = ?";
			
			
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, idPersona);
			preStatement.executeUpdate();
		
				
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("no se pudo eliminar la Producto, verifique el documento no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar el producto";
		}
		catch (Exception e) {
			System.out.println("No se pudo eliminar el producto: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar el producto";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
		
	}
	
	
	

	
	public ArrayList<Long> buscarIdProducto(int id) {
		ArrayList<Long> lista = new ArrayList<>();
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		ProductoDao miProducto = null; 
		
		connection=miConexion.getConnection();

		String consulta = "SELECT producto_id FROM personas_productos WHERE persona_id = ? ";
		
		try {
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX_--------------_XXXXXXXXXXXXXXXXXXXXXX");
			System.out.println(id);
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, id);
				result=statement.executeQuery();
				while(result.next()==true){
					lista.add(result.getLong("producto_id"));
					
				}
				return lista;
			}
			
		} 
		catch (SQLException e) {
			System.out.println("Error en la consulta del producto" +e.getMessage());
		} 
		finally {
			miConexion.desconectar();
			System.out.println(lista);
		}
		
		return lista;
		
	}
	
	
	public String eliminarTablaProductos(ArrayList<Long> lista) {
		
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		
		try {
			
			String consulta = "DELETE FROM productos WHERE id_producto = ?";
			
			
			preStatement = connection.prepareStatement(consulta);
			
			for (Long idPersona : lista) {
				preStatement.setLong(1, idPersona);
				preStatement.executeUpdate();
			}
			
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("no se pudo eliminar la Producto, verifique el documento no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar el producto";
		}
		catch (Exception e) {
			System.out.println("No se pudo eliminar el producto: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar el producto";
		}
		finally {
			conexion.desconectar();
		}
		return resultado;
		
	}
	
	public ArrayList<ProductoVo> consultarTodosLosProductos() {
		ArrayList<ProductoVo> todosLosDatos=new ArrayList<>();
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		ProductoVo miProducto=null;
		
		//NacimientoVo miNacimiento=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM productos";
		System.out.println("*********************************************");
		try {
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);
				result=statement.executeQuery();
			
				while(result.next()==true){
					
					miProducto=new ProductoVo();
					
					miProducto.setIdProducto(result.getLong("id_producto"));
					miProducto.setNombreProducto(result.getString("nombre_producto"));
					miProducto.setPrecioProducto(result.getDouble("precio_producto"));
						
					todosLosDatos.add(miProducto);
				}
				
			}
			else {
				miProducto=null;
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
	
	
	
	public String eliminarProductoPorId(Long idProducto) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		
		
		try {
			
			String consulta = "DELETE FROM productos WHERE id_producto = ?";
			
			
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, idProducto);
			preStatement.executeUpdate();
		
				
			resultado = "ok";
			
		} catch (SQLException e) {
			System.out.println("no se pudo eliminar la Producto, verifique el documento no existe: "+ e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar el producto";
		}
		catch (Exception e) {
			System.out.println("No se pudo eliminar el producto: " +e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar el producto";
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
