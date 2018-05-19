package dmitry.avgustis.prototype.controller.v1;

import dmitry.avgustis.prototype.persist.Student;
import dmitry.avgustis.prototype.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    final
    StudentRepository repo;

    @Autowired
    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping(value = "/{name}")
    public Student getStudent(@PathVariable("name") String name) {
        //http://localhost:8081/v1/student/Dima
        return repo.findByName(name);
    }

}
