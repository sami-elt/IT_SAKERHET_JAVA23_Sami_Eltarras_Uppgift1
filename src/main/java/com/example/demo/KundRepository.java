package com.example.demo;

import com.example.demo.Kund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KundRepository extends JpaRepository<Kund, Long>{

    List <Kund> findByfirstname(String firstname);


}
