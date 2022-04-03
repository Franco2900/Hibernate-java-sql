package test;

import java.time.LocalDate;

import datos.Inspector;
import negocio.AutomotorABM;
import negocio.InspeccionABM;
import negocio.PersonaABM;

public class TestOO2 {

	public static void main(String[] args) {
		
		AutomotorABM automotorABM = new AutomotorABM();
		
		InspeccionABM inspeccionABM = new InspeccionABM();
		
		//Caso de uso 1*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 1: traer contribuyente");
			
			System.out.println(PersonaABM.getInstance().traerContribuyente(2));
			
		
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		//Caso de uso 2*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 2: traer inspector");
			System.out.println(PersonaABM.getInstance().traerInspector(1));
			
			
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		//Caso de uso 3*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 3: traer rodado por dominio");
		
			System.out.println(automotorABM.traerAutomotor("LLL444"));
			
			
		
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
	
		}
		//Caso de uso 4*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 4: traer inspeccion ");
		
			System.out.println(inspeccionABM.traerInspeccion(1));
			

			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
	
		}
		//Caso de uso 5*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 5: traer inspeccion por automotor");
		
			System.out.println(inspeccionABM.traerInspeccion(automotorABM.traerAutomotor("LLL444")));
			

			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
	
		}
		//Caso de uso 6*******************************
				try {
					System.out.println("");
					System.out.println("Caso de uso 6: traer inspeccion por fecha");
					
					System.out.println(inspeccionABM.traerInspeccion(LocalDate.of(2021, 2, 11)));
					
	
					System.out.println("");
				}catch(Exception e) {
					System.out.println("Exception: "+e.getMessage());
			
				}
		//Caso de uso 7*******************************
				try {
					System.out.println("");
					System.out.println("Caso de uso 7: traer inspeccion por inspector y por fecha ");
									
					System.out.println(inspeccionABM.traerInspeccion((Inspector) PersonaABM.getInstance().traerInspector(1), LocalDate.of(2021, 2, 11)));
					
					System.out.println("");
				}catch(Exception e) {
					System.out.println("Exception: "+e.getMessage());
			
				}
		//Caso de uso 8*******************************
				try {
					System.out.println("");
					System.out.println("Caso de uso 8: traer inspeccion por fecha y por string 'apto' ");
				
					System.out.println(inspeccionABM.traerInspeccion(LocalDate.of(2021, 2, 11),"apto"));
					
				
					System.out.println("");
				}catch(Exception e) {
					System.out.println("Exception: "+e.getMessage());
			
				}				
				
	}//fin main

}//fin clase Test
