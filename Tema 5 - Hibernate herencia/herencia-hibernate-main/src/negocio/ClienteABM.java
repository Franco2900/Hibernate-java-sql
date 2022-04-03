package negocio;
import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;
import datos.PersonaFisica;
import datos.PersonaJuridica;

public class ClienteABM {
	
private static ClienteABM instancia=null;// Patrón Singleton 1/3

protected ClienteABM() {}//herencia 2/3

public static ClienteABM getInstance(){ //herencia 3/3
if(instancia==null)
instancia=new ClienteABM();// la instancia es de ClienteABM por el patron singleton
return instancia;
}



//AGREGAR
	public int agregarPersonaFisica(String nroCliente, String apellido, String nombre, int dni)throws Exception {
		if(ClienteDao.getInstance().traer((long)dni)!=null) throw new Exception("Error: el dni ya se encuentra cargado en la base de datos "+dni);

	Cliente c = new PersonaFisica(nroCliente, apellido, nombre, dni);

	return ClienteDao.getInstance().agregar(c);
	}

	public int agregarPersonaJuridica(String nroCliente, String razonSocial, String cuit)throws Exception {
		PersonaJuridica p = (PersonaJuridica)(ClienteDao.getInstance().traer(cuit));
	
		if(p!=null) {
		if(p.getCuit().compareTo(cuit)==0) throw new Exception("Error: el cuit ya se encuentra cargado en la base de datos "+cuit);
		}
		Cliente c = new PersonaJuridica(nroCliente, razonSocial, cuit);
		
		return ClienteDao.getInstance().agregar(c);
	}


//TRAER
public Cliente traer(int idCliente){
return ClienteDao.getInstance().traer(idCliente);
}
public Cliente traerDni(long dni){
return ClienteDao.getInstance().traer(dni);
}
public Cliente traerCuit(String cuit){
return ClienteDao.getInstance().traer(cuit);
}
public List<Cliente> traer(){
return ClienteDao.getInstance().traer();
}

//MODIFICAR
public void modificar(Cliente c)throws Exception {

ClienteDao.getInstance().actualizar(c);
}

//ELIMINAR
public void eliminar(Cliente c)throws Exception {

ClienteDao.getInstance().eliminar(c);
}

}//FIN CLASE