package negocio;


import java.time.LocalDate;
import java.util.List;

import dao.InspeccionDao;
import datos.Automotor;
import datos.Inspeccion;
import datos.Inspector;

public class InspeccionABM {

	InspeccionDao dao=new InspeccionDao();
	
	//TRAER
		public Inspeccion traerInspeccion(int idInspeccion)throws Exception{
			if(dao.traerInspeccion(idInspeccion)==null)throw new Exception("Error: no existe la inspeccion con el id: "+idInspeccion);
			
			Inspeccion i = dao.traerInspeccion(idInspeccion);
			return i;
		}
	
		public List<Inspeccion> traerInspeccion(LocalDate fecha)throws Exception{
			if(dao.traerInspeccion(fecha).isEmpty()==true)throw new Exception("La fecha "+fecha+" no tiene ningun inspeccion");
			return dao.traerInspeccion(fecha);
		}
		
		public List<Inspeccion> traerInspeccion(Inspector inspector, LocalDate fecha)throws Exception{
			if(dao.traerInspeccion(inspector, fecha).isEmpty()==true)throw new Exception("La fecha "+fecha+" no tiene ningun inspeccion");
			
			return dao.traerInspeccion(inspector, fecha);
			
		}
		
		public List<Inspeccion> traerInspeccion (LocalDate fecha, String estado)throws Exception{
			if(dao.traerInspeccion(fecha, estado).isEmpty()==true)throw new Exception("La fecha "+fecha+" no tiene ningun inspeccion");
			return dao.traerInspeccion(fecha, estado);
		}
		
		public List<Inspeccion> traerInspeccion (Automotor automotor)throws Exception{
			if(dao.traerInspeccion(automotor).isEmpty()==true)throw new Exception("El rodado no tiene ninguna inspeccion");

			return dao.traerInspeccion(automotor);
			
		}
		
	
}
