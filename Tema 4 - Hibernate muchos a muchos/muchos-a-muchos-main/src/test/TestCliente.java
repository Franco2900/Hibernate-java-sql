package test;



import java.time.LocalDate;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;
import negocio.EventoABM;

public class TestCliente {

	public static void main(String[] args) {
		
		ClienteABM clienteABM = new ClienteABM();
		EventoABM	eventoABM = new EventoABM();
		//Casos de uso
		// agregar actualizar y eliminar cliente listo
		//Traer un cliente y los eventos
		//Agregar un evento a un cliente y actualizar
		//Eliminar un evento a un cliente
		
		
		
		//caso de uso 1
		try {
			
			print("Caso de uso 1: Agregar un cliente");
			
			clienteABM.agregar("Flores", "Federico", 38526504,LocalDate.of(1994, 07, 27));
			
			print("Caso de uso correcto");
		}catch(Exception e) {
			print("Exception: "+e.getMessage());
		}
		//caso de uso 2
		try {
			
			print("Caso de uso 2: traer un cliente por dni");
			
			print(clienteABM.traer(38526503));
			print(clienteABM.traerId(3));
			
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
//		caso de uso 3 
	try {
			
			print("Caso de uso 3: actualizar cliente");
			
			Cliente c = clienteABM.traerId(4);
			c.setDni(38526503);
			clienteABM.actualizarCliente(c);
			print("Caso de uso correcto");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
	//	caso de uso 4 
	try {
		
		print("Caso de uso 4: eliminar cliente");
		
		//clienteABM.eliminar(clienteABM.traerId(3));
		print("Caso de uso correcto");
	}catch(Exception e) {
		System.out.println("Exception: "+e.getMessage());
	}
		
	//	caso de uso 5 
	try {
		
		print("Caso de uso 5: traer un cliente y sus eventos");
		
		eventoABM.agregar("Cumpleaños Sofia", LocalDate.of(2021,7,14));
		eventoABM.agregar("Cumpleaños Nahuel", LocalDate.of(2021,8,05));
		
 
		clienteABM.agregarEventoACliente(clienteABM.traer(38526503), eventoABM.traer(3));
		clienteABM.agregarEventoACliente(clienteABM.traer(38526503), eventoABM.traer(4));
		
		
		Cliente c = clienteABM.traerClienteyEventos(clienteABM.traer(38526503));
		print("Cliente");
		print(c.toString());
		print("Eventos");
		print(c.getEventos());
	}catch(Exception e) {
		System.out.println("Exception: "+e.getMessage());
	}
		
//	caso de uso 6
	try {
		
		print("Caso de uso 6: eliminar un evento a un cliente");
		
		clienteABM.eliminarEventoACliente(clienteABM.traer(38526503), eventoABM.traer(4));
		
		Cliente c = clienteABM.traerClienteyEventos(clienteABM.traer(38526503));
		print("Cliente");
		print(c.toString());
		print("Eventos");
		print(c.getEventos());
		
	}catch(Exception e) {
		System.out.println("Exception: "+e.getMessage());
	}
	
	
	
	}//fin main
	static void print(Object line) {
	    System.out.println(line);
	}
}//fin clase test
