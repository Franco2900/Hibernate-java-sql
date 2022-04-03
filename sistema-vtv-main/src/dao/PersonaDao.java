package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Contribuyente;
import datos.Inspector;



public class PersonaDao {

	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia=null; // Patrón Singleton

	//constructor vacio de ClienteDao para comprobar la instancia
	protected PersonaDao() {}

	public static PersonaDao getInstance(){
		if(instancia==null)
			instancia=new PersonaDao();
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
	tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	//TRAER
		
	public Contribuyente traerContribuyente(int idPersona) throws HibernateException {
		Contribuyente objeto = null;
		try {
		iniciaOperacion();
		objeto = (Contribuyente) session.get(Contribuyente.class, idPersona);
		} finally {
		session.close();
		}
		return objeto;
		}
	
	
	
	
	public Inspector traerInspector(int idPersona) throws HibernateException {
		Inspector objeto = null;
		try {
		iniciaOperacion();
		objeto = (Inspector) session.get(Inspector.class, idPersona);
		} finally {
		session.close();
		}
		return objeto;
		}
	
	
	
}
