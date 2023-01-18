package com.OrderWand.orderWandAPI.Entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name= "wizard_id")
    private int wizardID;
    @Column(name = "wand_id")
    private int wandID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWizardID() {
        return wizardID;
    }

    public void setWizardID(int wizardID) {
        this.wizardID = wizardID;
    }

    public int getWandID() {
        return wandID;
    }

    public void setWandID(int wandID) {
        this.wandID = wandID;
    }



}
