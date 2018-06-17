package Domain;

public class Score {
	private int scoreNo;
	private int studentNo;
	private int subjectNo;
	private int score;
	
	public Score(){}
	
	public Score(int scoreNo, int studentNo, int subjectNo, int score){
		this.scoreNo = scoreNo;
		this.studentNo = studentNo;
		this.subjectNo = subjectNo;
		this.score = score;
	}

	public int getScoreNo() {
		return scoreNo;
	}

	public void setScoreNo(int scoreNo) {
		this.scoreNo = scoreNo;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getSubjectNo() {
		return subjectNo;
	}

	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return scoreNo + "\t" + studentNo + "\t" + subjectNo + "\t" + score + "Á¡";
	}
	
	
}
