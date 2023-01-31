package com.magicWandInfo.magicWandAPI.Entity;

import javax.persistence.*;

@Entity
@Table(name= "magic_wands")
public class MagicWand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magicWand_id", nullable = false)
    private Long magicWand_id;
    @Column(name="magicWandName")
    private String magicWandName;
    @Column(name="descriptionWand")
    private String descriptionWand;
    @Column(name="ageLimit")
    private int ageLimit;
    @Column(name="stockWand")
    private int stockWand;

    public Long getMagicWand_id() {
        return magicWand_id;
    }

    public void setMagicWand_id(Long magicWand_id) {
        this.magicWand_id = magicWand_id;
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
