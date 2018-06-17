package Domain;

public class Professor {
	private int professorNo;
	private String name;
	private String birthDate;
	private String subjectName;
	
	public Professor(){}
	
	public Professor(int professorNo, String name, String birthDate, String subjectName){
		this.professorNo = professorNo;
		this.name = name;
		this.birthDate = birthDate;
		this.subjectName = subjectName;
	}
	
	public int getProfessorNo() {
		return professorNo;
	}
	public void setProfessorNo(int professorNo) {
		this.professorNo = professorNo;
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
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return professorNo + "\t" + name + "\t" + birthDate	+ "\t" + subjectName;
	}
	
	
}
