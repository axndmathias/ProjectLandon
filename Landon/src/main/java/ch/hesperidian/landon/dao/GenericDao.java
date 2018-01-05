package ch.hesperidian.landon.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import ch.hesperidian.landon.util.HibernateUtil;

public class GenericDao<Entidade> {
	
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(entidade);
			transaction.commit();

		} catch (RuntimeException error) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw error;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = session.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}

	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long code) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = session.createCriteria(classe);
			consulta.add(Restrictions.idEq(code));
			
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
			
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}
	}
	
	public void excluir(Entidade entidade) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(entidade);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void editar(Entidade entidade) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(entidade);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
}
