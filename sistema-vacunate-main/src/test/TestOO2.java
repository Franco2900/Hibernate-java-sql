package test;

import java.time.LocalDate;
import java.util.List;

import datos.Dosis;
import datos.Persona;
import datos.Vacuna;
import negocio.DosisABM;
import negocio.PersonaABM;
import negocio.VacunaABM;

public class TestOO2 {

	public static void main(String[] args) {
		
		
		PersonaABM personaABM = new PersonaABM();
		DosisABM dosisABM = new DosisABM();
		VacunaABM vacunaABM = new VacunaABM();	
		
		//TEST 1*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 1: traer persona por documento ");
			
			System.out.println(personaABM.traer(33333333));
			
			
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		//TEST 2*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 2: traer las vacunas fabricadas entre 1 y 2 meses ");
			
			Vacuna AstraZeneca = vacunaABM.traer(4);
			Vacuna SputnikV = vacunaABM.traer(1);
			
			System.out.println(AstraZeneca);
			System.out.println(AstraZeneca.calcularMesesElaboracion(LocalDate.now()));
			
			System.out.println(SputnikV);
			System.out.println(SputnikV.calcularMesesElaboracion(LocalDate.now()));
			
			System.out.println(vacunaABM.traerVacuna(1, 2));
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		//TEST 3*******************************
		try {
			System.out.println("Caso de uso 3: traer dosis que se hayan aplicado a una persona");
			
			Persona persona1 = personaABM.traer(33333333);
			List<Dosis> dosis = dosisABM.traer(persona1);
			
			System.out.println("\nDatos de las Dosis:");
			for (int i=0;i<dosis.size();i++) {
			System.out.println("Dosis: "+dosis.get(i));	
			System.out.println("Persona: "+dosis.get(i).getPersona());
			System.out.println("Vacuna: "+dosis.get(i).getVacuna()+"\n");
			}
			
			
		
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
	
		}
		//TEST 4*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 4: traer dosis aplicadas entre fecha y fecha");
			List<Dosis> dosis = dosisABM.traer(LocalDate.of(2020, 06, 01),LocalDate.of(2020, 06, 15));
			
			System.out.println("\nDatos de las Dosis:");
			for (int i=0;i<dosis.size();i++) {
				System.out.println("Dosis: "+dosis.get(i));	
				System.out.println("Persona: "+dosis.get(i).getPersona());
				System.out.println("Vacuna: "+dosis.get(i).getVacuna()+"\n");
				}

			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
	
		}
		//TEST 5*******************************
				try {
					System.out.println("");
					System.out.println("Caso de uso 5: traer dosis aplicadas entre fecha y fecha con comorbilidades ");
					List<Dosis> dosis =dosisABM.traer(LocalDate.of(2020, 06, 01),LocalDate.of(2020, 06, 15), true);
					
					System.out.println("\nDatos de las Dosis:");
					for (int i=0;i<dosis.size();i++) {
						System.out.println("Dosis: "+dosis.get(i));	
						System.out.println("Persona: "+dosis.get(i).getPersona());
						System.out.println("Vacuna: "+dosis.get(i).getVacuna()+"\n");
						}
		
					System.out.println("");
				}catch(Exception e) {
					System.out.println("Exception: "+e.getMessage());
			
				}
			
				
	}//fin main

}//fin clase Test
