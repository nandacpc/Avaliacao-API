package org.serratec.curriculos.service;

import java.util.List;
import java.util.Optional;

import org.serratec.curriculos.dto.CandidatoDto;
import org.serratec.curriculos.model.Candidato;
import org.serratec.curriculos.model.Escolaridade;
import org.serratec.curriculos.model.StatusC;
import org.serratec.curriculos.model.Vaga;
import org.serratec.curriculos.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository repository;
	
	public List<CandidatoDto> obterTodos(){
		return repository.findAll().stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	
	public Optional<CandidatoDto> obterPorId(Long id){
		if(!repository.existsById(id)) {
			return Optional.empty();
		}
		return Optional.of(CandidatoDto.toDto(repository.findById(id).get()));
	}
	
	public CandidatoDto salvarCurriculo(CandidatoDto dto) {
		return CandidatoDto.toDto(repository.save(dto.toEntity()));
	}
	
	public boolean apagarCurriculo(Long id) {
		if(!repository.existsById(id)) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
	
	public Optional<CandidatoDto> alterarCurriculo(Long id, CandidatoDto dto){
		if(!repository.existsById(id)) {
			return Optional.empty();
		}
		Candidato candidatoEntity = dto.toEntity();
		candidatoEntity.setId(id);
		repository.save(candidatoEntity);
		return Optional.of(CandidatoDto.toDto(candidatoEntity));		
	}

	public List<CandidatoDto> obterPorNome(String nome) {
		List<Candidato> candidato = repository.findByNomeContainingIgnoreCase(nome);		
		return candidato.stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	
	public List<CandidatoDto> obterPorEscolaridade(Escolaridade escolaridade) {
		List<Candidato> candidato = repository.findByEscolaridade(escolaridade);		
		return candidato.stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	
	public List<CandidatoDto> obterPorVaga(Vaga vaga) {
		List<Candidato> candidato = repository.findByVagaDesejada(vaga);		
		return candidato.stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	
	public List<CandidatoDto> obterPorStatus(StatusC status) {
		List<Candidato> candidato = repository.findByStatusCurriculo(status);		
		return candidato.stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	
	
}
