package dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	LocalDateTime time;
	String problem;
	
	@ManyToOne
	Doctor doctor;
	
	@ManyToOne
	Patient patient;

}
