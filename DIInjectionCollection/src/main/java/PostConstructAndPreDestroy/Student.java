package PostConstructAndPreDestroy;

public class Student {
	
	public Student() {
		System.out.println("constructor");
	}
	
   void	myVerify(){
		System.out.println("Verfiy method");
	}
   
   void unload() {
	   System.out.println("delete method");
   }
}
