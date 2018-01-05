package ch.hesperidian.landon.dao;

import org.junit.Test;

import ch.hesperidian.landon.domain.Person;
import ch.hesperidian.landon.domain.User;

public class UserDAOTest {

	@Test
	public void save(){
		PersonDao personDAO = new PersonDao();
		Person person = personDAO.buscar(1L);
		
		System.out.println("Pessoa Encontrada");
		System.out.println("Nome: " + person.getName());
		System.out.println("Email :" + person.getEmail());
		
		
		User user = new User();
		user.setPassword("1111");
		user.setPerson(person);
		user.setStatus(true);
		user.setType('A');
		
		UserDAO userDAO = new UserDAO();
		userDAO.salvar(user);
		System.out.println("Usuario salvo com sucesso!");
		
		
	}
	
}
