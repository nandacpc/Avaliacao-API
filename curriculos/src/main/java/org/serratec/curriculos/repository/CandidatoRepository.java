package org.serratec.curriculos.repository;

import java.util.List;

import org.serratec.curriculos.model.Candidato;
import org.serratec.curriculos.model.Escolaridade;
import org.serratec.curriculos.model.StatusC;
import org.serratec.curriculos.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
	List<Candidato> findByNomeContainingIgnoreCase(String nome);
	List<Candidato> findByEscolaridade(Escolaridade escolaridade);
	List<Candidato> findByVagaDesejada(Vaga vaga);
	List<Candidato> findByStatusCurriculo(StatusC status);
}
