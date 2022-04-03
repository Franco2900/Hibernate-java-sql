package test;

import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {
	
	public static void main(String[] args ) {
		
		PrestamoABM prestamoABM = new PrestamoABM();
		long idPrestamo =1;
		System. out .println("\n---> TraerPrestamo idPrestamo=" + idPrestamo +"\n\n");
		
		try {
			Prestamo p = prestamoABM .traerPrestamo(idPrestamo);
			System. out .println(p + "\nPertenece a " + p .getCliente() );
		}catch(Exception e) {
			System.out.println(e.getMessage() );
		}

		ClienteABM clienteABM = new ClienteABM();
		int dni =14000000;
		Cliente c = clienteABM .traer(dni);
		System. out .println( "\n---> TraerPrestamos del Cliente=" + c + "\n\n" );
		
		// implementar Si este cliente no tiene prestamos otorgados imprima eL mensaje
		try {
			List<Prestamo> prestamos = prestamoABM .traerPrestamo( c );
			for (Prestamo o : prestamos) 
				System. out .println( o + "\nPertenece a " + o .getCliente());
		}catch(Exception e) {
			System.out.println(e.getMessage() );
		}
		
		
	}
}