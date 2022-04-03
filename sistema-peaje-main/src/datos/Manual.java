package datos;

import java.time.LocalDate;
import java.util.List;

public class Manual extends Peaje{

	private int idManual;
	private String codCabina;
	
	public Manual() {
		super();
	}
	public Manual(LocalDate fecha, String hora, double precio, String codCabina) {
		super(fecha, hora, precio);
		this.codCabina = codCabina;
	}
	public int getIdManual() {
		return idManual;
	}
	protected void setIdManual(int idManual) {
		this.idManual = idManual;
	}
	public String getCodCabina() {
		return codCabina;
	}
	public void setCodCabina(String codCabina) {
		this.codCabina = codCabina;
	}
	@Override
	public String toString() {
		return "idManual=" + getIdPeaje() + ", codCabina=" + codCabina + "\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idManual;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		return ((Manual)obj).getIdManual()==this.getIdManual();
	}
	 
	public double cerrarCaja(List<Manual> manuales) {
		
		double total=0;
		
		 for (int i=0;i<manuales.size();i++) {
		      
			 total=total+manuales.get(i).getPrecio();
			 
		 }
		
		return total;
	}
	
	
	
}
