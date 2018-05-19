package dmitry.avgustis.prototype.repository;

import dmitry.avgustis.prototype.persist.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByName(String name);
}
