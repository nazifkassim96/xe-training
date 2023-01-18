package com.wizardInfo.wizardAPI.Controller;


import com.wizardInfo.wizardAPI.Entity.Wizard;
import com.wizardInfo.wizardAPI.Repository.wizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8073/"})
@RestController
@RequestMapping("/api")
public class WizardController {

    @Autowired
    private wizardRepository WizardRepository;

    private Wizard wizard = new Wizard();

    public WizardController(wizardRepository WizardRepository){
        this.WizardRepository = WizardRepository;

    }
    @GetMapping("/wizardList")

    public List<Wizard> getWizardList(){
        return WizardRepository.findAll();
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody Wizard wizard){
        Wizard w = new Wizard();
        w.setName(wizard.getName());
        w.setAge(wizard.getAge());
        w.setActiveStatus(wizard.isActiveStatus());
        w.setJoinedDate(wizard.getJoinedDate());
        WizardRepository.save(w);
    }

    @DeleteMapping("delete/{orderId}")
    public void deleteOrder(@PathVariable(value="wizardID")long id){
        WizardRepository.deleteById(id);
    }

    @PutMapping("update/{orderId}")
    public void updateOrder(@RequestBody Wizard wizard){
        WizardRepository.save(wizard);
    }


}

