package university;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
enum LetterGrade {A, B, C, D, F, P, NP};
enum UniMemberType {STUDENT, INSTRUCTOR, OUTSIDER};

public class University {
    BufferedReader reader;
	/**
	 * All the instructors at the University organized by their ID 
     * numbers.
	 */
	private Hashtable<Integer, Instructor> faculty;
	
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
		faculty = new Hashtable<Integer, Instructor>();
		classes = new Hashtable<String, Course>();
		students = new Hashtable<Integer, Student>();
	}
	
	/** 
	 * Creates Instructors and adds them to the University.
	 * @param name  The name of the Instructor to add.
	 */
	public Instructor addInstructor (String name){
		Instructor i = new Instructor(name);
		faculty.put(i.getId(), i);
		return i;
	}


	/**
	 * Returns an Instructor given that instructors name.
	 * 
	 * @param name The name of the Instructor to return.
	 */
	public Instructor getInstructor(int id){
		return faculty.get(id);
	}

	
	/**
	 * Adds courses to the University.
	 * 
	 * @param name The name of the course to be added.
	 * @param i The instructor that teaches the course.
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
	public String validateCourseName(String queryPurpose, int id) 
			throws IOException{
		String courseName = null;
		boolean validCourse = false;
		do{
			System.out.print("Enter the course name " + queryPurpose);
			courseName = reader.readLine().toLowerCase().trim();
			if(classes.containsKey(courseName)){
				Course crs = classes.get(courseName);
				//check whether student is enrolled in this course
				if(students.containsKey(id)){ 
					if(crs.getRoster().containsKey(id)){
						return courseName;
					}
					else{
						System.out.println("You are not enrolled in this" +
								" course!!");
						continue;
					}
				}
				// check whether professor is teaching this course 
				else{
					if(crs.getInstructor().getId() == id){
						return courseName;
					}
					else{
						System.out.println("You do not teach this course.");
						continue;
					}					
				}
	    	}
	    	else{
	    		System.out.println("That's not a valid course name.");
	    	}
		}while(!validCourse);
		return courseName;
	}
	
	public void instructorIO(int id) throws IOException{
		System.out.println("Instructor IO");
		Instructor instructor = faculty.get(id);
		String[] courseLoad = instructor.getClasses();
		
		// display all the courses this instructor teaches
		System.out.println("Here is your course load:");
		for (String s : courseLoad){
			System.out.println(s);
		}	
		
		//retrieve course to grade
		String courseName = validateCourseName("to begin entering grades: ", 
				id);
		Course crs = classes.get(courseName);
		
		//display all the students in the course
		HashMap<Integer, Student> roster = classes.get(courseName).getRoster();
		Set<Integer> pupils = roster.keySet();
		System.out.println("Here are your students: ");
		System.out.printf("%1$9s %2$s\n", "id", "name");
		System.out.printf("%1$9s %2$s\n", "--", "----");
		for(Integer i : pupils){
			System.out.printf("%1$9d %2$s\n", i, roster.get(i).getName()); 
		}
		
		// Post the grade for students
		int expectedTokens = 2;
		int studentToGrade = 0;
		String[] tokensIn;
		Grade grade = null;
		String errorMsg = "Student-grade combo not entered correctly." +
				"  Try again.";
		
		do{
			System.out.print("Enter [id grade] or \"STOP\": ");
			tokensIn = reader.readLine().split("\\s");
			
			// query again if both student and id were not entered
			if (tokensIn.length < expectedTokens){
				if(!tokensIn[0].equalsIgnoreCase("STOP")){
					System.out.println(errorMsg);
				}
				continue;
			}
			
			// collect student id
			try {
				studentToGrade = Integer.parseInt(tokensIn[0]);
				// check if student is enrolled in class
				if(!crs.getRoster().containsKey(studentToGrade)){
					System.out.println("This student is not enrolled in this" +
							" class.");
					continue;					
				}
			}catch(NumberFormatException e){
				System.out.println(errorMsg);
				continue;
			}

			// collect grade
			String theirGrade = tokensIn[1];
			Student pupil = students.get(studentToGrade);
			if(theirGrade.length() < 1){
				System.out.println(errorMsg);
				continue;				
			}
			else{
				if(theirGrade.equalsIgnoreCase("A")){
					grade = new Grade(pupil, LetterGrade.A);
				}
				else if(theirGrade.equalsIgnoreCase("B")){
					grade = new Grade(pupil, LetterGrade.B);
				}
				else if(theirGrade.equalsIgnoreCase("C")){
					grade = new Grade(pupil, LetterGrade.C);
				}
				else if(theirGrade.equalsIgnoreCase("D")){
					grade = new Grade(pupil, LetterGrade.D);
				}
				else if(theirGrade.equalsIgnoreCase("F")){
					grade = new Grade(pupil, LetterGrade.F);
				}
				else if(theirGrade.equalsIgnoreCase("P")){
					grade = new Grade(pupil, LetterGrade.B);
				}
				else if(theirGrade.equalsIgnoreCase("NP")){
					grade = new Grade(pupil, LetterGrade.NP);
				}
				else{
					System.out.println(errorMsg);
					continue;
				}
			}
			instructor.setGrade(crs, studentToGrade, grade);
		}while(!tokensIn[0].equalsIgnoreCase("STOP"));
		
		//display all the students and their grades
		System.out.println("Here are the grades you reported: ");
		System.out.printf("%1$9s %2$25s %3$25s\n", "id", "name", "grade");
		System.out.printf("%1$9s %2$25s %3$25s\n", "--", "----", "-----");
		for(Integer p : pupils){
			String pupilName = roster.get(p).getName();
			String pupilGrade = null;
			try{
				pupilGrade = instructor.getGrade(p, crs).getValue().toString();
			}catch(Instructor.GradeNotPostedException e){
				pupilGrade = "Not posted yet";
			}
			System.out.printf("%1$9d %2$25s %3$25s\n", p, pupilName, 
					pupilGrade); 
		}		
		
	}

	/**
	 * Output the student's grade in a course. 
	 * @param reader The command line reader.
	 * @param id The student's id.
	 */
	public void studentIO(int id) throws IOException{
		System.out.println("Student IO");				
		String courseName = validateCourseName("to see your grade: ", id);
	    String gradeInClass = 
	    		classes.get(courseName).getGrade(id);
	    System.out.println(gradeInClass);
	}

	/**
	 * Driver.  
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
	    		rc.getInstructor(ic.getId()));
	    Course c2 = rc.createCourse("Psychology 143", 
	    		rc.getInstructor(ib.getId()));
	    Course c3 = rc.createCourse("Agriculture 124", 
	    		rc.getInstructor(ia.getId()));
	    Course c4 = rc.createCourse("Nutrition 101", 
	    		rc.getInstructor(ic.getId()));
	    
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
	    
	    boolean stop = false;
	    while(!stop){
		    // get user id
		    int id = 0;
		    UniMemberType member = UniMemberType.OUTSIDER;
	    	do{
	    		String c_line = null;
	    		System.out.print("Please enter your ID number: ");	    	
	    		try{
	    			c_line = rc.reader.readLine();
	    			id = Integer.valueOf(c_line);
	    		}catch(NumberFormatException e){
	    			if (c_line.equalsIgnoreCase("STOP")){
	    				stop = true;
	    			}
	    			else{
	    				System.out.println("Invalid ID number was entered.");
	    			}
	    			continue;
	    		}
	    		member = rc.checkMember(id);
	    		if(member == UniMemberType.OUTSIDER){
	    			System.out.println("Invalid ID number was entered.");
	    		}
	    	}while(member == UniMemberType.OUTSIDER);


	    	// start student or instructor i/o.
	    	switch(member){
	    	case STUDENT:
	    		rc.studentIO(id);
	    		break;
	    	case INSTRUCTOR:
	    		rc.instructorIO(id);
	    	}
	    }
    	rc.reader.close();
	}	
}