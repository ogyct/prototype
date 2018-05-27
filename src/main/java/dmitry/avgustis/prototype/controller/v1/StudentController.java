package dmitry.avgustis.prototype.controller.v1;

import dmitry.avgustis.prototype.persist.Student;
import dmitry.avgustis.prototype.repository.StudentRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = StudentController.STUDENT_API_PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {


    public static final String STUDENT_API_PREFIX = "client/student/v1";
    private final StudentRepository repo;

    @Autowired
    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping(value = "/{name}")
    @ApiOperation("Try \"Dima\"")
    public Student getStudent(@PathVariable("name") String name) {
        //http://localhost:8081/student/v1/Dima
        return repo.findByName(name);
    }

    @PutMapping(value = "/addStudent")
    public Student addStudent(@Valid @RequestBody Student student) {
        return repo.saveAndFlush(student);
    }

    @DeleteMapping("/deleteStudent")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(long id) {
        repo.deleteById(id);
    }

    @PostMapping("/editStudent")
    public Student editStudent(Student student) {
        return repo.saveAndFlush(student);
    }

}
