package br.com.hr.worker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hr.worker.entities.Worker;
import br.com.hr.worker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
