package com.nt.runner;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repo.DoctorRepository;

@Component
public class DoctorRunner implements CommandLineRunner {

	@Autowired
	private DoctorRepository repo;

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			IO.println("\n===== DOCTOR MANAGEMENT SYSTEM =====");
			IO.println("1. Find doctors whose names match LIKE '%Raj%'");
			IO.println("2. Find doctors whose specialization is in Cardiology or Neurology");
			IO.println("3. Find doctors whose names start with 'Dr. A'");
			IO.println("4. Find doctors whose names end with 'Kumar'");
			IO.println("5. Find doctors located in Chennai or Bengaluru");
			IO.println("6. Find hospitals matching LIKE '%Care%'");
			IO.println("7. Find doctors with email ending '@hospital.com'");
			IO.println("8. Find specializations starting with 'Ortho'");
			IO.println("9. Update doctor record and verify version increments");
			IO.println("10. Verify createdAt unchanged and updatedAt changed");
			IO.println("11. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			case 1 -> {
				IO.println("\nDoctors whose name contains Raj:");
				repo.findByDoctorNameLike("%Raj%").forEach(IO::println);
			}

			case 2 -> {
				IO.println("\nDoctors with Cardiology or Neurology specialization:");
				repo.findBySpecializationIn(List.of("Cardiology", "Neurology")).forEach(IO::println);
			}

			case 3 -> {
				IO.println("\nDoctors whose name starts with Dr. A:");
				repo.findByDoctorNameStartingWith("Dr. A").forEach(IO::println);
			}

			case 4 -> {
				IO.println("\nDoctors whose name ends with Kumar:");
				repo.findByDoctorNameEndingWith("Kumar").forEach(IO::println);
			}

			case 5 -> {
				IO.println("\nDoctors located in Chennai or Bengaluru:");
				repo.findByCityIn(List.of("Chennai", "Bengaluru")).forEach(IO::println);
			}

			case 6 -> {
				IO.println("\nHospitals matching Care:");
				repo.findByHospitalNameLike("%Care%").forEach(IO::println);
			}

			case 7 -> {
				IO.println("\nDoctors with email ending @hospital.com:");
				repo.findByEmailEndingWith("@hospital.com").forEach(IO::println);
			}

			case 8 -> {
				IO.println("\nSpecializations starting with Ortho:");
				repo.findBySpecializationStartingWith("Ortho").forEach(IO::println);
			}

			case 9 -> {
				Long id = Long.parseLong(IO.readln("Enter Doctor Id to update : "));

				Doctor doctor = repo.findById(id).orElse(null);

				if (doctor == null) 
				{
					IO.println("Doctor not found");
				} 
				else 
				{
					Integer oldVersion = doctor.getVersion();

					IO.println("\nBefore Update:");
					IO.println("Doctor Fee : " + doctor.getConsultationFee());
					IO.println("Version    : " + oldVersion);

					Double newFee = Double.parseDouble(IO.readln("Enter New Consultation Fee : "));
					doctor.setConsultationFee(newFee);

					Doctor updatedDoctor = repo.save(doctor);

					IO.println("\nAfter Update:");
					IO.println("Doctor Fee : " + updatedDoctor.getConsultationFee());
					IO.println("Version    : " + updatedDoctor.getVersion());

					if (updatedDoctor.getVersion() > oldVersion) 
					{
						IO.println("Version incremented successfully");
					}
					else
					{
						IO.println("Version not incremented");
					}
				}
			}

			case 10 -> {
				Long id = Long.parseLong(IO.readln("Enter Doctor Id to update : "));

				Doctor doctor = repo.findById(id).orElse(null);

				if (doctor == null) 
				{
					IO.println("Doctor not found");
				} 
				else 
				{
					LocalDateTime oldCreatedAt = doctor.getCreatedAt();
					LocalDateTime oldUpdatedAt = doctor.getUpdatedAt();

					IO.println("\nBefore Update:");
					IO.println("Created At : " + oldCreatedAt);
					IO.println("Updated At : " + oldUpdatedAt);

					Thread.sleep(2000);

					Double newFee = Double.parseDouble(IO.readln("Enter New Consultation Fee : "));
					doctor.setConsultationFee(newFee);

					Doctor updatedDoctor = repo.save(doctor);

					IO.println("\nAfter Update:");
					IO.println("Created At : " + updatedDoctor.getCreatedAt());
					IO.println("Updated At : " + updatedDoctor.getUpdatedAt());

					IO.println("\ncreatedAt unchanged : " + updatedDoctor.getCreatedAt().equals(oldCreatedAt));

					IO.println("updatedAt changed    : " + updatedDoctor.getUpdatedAt().isAfter(oldUpdatedAt));
				}
			}

			case 11 -> {
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}
}