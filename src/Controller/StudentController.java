package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Domain.Student;

public class StudentController {
	private Map<Integer, Student> studentMap;
	
	public StudentController(){
		studentMap = new HashMap<>();
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
					listStudent();
					break;
				case 2:
					Student student = new Student();
					System.out.print("�л���ȣ : ");
					student.setStudentNo(scanner.nextInt());
					System.out.print("�̸� : ");
					student.setName(scanner.next());
					System.out.print("�������(YYYYMMDD) : ");
					student.setBirthDate(scanner.next());
					registerStudent(student);
					break;
				case 3:
					System.out.print("�л���ȣ : ");
					deleteStudent(scanner.nextInt());
					break;
				case 4:
					button = false;
			}
		}
	}
	
	private void listStudent(){
		System.out.println("�й�\t�̸�\t�������");
		for(Student student : studentMap.values()){
			System.out.println(student.toString());
		}
	}
	
	private void registerStudent(Student student){
		if(checkStudentNo(student.getStudentNo())){
			studentMap.put(student.getStudentNo(), student);
		} else {
			System.out.println("��ϵ� �л���ȣ�Դϴ�.");
		}
	}

	private void deleteStudent(int studentNo){
		if(checkStudentNo(studentNo)){
			System.out.println("��ϵ��� ���� �л���ȣ�Դϴ�.");
		} else {
			studentMap.remove(studentNo);
		}
	}
	
	private boolean checkStudentNo(int studentNo){
		for(Student std : studentMap.values()){
			if(std.getStudentNo() == studentNo){
				return false;
			}
		}
		return true;
	}
}
