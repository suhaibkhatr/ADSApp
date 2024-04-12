package com.ads.ADS.controller;


import com.ads.ADS.model.Patient;
import com.ads.ADS.service.AddressService;
import com.ads.ADS.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/adsweb/api/v1/patient/list")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatientsSortedByLastName();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/patient/get/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        try {
            Patient patient = patientService.getPatientById(id);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } catch (PatientNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adsweb/api/v1/patient/register")
    public ResponseEntity<Patient> registerNewPatient(@RequestBody Patient patient) {
        Patient registeredPatient = patientService.registerPatient(patient);
        return new ResponseEntity<>(registeredPatient, HttpStatus.CREATED);
    }

    @PutMapping("/adsweb/api/v1/patient/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        try {
            Patient updatedPatient = patientService.updatePatient(id, patientDetails);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } catch (PatientNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/adsweb/api/v1/patient/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        try {
            patientService.deletePatient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (PatientNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/adsweb/api/v1/patient/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatients(@PathVariable String searchString) {
        List<Patient> patients = patientService.searchPatients(searchString);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
