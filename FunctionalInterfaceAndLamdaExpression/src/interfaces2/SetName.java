package interfaces2;

public class SetName {
	
	public static void main(String[] args) {
		
		Naming name = (fatherName, motherName) -> {
			
			String father = fatherName.substring(0, 3) ;
			String mother = motherName.substring(0, 3) ;
			String namee = father+mother ;
			
			System.out.println("The Child Name is "+namee);
		} ;
		
		name.setChildName("Anvit", "Jacqueline Fernandez ");
	}
}
