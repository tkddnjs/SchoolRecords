import java.util.Scanner;

import Controller.ProfessorController;
import Controller.ScoreController;
import Controller.StudentController;
import Controller.SubjectController;

public class Launcher {

	private Scanner scanner;
	private StudentController studentController;
	private ProfessorController professorController;
	private SubjectController subjectController;
	private ScoreController scoreController;
	
	private Launcher(){
		scanner = new Scanner(System.in);
		studentController = new StudentController();
		professorController = new ProfessorController();
		subjectController = new SubjectController();
		scoreController = new ScoreController();
	}
	
	private void PrintMenu(){
		
		System.out.println("================");
		System.out.println("1.�л�");
		System.out.println("2.����");
		System.out.println("3.����");
		System.out.println("4.����");
		System.out.println("5.����");
		System.out.println("================");
		
		switch(scanner.nextInt()){
			case 1:
				studentController.printMenu(scanner);
				break;
			case 2:
				professorController.printMenu(scanner);
				break;
			case 3:
				subjectController.printMenu(scanner);
				break;
			case 4:
				scoreController.printMenu(scanner);
				break;
			case 5:
				scanner.close();
				return;
		}
	}
	
	public static void main(String args[]){	
		
		Launcher lc = new Launcher();
		
		while(true){
			lc.PrintMenu();
		}
	}
	
}
