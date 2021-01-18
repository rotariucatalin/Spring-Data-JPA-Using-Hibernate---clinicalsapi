package com.example.clinicalsapi;

import com.example.clinicalsapi.models.Patient;
import com.example.clinicalsapi.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClinicalsapiApplicationTests {

	@Autowired
	PatientRepository patientRepository;

	@Test
	void contextLoads() {
	}

}
