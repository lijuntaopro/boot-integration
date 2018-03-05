package cn.lijuntao.boot.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import freemarker.template.Template;

public class MyRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		 {
	private EntityManager entityManager;
	private ElasticsearchTemplate template;

	// There are two constructors to choose from, either can be used.
	public MyRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		// This is the recommended method for accessing inherited class
		// dependencies.
		this.entityManager = entityManager;
	}
	
	// There are two constructors to choose from, either can be used.
	public MyRepositoryImpl(Class<T> domainClass, ElasticsearchTemplate template) {
		super(domainClass, null);
		// This is the recommended method for accessing inherited class
		// dependencies.
		this.template = template;
	}
	
	
	@Transactional
	public <S extends T> S save(S entity) {
		// implementation goes here
		System.out.println(entity);
		return entity;
	}
	
	public void sharedCustomMethod(ID id) {
		System.out.println("entityManager:" + entityManager);
	}
}
