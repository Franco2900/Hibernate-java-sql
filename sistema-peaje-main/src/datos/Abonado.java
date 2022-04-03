package datos;

public class Abonado {

	private int idAbonado;
	private String apellido;
	private String nombres;
	private int dni;
	public Abonado() {
		super();
	}
	public Abonado(String apellido, String nombres, int dni) {
		super();
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
	}
	public int getIdAbonado() {
		return idAbonado;
	}
	public void setIdAbonado(int idAbonado) {
		this.idAbonado = idAbonado;
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
		return "idAbonado=" + idAbonado + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAbonado;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		return ((Abonado)obj).getIdAbonado()==this.getIdAbonado();
	}
	
	
}
