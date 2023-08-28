package Model;

import java.util.List;

public class University {
	
	private int uid ;
	private String uname ;
	
	List<Student> listofStudents ;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public List<Student> getListofStudents() {
		return listofStudents;
	}

	public void setListofStudents(List<Student> listofStudents) {
		this.listofStudents = listofStudents;
	}

	public University() {
		super();
	}

	@Override
	public String toString() {
		return "University [uid=" + uid + ", uname=" + uname + ", listofStudents=" + listofStudents + "]";
	}
	
	
}
