package ch.hesperidian.landon.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ch.hesperidian.landon.domain.Person;

public class PersonDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Person pessoa = new Person();
		pessoa.setName("Denise");
		pessoa.setPhone("4335");
		pessoa.setEmail("denisea@denise");

		PersonDao pessoaDAO = new PersonDao();
		pessoaDAO.salvar(pessoa);
	}

	@Test
	@Ignore
	public void listar() {
		PersonDao personDAO = new PersonDao();
		List<Person> resultado = personDAO.listar();

		for (Person person : resultado) {
			System.out.println(person.getName() + " - " + person.getEmail());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		PersonDao personDAO = new PersonDao();
		Person person = personDAO.buscar(codigo);

		if (person == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado: ");
			System.out.println(person.getName() + " - " + person.getPhone());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;

		PersonDao personDAO = new PersonDao();
		Person person = personDAO.buscar(codigo);
		if (person == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			personDAO.excluir(person);
			System.out.println("Registro removido: ");
			System.out.println(person.getName() + " - " + person.getPhone());
		}
	}

	@Test
	public void editar() {
		Long codigo = 2L;
		PersonDao personDAO = new PersonDao();
		Person person = personDAO.buscar(codigo);
		if (person == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			person.setName("Peter");
			person.setEmail("peter@hesperidian.ch");
			
			personDAO.editar(person);
			System.out.println("Registro editado: ");
			System.out.println(person.getName() + " - " + person.getPhone());
		}
	}

}
