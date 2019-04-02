package main;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarefaController {

	private final Tarefa tarefa;

	TarefaController(Tarefa tarefa) {
		this.tarefa = tarefa;
    }
    
	@GetMapping("/tarefa")
	List<Tarefa> all() {
		return tarefa.findAll();
	}

	@PostMapping("/tarefa")
	Tarefa newTarefa(@RequestBody Tarefa newTarefa) {
		return tarefa.save(newTarefa);
	}

	// Single item

	@GetMapping("/tarefa/{id}")
	Tarefa one(@PathVariable int id) {

		return tarefa.findById(id)
			.orElseThrow(() -> new TarefaNotFoundException(id));
	}

	@PutMapping("/tarefa/{id}")
	Tarefa replaceTarefa(@RequestBody Tarefa newTarefa, @PathVariable int id) {

		return tarefa.findById(id)
			.map(tarefa -> {
				tarefa.setDescricao(newTarefa.getDescricao());
                tarefa.setDataCriacao(newTarefa.getDataCriacao());
                tarefa.setSituacao(newTarefa.getSituacao());
                tarefa.setResponsavel(newTarefa.getResponsavel());
                tarefa.setHorasEstimada(newTarefa.getHorasEstimada());
				return tarefa.save(tarefa);
			})
			.orElseGet(() -> {
				newTarefa.setId(id);
				return tarefa.save(newTarefa);
			});
	}

	@DeleteMapping("/tarefa/{id}")
	void deleteTarefa(@PathVariable int id) {
		tarefa.deleteById(id);
	}
}