package cn.lijuntao.boot.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class MyRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements MyRepository<T, ID> {
	private EntityManager entityManager;

	// There are two constructors to choose from, either can be used.
	public MyRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		// This is the recommended method for accessing inherited class
		// dependencies.
		this.entityManager = entityManager;
	}

	public void sharedCustomMethod(ID id) {
		System.out.println("entityManager:" + entityManager);
	}
}
