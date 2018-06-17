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
		System.out.println("1.��ȸ");
		System.out.println("2.�Է�");
		System.out.println("3.����");
		System.out.println("4.����ȭ��");
		System.out.println("================");
		System.out.print("���ϴ� �޴��� �����ϼ��� : ");
		
		while(button){
			switch(scanner.nextInt()){
				case 1:
					listProfessor();
					break;
				case 2:
					Professor professor = new Professor();
					System.out.print("������ȣ : ");
					professor.setProfessorNo(scanner.nextInt());
					System.out.print("�̸� : ");
					professor.setName(scanner.next());
					System.out.print("�������(YYYYMMDD) : ");
					professor.setBirthDate(scanner.next());
					System.out.print("���� : ");
					professor.setSubjectName(scanner.next());
					registerProfessor(professor);
					break;
				case 3:
					System.out.print("������ȣ : ");
					deleteProfessor(scanner.nextInt());
					break;
				case 4:
					button = false;
			}
		}
	}
	
	private void listProfessor(){
		System.out.println("������ȣ\t�̸�\t�������\t����");
		for(Professor professor : professorMap.values()){
			System.out.println(professor.toString());
		}
	}
	
	private void registerProfessor(Professor professor){
		if(checkProfessorNo(professor.getProfessorNo())){
			professorMap.put(professor.getProfessorNo(), professor);
		} else {
			System.out.println("��ϵ� ������ȣ�Դϴ�.");
		}
	}
	
	private void deleteProfessor(int professorNo){
		if(checkProfessorNo(professorNo)){
			System.out.println("��ϵ��� ���� ������ȣ�Դϴ�.");
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
