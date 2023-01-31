package com.OrderWand.orderWandAPI.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name= "wizard_id")
    private Long wizard_id;
    @Column(name = "magicWand_id")
    private Long magicWand_id;

    @Column(name = "wizard_name")
    private String wizard_name;
    @Column(name = "wizard_age")
    private int wizard_age;
    @Column(name = "joinedDate")
    private LocalDate joinedDate;
    @Column(name = "wizard_activeStatus")
    private String wizard_activeStatus;

    @Column(name = "magicWandName")
    private String magicWandName;
    @Column(name = "descriptionWand")
    private String descriptionWand;
    @Column(name = "ageLimit")
    private int ageLimit;
    @Column(name = "stockWand")
    private int stockWand;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWizard_id() {
        return wizard_id;
    }

    public void setWizard_id(Long wizard_id) {
        this.wizard_id = wizard_id;
    }

    public Long getMagicWand_id() {
        return magicWand_id;
    }

    public void setMagicWand_id(Long magicWand_id) {
        this.magicWand_id = magicWand_id;
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

    public String getMagicWandName() {
        return magicWandName;
    }

    public void setMagicWandName(String magicWandName) {
        this.magicWandName = magicWandName;
    }

    public String getDescriptionWand() {
        return descriptionWand;
    }

    public void setDescriptionWand(String descriptionWand) {
        this.descriptionWand = descriptionWand;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getStockWand() {
        return stockWand;
    }

    public void setStockWand(int stockWand) {
        this.stockWand = stockWand;
    }
}
