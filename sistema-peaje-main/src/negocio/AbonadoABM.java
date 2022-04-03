package negocio;

import dao.AbonadoDao;
import datos.Abonado;


public class AbonadoABM {

	
	AbonadoDao dao=new AbonadoDao();
	
	//TRAER

	public Abonado traer(int dni) throws Exception{
		if(dao.traer(dni)==null)throw new Exception("No existe el abonado con dni "+dni);
		Abonado a = dao.traer(dni);
		return a;
	}
}// fin abm
