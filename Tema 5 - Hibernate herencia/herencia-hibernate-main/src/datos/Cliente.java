package datos;

public class Cliente {
	//ATRIBUTOS
	protected int idCliente;
	protected String nroCliente;
	
	
	//CONSTRUCTOR VACIO Y COMUN(sin id)
	public Cliente() {}
	
	public Cliente(String nroCliente) {
		this.nroCliente = nroCliente;

	}
	
	//GETTERS Y SETTERS(protected setId)
	
	public int getIdCliente() {
		return idCliente;
	}
	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNroCliente() {
		return nroCliente;
	}
	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}

		
	
	//METODOS
	public String toString() {
		String cadena = "idCliente=" + idCliente + ", nroCliente=" + nroCliente;
		return cadena;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCliente;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		return ((Cliente)obj).getIdCliente() == this.getIdCliente();
	}

	
	
	
	
}
