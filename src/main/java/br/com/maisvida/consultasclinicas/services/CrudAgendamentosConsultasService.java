package br.com.maisvida.consultasclinicas.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.maisvida.consultasclinicas.orm.AgentamentosConsultas;
import br.com.maisvida.consultasclinicas.repository.ConsultasClinicasRepository;

@Service
public class CrudAgendamentosConsultasService {
	private Boolean system = true;
	private final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm:ss");
	private final ConsultasClinicasRepository consultaRepository;

	public CrudAgendamentosConsultasService(ConsultasClinicasRepository consultaRepository) {
//		super();
		this.consultaRepository = consultaRepository;
	}

	public void begin() {
		Scanner scanner = new Scanner(System.in);
		while (system) {
			System.out.println("0 - Sair ...");
			System.out.println("1 - Agendar uma consulta");
			System.out.println("2 - Cancelar agendamento");
			System.out.println("3 - Consultar agendamento");
			System.out.println("4 - Alterar data de agendamento");
			Integer teste = Integer.parseInt(scanner.nextLine());
			switch (teste) {
			case 1:
				agendarConsulta(scanner);
				break;
			default:
				system = false;
				System.out.println("Saindo ...");
				break;
			}
		}
	}

	private void agendarConsulta(Scanner scanner) {
		System.out.println("Informe seu nome");
		String nome = scanner.nextLine();
		System.out.println("Informe seu rg");
		String rg = scanner.nextLine();
		System.out.println("Informe um telefone para contato");
		String telefone = scanner.nextLine();
		System.out.println("Informe sua data de nascimento");
		String dataNascimento = scanner.nextLine();
		System.out.println("Informe o horário da consulta");
		String horaConsulta = scanner.nextLine();
		AgentamentosConsultas consulta = new AgentamentosConsultas();
		consulta.setNome(nome);
		consulta.setRg(rg);
		consulta.setTelefone(telefone);
		consulta.setDataNascimento(LocalDate.parse(dataNascimento, formatoData));
		consulta.setHoraDaConsulta(LocalTime.parse(horaConsulta, formatHora));
		consultaRepository.save(consulta);

	}
}
