package university;

import java.util.HashMap;

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
	
	public void setValue(LetterGrade score){
		value = score;
	}
	
}
