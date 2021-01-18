package com.example.clinicalsapi.controllers;

import com.example.clinicalsapi.models.ClinicalData;
import com.example.clinicalsapi.models.ClinicalDataDto;
import com.example.clinicalsapi.models.Patient;
import com.example.clinicalsapi.repositories.ClinicalDataRepository;
import com.example.clinicalsapi.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class ClinicalDataController {

    @Autowired
    ClinicalDataRepository clinicalDataRepository;

    @Autowired
    PatientRepository patientRepository;

    @RequestMapping(value = "/clinicals", method = RequestMethod.POST)
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataDto clinicalDataDto) {

        Patient patient = patientRepository.findById(clinicalDataDto.getPatientId()).get();

        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(clinicalDataDto.getComponentName());
        clinicalData.setComponentValue(clinicalDataDto.getComponentValue());
        clinicalData.setMeasuredDateTime(clinicalDataDto.getMeasuredDateTime());
        clinicalData.setPatient(patient);

        return clinicalDataRepository.save(clinicalData);
    }
}
