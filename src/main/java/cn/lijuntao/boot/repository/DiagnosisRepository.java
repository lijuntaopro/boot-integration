package cn.lijuntao.boot.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.lijuntao.boot.entity.Diagnosis;

public interface DiagnosisRepository extends ElasticsearchRepository<Diagnosis, Long>, DiagnosisRepositoryCustom<Diagnosis, Long> {
	@Query("{\"bool\":{\"must\":[{\"match_all\":{}}],\"must_not\":[],\"should\":[]}}")
	List<Diagnosis> searchAll();
	
	@Query("{\"bool\":{\"must\":[{\"query_string\":{\"default_field\":\"?0\",\"query\":\"?1\"}}],\"must_not\":[],\"should\":[]}}")
	List<Diagnosis> searchByName(String property, String name, Pageable pageable);
	
	@Query("{\"bool\":{\"must\":[{\"query_string\":{\"default_field\":\"?0\",\"query\":\"?1\"}}],\"must_not\":[],\"should\":[]}}")
	List<Diagnosis> searchByPropertyAndName(String property, String name, Pageable pageable);
	
	@Query("{\"bool\":{\"must\":[{\"query_string\":{\"default_field\":\"_all\",\"query\":\"?0\"}}],\"must_not\":[],\"should\":[]}}")
	List<Diagnosis> searchByAll(String name, Pageable pageable);
	
}