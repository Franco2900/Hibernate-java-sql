package datos;

import java.time.LocalDate;

public class Inspeccion {
	private int idInspeccion;
	private LocalDate fecha;
	private boolean	estadoPagado;
	private String estado;
	Automotor automotor;
	Inspector inspector;
	
	public Inspeccion() {
		super();
	}
	
	public Inspeccion(int idInspeccion, LocalDate fecha, boolean estadoPagado, String estado, Automotor automotor,
			Inspector inspector) {
		super();
		this.idInspeccion = idInspeccion;
		this.fecha = fecha;
		this.estadoPagado = estadoPagado;
		this.estado = estado;
		this.automotor = automotor;
		this.inspector = inspector;
	}

	public int getIdInspeccion() {
		return idInspeccion;
	}

	protected void setIdInspeccion(int idInspeccion) {
		this.idInspeccion = idInspeccion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isEstadoPagado() {
		return estadoPagado;
	}

	public void setEstadoPagado(boolean estadoPagado) {
		this.estadoPagado = estadoPagado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	
	
	public Automotor getAutomotor() {
		return automotor;
	}

	public void setAutomotor(Automotor automotor) {
		this.automotor = automotor;
	}

	@Override
	public String toString() {
		return "Inspeccion [idInspeccion=" + idInspeccion + ", fecha=" + fecha + ", estadoPagado=" + estadoPagado
				+ ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idInspeccion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
	
		return ((Inspeccion)obj).getIdInspeccion() == this.getIdInspeccion();
	}

	
	
	
	
	
	
	
}
