package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;

public class PersonaDao {

	//atributos
	private static Session session;
	private Transaction tx;

	//inicia la conexion con la bd
	private void iniciaOperacion() throws HibernateException {
	session = HibernateUtil.getSessionFactory().openSession();
	tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
	tx.rollback();
	throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	public Persona traer(long documento) throws HibernateException {
		Persona objeto = null;
		try {
		iniciaOperacion();
		objeto = (Persona) session.createQuery("from Persona p where p.documento="+ documento).uniqueResult();
		} finally {
		session.close();
		}
		return objeto;
		}
	
	
	
	
	
	
}
