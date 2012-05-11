package university;

import java.util.HashMap;

/**
 * @author Tonisha
 *
 */
public class Instructor extends UniversityMember {
	private HashMap<Course, HashMap<Integer, Grade>> reports;
	
	/**
	 * Sets the instructors name and creates unique id.
	 * 
	 * @param name First and last name of an instructor.
	 */
	public Instructor(String name) {
		super(name);
		id = UniversityMember.nextIID++;
	}

    /**
     * Records that the Instructor is teaching the course that was passed in.
     * 
     * @param crs The course to add the instructors course load {@link #report}.
     */
	public void addCourse(Course crs) {
		reports.put(crs, new HashMap<Integer, Grade>());
		
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

}
