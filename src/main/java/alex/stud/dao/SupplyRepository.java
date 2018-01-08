package alex.stud.dao;

import alex.stud.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supply,Integer> {
}
