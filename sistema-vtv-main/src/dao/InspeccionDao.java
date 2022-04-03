package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Automotor;
import datos.Inspeccion;
import datos.Inspector;

public class InspeccionDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public Inspeccion traerInspeccion (int idInspeccion) throws HibernateException {
		Inspeccion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Inspeccion) session.get(Inspeccion.class, idInspeccion);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion (Automotor automotor) throws HibernateException {
		 List<Inspeccion> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Inspeccion i inner join fetch i.automotor a where a.idAutomotor=" + automotor.getIdAutomotor();
			lista = session.createQuery(hQL).list();
			} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion (LocalDate fecha) throws HibernateException {
		 List<Inspeccion> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Inspeccion i where i.fecha=:fecha";
			lista = session.createQuery(hQL).setParameter("fecha", fecha).list();
			} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion (Inspector inspector, LocalDate fecha) throws HibernateException {
		List<Inspeccion> lista = null;
		try {
			iniciaOperacion();
			
			String sql = "select * from inspeccion i where i.idInspector=:idInspector and i.fecha=:fecha";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Inspeccion.class);
			
			query.setParameter("idInspector", inspector.getIdPersona());
			query.setParameter("fecha", fecha);
			lista = query.list();
			} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion (LocalDate fecha, String estado) throws HibernateException {
		 List<Inspeccion> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Inspeccion i where i.fecha=:fecha and i.estado=:estado";
			lista = session.createQuery(hQL).setParameter("fecha", fecha).setParameter("estado", estado).list();
			} finally {
			session.close();
		}
		return lista;
	}
	
	
	
	
}
