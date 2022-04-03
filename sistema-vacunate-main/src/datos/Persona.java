package datos;

import java.time.LocalDate;

public class Persona {
	private int idPersona;
	private long documento;
	private LocalDate fechaNacimiento;
	private boolean tieneComorbilidad;
	public Persona() {
		super();
	}
	public Persona(long documento, LocalDate fechaNacimiento, boolean tieneComorbilidad) {
		super();
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.tieneComorbilidad = tieneComorbilidad;
	}
	public int getIdPersona() {
		return idPersona;
	}
	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long documento) {
		this.documento = documento;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public boolean getTieneComorbilidad() {
		return tieneComorbilidad;
	}
	public void setTieneComorbilidad(boolean tieneComorbilidad) {
		this.tieneComorbilidad = tieneComorbilidad;
	}
	@Override
	public String toString() {
		return "idPersona=" + idPersona + ", documento=" + documento + ", fechaNacimiento=" + fechaNacimiento
				+ ", tieneComorbilidad=" + tieneComorbilidad;
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
