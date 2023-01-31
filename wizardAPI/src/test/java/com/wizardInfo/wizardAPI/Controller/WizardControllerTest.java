package com.wizardInfo.wizardAPI.Controller;

import com.wizardInfo.wizardAPI.Entity.Wizard;
import com.wizardInfo.wizardAPI.Repository.wizardRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WizardControllerTest {
    @Autowired
    private wizardRepository TestWizardRepository;

//    private static final Logger log = LoggerFactory.getLogger(WizardControllerTest.class);
    @Test
    public void testAddWizard() {

        Wizard wizard = new Wizard();
        wizard.setWizard_id(2L);
        wizard.setWizard_name("Drago");
        wizard.setAge(200);
        wizard.setJoinedDate(LocalDate.parse("2022-09-04"));
        wizard.setActiveStatus("Y");
        TestWizardRepository.save(wizard);
        System.out.println();
        assertNotNull(TestWizardRepository.findById(3L).get());
    }

    @Test    public void testUpdateWizard(){
        Wizard wizard = TestWizardRepository.findById(7L).get();
        wizard.setWizard_name("Nazif");
        TestWizardRepository.save(wizard);
        assertNotEquals("Drago", TestWizardRepository.findById(7L).get().getWizard_name());
    }



}