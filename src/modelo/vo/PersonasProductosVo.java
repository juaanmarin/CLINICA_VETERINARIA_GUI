package modelo.vo;

public class PersonasProductosVo {

	private Long personaId;
	private Long productoId;
	
	public PersonasProductosVo() {
		
	}

	public PersonasProductosVo(Long personaId, Long productoId) {
		super();
		this.personaId = personaId;
		this.productoId = productoId;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	@Override
	public String toString() {
		return "PersonasProductosVo [personaId=" + personaId + ", productoId=" + productoId + "]";
	}
	
	
}
