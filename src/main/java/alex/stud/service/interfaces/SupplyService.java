package alex.stud.service.interfaces;

import alex.stud.entity.Producer;
import alex.stud.entity.Supply;
import alex.stud.entity.User;

import java.util.List;

public interface SupplyService {
    List<Producer> getAllProducer();
    List<Supply> getAllSupply();
    void addProducer(Producer producer);
    void save(Supply supply);
}