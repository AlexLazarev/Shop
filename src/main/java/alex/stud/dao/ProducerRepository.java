package alex.stud.dao;

import alex.stud.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer,Integer> {
    Producer findByName(String name);

}
