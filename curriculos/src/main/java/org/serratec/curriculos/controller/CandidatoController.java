package org.serratec.curriculos.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.curriculos.dto.CandidatoDto;
import org.serratec.curriculos.model.Escolaridade;
import org.serratec.curriculos.model.StatusC;
import org.serratec.curriculos.model.Vaga;
import org.serratec.curriculos.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/curriculos")
public class CandidatoController {

	@Autowired
	private CandidatoService service;
	
	@GetMapping
	public List<CandidatoDto> obterTodos() {
		return service.obterTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CandidatoDto> obterPorId(@PathVariable Long id) {
		Optional<CandidatoDto> dto = service.obterPorId(id);
		if (!dto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto.get());
	}
	
	@GetMapping("/nome/{nome}")
	public List<CandidatoDto> obterPorNome(@PathVariable String nome) {
		return service.obterPorNome(nome);
		
	}
	
	@GetMapping("/escolaridade/{escolaridade}")
	public List<CandidatoDto> obterPorEscolaridade(@PathVariable Escolaridade escolaridade) {
		return service.obterPorEscolaridade(escolaridade);
	}	
	

	@GetMapping("/vaga/{vaga}")
	public List<CandidatoDto> obterPorVaga(@PathVariable Vaga vaga) {
		return service.obterPorVaga(vaga);
	}
	

	@GetMapping("/status/{status}")
	public List<CandidatoDto> obterPorStatus(@PathVariable StatusC status) {
		return service.obterPorStatus(status);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CandidatoDto adicionarCurriculo(@RequestBody @Valid CandidatoDto dto) {
		return service.salvarCurriculo(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CandidatoDto> alterarCurriculo(@PathVariable Long id, @RequestBody CandidatoDto dto) {
		Optional<CandidatoDto> curriculoAlterado = service.alterarCurriculo(id, dto);

		if (!curriculoAlterado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(curriculoAlterado.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletaPedido(@PathVariable Long id) {
		if (!service.apagarCurriculo(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
