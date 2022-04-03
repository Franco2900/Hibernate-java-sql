package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Automotor;

public class AutomotorDao {


	//atributos
	private static Session session;
	private Transaction tx;

	//inicia la conexion con la bd
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	//este metodo maneja la exception, si ocurre un error durante la carga vuelve para atras a toda la carga que se hizo para no generar errores cuando se intente cargar en otro momento.
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	//TRAER
	public Automotor traerAutomotor(String dominio) throws HibernateException {
		Automotor obj = null;
		try {
			iniciaOperacion();
			String hQL = "from Automotor a where a.dominio=:dominio";
			obj = (Automotor) session.createQuery(hQL).setParameter("dominio", dominio).uniqueResult();
			} finally {
			session.close();
		}
		return obj;
	}
	
	
	
	
	
}
