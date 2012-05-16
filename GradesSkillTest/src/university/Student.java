package university;

public class Student extends UniversityMember {

	/**
	 * Creates a Student with a unique id.
	 * @param name The name of the student.
	 */
	public Student(String name) {
		super(name);
		id = UniversityMember.nextSID++;
	}

	/**
	 * Enrolls the student by adding it to a course roster and the instructor's
	 * report.
	 *  @param crs The course to add the student to.
	 */
	public void addCourse(Course crs) {
		crs.addStudent(id, this);
		crs.getInstructor().addCourse(crs);
	}
	
	
}
