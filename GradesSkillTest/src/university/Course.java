package university;
import java.util.HashMap;

public class Course {
  private String name;
  private Instructor instructor;
  private HashMap<Integer, Student> roster;
  
  /**
   * Sets the name and instructor for the course and creates a roster that 
   * will contain students and their grades for the course.
   * 
   * @param name The title of the course.
   * @param instructor The person teaching the course.
   */
  public Course(String name, Instructor instructor){
	  this.name = name;
	  this.instructor = instructor;
	  
	  roster = new HashMap<Integer, Student>();
  }
  
  /**
   * Adds a student to the roster.
   * @param id The ID number of the student to add to the {@link #roster}.
   */
  public void addStudent(int id, Student s){
	  roster.put(id, s);
  }
  
  
}
