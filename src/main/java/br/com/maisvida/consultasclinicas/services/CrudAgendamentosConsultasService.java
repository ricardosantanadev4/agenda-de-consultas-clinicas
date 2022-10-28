package br.com.maisvida.consultasclinicas.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.maisvida.consultasclinicas.orm.AgendamentosConsultas;
import br.com.maisvida.consultasclinicas.orm.Especialidade;

@Service
public class CrudAgendamentosConsultasService {
	private Boolean system = true;
	private final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm:ss");
//	private final ConsultasClinicasRepository consultaRepository;
	private final CrudEspecialistas crudEspercialistas;

//	public CrudAgendamentosConsultasService(ConsultasClinicasRepository consultaRepository) {
////		super();
//		this.consultaRepository = consultaRepository;
//	}

	public CrudAgendamentosConsultasService(CrudEspecialistas crudEspercialistas) {
//		super();
		this.crudEspercialistas = crudEspercialistas;
	}

	public void begin() {
		Scanner scanner = new Scanner(System.in);
		while (system) {
			System.out.println("0 - Sair ...");
			System.out.println("1 - Agendar uma consulta");
			System.out.println("2 - Listar especialistas");
//			System.out.println("2 - Cancelar agendamento");
//			System.out.println("3 - Consultar agendamento");
//			System.out.println("4 - Alterar data de agendamento");
			Integer teste = Integer.parseInt(scanner.nextLine());
			switch (teste) {
			case 1:
				agendarConsulta(scanner);
				break;
			case 2:
				crudEspercialistas.visualizar();
				break;
			default:
				system = false;
				System.out.println("Saindo ...");
				break;
			}
		}
	}

	private void agendarConsulta(Scanner scanner) {
		AgendamentosConsultas consulta = new AgendamentosConsultas();
		System.out.println("Informe seu nome");
		String nome = scanner.nextLine();
		System.out.println("Informe seu rg");
		String rg = scanner.nextLine();
		System.out.println("Informe um telefone para contato");
		String telefone = scanner.nextLine();
		System.out.println("Informe sua data de nascimento");
		String dataNascimento = scanner.nextLine();
		especialistas(scanner, consulta);
		System.out.println("Escolha um especialista");
		crudEspercialistas.visualizar();
//		String especialista = scanner.nextLine();
		consulta.setNome(nome);
		consulta.setRg(rg);
		consulta.setTelefone(telefone);
		consulta.setDataNascimento(LocalDate.parse(dataNascimento, formatoData));
//		consulta.setHoraDaConsulta(LocalTime.parse(horaConsulta, formatHora));
//		consultaRepository.save(consulta);

	}

	public void especialistas(Scanner scanner, AgendamentosConsultas consulta) {
		System.out.println("Escolha um especialista:");
		System.out.println("1 - " + Especialidade.CARDIOLOGISTA.toString());
		System.out.println("2 - " + Especialidade.CLINICOGERAL.toString());
		System.out.println("3 - " + Especialidade.NEUROLOGISTA.toString());
		System.out.println("4 - " + Especialidade.PEDIATRA.toString());
		System.out.println("5 - " + Especialidade.PSIQUIATRA.toString());
		Integer function = Integer.parseInt(scanner.nextLine());
		switch (function) {
		case 1:
			consulta.setEspecialista(Especialidade.CARDIOLOGISTA.toString());
//			consultaRepository.save(consulta);
			break;
		case 2:
			consulta.setEspecialista(Especialidade.CLINICOGERAL.toString());
//			consultaRepository.save(consulta);
			break;
		case 3:
			consulta.setEspecialista(Especialidade.NEUROLOGISTA.toString());
//			consultaRepository.save(consulta);
			break;
		case 4:
			consulta.setEspecialista(Especialidade.PEDIATRA.toString());
//			consultaRepository.save(consulta);
			break;
		case 5:
			consulta.setEspecialista(Especialidade.PSIQUIATRA.toString());
//			consultaRepository.save(consulta);
			break;
		default:
			break;
		}
	}
}
