package negocio;

import dao.RodadoDao;
import datos.Rodado;

public class RodadoABM {

	
	RodadoDao dao=new RodadoDao();
	
	//TRAER
		public Rodado traerRodado(String dominio)throws Exception{
			if(dao.traerRodado(dominio)==null)throw new Exception("Error: no existe el rodado con el dominio: "+dominio);
			
			Rodado r = dao.traerRodado(dominio);
			return r;
		}
	
}// fin abm
