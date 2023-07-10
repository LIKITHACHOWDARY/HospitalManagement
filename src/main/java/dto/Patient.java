package dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpServlet;

import lombok.Data;

@Entity
@Data
public class Patient extends HttpServlet{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	Date dob;
	int age;
	long mobile;
	
	@Lob
	byte[] picture;
	
	@OneToMany
	List<Appointment> appointments;
	
}
