package negocio;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import dao.VacunaDao;
import datos.Vacuna;

public class VacunaABM {
	
	VacunaDao dao = new VacunaDao();
	
	public Vacuna traer(int id) {
		return dao.traer(id);
	}
	
	public List<Vacuna> traerVacuna(int mesesDesde,int mesesHasta){
		List<Vacuna> filtrado = new ArrayList<Vacuna>();
		List<Vacuna> completa = dao.traer();
		int meses=0;
		
		  for (int i=0;i<completa.size();i++) {
		      meses=completa.get(i).calcularMesesElaboracion(LocalDate.now());
		      if(meses>=mesesDesde && meses<mesesHasta) {
		    	  //1>=1 && 1<=2
		    	  filtrado.add(completa.get(i));
		      }
		    }
		
		return filtrado;
	}
	
	
	
	}
