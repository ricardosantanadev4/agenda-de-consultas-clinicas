package br.com.maisvida.consultasclinicas.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.maisvida.consultasclinicas.orm.Especialistas;
import br.com.maisvida.consultasclinicas.repository.EspecialistasRepository;

@Service
public class CrudEspecialistas {
	private final EspecialistasRepository especialistaRepository;

	public CrudEspecialistas(EspecialistasRepository especialistaRepository) {
		this.especialistaRepository = especialistaRepository;
	}

	public void visualizar() {
		Iterable<Especialistas> listEspecialista = especialistaRepository.findAll();
		listEspecialista.forEach(especialista -> System.out.println(especialista));
	}

	public void detalharEspecialidade(String especialidade) {
		Iterable<Especialistas> especialistas = especialistaRepository.findByEspecialidade(especialidade);
		especialistas.forEach(especialista -> System.out.println(especialista));
	}

	public void salvar(Especialistas codigoEspecialista) {
		Especialistas especialista = especialistaRepository.save(codigoEspecialista);
		System.out.println(especialista.getId());
		System.out.println(especialista.getNome());
		System.out.println(especialista.getEspecialidade());
		System.out.println(especialista.getDiaDaSemana());
		System.out.println(especialista.getHorario());
	}

	public void detalhar(Long id) {
		Optional<Especialistas> opcao = especialistaRepository.findById(id);
		if (opcao.isPresent()) {
			System.out.println("################ Segue os detalhes do agendamento! #####################");
			System.out.println("Código: " + opcao.get().getId() + " Nome: " + opcao.get().getNome() + " Especialidade: "
					+ opcao.get().getEspecialidade() + " Dia da consulta: " + opcao.get().getDiaDaSemana() + " Horário "
					+ opcao.get().getHorario());
		} else {
			System.out.println("Código não encontrado! Verifique o código e retorne novamente");
		}
	}
}
