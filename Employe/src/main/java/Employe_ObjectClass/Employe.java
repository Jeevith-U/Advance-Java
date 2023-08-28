package Employe_ObjectClass;

public class Employe {
	
	private int emp_id ;
	private String emp_name ;
	private String emp_designation ;
	private long emp_ph_no ;
	private String emp_dept ;
	private long emp_sal ;
	private String emp_pass ;
	
	
	public int getEmp_id() {
		return emp_id;
	}
	
	public int setEmp_id(int emp_id) {
		return this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}
	public String setEmp_name(String emp_name) {
		return this.emp_name = emp_name;
	}
	public String getEmp_designation() {
		return emp_designation;
	}
	public String setEmp_designation(String emp_designation) {
		return this.emp_designation = emp_designation;
	}
	public long getEmp_ph_no() {
		return emp_ph_no;
	}
	public long setEmp_ph_no(long emp_ph_no) {
		return this.emp_ph_no = emp_ph_no;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public String setEmp_dept(String emp_dept) {
		return this.emp_dept = emp_dept;
	}
	public double getEmp_sal() {
		return emp_sal;
	}
	public long setEmp_sal(long emp_sal) {
		return this.emp_sal = emp_sal;
	}
	public String getEmp_pass() {
		return emp_pass;
	}
	public String setEmp_pass(String emp_pass) {
		return this.emp_pass = emp_pass;
	}
	@Override
	public String toString() {
		return "Employe [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_designation=" + emp_designation
				+ ", emp_ph_no=" + emp_ph_no + ", emp_dept=" + emp_dept + ", emp_sal=" + emp_sal + ", emp_pass="
				+ emp_pass + "]";
	}
}
