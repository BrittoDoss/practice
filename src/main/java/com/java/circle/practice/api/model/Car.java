package com.java.circle.practice.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "CAR")
public class Car {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 7)
    private String licensePlate;

    private String brand;

    private int consumption;

}
