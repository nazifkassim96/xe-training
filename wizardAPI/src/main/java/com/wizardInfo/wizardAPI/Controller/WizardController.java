package com.wizardInfo.wizardAPI.Controller;


import com.wizardInfo.wizardAPI.Entity.Wizard;
import com.wizardInfo.wizardAPI.Exception.BarsException;
import com.wizardInfo.wizardAPI.Exception.WizardException;
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
    public void addWizard(@RequestBody Wizard wizard) {
        WizardRepository.save(wizard);
    }

    @DeleteMapping("/delete/{wizard_id}")
    public void deleteWizard(@PathVariable(value="wizard_id") Long wizard_id) throws WizardException {
        if(WizardRepository.existsById(wizard_id)){
            WizardRepository.deleteById(wizard_id);
        }else{
//            throw new WizardException(WizardException.INVALID_ID);
            throw new BarsException(BarsException.FILE_NOT_SUPPORTED);
        }

//        try{
//            WizardRepository.deleteById(wizard_id);
//            return WizardRepository.toString();
//        }catch(Exception e){
////            e.printStackTrace();
//            throw new WizardException(WizardException.INVALID_ID);
//
//        }
    }

    @PutMapping("/update")
    public Wizard updateWizards(@RequestBody Wizard wizard)throws WizardException {
        //testing function
//       List<Wizard> newWizards = new ArrayList<>(wizard);
//        if(newWizards.isEmpty()){
//            throw new WizardException("INVALID ID");
//        }else {
//            WizardRepository.save(wizard);
//        }
//        return newWizards;
        //old ways
//        String test = "";
//        if(WizardRepository.existsById(wizard.getWizard_id())){
//            WizardRepository.save(wizard);
//        }else{
//            return test = "INVALID ID!";
//        }
//        return test;

        WizardRepository.findById(wizard.getWizard_id()).orElseThrow(() -> new WizardException("INVALID ID"));
        return WizardRepository.save(wizard);
    }

//    @PostMapping("/test")
//    public ResponseEntity<Wizard> testUpdate (@RequestBody Wizard wizard) throws RuntimeException{
//        if(WizardRepository.existsById(wizard.getWizard_id())){
//            WizardRepository.save(wizard);
//        }else{
//            throw new WizardException("INVALID ID");
//
//
//    }
//
//    @ExceptionHandler(WizardException.class)
//    public ResponseEntity<Wizard> handleWizardException (Exception exception){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value()));
//    }

}

