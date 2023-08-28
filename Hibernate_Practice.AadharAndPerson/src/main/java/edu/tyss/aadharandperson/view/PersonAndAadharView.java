package edu.tyss.aadharandperson.view;

import java.util.Scanner;

import edu.tyss.aadharandperson.controller.AadharAndPersonController;
import edu.tyss.aadharandperson.model.Aadhar;
import edu.tyss.aadharandperson.model.Person;

public class PersonAndAadharView {
	
	public static void main(String[] args) {
		
		AadharAndPersonController controller = new AadharAndPersonController() ;
		
		Scanner scanner = new Scanner(System.in) ;
		
		PersonAndAadharView personAndAadharView = new PersonAndAadharView() ;
		
		boolean flag = true ;
		
		while (flag) {
			System.out.println("Select the operation that You want to perform");
			int operation = scanner.nextInt() ;
			
			switch (operation) {
			case 1:
				personAndAadharView.createPersonAndAadhar(scanner, controller);
				break;
			case 2:
				System.out.println("Enter the ID");
				int id = scanner.nextInt() ;
				Person person = controller.findPerson(id) ;
				System.out.println(person);
				break;
			case 3:
				System.out.println("Enter the id");
				int uid = scanner.nextInt() ;
				System.out.println("Enter the Phone Number");
				long upn = scanner.nextLong() ;
				controller.UpdatePerson(uid, upn);
				System.out.println("Updated...!");
				break;
			case 4:
				System.out.println("Enter the ID");
				int delId = scanner.nextInt() ;
				controller.deletePerson(delId);
				System.out.println("Deleted Successfully");
				break;
			case 5:
				System.out.println("Enter the Aadhar Number");
				long anum = scanner.nextLong() ;
				String name = controller.findPersonByAadharNumber(anum) ;
				System.out.println(name);

			default:
				break;
			}
		}
	}

	private void createPersonAndAadhar(Scanner scanner, AadharAndPersonController controller) {
		
		System.out.println("Enter the Person Id");
		int id = scanner.nextInt() ;
		System.out.println("Enter the person Name");
		scanner.nextLine() ;
		String name = scanner.nextLine() ;
		System.out.println("Enter the Address");
		String address = scanner.nextLine() ;
		System.out.println("Enter the Phone Number");
		long phno = scanner.nextLong() ;
		System.out.println("Enter the pin code");
		int pincode = scanner.nextInt() ;
		
		Person person = new Person() ;
		person.setId(id);
		person.setName(name);
		person.setAddres(address);
		person.setPhno(phno);
		person.setPicode(pincode);
		
		System.out.println("Enter the Aadhar Details Now");
		System.out.println();
		System.out.println("Enter the Aadhar Id");
		int aid = scanner.nextInt() ;
		System.out.println("Enter the Aadhar Number");
		long anum = scanner.nextLong() ;
		System.out.println("Enter the Full Name");
		scanner.nextLine() ;
		String aname = scanner.nextLine() ;
		System.out.println("Enter the PermanentAddress ");
		String aaadress = scanner.nextLine() ;
		
		Aadhar aadhar = new Aadhar() ;
		aadhar.setId(aid);
		aadhar.setAadharNumber(anum);
		aadhar.setFullName(aname);
		aadhar.setPermanentAddress(aaadress);
		
		person.setAadhar(aadhar);
		
		controller.savePerson(person, aadhar);
		
		System.out.println("Saved Successfully");
	}
}
