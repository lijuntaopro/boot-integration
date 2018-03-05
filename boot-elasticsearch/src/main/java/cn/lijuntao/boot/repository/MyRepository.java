package cn.lijuntao.boot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	void sharedCustomMethod(ID id);
}
