package com.wizardInfo.wizardAPI.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizards")
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)

    private Long id;
    @Column(name="wizard_name")
    private String Name;
    @Column(name="age")
    private int age;
    @Column(name="joined_Date")
    private LocalDateTime joinedDate;
    @Column(name="active_status")
    private boolean activeStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }



}
