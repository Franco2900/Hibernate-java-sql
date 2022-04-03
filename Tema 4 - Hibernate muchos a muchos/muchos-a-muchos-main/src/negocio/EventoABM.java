package negocio;


import java.time.LocalDate;

import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class EventoABM {

	EventoDao dao = new EventoDao();
	
	public Evento traer(long idEvento) {
		Evento e = dao.traer(idEvento);
		return e;
		}
	
	public void actualizar(Evento e) {
		dao.actualizar(e);
	}
	
	public void eliminar(Evento e) throws Exception{
		if(dao.traer(e.getIdEvento())==null)throw new Exception("El evento no existe "+e.getEvento());
		dao.eliminar(e);
	}
	

	public int agregar(String evento, LocalDate fecha)throws Exception{
		Evento e = new Evento(evento,fecha);
		
		return dao.agregar(e);
		}
	
	public void agregarClienteAEvento(Evento e,Cliente c) {
		
		e = dao.traerEventoYClientes(e.getIdEvento());
		e.getClientes().add(c);
		dao.actualizar(e);
	}
	
	public Evento traerEventoyClientes(Evento e){
		
		return dao.traerEventoYClientes(e.getIdEvento());
		}
	
	public void agregarEventoACliente(Evento e, Cliente c) {
	
	e = dao.traerEventoYClientes(e.getIdEvento());
	e.getClientes().add(c);
	dao.actualizar(e);
	
	}
	
public void eliminarClienteAEvento(Evento e,Cliente c) {
		
		e = dao.traerEventoYClientes(e.getIdEvento());
		e.getClientes().remove(c);
		dao.actualizar(e);
	}
	
	
	
//  agregar eliminar y agregar evento ok
//	Agregar un cliente a un evento ok
//	A partir de los parámetro idCliente y idEvento:
//	traer el cliente
//	traer evento y sus clientes ok
//	agregar el cliente a un evento y actualizar ok
//	Eliminar un cliente a un evento y actualizar ok
	
	
	

}
