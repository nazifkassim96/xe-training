package com.OrderWand.orderWandAPI.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class wizardPojo {

    @JsonProperty("wizard_id")
    private Long wizard_id;

    @JsonProperty("wizard_name")
    private String wizard_name;

    @JsonProperty("wizard_age")
    private int wizard_age;

    @JsonProperty("joinedDate")
    private LocalDate joinedDate;

    @JsonProperty("wizard_activeStatus")
    private String wizard_activeStatus;

}
