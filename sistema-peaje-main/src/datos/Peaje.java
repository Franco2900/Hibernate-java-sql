package datos;

import java.time.LocalDate;


public class Peaje {
	
	private int idPeaje;
	private LocalDate fecha;
	private String hora;
	private double precio;
	
	public Peaje() {
		super();
	}
	public Peaje(LocalDate fecha, String hora, double precio) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
	}
	public int getIdPeaje() {
		return idPeaje;
	}
	protected void setIdPeaje(int idPeaje) {
		this.idPeaje = idPeaje;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Peaje [idPeaje=" + idPeaje + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPeaje;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
			return ((Peaje)obj).getIdPeaje() == this.getIdPeaje();
	}
	

	
	
	
}
