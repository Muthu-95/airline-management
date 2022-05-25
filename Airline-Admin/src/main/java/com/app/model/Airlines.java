package com.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Airlines")
public class Airlines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AirlineId")
	private Integer airlineId;
	
	@Column(name = "AirlineName")
	private String airlineName;
	
	@Column(name = "ContactNumber")
	private String contactNumber;
	
	@Column(name = "ContactAddress")
	private String contactAddress;
	
	@Column(name = "IsDeleted")
	private Byte isDeleted;
	
	@Column(name = "CreatedBy")
	private Integer createdBy;
	
	@Column(name = "CreatedOn")
	private LocalDateTime createdOn;
	
	@Column(name = "ModifiedBy")
	private Integer modifiedBy;
	
	@Column(name = "ModifiedOn")
	private LocalDateTime modifiedOn;

}
