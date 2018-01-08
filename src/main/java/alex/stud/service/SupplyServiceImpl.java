package alex.stud.service;

import alex.stud.dao.ProducerRepository;
import alex.stud.dao.SupplyRepository;
import alex.stud.entity.Producer;
import alex.stud.entity.Supply;
import alex.stud.service.interfaces.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {
    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private SupplyRepository supplyRepository;

    @Override
    public List<Producer> getAllProducer() {
        return producerRepository.findAll();
    }

    @Override
    public List<Supply> getAllSupply() {
        return supplyRepository.findAll();
    }

    @Override
    public void addProducer(Producer producer) {
        producerRepository.save(producer);
    }

    @Override
    public void save(Supply supply) {
        supplyRepository.save(supply);
    }
}
