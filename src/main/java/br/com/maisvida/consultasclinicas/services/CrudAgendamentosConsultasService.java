package br.com.maisvida.consultasclinicas.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.maisvida.consultasclinicas.orm.AgendamentosConsultas;
import br.com.maisvida.consultasclinicas.orm.Especialidade;
import br.com.maisvida.consultasclinicas.orm.Especialistas;
import br.com.maisvida.consultasclinicas.repository.ConsultasClinicasRepository;
import br.com.maisvida.consultasclinicas.repository.EspecialistasRepository;

@Service
public class CrudAgendamentosConsultasService {
	private Boolean system = true;
	private final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm:ss");
	private final ConsultasClinicasRepository consultaRepository;
	private final CrudEspecialistas crudEspercialistas;
	private final EspecialistasRepository especialistaRepository;

	public CrudAgendamentosConsultasService(ConsultasClinicasRepository consultaRepository,
			CrudEspecialistas crudEspercialistas, EspecialistasRepository especialistaRepository) {
		this.consultaRepository = consultaRepository;
		this.crudEspercialistas = crudEspercialistas;
		this.especialistaRepository = especialistaRepository;

	}

	public void begin() {
		Scanner scanner = new Scanner(System.in);
		while (system) {
			System.out.println("0 - Sair ...");
			System.out.println("1 - Agendar uma consulta");
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
		String especialidade = especialidade(scanner);
		crudEspercialistas.detalharEspecialidade(especialidade);
		System.out.println("Digite o código do especialista para realizar o agendamento");
		Long codigoEspecialista = Long.parseLong(scanner.nextLine());
		salvar(codigoEspecialista, nome, rg, telefone, dataNascimento);
		crudEspercialistas.atualizarStatusEspecialista(codigoEspecialista);
		crudEspercialistas.atualizarPacienteEspecialista(codigoEspecialista, nome);
		crudEspercialistas.detalhar(codigoEspecialista);

	}

	public String especialidade(Scanner scanner) {
		String especialidade = "";
		System.out.println("Escolha uma especialidade: ");
		System.out.println("1 - " + Especialidade.CARDIOLOGISTA.toString());
		System.out.println("2 - " + Especialidade.CLINICOGERAL.toString());
		System.out.println("3 - " + Especialidade.NEUROLOGISTA.toString());
		System.out.println("4 - " + Especialidade.PEDIATRA.toString());
		System.out.println("5 - " + Especialidade.PSIQUIATRA.toString());
		Integer function = Integer.parseInt(scanner.nextLine());
		switch (function) {
		case 1:
			especialidade = Especialidade.CARDIOLOGISTA.toString();
			break;
		case 2:
			especialidade = Especialidade.CLINICOGERAL.toString();
			break;
		case 3:
			especialidade = Especialidade.NEUROLOGISTA.toString();
			break;
		case 4:
			especialidade = Especialidade.PEDIATRA.toString();
			break;
		case 5:
			especialidade = Especialidade.PSIQUIATRA.toString();
			break;
		default:
			break;
		}
		return especialidade;
	}

	public void salvar(Long codigoEspecialista, String nome, String rg, String telefone, String dataNascimento) {
		Optional<Especialistas> opcao = especialistaRepository.findById(codigoEspecialista);
		if (opcao.isPresent()) {
			AgendamentosConsultas consulta = new AgendamentosConsultas();
			consulta.setNome(nome);
			consulta.setRg(rg);
			consulta.setTelefone(telefone);
			consulta.setDataNascimento(LocalDate.parse(dataNascimento, formatoData));
			consulta.setCodigoEspecialista(codigoEspecialista);
			consultaRepository.save(consulta);
			System.out.println("################ Consulta marcada! #####################");
		} else {
			System.out.println(
					"Não foi encontrado especialista com o código informado, verifique o número e retorne novamente");
		}
	}
}
