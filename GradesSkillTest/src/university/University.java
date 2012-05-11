package university;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;
enum LetterGrade {A, B, C, D, F, P, NP};

public class University {
	/**
	 * All the instructors at the University organized by their ID 
         * numbers.
	 */
	private Hashtable<String, Instructor> faculty;
	
	/**
	 * All the courses offered at the University.
	 */
	private HashSet<Course> classes;

	/**
	 * All the students at the University organized by their ID numbers.
	 */
	private Hashtable<Integer, Student> students;	
	
	/**
	 * Initializes lists of Instructors, Students, Courses etc that make
	 * up the University.
	 */
	public University (){
		faculty = new Hashtable<String, Instructor>();
		classes = new HashSet<Course>();
		students = new Hashtable<Integer, Student>();
	}
	
	/** 
	 * Creates Instructors and adds them to the University.
	 * @param name  The name of the Instructor to add.
	 */
	public void addInstructor (String name){
		faculty.put(name, new Instructor(name));
	}


	/**
	 * Returns an Instructor given that instructors name.
	 * 
	 * @param name The name of the Instructor to return.
	 */
	public Instructor getInstructor(String name){
		return faculty.get(name);
	}

	
	/**
	 * Adds courses to the University.
	 * 
	 * @param name The name of the course to be added.
	 */
	public void createCourse (String name, Instructor i){
		classes.add(new Course(name, i));
	}
	
	public void createStudent(String name){
		Student s = new Student(name);
		students.put(s.getId(), s);
	}
	
	/**
	 * Checks whether the id is a valid UniversityMember
	 * 
	 * @param id
	 * @return false if the id doesn't represent a valid U
	 */
	public boolean checkMember(String userEnteredId){
		try{
			int id = Integer.valueOf(userEnteredId);
			if (UniversityMember.isStudent(id)){
				students.containsKey(id);
				System.out.println("Enter the course name to see your grade: ");
			}
			else{
				faculty.containsKey(userEnteredId);
				System.out.println("Enter the course name to enter grades: ");	
			}
		}catch (NumberFormatException e){
			System.out.println("Invalid ID is not a number.");
			return false;
		}
		return true;
	}

	/**
	 * Driver.  Creates O
	 * @param args
	 * @throws IOException If I/O error occurs.
	 */
	public static void main(String[] args) throws IOException {	
		University rc = new University();
		String instructorA = "Henry Wallace";
		String instructorB = "Sid Jenkins";
		String instructorC = "Ramona Beesley";
		
		System.out.println("** Welcome to Distracted University **");
		
		// Create instructors
		rc.addInstructor(instructorA);
		rc.addInstructor(instructorB);
		rc.addInstructor(instructorC);

	
		// create courses
	    rc.createCourse("Math 101", rc.getInstructor(instructorC));
	    rc.createCourse("Psychology 143", rc.getInstructor(instructorB));
	    rc.createCourse("Agriculture 124", rc.getInstructor(instructorA));
	    rc.createCourse("Nutrition 101", rc.getInstructor(instructorC));
	    
	    // create students 
	    rc.createStudent("Kelsey Grammar");
	    rc.createStudent("Bell Brady");
	    rc.createStudent("Brian McKnight");
	    
	    // start report card i/o	    
	    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	    
        while(!rc.checkMember(input.readLine())){
        	System.out.println("Please enter your ID number");
        }
		
		
		
	}

}
