package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;


public class ClienteDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(final HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(final Cliente objeto) throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (final HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(final Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion(); 			//Llama m�todo para abrir sesi�n
			session.update(objeto); 	//Actualiza la base de datos con lo que hicimos en Eclipse
			tx.commit(); 				//Guarda todos los cambios hechos - Es como un punto de control
		} catch (final HibernateException he) {
			manejaExcepcion(he); 		//En caso de error deshace todos los cambios
			throw he; 					//Muestra mensaje de error
		} finally {
			session.close();			//Cierra sesi�n pase lo que pase
		}
	}

	public void eliminar(final Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (final HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Cliente traer(final long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Cliente traer(final int dni) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c order by c.apellido asc,c.nombre asc").list();
		} finally {
			session.close();
		}
		return lista;
	}

	
	
	public Cliente traerClienteYPrestamos(long idCliente) throws HibernateException {
		Cliente objeto = null ;
		try {
			iniciaOperacion(); //Abre sesi�n
			String hql = "from Cliente c where c.idCliente =" + idCliente; //Consulta de datos
			objeto =(Cliente) session .createQuery(hql).uniqueResult(); 
			//B�squeda de la consulta en la base de datos
			Hibernate.initialize(objeto.getPrestamos());
		}
		finally {
			session .close();  //Cierra sesi�n
		}
		return objeto ;
	}
	
}
