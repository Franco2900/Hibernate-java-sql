package negocio;

import dao.AutomotorDao;
import datos.Automotor;



public class AutomotorABM {

	
	AutomotorDao dao=new AutomotorDao();
	
	//TRAER
		public Automotor traerAutomotor(String dominio)throws Exception{
			if(dao.traerAutomotor(dominio)==null)throw new Exception("Error: no existe el automotor con el dominio: "+dominio);
			
			Automotor a = dao.traerAutomotor(dominio);
			return a;
		}
	
	
}
