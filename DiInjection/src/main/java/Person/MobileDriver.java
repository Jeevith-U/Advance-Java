package Person;

public class MobileDriver {
	
	private Mobile mobile ;
	
	public Mobile getmobile() {
		return mobile ;
	}
	
	public void setmobile(Mobile mobile) {
		this.mobile = mobile ;
	}
	public void use() {
		mobile.ring() ;
		System.out.println("Person is usinh");
	}
}
