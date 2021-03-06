package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@OneToOne
	private Flight flight;
	
	private Long total;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
	private List<Passenger> passengers = new ArrayList<>();
}
