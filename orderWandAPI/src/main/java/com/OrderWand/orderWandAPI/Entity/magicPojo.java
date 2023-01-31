package com.OrderWand.orderWandAPI.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class magicPojo {

    @JsonProperty("magicWand_id")
    private Long magicWand_id;

    @JsonProperty("magicWandName")
    private String  magicWandName;

    @JsonProperty("descriptionWand")
    private String  descriptionWand;

    @JsonProperty("ageLimit")
    private int ageLimit;

    @JsonProperty("stockWand")
    private int stockWand;
}
