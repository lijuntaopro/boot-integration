package cn.lijuntao.boot.repository;

import java.io.Serializable;

public interface DiagnosisRepositoryCustom<T, D extends Serializable> {
	
	public T templateGet(D d);
	
}
