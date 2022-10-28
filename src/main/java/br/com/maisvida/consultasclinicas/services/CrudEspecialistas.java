package br.com.maisvida.consultasclinicas.services;

import org.springframework.stereotype.Service;

import br.com.maisvida.consultasclinicas.orm.Especialistas;
import br.com.maisvida.consultasclinicas.repository.EspecialistasRepository;

@Service
public class CrudEspecialistas {
	private final EspecialistasRepository especialistaRepository;

	public CrudEspecialistas(EspecialistasRepository especialistaRepository) {
//		super();
		this.especialistaRepository = especialistaRepository;
	}

	public void visualizar() {
		Iterable<Especialistas> listEspecialista = especialistaRepository.findAll();
		listEspecialista.forEach(especialista -> System.out.println(especialista));
	}
}
