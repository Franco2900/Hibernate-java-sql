package negocio;

import dao.PersonaDao;
import datos.Persona;

public class PersonaABM {
	
	PersonaDao dao = new PersonaDao();
	
	public Persona traer(long documento) {
		Persona p = dao.traer(documento);
		return p;
	}
}
