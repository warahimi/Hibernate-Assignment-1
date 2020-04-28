package com.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;


public class CreateSaveObject {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		// 1- Create a factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		//Creating and object of Student and saving it to database
		
		try {
			//start the transaction
			String choice = "y";
			while (choice.equalsIgnoreCase("y")) {
				// 2 - create Session
				Session theSession = factory.getCurrentSession();
				theSession.beginTransaction();
				
				
				System.out.print("Enter the Student First Name: ");
				String firstName = br.readLine();
				System.out.print("Enter the Student Last Name: ");
				String lastName = br.readLine();
				System.out.print("Enter the Student Major: ");
				String major = br.readLine();
				System.out.print("Enter the Student College: ");
				String college = br.readLine();
				System.out.print("Enter the Student Country: ");
				String country = br.readLine();
				System.out.print("Enter the Student City: ");
				String city = br.readLine();
				

				Student s1 = new Student(firstName, lastName, major, college, country, city);
				
				theSession.save(s1);
				
				theSession.getTransaction().commit();
				
				System.out.println("Do you want to enter more student? (y/n)");
				choice = br.readLine();
				if (choice.equalsIgnoreCase("n")) {
					theSession.close();
				}
			}

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		}

	}

}
