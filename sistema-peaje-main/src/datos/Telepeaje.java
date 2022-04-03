package datos;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;


public class Telepeaje extends Peaje {

	private int idTelepeaje; 
	private String lector;
	private Rodado rodado;
	
	public Telepeaje() {
		super();
	}
	public Telepeaje(LocalDate fecha, String hora, double precio, String codCabina, String lector, Rodado rodado) {
		super(fecha, hora, precio);
		this.lector = lector;
	}
	public int getIdTelepeaje() {
		return idTelepeaje;
	}
	protected void setIdTelepeaje(int idTelepeaje) {
		this.idTelepeaje = idTelepeaje;
	}
	public String getLector() {
		return lector;
	}
	public void setLector(String lector) {
		this.lector = lector;
	}
	public Rodado getRodado() {
		return rodado;
	}
	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}
	@Override
	public String toString() {
		return "idTelepeaje=" + getIdPeaje() + ", lector=" + lector + "\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idTelepeaje;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
	
		return ((Telepeaje)obj).getIdTelepeaje()==this.getIdTelepeaje();
	}
	
	public double calcularDescuento(double porcentajeDescuento) {
		LocalDate fecha = this.getFecha();
		double precio = this.getPrecio();
		
		LocalTime hora = LocalTime.parse(this.getHora());
	
		
		double descuento = 0;
		
		if((fecha.getDayOfWeek()== DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY) || (hora.getHour()<=7 || hora.getHour()>=19)) {
			descuento = precio*(porcentajeDescuento*0.01);
		}else {
			descuento = 0;
			}
		
		return descuento;
	}
	
	
	
}
