package cn.lijuntao.boot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;

import cn.lijuntao.boot.entity.Diagnosis;

public class DiagnosisRepositoryCustomImpl implements DiagnosisRepositoryCustom<Diagnosis, Long>{
	
	@Autowired
	protected ElasticsearchTemplate template;
	
	@Override
	public Diagnosis templateGet(Long id) {
		//SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery("id", id)).build();
		GetQuery getQuery = new GetQuery();
		getQuery.setId(String.valueOf(id));
		return template.queryForObject(getQuery, Diagnosis.class);
	}

}
