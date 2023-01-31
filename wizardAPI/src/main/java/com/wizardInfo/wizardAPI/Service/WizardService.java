package com.wizardInfo.wizardAPI.Service;

import com.wizardInfo.wizardAPI.Entity.Wizard;
import com.wizardInfo.wizardAPI.Exception.WizardException;
import com.wizardInfo.wizardAPI.Repository.wizardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WizardService {

    @Autowired
    wizardRepository wizardRepo;

    public List<Wizard> getWizards(){
        return wizardRepo.findAll();
    }

    public void addWizard(Wizard wizard){
       wizardRepo.save(wizard);
    }

    public void deleteWizard(Long wizard_id) {
        wizardRepo.findById(wizard_id).orElseThrow(() -> new RuntimeException("INVALID ID!"));
        wizardRepo.deleteById(wizard_id);
    }

    public Wizard updateWizard(Wizard wizard) throws RuntimeException{
        wizardRepo.findById(wizard.getWizard_id()).orElseThrow(() -> new RuntimeException("INVALID ID!"));
        return wizardRepo.save(wizard);
    }
}
