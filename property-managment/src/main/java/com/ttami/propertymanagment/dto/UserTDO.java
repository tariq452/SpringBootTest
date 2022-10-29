package com.ttami.propertymanagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTDO {
    private Long id;
    private String ownerName;
    @NotNull(message = "owner Email is mandatory ")
    @Size(min = 1,max = 50,message = "owner Email should be between 1 to 50")
    private String ownerEmail;

    private String phone;
    @NotNull(message = "the password is mandatory")
    private String password;
}
