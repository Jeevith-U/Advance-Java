package ImplicitReturn;

public class SetChildNameDriver {
	
	public static void main(String[] args) {
		
		SetChildName childName = (fathername, mothername)-> fathername.substring(0, 4)+mothername.substring(2, 5)  ;
		
		System.out.println(childName.setChildName("Jeevith", "Kylie Jenner"));
	}
}
