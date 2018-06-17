package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Domain.Score;

public class ScoreController {

	private Map<Integer, Score> scoreMap;
	
	public ScoreController(){
		scoreMap = new HashMap<>();
	}
	
	public void printMenu(Scanner scanner){
		boolean button = true;
		
		while(button){
			System.out.println("================");
			System.out.println("1.학생별 성적조회");
			System.out.println("2.과목별 성적조회");
			System.out.println("3.성적 입력");
			System.out.println("4.성적 삭제");
			System.out.println("5.이전화면");
			System.out.println("================");
			System.out.print("원하는 메뉴를 선택하세요 : ");
			switch(scanner.nextInt()){
				case 1:
					System.out.print("학생번호 : ");
					listScoreByStudentNo(scanner.nextInt());
					break;
				case 2:
					System.out.print("과목번호 : ");
					listScoreBySubjectNo(scanner.nextInt());
					break;
				case 3:
					Score score = new Score();
					System.out.print("성적번호 : ");
					score.setScoreNo(scanner.nextInt());
					System.out.print("학생번호 : ");
					score.setStudentNo(scanner.nextInt());
					System.out.print("과목번호 : ");
					score.setSubjectNo(scanner.nextInt());
					System.out.print("성적 : ");
					score.setScore(scanner.nextInt());
					registerScore(score);
					break;
				case 4:
					System.out.print("성적번호 : ");
					deleteScore(scanner.nextInt());
					break;
				case 5:
					button = false;
			}
		}
	}
	
	private void listScoreByStudentNo(int studentNo){
		System.out.println("성적번호\t학생번호\t과목번호\t성적");
		for(Score score : scoreMap.values()){
			if(score.getStudentNo() == studentNo){
				System.out.println(score.toString());
			}
		}
	}
	
	private void listScoreBySubjectNo(int subjectNo){
		System.out.println("성적번호\t학생번호\t과목번호\t성적");
		for(Score score : scoreMap.values()){
			if(score.getSubjectNo() == subjectNo){
				System.out.println(score.toString());
			}
		}
	}
	
	private void registerScore(Score score){
		if(checkScoreNo(score.getScoreNo())){
			scoreMap.put(score.getScoreNo(), score);
		} else {
			System.out.println("등록된 성적번호 입니다.");
		}
	}
	
	private void deleteScore(int scoreNo){
		if(checkScoreNo(scoreNo)){
			System.out.println("등록되지 않은 성적번호 입니다.");
		} else{
			scoreMap.remove(scoreNo);
		}
	}
	
	private boolean checkScoreNo(int scoreNo){
		for(Score score : scoreMap.values()){
			if(score.getScoreNo() == scoreNo){
				return false;
			}
		}
		return true;
	}
}
