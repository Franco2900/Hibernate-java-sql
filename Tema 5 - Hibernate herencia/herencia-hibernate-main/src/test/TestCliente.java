package test;
import datos.Cliente;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import negocio.ClienteABM;
public class TestCliente {

	public static void main(String[] args) {

		//Caso de uso 1*******************************
		try {
			System.out.println("");
			System.out.println("Caso de uso 1: mostrar clientes");
			
			System.out.println("Clientes:");
			System.out.println("Metodo traer Cliente ("+1+")");
			System.out.println(ClienteABM.getInstance().traer(1));
			
			System.out.println("\nMetodo traer Cliente("+2+")");
			System.out.println(ClienteABM.getInstance().traer(2));
			
			System.out.println("\nMetodo traer() - todos los clientes");
			for (Cliente c: ClienteABM.getInstance().traer()) {
			System.out.println(c);
			}
					
			
			System.out.println("Caso de uso correcto");
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Caso de uso 2: agregar");
			
			System.out.println("Agregar persona fisica");
			
			
			
		
			
			System.out.println("\nAgregar persona fisica");
			ClienteABM.getInstance().agregarPersonaFisica("2A", "Flores", "Federico", 38526503);
	
	
			
			System.out.println("\nTraer Cliente");
			System.out.println(ClienteABM.getInstance().traerDni(38526503));

			
		
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		try {
			System.out.println("");
			System.out.println("Caso de uso 2.1: agregar");
			
			
			
			
		
			System.out.println("\nAgregar persona juridica");

			ClienteABM.getInstance().agregarPersonaJuridica("3Z", "Accenture", "40506070213");
			
			System.out.println("\nTraer Cliente");
			
			System.out.println(ClienteABM.getInstance().traerCuit("40506070213"));
			
		
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Caso de uso 3: modificar");
			
			System.out.println("Modificar persona fisica");
			PersonaFisica p1= (PersonaFisica)ClienteABM.getInstance().traerDni(38526503);
			p1.setApellido("F");
			
			ClienteABM.getInstance().modificar(p1);
			System.out.println("\nModificar persona juridica");
			
			PersonaJuridica p2 = (PersonaJuridica)ClienteABM.getInstance().traerCuit("3040313135");
			p2.setRazonSocial("Apple");
			
			ClienteABM.getInstance().modificar(p2);
			
			System.out.println("\nTraer Clientes");
			System.out.println(ClienteABM.getInstance().traerDni(38526503));
			System.out.println(ClienteABM.getInstance().traerCuit("3040313135"));
			
			System.out.println("Caso de uso correcto");
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Caso de uso 4: eliminar");
			
			System.out.println("Agrego una persona");
			//System.out.println(ClienteABM.getInstance().agregar("5g", "Gonzales", "Marcos", 99049170));
			//System.out.println(ClienteABM.getInstance().agregarPersonaJuridica("3Z", "Accenture", "40506070213"));
			//System.out.println(ClienteABM.getInstance().agregar("1N", "Tenaris", "304031666"));
			
			Cliente c = ClienteABM.getInstance().traerCuit("40506070213");
			
			System.out.println(ClienteABM.getInstance().traerCuit("40506070213"));
			
			System.out.println("Eliminar cliente"+c);
			ClienteABM.getInstance().eliminar(c);
			
			System.out.println("\nTraer Cliente eliminado");
			
		
			System.out.println(ClienteABM.getInstance().traerCuit("40506070213"));
			
		
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		

	}

}
