package cn.lijuntao.boot.utils;

import java.util.Map;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;

public class ESEntity {
	
	private String index;
	
	private String type;
	
	public IndexResponse doPut(String id, Map<String,?> map){
		return ClientFactory.getInstance().prepareIndex(index, type, id).setSource(map).execute().actionGet();
	}
	
	public IndexResponse doGet(String id, Map<String,?> map){
		return ClientFactory.getInstance().prepareIndex(index, type, id).setSource(map).execute().actionGet();
	}
	
	public void doPost(){
		
	}
	
	public void doDelete(){
		
	}
	
	public GetResponse doQuery(String id){
		return ClientFactory.getInstance().prepareGet("test", "info", "101").get();
	}
	
}
