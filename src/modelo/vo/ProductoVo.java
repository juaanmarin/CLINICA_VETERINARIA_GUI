package modelo.vo;

public class ProductoVo {

	private Long idProducto;
	private String nombreProducto;
	private Double precioProducto;
	
	public ProductoVo() {
		
	}

	public ProductoVo(Long idProducto, String nombreProducto, Double precioProducto) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	@Override
	public String toString() {
		return "ID Producto: "+idProducto+ "\nNombre Producto: "+nombreProducto+ "\nPrecio Producto: "+ precioProducto+"\n\n";
	}
	
}
