package Domain;

public class Student {
	private int studentNo;
	private String name;
	private String birthDate;

	public Student(){}
	
	public Student(int studentNo, String name, String birthDate){
		this.studentNo = studentNo;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return studentNo + "\t" + name + "\t" + birthDate;
	}
	
	
}
