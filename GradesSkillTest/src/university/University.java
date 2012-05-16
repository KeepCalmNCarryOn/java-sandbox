package university;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Iterator;
enum LetterGrade {A, B, C, D, F, P, NP};
enum UniMemberType {STUDENT, INSTRUCTOR, OUTSIDER};

public class University {
    BufferedReader reader;
	/**
	 * All the instructors at the University organized by their ID 
         * numbers.
	 */
	private Hashtable<String, Instructor> faculty;
	
	/**
	 * All the courses offered at the University organized by name.
	 */
	private Hashtable<String, Course> classes;

	/**
	 * All the students at the University organized by their ID numbers.
	 */
	private Hashtable<Integer, Student> students;	
	
	/**
	 * Initializes lists of Instructors, Students, Courses etc that make
	 * up the University.
	 */
	public University (){
		reader = new BufferedReader(new InputStreamReader(System.in));
		faculty = new Hashtable<String, Instructor>();
		classes = new Hashtable<String, Course>();
		students = new Hashtable<Integer, Student>();
	}
	
	/** 
	 * Creates Instructors and adds them to the University.
	 * @param name  The name of the Instructor to add.
	 */
	public Instructor addInstructor (String name){
		Instructor i = new Instructor(name);
		faculty.put(name, i);
		return i;
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
	public Course createCourse (String name, Instructor i){
		Course c = new Course(name, i);
		classes.put(name.toLowerCase().trim(), c);
		
		return c; 
	}
	
	public Student createStudent(String name){
		Student s = new Student(name);
		students.put(s.getId(), s);
		return s;
	}
	
	/**
	 * Checks whether the id is a valid UniversityMember
	 * 
	 * @param userEnteredId The id entered at the command line.
	 * @return the type of university member that the id represents
	 */
	public UniMemberType checkMember(int userEnteredId){
		try{
			if(students.containsKey(userEnteredId)){
				return UniMemberType.STUDENT;
			}
			if(faculty.containsKey(userEnteredId)){
				return UniMemberType.INSTRUCTOR;
			}
		}catch (NumberFormatException e){
			System.out.println("Invalid ID is not a number.");
			return UniMemberType.OUTSIDER;
		}
		return UniMemberType.OUTSIDER;
	}
	
	/**
	 * Queries the user for a valid course name.
	 * @param queryPurpose A string tacked on to the end of the user query
	 * to signify the use of the course name of student or instructor related
	 * i/o.
	 * @return Returns a valid course name formatted to be used as a key.
	 */
	public String validateCourseName(String queryPurpose) throws IOException{
		String courseName = null;
		boolean validCourse = false;
		do{
			System.out.print("Enter the course name " + queryPurpose);
			courseName = reader.readLine().toLowerCase().trim();
			if(classes.containsKey(courseName)){
	    		return courseName;
	    	}
	    	else{
	    		System.out.println("That's not a valid course name.");
	    	}
		}while(!validCourse);
		return courseName;
	}
	
	public void instructorIO(int id) throws IOException{
		System.out.println("Instructor IO");
		String courseName = validateCourseName("to begin entering grades: ");
	}

	/**
	 * Output the student's grade in a course. 
	 * @param reader The command line reader.
	 * @param id The student's id.
	 */
	public void studentIO(int id) throws IOException{
		String courseName;
		boolean validCourse = false;
		System.out.println("Student IO");		
	    do{
	    	System.out.print("Enter the course name to see your grade: ");
	    	courseName = reader.readLine();		    
	    	if(classes.containsKey(courseName.toLowerCase().trim())){
	    		String gradeInClass = 
	    				classes.get(courseName.toLowerCase().trim()).getGrade(id);
	    		System.out.println(gradeInClass);
	    	}
	    	else{
	    		System.out.println("That's not a valid course name.");
	    	}
	    }while(!validCourse);
	}

	/**
	 * Driver.  Creates O
	 * @param args
	 * @throws IOException If I/O error occurs.
	 */
	public static void main(String[] args) throws IOException, 
	NumberFormatException{	
		University rc = new University();
		System.out.println("** Welcome to Distracted University **");
		
		// Create instructors
		Instructor ia = rc.addInstructor("Henry Wallace");
		Instructor ib = rc.addInstructor("Sid Jenkins");
		Instructor ic = rc.addInstructor("Ramona Beesley");

	
		// create courses
	    Course c1 = rc.createCourse("Math 101", 
	    		rc.getInstructor(ic.getName()));
	    Course c2 = rc.createCourse("Psychology 143", 
	    		rc.getInstructor(ib.getName()));
	    Course c3 = rc.createCourse("Agriculture 124", 
	    		rc.getInstructor(ia.getName()));
	    Course c4 = rc.createCourse("Nutrition 101", 
	    		rc.getInstructor(ic.getName()));
	    
	    // create students 
	    Student s1 = rc.createStudent("Kelsey Grammar");  
	    Student s2 = rc.createStudent("Bell Brady");
	    Student s3 = rc.createStudent("Brian McKnight");
	
	    //add students to courses
	    s1.addCourse(c1);
	    s1.addCourse(c3);
	    s2.addCourse(c4);
	    s3.addCourse(c2);
	    s3.addCourse(c3);
	    s3.addCourse(c1);
	    
	    
	    
	    // get user id
	    int id = 0;
	    UniMemberType member = UniMemberType.OUTSIDER;
	    
	    do{
	    	System.out.print("Please enter your ID number: ");	    	
	    	try{
	    		id = Integer.valueOf(rc.reader.readLine());
	    	}catch(NumberFormatException e){
	    		System.out.println("Invalid ID number was entered.");
	    		continue;
	    	}
	    	member = rc.checkMember(id);
	    	if(member == UniMemberType.OUTSIDER){
	    		System.out.println("Invalid ID number was entered.");
	    	}
	    }while(member == UniMemberType.OUTSIDER);
	    
	    // identify student or instructor
    	if (UniversityMember.isStudent(Integer.valueOf(id))){
    		rc.studentIO(id);
    	}		
    	else{
    		rc.instructorIO(id);
    	}
    	rc.reader.close();
	}	
}

