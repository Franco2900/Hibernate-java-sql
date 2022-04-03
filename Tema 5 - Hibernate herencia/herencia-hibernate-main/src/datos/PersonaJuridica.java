package datos;

public class PersonaJuridica extends Cliente{
	//ATRIBUTOS
	private int idPersonaJuridica;
	private String razonSocial;
	private String cuit;
	
	//CONSTRUCTOR VACIO Y COMUN(sin id)
	public PersonaJuridica() {}
	public PersonaJuridica(String nroCliente, String razonSocial, String cuit) {
		super(nroCliente);//hereda nro cliente
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}
	//GETTERS Y SETTERS
	public int getIdPersonaJuridica() {
		return idPersonaJuridica;
	}
	public void setIdPersonaJuridica(int idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	//METODOS
	@Override
	public String toString() {
		String cadena = "\nidPersonaJuridica=" + this.getIdCliente() + ", nroCliente=" +this.getNroCliente()+", razonSocial=" + razonSocial + ", cuit=" + cuit + "\n";
		return cadena;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idPersonaJuridica;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		return ((PersonaJuridica)obj).getIdCliente() == this.getIdCliente();
	}
	
	
	
	
	
	
}