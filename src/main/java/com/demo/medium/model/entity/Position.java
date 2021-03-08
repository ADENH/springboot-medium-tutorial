package com.demo.medium.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.demo.medium.dto.PositionDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = { "code", "name" })
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Position implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5046429462024401492L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Integer id;
	@NonNull
	@Column(unique = true)
	private String code;
	@NonNull
	private String name;
	@Column(name = "is_delete")
	@NonNull
	private Integer isDelete;

	@OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Employee> employees;

	public Position(PositionDto positionDto) {
		this.id = -1;
		this.code = positionDto.getCode();
		this.name = positionDto.getName();
		this.isDelete = 0;
	}

}
