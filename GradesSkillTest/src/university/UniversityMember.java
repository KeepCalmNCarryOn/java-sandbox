package university;

public abstract class UniversityMember {
	/**
	 * The minimum value for all student IDs.
	 */
	private static final int sidStart = 1000000;
	/**
	 * The latest ID number available for a new student.
	 */
	protected static int nextSID = sidStart;

	/**
	 * The latest ID number available for a new instructor.
	 */
	protected static int nextIID = 1;
	
	/**
	 * Unique number associated with each {@link UniversityMember}. 
	 */
	protected int id;
	
	/**
	 * First and last name.
	 */
	protected String name;
	
	protected UniversityMember(String name){
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public abstract void addCourse(Course crs);
	
	/**
	 * Checks the value of the given id against {@link UniversityMember#sidStart} to
     * see if the id represents a {@link Student}.
	 * 
	 * @param id The id of the university member.
	 * @return False if it's not a student
	 */
	public static boolean isStudent(int id){
		if (id >= sidStart){
			return true;
		}
		return false;
	}
	
}
