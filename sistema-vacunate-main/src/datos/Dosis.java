package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Dosis {

	private int idDosis;
	private String vacunatorio;
	private LocalDate fecha; 
	Vacuna vacuna;
	Persona persona; 
	LocalTime hora;
	
	public Dosis() {
		super();
	}
	public Dosis(String vacunatorio, LocalDate fecha, Vacuna vacuna, Persona persona, LocalTime hora) {
		super();
		this.vacunatorio = vacunatorio;
		this.fecha = fecha;
		this.vacuna = vacuna;
		this.persona = persona;
		this.hora = hora;
	}
	public int getIdDosis() {
		return idDosis;
	}
	public void setIdDosis(int idDosis) {
		this.idDosis = idDosis;
	}
	public String getVacunatorio() {
		return vacunatorio;
	}
	public void setVacunatorio(String vacunatorio) {
		this.vacunatorio = vacunatorio;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Vacuna getVacuna() {
		return vacuna;
	}
	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "idDosis=" + idDosis + ", vacunatorio=" + vacunatorio + ", fecha=" + fecha + ", hora=" + hora;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDosis;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		return ((Dosis)obj).getIdDosis()==this.getIdDosis();
	}
	
	
	
	
	
	
	
}
