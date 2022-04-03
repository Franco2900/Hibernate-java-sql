package datos;

public class Inspector extends Persona {

	private int idInspector;
	private int legajo;
	public Inspector() {
		super();
	}
	public Inspector(String apellido, String nombres, int dni, int legajo) {
		super(apellido,nombres, legajo);
		this.legajo = legajo;
	}
	public int getIdInspector() {
		return idInspector;
	}
	protected void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	@Override
	public String toString() {
		return "Inspector [idInspector=" + this.getIdPersona() + ", legajo=" + legajo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idInspector;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
	
		return ((Inspector)obj).getIdInspector() == this.getIdInspector();
	}
	
	
	
	
	
	
	
}
