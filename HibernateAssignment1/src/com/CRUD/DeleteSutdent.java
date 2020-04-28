package com.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;




public class DeleteSutdent {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		// 1- Create a factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		try {
			Session theSession = factory.getCurrentSession();
			theSession.beginTransaction();
			System.out.println("1-Press 1 to delete all students.\n2-Press 2 to delete specific student.");
			int d = input.nextInt();
			if (d ==1) {
				theSession.createQuery("delete from Student").executeUpdate();
			}
			else if (d==2) {
				System.out.print("Enter the Employee ID you want to delete: ");
				int sID = input.nextInt();
				Student s = theSession.get(Student.class, sID);
				System.out.println();
				System.out.println(s);
				
				System.out.println("\nAre you sure you want to delete the above student? (y/n)");
			
				String choiceString = input.next();
				if(choiceString.equalsIgnoreCase("y"))
				{
					theSession.delete(s);
				}
				//theSession.createQuery("delete from employee where id= 3").executeUpdate();
				
			}
			else {
				System.out.println("Invalid entry.\nPlease enter 1 or 2");
			}
			

			theSession.getTransaction().commit();
			System.out.println("\nStudent deleted!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
