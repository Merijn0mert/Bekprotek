package com.bekprotek.bekprotek.repositories;

import com.bekprotek.bekprotek.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressbookDAO extends JpaRepository<Contact,Long> {
    /*Contact findById(String id);*/
/*    List<Contact> findAll();*/
}
