package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.DosisDao;
import datos.Dosis;
import datos.Persona;



public class DosisABM {

	DosisDao dao = new DosisDao();
	
	
	public List<Dosis> traer(Persona p)throws Exception {
		
		List<Dosis> dosis = dao.traer(p);
		return dosis;
		
	}


public List<Dosis> traer(LocalDate fechaDesde, LocalDate fechaHasta){
	return dao.traer(fechaDesde, fechaHasta);
		
}


public List<Dosis> traer(LocalDate fechaDesde, LocalDate fechaHasta, boolean tieneComorbilidad) {
	
	return dao.traer(fechaDesde, fechaHasta, tieneComorbilidad);
}




}
