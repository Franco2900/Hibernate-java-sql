package datos;

public class Rodado {

	
	private int idRodado;
	private String dominio;
	private int categoria;
	private Abonado abonado;
	
	public Rodado() {
		super();
	}

	public Rodado(String dominio, int categoria, Abonado abonado) {
		super();
		this.dominio = dominio;
		this.categoria = categoria;
	}

	public int getIdRodado() {
		return idRodado;
	}

	protected void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
		
	public Abonado getAbonado() {
		return abonado;
	}

	public void setAbonado(Abonado abonado) {
		this.abonado = abonado;
	}

	@Override
	public String toString() {
		return "Rodado [idRodado=" + idRodado + ", dominio=" + dominio + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRodado;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Rodado)obj).getIdRodado()==this.getIdRodado();
	}
	
	
	
	
}
