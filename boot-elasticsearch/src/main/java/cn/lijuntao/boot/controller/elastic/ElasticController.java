package cn.lijuntao.boot.controller.elastic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lijuntao.boot.entity.Diagnosis;
import cn.lijuntao.boot.repository.DiagnosisRepository;

@RestController
@RequestMapping("/elastic")
public class ElasticController {
	
	@Autowired
    protected ElasticsearchTemplate elasticsearchTemplate;
	
	@Autowired
	protected DiagnosisRepository diagnosisRepository;
	
	@RequestMapping("/findAll")
	public List<Diagnosis> findAll(){
		Iterable<Diagnosis> findAll = diagnosisRepository.findAll();
		Iterator<Diagnosis> iterator = findAll.iterator();
		List<Diagnosis> list = new ArrayList<Diagnosis>();
		while(iterator.hasNext()){
			list.add(iterator.next());
		}
		return list;
	}
	
	@RequestMapping("/save")
	public Diagnosis save(Diagnosis diagnosis){
		
		System.out.println(diagnosis);
		
		diagnosisRepository.save(diagnosis);
		
		return diagnosis;
	}
	
	@RequestMapping("/get")
	public Diagnosis get(Long id){
		Diagnosis findOne = diagnosisRepository.findOne(id);
		return findOne;
	}
}
