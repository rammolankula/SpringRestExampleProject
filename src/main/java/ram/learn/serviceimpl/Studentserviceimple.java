package ram.learn.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ram.learn.model.Student;
import ram.learn.repo.StdRepoa;
import ram.learn.service.Stdserviceinterface;
@Service
public class Studentserviceimple implements Stdserviceinterface{
	
	@Autowired
	StdRepoa repo;

	@Override
	public Integer saveStudent(Student s) {
		s=repo.save(s);
		return s.getId();
	}

	@Override
	public void updateStudent(Student s) {
		 repo.save(s);
	}

	@Override
	public void deleteStudent(Integer Id) {
        repo.deleteById(Id);		
	}

	@Override
	public Optional<Student> getoneStudnet(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}

	@Override
	public boolean isStudnetExist(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

}
