package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;
import negocio.EventoABM;

public class TestEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventoABM eventoABM = new EventoABM();
		ClienteABM clienteABM = new ClienteABM();
		
		//  agregar eliminar y agregar evento ok
		//	Agregar un cliente a un evento  ok
		//	A partir de los parámetro idCliente y idEvento:
		//	traer el cliente
		//	traer evento y sus clientes ok
		//	agregar el cliente a un evento y actualizar ok
		//	Eliminar un cliente a un evento y actualizar ok
		
		
		
		

		//caso de uso 1
		try {
			
			println("Caso de uso 1: Agregar un evento");
			
			//eventoABM.agregar("cumple Sara", LocalDate.of(2021, 9, 12));
			
			println(eventoABM.traer(2));
			
			println("Caso de uso correcto");
		}catch(Exception e) {
			println("Exception: "+e.getMessage());
		}
		
		//caso de uso 2
				try {
					
					println("Caso de uso 2: Modificar evento");
					
					Evento ev = eventoABM.traer(9);
					
					ev.setEvento("Cumpleaños de Sara");
					
					//eventoABM.actualizar(ev);
					
					println(eventoABM.traer(1));
					
					println("Caso de uso correcto");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
		
		//caso de uso 3
				try {
					
					println("Caso de uso 3: eliminar eventos");
					
					Evento e1 = eventoABM.traer(5);
					Evento e2 = eventoABM.traer(6);
					Evento e3 = eventoABM.traer(7);
					Evento e4 = eventoABM.traer(8);
					
					eventoABM.eliminar(e1);
					eventoABM.eliminar(e2);
					eventoABM.eliminar(e3);
					eventoABM.eliminar(e4);
					
					
					println("Caso de uso correcto");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
				//caso de uso 4
				try {
					
					println("Caso de uso 4: agregar a un evento un cliente ");
					
					eventoABM.agregarClienteAEvento(eventoABM.traer(2), clienteABM.traer(38526503));
					
					Evento e =eventoABM.traerEventoyClientes(eventoABM.traer(2));
					
					println("Evento:");
					println(e);
					println("Clientes:");
					println(e.getClientes());
					
					println("Caso de uso correcto");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
		
				//caso de uso 5
				try {
					
					println("Caso de uso 5: eliminar a un evento un cliente ");
					
					
					Evento e =eventoABM.traerEventoyClientes(eventoABM.traer(2));
					Cliente c = clienteABM.traer(38526503);
							
					eventoABM.eliminarClienteAEvento(e, c);
					
					e =eventoABM.traerEventoyClientes(eventoABM.traer(2));
					
					println("Evento:");
					println(e);
					println("Clientes:");
					println(e.getClientes());
					
					println("Caso de uso correcto");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
		
		
		
	}//fin main
	static void println(Object line) {
	    System.out.println(line);
	}
}// fin clase evento
