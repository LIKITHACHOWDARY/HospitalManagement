package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.print.Doc;

import dto.Appointment;
import dto.Doctor;
import dto.Patient;
import dto.Staff;

public class MyDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveStaff(Staff staff) {
		et.begin();
		em.persist(staff);
		et.commit();
	}

	public void updateStaff(Staff staff) {
		et.begin();
		em.merge(staff);
		et.commit();
	}

	public void updatedoctor(Doctor doctor) {
		et.begin();
		em.merge(doctor);
		et.commit();
	}

	public void saveDoctor(Doctor doctor) {
		et.begin();
		em.persist(doctor);
		et.commit();

	}

	public Staff fetchByMobile(long mobile) {
		List<Staff> list = em.createQuery("select x from Staff x where mobile=?1")
				.setParameter(1, mobile).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	public Staff fetchByemail(String email) {
		List<Staff> list = em
				.createQuery("select x from Staff x where email=?1", Staff.class)
				.setParameter(1, email).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	public Doctor fetchdoctorbymobile(long mobile) {
		List<Doctor> list = em.createQuery("select x from Doctor x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	public Doctor fetchdoctorbyemaill(String email) {
		List<Doctor> list = em.createQuery("select x from Doctor x where email=?1", Doctor.class).setParameter(1, email)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	public List<Doctor> Fetchalldoctor() {
		return em.createQuery("select x from Doctor x").getResultList();
	}

	public List<Staff> Fetchallstaff() {
		return em.createQuery("select x from Staff x").getResultList();
	}

	public Staff fetchstaff(int id) {
		return em.find(Staff.class, id);
	}

	public Doctor fetchdoctor(int id) {
		return em.find(Doctor.class, id);
	}

	public void savePatient(Patient p) {
		et.begin();
		em.persist(p);
		et.commit();
	}

	public Patient fetchpatientbymobile(long mobile) {
		List<Patient> list = em.createQuery("select x from Patient x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public List<Patient> Fetchallpatient() {
		return em.createQuery("select x from Patient x").getResultList();
	}

	public Patient fetchpatient(int id) {
		List<Patient> list = em.createQuery("select x from Patient x where id=?1").setParameter(1, id).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public List<Doctor> fetchAvailableDoctor() {
		return em.createQuery("select x from Doctor x where available=true").getResultList();
	}

	public void updatepatient(Patient patient) {
		et.begin();
		em.merge(patient);
		et.commit();

	}

	public void saveappointment(Appointment appointment) {
		et.begin();
		em.persist(appointment);
		et.commit();
	}

	public Appointment fetchAppointment(int id) {
		List<Appointment> list = em.createQuery("select x from Appointment x where id=?1").setParameter(1, id)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public void updateAppointment(Appointment appointment) {
		et.begin();
		em.merge(appointment);
		et.commit();
	}

}