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
			System.out.println("1.��ȸ");
			System.out.println("2.�Է�");
			System.out.println("3.����");
			System.out.println("4.����ȭ��");
			System.out.println("================");
			System.out.print("���ϴ� �޴��� �����ϼ��� : ");
			switch(scanner.nextInt()){
				case 1:
					listSubject();
					break;
				case 2:
					Subject subject = new Subject();
					System.out.print("�����ȣ : ");
					subject.setSubjectNo(scanner.nextInt());
					System.out.print("����� : ");
					subject.setName(scanner.next());
					registerSubject(subject);
					break;
				case 3:
					System.out.print("�����ȣ : ");
					deleteSubject(scanner.nextInt());
					break;
				case 4:
					button = false;
			}
		}
	}
	
	private void listSubject(){
		for(Subject subject : subjectMap.values()){
			System.out.println("�����ȣ\t�����");
			subject.toString();
		}
	}
	
	private void registerSubject(Subject subject){
		if(checkSubject(subject.getSubjectNo())){
			subjectMap.put(subject.getSubjectNo(), subject);
		} else {
			System.out.println("��ϵ� �����ȣ�Դϴ�.");
		}
	}
	
	private void deleteSubject(int subjectNo){
		if(checkSubject(subjectNo)){
			System.out.println("��ϵ��� ���� �����ȣ�Դϴ�.");
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
