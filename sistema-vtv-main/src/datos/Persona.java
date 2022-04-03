package datos;

public class Persona {
	private int idPersona;
	private String apellido;
	private String nombres;
	private int dni;
	
	public Persona() {
		super();
	}
	public Persona(String apellido, String nombres, int dni) {
		super();
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
	}
	public int getIdPersona() {
		return idPersona;
	}
	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPersona;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		return ((Persona)obj).getIdPersona() == this.getIdPersona();
	}
	
	
	
	
	
	
}
