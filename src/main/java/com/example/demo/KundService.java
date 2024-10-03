package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KundService {

    @Autowired
    private KundRepository kundRepository;

    public List <Kund> findByFirstName(String firstname){
        return kundRepository.findByfirstname(firstname);
    }

    public void deleteById(long id){
         kundRepository.deleteById(id);
    }

    public void save(Kund kund){
        kundRepository.save(kund);
    }

}
