package datos;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Vacuna {
	private int idVacuna;
	private int codigo;
	private String nombre;
	private LocalDate fechaElaboracion;
	public Vacuna() {
		super();
	}
	public Vacuna(int codigo, String nombre, LocalDate fechaElaboracion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaElaboracion = fechaElaboracion;
	}
	public int getIdVacuna() {
		return idVacuna;
	}
	protected void setIdVacuna(int idVacuna) {
		this.idVacuna = idVacuna;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaElaboracion() {
		return fechaElaboracion;
	}
	public void setFechaElaboracion(LocalDate fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}
	
	@Override
	public String toString() {
		return "idVacuna=" + idVacuna + ", codigo=" + codigo + ", nombre=" + nombre + ", fechaElaboracion="
				+ fechaElaboracion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idVacuna;
		return result;
	}
	@Override
	public boolean equals(Object obj) {

		return ((Vacuna)obj).getIdVacuna()==this.getIdVacuna();
	}
	
	public int calcularMesesElaboracion(LocalDate hoy) {
		Period diferencia = Period.between(this.getFechaElaboracion(), hoy);
		return diferencia.getMonths();
		
	}
	
	
	
	
	
}
