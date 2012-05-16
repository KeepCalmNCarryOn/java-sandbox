package university;

import java.util.HashMap;

/**
 * @author Tonisha
 *
 */
public class Instructor extends UniversityMember {
	/**
	 * Exception 
	 * Indicates that the instructor hasn't reported the grade of the student 
	 * yet.
	 * @author Tonisha Whyte
	 *
	 */
	public class GradeNotPostedException extends Exception {
		private static final long serialVersionUID = 1L;

		public GradeNotPostedException(){
			super();
		}
	}

	/**
	 * Indicates that the course does not contain a student that is being 
	 * queried.
	 * @author Tonisha Whyte
	 *
	 */
	public class StudentNotInCourseException extends Exception {
		private static final long serialVersionUID = 1L;

		public StudentNotInCourseException (){
			super();
		}
	}

	/**
	 * Collection of student grades sorted by course.
	 */
	private HashMap<Course, HashMap<Integer, Grade>> reports;
	
	/**
	 * Sets the instructors name and creates unique id.
	 * 
	 * @param name First and last name of an instructor.
	 */
	public Instructor(String name) {
		super(name);
		id = UniversityMember.nextIID++;
		reports = new HashMap<Course, HashMap<Integer,Grade>>();
	}

    /**
     * Adds the course and that course's roster to the Instructors grade 
     * reports.
     * 
     * @param crs The course to add the instructors course load {@link #report}.
     */
	public void addCourse(Course crs) {
		HashMap<Integer, Grade> gradeList = new HashMap<Integer, Grade>();
		// add all students to the report
		for(int i: crs.getRoster().keySet()){
			gradeList.put(i, null);
		}		
		reports.put(crs, gradeList);
	}
	
	/**
	 * Sets the grade for a student in a particular course.
	 * 
	 * @param crs The course that the student is being graded on.
	 * @param id The id number of the student in the course.
	 * @param grade The grade the student earned.
	 */
	public void setGrade(Course crs, int id, LetterGrade score){
		try{
			//TODO error check for empty course
			Grade grade = reports.get(crs).get(id);
		    grade.setValue(score);
		}catch (NullPointerException e){
			//TODO complete error check for no students/grades in course.
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the grade of the student in the course.
	 * @param student Student id number.
	 * @param crs A course this instructor teaches.
	 * @return Grade of student in the given course.
	 * @throws GradeNotPostedException If instructor hasn't stored a grade for
	 * this student and course pair.
	 */
	public Grade getGrade(int student, Course crs) 
			throws GradeNotPostedException, StudentNotInCourseException{
		HashMap<Integer, Grade> gradeList = reports.get(crs);
		Grade g = null;

		if (gradeList.containsKey(student)){
			g = gradeList.get(student);
			if (g == null){
				throw new GradeNotPostedException();
			}
		}
		else {
			throw new StudentNotInCourseException();
		}
		return g;
	}
}