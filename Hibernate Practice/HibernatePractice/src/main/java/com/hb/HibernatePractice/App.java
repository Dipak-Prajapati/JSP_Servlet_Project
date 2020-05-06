package com.hb.HibernatePractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println(factory);
		System.out.println(factory.isClosed());

		StudentModel stdModel = new StudentModel();
		stdModel.setStdId(4);
		stdModel.setFirstName("Dips");
		stdModel.setLastName("Prajapati");
		System.out.println(stdModel);
		
		AddressModel ad = new AddressModel();
		ad.setStreet("street1");
		ad.setCity("Ahmedabad");
		ad.setOpen(true);
		ad.setX(123.321);
		ad.setAddedDate(new Date());
		/* /HibernatePractice/src/main/java/dips.jpg */
		FileInputStream fis = new FileInputStream("src/main/java/dips.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		System.out.println(ad);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(stdModel);
		session.save(ad);
		
		tx.commit();
		
		session.close();
		System.out.println("Done");
	}
}
