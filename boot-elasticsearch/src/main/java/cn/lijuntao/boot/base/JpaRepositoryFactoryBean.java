package cn.lijuntao.boot.base;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import cn.lijuntao.boot.repository.MyRepository;
import cn.lijuntao.boot.repository.MyRepositoryImpl;

public class JpaRepositoryFactoryBean {
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new MyRepositoryFactory(entityManager);
	}

	private static class MyRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {
		private EntityManager entityManager;

		public MyRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.entityManager = entityManager;
		}
		
		protected Object getTargetRepository(RepositoryMetadata metadata) {
			return new MyRepositoryImpl<T, I>((Class<T>) metadata.getDomainType(), entityManager);
		}

		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			 // The RepositoryMetadata can be safely ignored, it is used by the
			 //to check for QueryDslJpaRepository's which is out of scope.
			 return MyRepository.class;
		}
	}
}
