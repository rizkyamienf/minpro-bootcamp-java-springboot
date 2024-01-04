package com.teama.minpro.teama.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.teama.minpro.teama.model.Biodata;
import com.teama.minpro.teama.model.Doctor;
import com.teama.minpro.teama.model.DoctorEducation;
import com.teama.minpro.teama.model.DoctorOffice;
import com.teama.minpro.teama.model.DoctorSpecialization;
import com.teama.minpro.teama.model.Specialization;
import com.teama.minpro.teama.model.TreatmentDoctor;
import com.teama.minpro.teama.model.User;
import com.teama.minpro.teama.repository.BiodataRepository;
import com.teama.minpro.teama.repository.CurrentSpecializationRepository;
import com.teama.minpro.teama.repository.DoctorEducationRepository;
import com.teama.minpro.teama.repository.DoctorOfficeRepository;
import com.teama.minpro.teama.repository.DoctorRepository;
import com.teama.minpro.teama.repository.SpecializationRepository;
import com.teama.minpro.teama.repository.TreatmentRepository;
import com.teama.minpro.teama.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class ApiProfileDoctorController {
	private String imgPath = null;
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/img";

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BiodataRepository biodataRepo;

	@Autowired
	private DoctorRepository doctorRepo;

	@Autowired
	private TreatmentRepository treatmentRepo;

	@Autowired
	private DoctorOfficeRepository doctorOfficeRepo;

	@Autowired
	private DoctorEducationRepository doctorEduRepo;

	@Autowired
	private CurrentSpecializationRepository currentSpecRepo;

	@Autowired
	private SpecializationRepository specializationRepo;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUserData(@PathVariable("id") Long id) {
		try {
			User data = userRepo.findByBiodataId(id);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/profile/doctor/{id}")
	public ResponseEntity<Object> getDoctorData(@PathVariable("id") Long id) {
		try {
			Doctor data = doctorRepo.findByIdDoctor(id);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/biodata/doctor/treatment/{id}")
	public ResponseEntity<Object> getTreatmentDate(@PathVariable("id") Long id) {
		try {
			List<TreatmentDoctor> data = treatmentRepo.findByIdDoctor(id);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/doctor/office/{doctorId}")
	public ResponseEntity<Object> getDoctorOffice(@PathVariable("doctorId") Long id) {
		try {
			List<DoctorOffice> data = doctorOfficeRepo.findByDoctorId(id);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/doctor/education/{doctorId}")
	public ResponseEntity<Object> getDoctorEducation(@PathVariable("doctorId") Long id) {
		try {
			List<DoctorEducation> data = doctorEduRepo.findEducationByDoctorId(id);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/doctor/currentSpecialization/{doctorId}")
	public ResponseEntity<Object> getCurrentDoctorSpec(@PathVariable("doctorId") Long id) {
		try {
			System.out.println(id);
			DoctorSpecialization data = currentSpecRepo.findByDoctorId(id).orElse(null);
			System.out.println(data);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/{userId}/{doctorId}/currentSpecialization")
	public ResponseEntity<Object> addCurrentSpecialization(@PathVariable("userId") Long userId, @PathVariable("doctorId") Long doctorId, @RequestBody Map<String, Long> request){
		try {
			Optional<Doctor> doc = doctorRepo.findById(doctorId);
			DoctorSpecialization curr = new DoctorSpecialization();
			Long specId = request.get("specification_id");
			Specialization spec = specializationRepo.findById(specId).orElse(null);
			
			if (spec != null) {
				// Update the doctor's specialization here
				curr.setDoctorId(doctorId);
//				curr.setSpecialization(spec);
				curr.setSpecializationId(specId);
				curr.setCreatedBy(userId);
				curr.setCreatedOn(LocalDateTime.now());
				curr.setIsDelete(false);
				System.out.println(curr);
				this.currentSpecRepo.save(curr);
				System.out.println(this.currentSpecRepo);
				return new ResponseEntity<>("Add data success!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Specialization not found.", HttpStatus.NOT_FOUND);
			}
			
			
			
		}catch(Exception e) {
			return new ResponseEntity<>("Failed add data!", HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping("/{userId}/doctor/currentSpecialization/{currentSpecId}")
	public ResponseEntity<Object> editCurrentDoctorSpec(@PathVariable("userId") Long userId, @PathVariable("currentSpecId") Long id,
			@RequestBody Map<String, Long> request) {
		try {
			DoctorSpecialization curr = currentSpecRepo.findById(id).orElse(null);
			Long specId = request.get("specification_id");
			Specialization spec = specializationRepo.findById(specId).orElse(null);
			System.out.println(spec);
			System.out.println(curr);

			if (curr != null && spec != null) {
				// Update the doctor's specialization here
				curr.setSpecialization(spec);
				curr.setSpecializationId(specId);
				curr.setModifiedBy(userId);
				curr.setModifiedOn(LocalDateTime.now());
				System.out.println(curr);
				this.currentSpecRepo.save(curr);
				System.out.println(this.currentSpecRepo);
				return new ResponseEntity<>("Edit data success!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Doctor or Specialization not found.", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Failed edit data!", HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/doctor/specialization")
	public ResponseEntity<Object> getDoctorSpec() {
		try {
			List<Specialization> data = specializationRepo.findAll();
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/save")
	public ResponseEntity<Object> saveImageProfile(@RequestParam("file") MultipartFile file,
			@RequestParam("id") Long id, @RequestParam("userId") Long userId) {
		Path filenameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		try {
			Files.write(filenameAndPath, file.getBytes());
			Biodata data = this.biodataRepo.findById(id).orElse(null);
			data.setPathImage("/img/" + file.getOriginalFilename());
			data.setModifiedBy(userId);
			data.setModifiedOn(LocalDateTime.now());
			this.biodataRepo.save(data);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Upload Image", HttpStatus.BAD_REQUEST);
		}

	}

//	@GetMapping("/profile/doctor/{id}")
//	public ResponseEntity<Object> getDoctorTreatment(@PathVariable("id") Long id){
//		try {
//			Optional<Biodata> data = biodataRepo.findById(id);
//			return new ResponseEntity<>(data, HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
}
