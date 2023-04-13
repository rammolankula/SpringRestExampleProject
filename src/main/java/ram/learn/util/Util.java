package ram.learn.util;

import ram.learn.model.Student;

public class Util {
	public static void maptoactualobject(Student actual, Student student) {
		actual.setName(student.getName());
		actual.setAddr(student.getAddr());
		actual.setCourse(student.getCourse());
		actual.setEmail(student.getEmail());
		actual.setFee(student.getFee());

	}

}
