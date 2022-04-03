package test;

import java.time.LocalDate;
import java.util.List;

import datos.Telepeaje;
import negocio.AbonadoABM;
import negocio.PeajeABM;
import negocio.RodadoABM;

public class TestOO2 {


	public static void main(String[] args) {
		
		RodadoABM rodadoABM = new RodadoABM();
		AbonadoABM abonadoABM = new AbonadoABM();
		
		//Caso de uso 1*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 1: traer todos los peajes manuales");
			System.out.println(PeajeABM.getInstance().traerManual());
			

			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		//Caso de uso 2*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 2: traer todos los telepeajes ");
			
					
			List<Telepeaje> telepeajes = PeajeABM.getInstance().traerTelepeaje();
			
			 for (int i=0;i<telepeajes.size();i++) {
				 
			System.out.println("Telepeajes");
			System.out.print(telepeajes.get(i));
			System.out.print("Descuento: ");
			System.out.print(telepeajes.get(i).calcularDescuento(10)+"\n \n");
			
			 }
		
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		//Caso de uso 3*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 3: traer por fecha peaje manual (fecha 01/11/2020)");
			
			System.out.println("Manuales");
			System.out.println(PeajeABM.getInstance().traerManualFecha(LocalDate.of(2020, 11, 01)));
			
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
	
		}
		//Caso de uso 4*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 4: Cerrar por fecha la caja de los manuales  (fecha 01/11/2020)");
			
			System.out.print("Valor diario: ");
			System.out.println(PeajeABM.getInstance().cerrarCaja(LocalDate.of(2020, 11, 01)));
			
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
	
		}
		//Caso de uso 5*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 5: Traer por dominio (dominio de rodado = AAA111)");
			
			String dominio = "AAA111";
			
			System.out.println(rodadoABM.traerRodado(dominio));
			
			
			
			
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
	
		}
		//Caso de uso 6*******************************
				try {
					System.out.println("");
					System.out.println("Caso de uso 6: traer telepeajes por rodado");
					System.out.println("Telepeajes");
					System.out.println(PeajeABM.getInstance().traerTelepeaje(rodadoABM.traerRodado("AAA111")));
					
					
				
					System.out.println("");
				}catch(Exception e) {
					System.out.println("Exception: "+e.getMessage());
			
				}
		//Caso de uso 7*******************************
				try {
					System.out.println("");
					System.out.println("Caso de uso 7: traer abonado por dni");
					
					
					System.out.println(abonadoABM.traer(11111111));
				
				
					
					System.out.println("");
				}catch(Exception e) {
					System.out.println("Exception: "+e.getMessage());
			
				}
		//Caso de uso 8*******************************
				try {
					System.out.println("");
					System.out.println("Caso de uso 8: traer telepeajes por abonado");
					
					List<Telepeaje> telepeajes = PeajeABM.getInstance().traerTelepeaje(abonadoABM.traer(11111111));
						System.out.println("Abonado");
						System.out.println(abonadoABM.traer(11111111));
						System.out.println("Telepeajes");
						for (int i=0;i<telepeajes.size();i++) {
						 
							
							System.out.print(telepeajes.get(i));
							System.out.print("Descuento: ");
							System.out.println(telepeajes.get(i).calcularDescuento(20)+"\n");
							
							 }
					
					
					System.out.println("");
				}catch(Exception e) {
					System.out.println("Exception: "+e.getMessage());
			
				}
		
		
	}//fin main
}//fin clase
