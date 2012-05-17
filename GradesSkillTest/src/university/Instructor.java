package university;

import java.util.HashMap;
import java.util.Set;

/**
 * @author Tonisha
 *
 */
public class Instructor extends UniversityMember {
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
	 * Returns the instructor's course load.
	 * @return The set of classes that instructor teaches.
	 */
	public String[] getClasses(){
		Set<Course> courses = reports.keySet();
		String [] courseLoad = new String[courses.size()];
		int i = 0;
		
		for (Course c: courses){
			courseLoad[i] = c.getName();
			++i;
		}
		return courseLoad;
	}
	
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
	public void setGrade(Course crs, int id, Grade grade){
		try{
			//TODO error check for empty course
			HashMap<Integer, Grade> gradeList = reports.get(crs);
			gradeList.put(id, grade);
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
			throws GradeNotPostedException{
		HashMap<Integer, Grade> gradeList = reports.get(crs);
		Grade g = null;

			g = gradeList.get(student);
			if (g == null){
				throw new GradeNotPostedException();
			}
		return g;
	}
}