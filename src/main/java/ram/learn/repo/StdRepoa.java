package ram.learn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ram.learn.model.Student;
@Repository
public interface StdRepoa extends JpaRepository<Student,Integer> {

}
