package nl.thuis.tutorial.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.thuis.tutorial.rest.entity.Student;
import nl.thuis.tutorial.rest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/students")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void init() {
		theStudents = new ArrayList<>();	
		theStudents.add(new Student(1, "Poornima", "Patel"));
		theStudents.add(new Student(2, "Mario", "Rossi"));
		theStudents.add(new Student(3, "Mary", "Smith"));
	}

	@GetMapping()
	public List<Student> getStudents() {
		return theStudents;
	}
	
	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if(studentId < 0 || studentId >= theStudents.size()) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudents.get(studentId);
	}

}
