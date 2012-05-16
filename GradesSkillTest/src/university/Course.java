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
	  if(roster.containsKey(id)){
		  System.out.println("Student is already enrolled in this class.\n");
	  }
	  else{
		  roster.put(id, s);
	  }
  }
  
  /**
   * Finds the grade for a student taking this course.
   * @param id Student id.
   * @return The grade of the student.
   */
  public String getGrade(int id){
	 String report = "Your grade in " + this.name + "was ";
	  try{
		  report += instructor.getGrade(id, this).toString();
	  }catch(Instructor.GradeNotPostedException e){
		  report = "Grade has not posted yet";
	  }catch(Instructor.StudentNotInCourseException e){
		  report = "You are not enrolled in this course";
	  }
	  return report.concat(".");
  }
  /**
   * A getter for the course roster.
   * @return The list of students enrolled in the course.
   */
  public HashMap<Integer, Student> getRoster(){
	  return roster;
  }
  
  /**
   * A getter for the instructor.
   * @return The instructor.
   */
  public Instructor getInstructor(){
	  return instructor;
  }
  
  
}
