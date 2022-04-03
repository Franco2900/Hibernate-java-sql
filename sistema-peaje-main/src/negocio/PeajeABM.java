package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PeajeDao;
import datos.Abonado;
import datos.Manual;

import datos.Rodado;
import datos.Telepeaje;


public class PeajeABM {
	
	private static PeajeABM instancia=null;// Patrón Singleton 1/3
	protected PeajeABM() {}// 2/3

	public static PeajeABM getInstance(){ // 3/3
	if(instancia==null)
	instancia=new PeajeABM();
	return instancia;
	}
	
	public List<Manual> traerManual(){
		return PeajeDao.getInstance().traerManual();
		}
	public List<Telepeaje> traerTelepeaje(){
		return PeajeDao.getInstance().traerTelepeaje();
		}
	
	public List<Manual> traerManualFecha(LocalDate fecha){
		return PeajeDao.getInstance().traerManualFecha(fecha);
		}
	
	public List<Telepeaje> traerTelepeaje(Rodado rodado)throws Exception {
		
		List<Telepeaje> telepeaje = PeajeDao.getInstance().traerTelepeaje(rodado);
		return telepeaje;
		
		
	}
	
public List<Telepeaje> traerTelepeaje(Abonado abonado)throws Exception {
		
		List<Telepeaje> telepeaje = PeajeDao.getInstance().traerTelepeaje(abonado);
		return telepeaje;
		
		
	}
	
	public double cerrarCaja(LocalDate fecha) {
		
		List<Manual> manuales = PeajeDao.getInstance().traerManualFecha(fecha);
			
		return manuales.get(0).cerrarCaja(manuales);
		
	}
	
	
	
}//fin clase
