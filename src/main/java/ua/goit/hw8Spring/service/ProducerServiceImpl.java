package ua.goit.hw8Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.hw8Spring.model.Producer;
import ua.goit.hw8Spring.repository.ProducerRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProducerServiceImpl implements BaseService<Producer,Long>{

    @Autowired
    private ProducerRepository producerRepository;

    public List<Producer> findAll() {
        return  producerRepository.findAll();
    }

    public Producer findById(Long id) {
        return producerRepository.findById(id).orElse(null);
    }

    public Producer findByName(String name) {
        return producerRepository.findByName(name).orElse(null);
    }

    public Producer save(Producer producer){
        return producerRepository.save(producer);
    }


    public void deleteById(Long id){
        producerRepository.deleteById(id);
    }

}
