package ram.learn.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ram.learn.model.Student;
import ram.learn.service.Stdserviceinterface;
import ram.learn.util.Util;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentRestController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(StudentRestController.class);

	@Autowired
	private Stdserviceinterface service;

	/*
	 * 
	 * Read JSON(student) Convert into the object format Store it into the database
	 * and return the message
	 * 
	 * 
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		/*
		 * i)Reading the data from Request and covert it to the object and store and
		 * return ii)Here we used logger for storing in log file this is uses for
		 * production environment iii)if the project will be at production environment
		 * at that we are unable to check the Request processs by using this log folder
		 * we are able to see the statement of the code we added by using the
		 * logback.xml file and we have another way to add it by using
		 * application.properties
		 */
		ResponseEntity<String> resp = null;
		logger.info("started storing the data");
		try {
			Integer id = service.saveStudent(student);
			String body = "Student " + id + " is saved";
			logger.debug("data storing::::::::::::" + id);
			resp = new ResponseEntity<String>(body, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Unable to store the data");
			resp = new ResponseEntity<String>("unable to create", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllStudents() {
		/*
		 * Fetch all rows from the DataBase by using service Sort the data by using
		 * name,Return as JSON else message part return the No data found and catch
		 * block give the response as unable to fetch the data
		 */
		ResponseEntity<?> resp = null;
		try {
			List<Student> list = service.getAllStudent();

			if (list != null && !list.isEmpty()) {
				logger.info("Data found here is   " + list.size());
				list.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
				/*
				 * Java 1.8 feature sorting comapring the one to one and it uses for
				 * caliculations list=list.stream().sorted(
				 * (s1,s2)->s1.getName().compareTo(s2.getName())) .collect(Collectors.toList());
				 */
				resp = new ResponseEntity<List<Student>>(list, HttpStatus.OK);
			} else {
				logger.info("Data not found " + list.size());
				resp = new ResponseEntity<String>("No data found", HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("Unable to fetch the data" + e.getMessage());
			resp = new ResponseEntity<String>("Unable to fetch the data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		{
			ResponseEntity<String> resp = null;
			try {
				Optional<Student> opt = service.getoneStudnet(id);
				if (opt.isPresent()) {
					Student actual = opt.get();
					Util.maptoactualobject(actual, student);
//	    Student actual=opt.get();
//	    actual.setName(student.getName());
//	    actual.setAddr(student.getAddr());
//	    actual.setCourse(student.getCourse());
//	    actual.setEmail(student.getEmail());
//	    actual.setFee(student.getFee());
					service.updateStudent(actual);
					resp = new ResponseEntity<String>("Student+" + id + "updated", HttpStatus.OK);
				} else {
					resp = new ResponseEntity<String>("Student" + id + "Not Founf", HttpStatus.BAD_REQUEST);
				}

			} catch (Exception e) {
				logger.error("Unable process the operation");
				resp = new ResponseEntity<String>("unable process the update the request",
						HttpStatus.INTERNAL_SERVER_ERROR);
				e.getMessage();
			}
			return resp;

		}
	}

	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getonestd(@PathVariable Integer id) {

		ResponseEntity<?> resp = null;

		try {
			Optional<Student> opt = service.getoneStudnet(id);
			if (opt.isPresent()) {
				logger.info("Std id exist is", +id);
				resp = new ResponseEntity<Student>(opt.get(), HttpStatus.OK);
			} else {
				logger.warn("Requested Student id not present", +id);
				resp = new ResponseEntity<String>("Requested" + id + "does'nt exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable to process the request", HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error(e.getMessage());
		}
		return resp;

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletestd(@PathVariable Integer id) {
		ResponseEntity<String> resp = null;
		try {
			boolean exist = service.isStudnetExist(id);
			if (exist) {
				service.deleteStudent(id);
				resp = new ResponseEntity<String>("Student" + id + "Successfully", HttpStatus.OK);
			} else {
				resp = new ResponseEntity<String>("Student "  +id+  " does'nt exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.error("Unable to process the request", e.getMessage());
			resp = new ResponseEntity<String>("Unable to delete", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;

	}
}
