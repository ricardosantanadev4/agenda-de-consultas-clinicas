package br.com.maisvida.consultasclinicas.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.maisvida.consultasclinicas.orm.Especialistas;
import br.com.maisvida.consultasclinicas.orm.StatusEspecialistas;
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
					+ opcao.get().getHorario() + " Status do agendamento: " + opcao.get().getStatusEspecialistas());
		} else {
			System.out.println("Código não encontrado! Verifique o código e retorne novamente");
		}
	}

	public void atualizarStatusEspecialista(Long id) {
		Optional<Especialistas> opcao = especialistaRepository.findById(id);
		if (opcao.isPresent()) {
			opcao.get().setStatusEspecialistas(StatusEspecialistas.AGENDADO.toString());
			especialistaRepository.save(opcao.get());
		} else {
			System.out.println("Não foi atualizar o status do agendamento verifique o código e retorne novamente");
		}

	}

	public void atualizarPacienteEspecialista(Long id, String nomePaciente) {
		Optional<Especialistas> opcao = especialistaRepository.findById(id);
		if (opcao.isPresent()) {
			opcao.get().setPaciente(nomePaciente);
			especialistaRepository.save(opcao.get());
		} else {
			System.out.println("Não foi atualizar o status do agendamento verifique o código e retorne novamente");
		}

	}
}
