package test.boot;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lijuntao.boot.entity.Diagnosis;
import cn.lijuntao.boot.entity.DiagnosisImp;
import cn.lijuntao.boot.repository.DiagnosisRepository;
import cn.lijuntao.boot.utils.JsonUtils;
import config.boot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class DiagnosisTest {
	
	@Autowired
	protected DiagnosisRepository diagnosisRepository;
	
	@Test
	public void saveAll(){
		try {
			File file = new File("C:\\Users\\lijuntao\\Desktop\\diagnosis.json");
			String str = FileUtils.readFileToString(file, "utf-8");
			List<DiagnosisImp> list = JsonUtils.toList(str, DiagnosisImp.class);
			for(DiagnosisImp imp : list){
				Diagnosis diagnosis = imp.getDiagnosis();
				diagnosisRepository.save(diagnosis);
			}
			System.out.println("保存个数：" + list.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void searchAll(){
		List<Diagnosis> searchAll = diagnosisRepository.searchAll();
		System.out.println(JsonUtils.toJson(searchAll));
	}
	
	@Test
	public void searchByName(){
		Pageable pageable = new PageRequest(0,300, Sort.Direction.DESC,"code");
		List<Diagnosis> searchAll = diagnosisRepository.searchByName("name*", "Sexuality Patterns ，Ineffective", pageable);
		System.out.println(searchAll.size());
		System.out.println(JsonUtils.toJson(searchAll));
	}
	
	@Test
	public void searchByAnyProperty(){
		Pageable pageable = new PageRequest(0,100, Sort.Direction.DESC,"code");
		List<Diagnosis> searchAll = diagnosisRepository.searchByAll("活动 AND 力", pageable);
		System.out.println(searchAll.size());
		System.out.println(JsonUtils.toJson(searchAll));
	}
	
	@Test
	public void findOne(){
		Diagnosis findOne = diagnosisRepository.findOne(101L);
		System.out.println(JsonUtils.toJson(findOne));
	}
	
	@Test
	public void findOne2(){
		Diagnosis diagnosis = diagnosisRepository.templateGet(101L);
		System.out.println(JsonUtils.toJson(diagnosis));
	}
	
	@Test
	public void save(){
		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setId(200L);
		diagnosis.setCode("1111");
		diagnosis.setName("test");
		Diagnosis save = diagnosisRepository.save(diagnosis);
		System.out.println(JsonUtils.toJson(diagnosis));
	}
}
