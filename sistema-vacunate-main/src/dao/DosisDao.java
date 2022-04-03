package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dosis;
import datos.Persona;


public class DosisDao {
	//atributos
		private static Session session;
		private Transaction tx;

		//inicia la conexion con la bd
		private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		}

		@SuppressWarnings("unused")
		private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
		}
		
		@SuppressWarnings("unchecked")
		public List<Dosis> traer(Persona p) throws HibernateException {
			List<Dosis> lista = null;
			try {
				iniciaOperacion();
				String hQL = "from Dosis d inner join fetch d.persona pe where pe.idPersona=" + p.getIdPersona();
				lista =  session.createQuery(hQL).list();
				
				for (int i=0;i<lista.size();i++) {
					Hibernate.initialize(lista.get(i).getVacuna());
					Hibernate.initialize(lista.get(i).getPersona());
				}
				
			} finally {
				session.close();
			}
			return lista;
		}
		
		@SuppressWarnings("unchecked")
		public List<Dosis> traer(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException {
			List<Dosis> lista = null;
			try {
				iniciaOperacion();
				
				
				String hql = "from Dosis d where d.fecha between :fechaDesde and :fechaHasta";
				lista = session.createQuery(hql).setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).list();
				
				for (int i=0;i<lista.size();i++) {
					Hibernate.initialize(lista.get(i).getVacuna());
					Hibernate.initialize(lista.get(i).getPersona());
				}
				
				} finally {
				session.close();
			}
			return lista;
		}
		
		@SuppressWarnings("unchecked")
		public List<Dosis> traer(LocalDate fechaDesde, LocalDate fechaHasta, boolean tieneComorbilidad) throws HibernateException {
			List<Dosis> lista = null;
			try {
				iniciaOperacion();
				
				
				String hql = "from Dosis d inner join fetch d.persona dp where d.fecha between :fechaDesde and :fechaHasta and dp.tieneComorbilidad=:tieneComorbilidad";
				lista = session.createQuery(hql).setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).setParameter("tieneComorbilidad", tieneComorbilidad).list();
				
				for (int i=0;i<lista.size();i++) {
					Hibernate.initialize(lista.get(i).getVacuna());
					Hibernate.initialize(lista.get(i).getPersona());
				}
				
				} finally {
				session.close();
			}
			return lista;
		}
	
	
	
}
