package negocio;

import java.time.LocalDate;


import dao.ClienteDao;
import datos.Cliente;
import datos.Evento;

public class ClienteABM {

	ClienteDao dao = new ClienteDao();
	
	public Cliente traerId(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
		}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
		}	
	
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento)throws Exception{
		if(dao.traer(dni)!=null)throw new Exception("Error: el cliente que quiere agregar ya se encuentra en la bd"+nombre+" "+dni);
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
		}
	
	public void eliminar(Cliente c)throws Exception{
		if(dao.traer(c.getDni())==null)throw new Exception("Error: el cliente que se quiere eliminar no existe"+c.getNombre()+" "+c.getDni());
		
		dao.eliminar(c);
		}
	
	public Cliente traerClienteyEventos(Cliente c){
		
		return dao.traerClienteYEventos(c.getIdCliente());
		}
	
	public void agregarEventoACliente(Cliente c, Evento e) {
		
		c = dao.traerClienteYEventos(c.getIdCliente());
		c.getEventos().add(e);
		dao.actualizar(c);
	}
	
	public void actualizarCliente(Cliente c) throws Exception{
		//if(dao.traer(c.getDni())!=null)throw new Exception("ERROR: el dni del cliente ingresado se encuentra repetido "+c.getDni());
	
		dao.actualizar(c);
	}
	
public void eliminarEventoACliente(Cliente c, Evento e) {
		
		c = dao.traerClienteYEventos(c.getIdCliente());
		c.getEventos().remove(e);
		dao.actualizar(c);
	}
	

	//casos de uso
	// agregar actualizar y eliminar cliente listo
	
	//Traer un cliente y los eventos
	//Agregar un evento a un cliente y actualizar
	//Eliminar un evento a un cliente
	
	
	
	
}
