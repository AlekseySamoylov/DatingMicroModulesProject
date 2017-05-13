package com.alekseysamoylov.dating.root.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class Customer {

    private String nikName;

    private Boolean active;

    private Gender gender;


}
