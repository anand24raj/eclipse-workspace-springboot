package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findByDoctorNameLike(String pattern);

	List<Doctor> findBySpecializationIn(List<String> specializations);

	List<Doctor> findByDoctorNameStartingWith(String prefix);

	List<Doctor> findByDoctorNameEndingWith(String suffix);

	List<Doctor> findByCityIn(List<String> cities);

	List<Doctor> findByHospitalNameLike(String pattern);

	List<Doctor> findByEmailEndingWith(String domain);

	List<Doctor> findBySpecializationStartingWith(String prefix);

}
