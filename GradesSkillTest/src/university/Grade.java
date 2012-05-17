package university;

public class Grade {
	private Student pupil;
	private LetterGrade value;

	/**
	 * Makes a record of the grade of the student.
	 */
	public Grade (Student pupil, LetterGrade v){
		this.pupil = pupil;
		this.value = v;
	}
	
	public LetterGrade getValue(){
		return value;
	}
	
	public Student getPupil(){
		return pupil;
	}
	
}
