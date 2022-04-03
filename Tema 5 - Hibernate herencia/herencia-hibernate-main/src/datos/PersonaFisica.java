package datos;

public class PersonaFisica extends Cliente{
	
	//ATRIBUTOS
	private int idPersonaFisica;
	private String apellido;
	private String nombre;
	private int dni;
	
	//CONSTRUCTOR VACIO Y COMUN(sin id)
	public PersonaFisica() {}
	public PersonaFisica(String nroCliente, String apellido, String nombre, int dni) {
		super(nroCliente);
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}
	
	//GETTERS Y SETTERS
	public int getIdPersonaFisica() {
		return idPersonaFisica;
	}
	protected void setIdPersonaFisica(int idPersonaFisica) {
		this.idPersonaFisica = idPersonaFisica;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	//METODOS
	@Override
	public String toString() {
		String cadena ="\nidPersonaFisica=" + this.getIdCliente() + ", nroCliente=" + this.getNroCliente()+ ",	apellido=" + apellido + ", nombre=" + nombre+ ", dni=" + dni + "\n"; 
		return cadena;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idPersonaFisica;
		return result;
	}
	@Override
	public boolean equals(Object obj) {

		return ((PersonaFisica)obj).getIdCliente() == this.getIdCliente();
	}
	
	
	
	
	
	
	}//FIN CLASE