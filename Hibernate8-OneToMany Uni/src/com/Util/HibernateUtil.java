package com.Util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.Student;
import com.model.Subject;

public class HibernateUtil {
	
	private HibernateUtil() {
		
	}
	
	private static SessionFactory sf;
	private static StandardServiceRegistry registry;
	
	public static SessionFactory getConnection() {
		
		if(sf==null) {
			
			Map<String,Object> map=new HashMap<String, Object>();
			
			map.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
			map.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernateonetomanyuni");
			map.put(Environment.USER,"root");
			map.put(Environment.PASS, "root");
			
			map.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
			map.put(Environment.SHOW_SQL,true);
			map.put(Environment.HBM2DDL_AUTO,"update");
			
			registry=new StandardServiceRegistryBuilder().applySettings(map).build();
			MetadataSources mds=new MetadataSources(registry).addAnnotatedClass(Student.class).addAnnotatedClass(Subject.class);
			Metadata md=mds.getMetadataBuilder().build();
			sf = md.buildSessionFactory();
			return sf;
		}
		return sf;
	}

}
