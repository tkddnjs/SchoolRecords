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
			System.out.println("1.�л��� ������ȸ");
			System.out.println("2.���� ������ȸ");
			System.out.println("3.���� �Է�");
			System.out.println("4.���� ����");
			System.out.println("5.����ȭ��");
			System.out.println("================");
			System.out.print("���ϴ� �޴��� �����ϼ��� : ");
			switch(scanner.nextInt()){
				case 1:
					System.out.print("�л���ȣ : ");
					listScoreByStudentNo(scanner.nextInt());
					break;
				case 2:
					System.out.print("�����ȣ : ");
					listScoreBySubjectNo(scanner.nextInt());
					break;
				case 3:
					Score score = new Score();
					System.out.print("������ȣ : ");
					score.setScoreNo(scanner.nextInt());
					System.out.print("�л���ȣ : ");
					score.setStudentNo(scanner.nextInt());
					System.out.print("�����ȣ : ");
					score.setSubjectNo(scanner.nextInt());
					System.out.print("���� : ");
					score.setScore(scanner.nextInt());
					registerScore(score);
					break;
				case 4:
					System.out.print("������ȣ : ");
					deleteScore(scanner.nextInt());
					break;
				case 5:
					button = false;
			}
		}
	}
	
	private void listScoreByStudentNo(int studentNo){
		System.out.println("������ȣ\t�л���ȣ\t�����ȣ\t����");
		for(Score score : scoreMap.values()){
			if(score.getStudentNo() == studentNo){
				System.out.println(score.toString());
			}
		}
	}
	
	private void listScoreBySubjectNo(int subjectNo){
		System.out.println("������ȣ\t�л���ȣ\t�����ȣ\t����");
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
			System.out.println("��ϵ� ������ȣ �Դϴ�.");
		}
	}
	
	private void deleteScore(int scoreNo){
		if(checkScoreNo(scoreNo)){
			System.out.println("��ϵ��� ���� ������ȣ �Դϴ�.");
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
