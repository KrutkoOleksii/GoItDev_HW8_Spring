package ua.goit.hw8Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.hw8Spring.model.Producer;
import ua.goit.hw8Spring.repository.ProducerRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProducerServiceImpl implements BaseService<Producer,Long>{

//    private final ProducerRepository producerRepository;

//    @PostConstruct
//    public void test(){
//        List<Producer> producers = producerRepository.findAll();
//        System.out.println("**********************");
//        System.out.println(producers);
//    }

}
