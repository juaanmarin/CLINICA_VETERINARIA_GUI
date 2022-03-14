package modelo.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private String nombreBd="bd_clinica";
	private String usuario="root";
	private String password="Sena1234"; //BDSE
	//private String password="nuviavelasquez07"; //MIBD
	private String url="jdbc:mysql://localhost:3306/"+nombreBd+"?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
			+ "serverTimezone=UTC";
	
	Connection conn=null;
	//CONSTRUCTOR DE LA CLASE
	
	public Conexion() {
		try {
			//obtener drive
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Obtener la conexion
			conn=DriverManager.getConnection(url,usuario,password);
			if(conn!=null) {
				System.out.println("Conexion Exitosa a la BD: "+nombreBd);
			}
			else {
				System.out.println("**************NO SE PUDO CONECTAR " +nombreBd);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("ocurre una ClassNotFoundException: " +e.getMessage());
		} catch (SQLException e) {
			System.out.println("ocurre una SQLException: " +e.getMessage());
			System.out.println("Verifique que MYSQL este encendido....");
		}
	}
	
	public Connection getConnection(){
		return conn;
	}
	public void desconectar(){
		conn=null;
	}

}
