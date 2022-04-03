package test;

import java.time.LocalDate;
import negocio.ClienteABM;

public class TestAgregarCliente {
	
	public static void main(String[] args ) {
		String apellido = "tu apellido" ;
		String nombre = "tu nombre" ;
		int documento = 35000000;
		// tu fecha de nacimiento
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 6, 29);
		ClienteABM abm = new ClienteABM();
		
		try {
			long ultimoIdCliente = abm .agregar( apellido , nombre , documento ,fechaDeNacimiento );
			System.out.println(ultimoIdCliente);
		}catch(Exception e) {
			System.out.println(e.getMessage() );
		}
		
	}
	
}