package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Doctor {
	@Id
	@GeneratedValue(generator = "doctorid")
	@SequenceGenerator(initialValue = 606061, allocationSize = 1, name = "doctorid", sequenceName = "doctorid")
	private int id;
	private String name;
	private Long mobile;
	private String gender;
	private String email;
	private String qualification;
	private String specialization;
	private String password;
	private Date dob;
	private int age;
	private boolean status;
	private boolean available;

	@OneToMany
	List<Appointment> list;

}