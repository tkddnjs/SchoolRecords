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
			System.out.println("1.조회");
			System.out.println("2.입력");
			System.out.println("3.삭제");
			System.out.println("4.이전화면");
			System.out.println("================");
			System.out.print("원하는 메뉴를 선택하세요 : ");
			switch(scanner.nextInt()){
				case 1:
					listStudent();
					break;
				case 2:
					Student student = new Student();
					System.out.print("학생번호 : ");
					student.setStudentNo(scanner.nextInt());
					System.out.print("이름 : ");
					student.setName(scanner.next());
					System.out.print("생년월일(YYYYMMDD) : ");
					student.setBirthDate(scanner.next());
					registerStudent(student);
					break;
				case 3:
					System.out.print("학생번호 : ");
					deleteStudent(scanner.nextInt());
					break;
				case 4:
					button = false;
			}
		}
	}
	
	private void listStudent(){
		System.out.println("학번\t이름\t생년월일");
		for(Student student : studentMap.values()){
			System.out.println(student.toString());
		}
	}
	
	private void registerStudent(Student student){
		if(checkStudentNo(student.getStudentNo())){
			studentMap.put(student.getStudentNo(), student);
		} else {
			System.out.println("등록된 학생번호입니다.");
		}
	}

	private void deleteStudent(int studentNo){
		if(checkStudentNo(studentNo)){
			System.out.println("등록되지 않은 학생번호입니다.");
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
