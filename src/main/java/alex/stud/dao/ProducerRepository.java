package alex.stud.dao;

import alex.stud.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProducerRepository extends JpaRepository<Producer,Integer> {
    Producer findByName(String name);


    /*@Modifying
    @Query("UPDATE Producer SET p.name = :name, p.address = :address, p.number = :number WHERE c.id = :id")
    int updateAddress(@Param("id") int id, @Param("name") String name, @Param("address") String address, @Param("number") String number);
*/
}
