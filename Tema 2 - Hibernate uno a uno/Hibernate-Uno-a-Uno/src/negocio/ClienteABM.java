package negocio;
import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, Contacto contacto) throws Exception {
		if(traer(dni) != null) {
			throw new Exception("No se puede agregar el cliente. El DNI ya existe");
		}
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento, contacto);
		return dao.agregar(c);
	}
	
	public void modificar(Cliente c) throws Exception {
		if(traer(c.getDni()) == null) {
			throw new Exception("No se puede modificar el Cliente. El dni no existe");
		} else if(traer(c.getIdCliente()) == null) {
			throw new Exception("No se puede modificar el Cliente. El id no existe");
		}
		dao.actualizar(c);
	}
	
	public void eliminar(long idCliente) throws Exception {

		Cliente c = dao.traer(idCliente);
		if(c == null) {
			throw new Exception("No se pudo realizar la operacion. El cliente no existe");
		}
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}

	public Cliente traerClienteYContacto(long idCliente) throws Exception {
		Cliente c = dao.traerClienteYContacto(idCliente);
		if(c == null) {
			throw new Exception("No se pudo realizar la operacion. El cliente no existe");
		}
		return c;
	}
}
