package test;
import org.hibernate.Session;

import dao.HibernateUtil;
public class TestHBM {
	
public static void main() {
Session session = HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();
session.close();
System.out.println("OK");
}
}