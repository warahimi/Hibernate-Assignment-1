package com.CRUD;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;


public class ReadStudent {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 1- Create a factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).
				buildSessionFactory();
	
		try {
			// 2 - create Session
			Session theSession = factory.getCurrentSession();
			theSession.beginTransaction();
			System.out.print("Enter the Student ID you want to read: ");
			int sID = input.nextInt();

			Student s = theSession.get(Student.class, sID);
			if (s == null) {
				System.out.println("\nThe Student does not exist");
				
			}
			else {
				System.out.println();
			System.out.println(s); // print the object
			
			theSession.getTransaction().commit();
			}
			
			
		} catch (Exception e) {
			
		}
		finally {
		}

	}

}
