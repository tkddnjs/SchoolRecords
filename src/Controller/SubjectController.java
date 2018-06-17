package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Domain.Subject;

public class SubjectController {
	
	private Map<Integer, Subject> subjectMap;
	
	public SubjectController(){
		subjectMap = new HashMap<>();
	}
	
	public void printMenu(Scanner scanner){
		boolean button = true;
		
		while(button){
			System.out.println("================");
			System.out.println("1.조회");
			System.out.println("2.입력");
			System.out.println("3.삭제");
			System.out.println("4.이전화면");
			System.out.println("================");
			System.out.print("원하는 메뉴를 선택하세요 : ");
			switch(scanner.nextInt()){
				case 1:
					listSubject();
					break;
				case 2:
					Subject subject = new Subject();
					System.out.print("과목번호 : ");
					subject.setSubjectNo(scanner.nextInt());
					System.out.print("과목명 : ");
					subject.setName(scanner.next());
					registerSubject(subject);
					break;
				case 3:
					System.out.print("과목번호 : ");
					deleteSubject(scanner.nextInt());
					break;
				case 4:
					button = false;
			}
		}
	}
	
	private void listSubject(){
		for(Subject subject : subjectMap.values()){
			System.out.println("과목번호\t과목명");
			subject.toString();
		}
	}
	
	private void registerSubject(Subject subject){
		if(checkSubject(subject.getSubjectNo())){
			subjectMap.put(subject.getSubjectNo(), subject);
		} else {
			System.out.println("등록된 과목번호입니다.");
		}
	}
	
	private void deleteSubject(int subjectNo){
		if(checkSubject(subjectNo)){
			System.out.println("등록되지 않은 과목번호입니다.");
		} else {
			subjectMap.remove(subjectNo);
		}
	}
	
	private boolean checkSubject(int subjectNo){
		for(Subject subject : subjectMap.values()){
			if(subject.getSubjectNo() == subjectNo){
				return false;
			}
		}
		return true;
	}
	
}
