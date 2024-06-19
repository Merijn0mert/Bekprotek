package com.bekprotek.bekprotek.services;

import com.bekprotek.bekprotek.controllers.*;
import com.bekprotek.bekprotek.repositories.*;
import com.bekprotek.bekprotek.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;
import java.util.*;

@Service
public class customizationService {

    private customizationRepository customizationrepo;


    @Autowired
    public customizationService(customizationRepository customizationrepo) {
        this.customizationrepo = customizationrepo;
    }


    public Collection<customizationEntity> getCustomizations() {
        return customizationrepo.findAll();
    }

    public Optional<customizationEntity> getCustomization(Long id) {
        return customizationrepo.findById(id);
    }

    public customizationEntity saveCustomization(customizationEntity custom) {
        return customizationrepo.save(custom);
    }

}