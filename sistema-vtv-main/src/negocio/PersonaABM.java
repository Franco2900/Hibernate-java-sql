package negocio;

import dao.PersonaDao;
import datos.Persona;

public class PersonaABM {

	private static PersonaABM instancia=null;// Patrón Singleton 1/3
	protected PersonaABM() {}// 2/3

	public static PersonaABM getInstance(){ // 3/3
	if(instancia==null)
	instancia=new PersonaABM();
	return instancia;
	}
	
	
	public Persona traerContribuyente(int idCliente){
		return PersonaDao.getInstance().traerContribuyente(idCliente);
		}
	
	
	public Persona traerInspector(int idCliente){
		return PersonaDao.getInstance().traerInspector(idCliente);
		}
	
	
}
