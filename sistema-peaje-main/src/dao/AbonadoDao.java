package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;

public class AbonadoDao {

	//atributos
	private static Session session;
	private Transaction tx;

	//inicia la conexion con la bd
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	//este metodo maneja la exception, si ocurre un error durante la carga vuelve para atras a toda la carga que se hizo para no generar errores cuando se intente cargar en otro momento.
	@SuppressWarnings("unused")
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
//TRAER
	public Abonado traer(int dni) throws HibernateException {
		Abonado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Abonado) session.createQuery("from Abonado a where a.dni="+ dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	
	
	
}
