package Domain;

public class Subject {
	private int subjectNo;
	private String name;
	
	public Subject(){}
	
	public Subject(int subjectNo, String name){
		this.subjectNo = subjectNo;
		this.name = name;
	}
	
	public int getSubjectNo(){
		return this.subjectNo;
	}
	
	public void setSubjectNo(int subjectNo){
		this.subjectNo = subjectNo;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return subjectNo + "\t" + name;
	}

	
}

