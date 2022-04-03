package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Vacuna;


public class VacunaDao {
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
	
	
	public Vacuna traer(int idVacuna) throws HibernateException {
		Vacuna objeto = null;
		try {
		iniciaOperacion();
		objeto = (Vacuna) session.get(Vacuna.class, idVacuna);
		} finally {
		session.close();
		}
		return objeto;
		}	
	
	@SuppressWarnings("unchecked")
	public List<Vacuna> traer() throws HibernateException {
	List<Vacuna> lista = null;
	try {
	iniciaOperacion();
	lista = session.createQuery("from Vacuna").list();
	} finally {
	session.close();
	}
	return lista;
	}
	
	
	
}
