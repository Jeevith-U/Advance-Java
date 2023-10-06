package ExplicitReturn;

public class SetChildNameDriver {
	
	public static void main(String[] args) {
		
		SetChildName childName = (fathername, mothername)->{
			
			return fathername.substring(0, 4)+mothername.substring(2, 5) ;
		} ;
		
		System.out.println(childName.setChildName("Anvit", "Kylie Jenner"));
	}
}
