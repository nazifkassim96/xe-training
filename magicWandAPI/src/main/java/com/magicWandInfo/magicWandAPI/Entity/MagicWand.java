package com.magicWandInfo.magicWandAPI.Entity;

import javax.persistence.*;

@Entity
@Table(name= "magic_wands")
public class MagicWand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="magic_wand_name")
    private String magicWandName;
    @Column(name="desc_wand")
    private String descriptionWand;
    @Column(name="age_limit")
    private int ageLimit;
    @Column(name="stock_wand")
    private int stockWand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
