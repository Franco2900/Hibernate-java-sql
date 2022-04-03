package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;
import datos.Manual;
import datos.Rodado;
import datos.Telepeaje;

public class PeajeDao {
	
	private static Session session;
	private Transaction tx;
	private static PeajeDao instancia=null; // Patrón Singleton

	//constructor vacio de ClienteDao para comprobar la instancia
	protected PeajeDao() {}

	public static PeajeDao getInstance(){
		if(instancia==null)
			instancia=new PeajeDao();
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
	
	
	
	@SuppressWarnings("unchecked")
	public List<Manual> traerManual() throws HibernateException {
		List<Manual> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Manual").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeaje() throws HibernateException {
		List<Telepeaje> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Telepeaje").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Manual> traerManualFecha(LocalDate fecha) throws HibernateException {
		List<Manual> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Manual m where m.fecha=:fecha";
			lista = session.createQuery(hQL).setParameter("fecha", fecha).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeaje(Rodado r) throws HibernateException {
		List<Telepeaje> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Telepeaje t inner join fetch t.rodado ro where ro.idRodado=" + r.getIdRodado();
			lista =  session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeaje(Abonado a) throws HibernateException {
		List<Telepeaje> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Telepeaje t inner join fetch t.rodado r inner join fetch r.abonado ab where ab.idAbonado=" + a.getIdAbonado();
			lista =  session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	
	
	
}
