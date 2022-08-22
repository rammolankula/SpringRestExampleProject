package ram.learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ram.learn.model.Student;

@Service
public interface Stdserviceinterface {
	
	Integer saveStudent(Student s);
	void updateStudent(Student s);
	void deleteStudent(Integer id);
    Optional<Student> getoneStudnet(Integer id);
    List<Student> getAllStudent();
    boolean isStudnetExist(Integer id);

}
