package datos;

public class Contribuyente extends Persona{

	
	private int idContribuyente;
	private boolean esExcento;
	public Contribuyente() {
		super();
	}
	public Contribuyente(String apellido, String nombres, int dni, boolean esExcento) {
		super(apellido, nombres, dni);
		this.esExcento = esExcento;
	}
	public int getIdContribuyente() {
		return idContribuyente;
	}
	protected void setIdContribuyente(int idContribuyente) {
		this.idContribuyente = idContribuyente;
	}
	public boolean isEsExcento() {
		return esExcento;
	}
	public void setEsExcento(boolean esExcento) {
		this.esExcento = esExcento;
	}
	@Override
	public String toString() {
		return "Contribuyente [idContribuyente=" + this.getIdPersona() + ", esExcento=" + esExcento + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idContribuyente;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		return ((Contribuyente)obj).getIdContribuyente() == this.getIdContribuyente();
	
	
	
	
	
	
	
	
	}
	
}
