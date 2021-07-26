package com.serasa.ExperianMS.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "Client")
public class Client {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId")
	private Long Id;
    
    @Column(name = "clientName")
    private String name;
    
    @Past
    @Column(name = "clientBirthdate")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birth;
    
    @Column(name = "clientPhoneNumber")
    @Size(min = 9, max = 14)
    private Integer phoneNumber;
}
