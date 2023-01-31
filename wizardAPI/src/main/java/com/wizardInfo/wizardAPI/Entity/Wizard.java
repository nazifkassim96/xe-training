package com.wizardInfo.wizardAPI.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizards")
public class Wizard {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wizard_id", nullable = false)
    private Long wizard_id;

    @Column(name="wizard_name")
    private String wizard_name;
    @Column(name="wizard_age")
    private int wizard_age;

    @Column(name="joined_Date")
    private LocalDate joinedDate;
    @Column(name="wizard_activeStatus")
    private String wizard_activeStatus;



    public Wizard() {
    }

    public Wizard(String wizard_name, int wizard_age, LocalDate joinedDate, String wizard_activeStatus) {
        this.wizard_name = wizard_name;
        this.wizard_age = wizard_age;
        this.joinedDate = joinedDate;
        this.wizard_activeStatus = wizard_activeStatus;
    }

    public Long getWizard_id() {
        return wizard_id;
    }

    public void setWizard_id(Long wizard_id) {
        this.wizard_id = wizard_id;
    }

    public String getWizard_name() {
        return wizard_name;
    }

    public void setWizard_name(String wizard_name) {
        this.wizard_name = wizard_name;
    }

    public int getWizard_age() {
        return wizard_age;
    }

    public void setWizard_age(int wizard_age) {
        this.wizard_age = wizard_age;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }
    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getWizard_activeStatus() {
        return wizard_activeStatus;
    }

    public void setWizard_activeStatus(String wizard_activeStatus) {
        this.wizard_activeStatus = wizard_activeStatus;
    }
}
