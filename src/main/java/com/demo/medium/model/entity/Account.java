package com.demo.medium.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonIgnoreProperties(value = {"password","hibernateLazyInitializer", "handler"}, allowSetters=true)
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7707690082574031320L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	
	@NotNull
	@Column(unique = true)
	private String username;
	
	@NotNull
	@Column(unique = true)
	@JsonIgnore
	private String password;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	private String firstName;
	private String lastName;
	
	@NotNull
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "position_id")
	private Position position;
}
