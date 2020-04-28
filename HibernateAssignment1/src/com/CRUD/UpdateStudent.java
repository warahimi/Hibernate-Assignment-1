package com.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

//Class to update an entity/column
public class UpdateStudent {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String x;
		// 1- Create a factory 
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).
						buildSessionFactory();
		try {
			Session theSession = factory.getCurrentSession();
			theSession.beginTransaction();
			System.out.print("Enter the student ID to update: ");
			int studentID = input.nextInt();
			Student retrievedStudent = theSession.get(Student.class, studentID);
			if (retrievedStudent == null) {
				System.out.println("The Student does not exist.\nPlease Try again!");
			}
			else {
				System.out.println(retrievedStudent); // print the object
				System.out.println("\n================================\n");
				System.out.println("\nWhat you want to update?\n1. First Name\n2. Last Name\n3. Major\n4. College. \n5. Country \n6. City");
				int choice = input.nextInt();
				if(choice ==1)
				{
					System.out.print("Enter the new first name: ");
					x = bReader.readLine();
					retrievedStudent.setFirstName(x);
				}
				else if(choice ==2)
				{
					System.out.print("Enter the new last name: ");
					x = bReader.readLine();
					retrievedStudent.setLastName(x);
				}
				else if(choice ==3)
				{
					System.out.print("Enter the new major: ");
					x = bReader.readLine();
					retrievedStudent.setMajor(x);
				}
				else if(choice ==4)
				{
					System.out.print("Enter the new college: ");
					x = bReader.readLine();
					retrievedStudent.setCollege(x);
				}
				else if (choice==5) 
				{
					System.out.print("Enter the new country: ");
					x = bReader.readLine();
					retrievedStudent.setCountry(x);
				}
				else if (choice==6) 
				{
					System.out.print("Enter the new city: ");
					x = bReader.readLine();
					retrievedStudent.setCity(x);
				}
				else 
				{
					System.out.println("Invalid Entry");
				}
				
				theSession.getTransaction().commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		
		}

	}

}
