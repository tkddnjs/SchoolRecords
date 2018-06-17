package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Domain.Professor;

public class ProfessorController {
	
	private Map<Integer, Professor> professorMap;
	
	public ProfessorController(){
		professorMap = new HashMap<>();
	}
	
	public void printMenu(Scanner scanner){
		boolean button = true;
		
		System.out.println("================");
		System.out.println("1.조회");
		System.out.println("2.입력");
		System.out.println("3.삭제");
		System.out.println("4.이전화면");
		System.out.println("================");
		System.out.print("원하는 메뉴를 선택하세요 : ");
		
		while(button){
			switch(scanner.nextInt()){
				case 1:
					listProfessor();
					break;
				case 2:
					Professor professor = new Professor();
					System.out.print("교수번호 : ");
					professor.setProfessorNo(scanner.nextInt());
					System.out.print("이름 : ");
					professor.setName(scanner.next());
					System.out.print("생년월일(YYYYMMDD) : ");
					professor.setBirthDate(scanner.next());
					System.out.print("과목 : ");
					professor.setSubjectName(scanner.next());
					registerProfessor(professor);
					break;
				case 3:
					System.out.print("교수번호 : ");
					deleteProfessor(scanner.nextInt());
					break;
				case 4:
					button = false;
			}
		}
	}
	
	private void listProfessor(){
		System.out.println("교수번호\t이름\t생년월일\t과목");
		for(Professor professor : professorMap.values()){
			System.out.println(professor.toString());
		}
	}
	
	private void registerProfessor(Professor professor){
		if(checkProfessorNo(professor.getProfessorNo())){
			professorMap.put(professor.getProfessorNo(), professor);
		} else {
			System.out.println("등록된 교수번호입니다.");
		}
	}
	
	private void deleteProfessor(int professorNo){
		if(checkProfessorNo(professorNo)){
			System.out.println("등록되지 않은 교수번호입니다.");
		} else {
			professorMap.remove(professorNo);
		}
	}
	
	private boolean checkProfessorNo(int professorNo){
		for(Professor professor : professorMap.values()){
			if(professor.getProfessorNo() == professorNo){
				return false;
			}
		}
		return true;
	}
}
