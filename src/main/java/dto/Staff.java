package dto;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Staff {
	@Id
	@GeneratedValue(generator = "staffid")
	@SequenceGenerator(initialValue = 101, allocationSize = 1, name = "staffid", sequenceName = "staffidf")
	private int id;
	private String name;
	private String email;
	private String password;
	private Date dob;
	private boolean status;
	private int age;
	private long mobile;
	private String gender;
	
}