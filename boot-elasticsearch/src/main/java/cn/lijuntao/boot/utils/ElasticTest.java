package cn.lijuntao.boot.utils;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

public class ElasticTest {
    TransportClient client;
    @Before
    public void before() throws UnknownHostException, InterruptedException, ExecutionException {
        Settings esSettings = Settings.builder()
                .put("cluster.name", "elasticsearch") //设置ES实例的名称
                .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();
        client = new PreBuiltTransportClient(Settings.EMPTY);//初始化client较老版本发生了变化，此方法有几个重载方法，初始化插件等。
        //此步骤添加IP，至少一个，其实一个就够了，因为添加了自动嗅探配置
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("1"), 9300));
    }
    
    @Test
    public void index(){
    	Log log = LogFactory.getLog("sdfsf");
        Map<String,Object> infoMap = new HashMap<String, Object>();
        infoMap.put("name", "sdfadga");
        infoMap.put("title", "sdlka");
        infoMap.put("createTime", new Date());
        infoMap.put("count", 102);
        IndexResponse indexResponse = client.prepareIndex("test", "info","101").setSource(infoMap).execute().actionGet();
        System.out.println("id:"+indexResponse.getId());
    }
    
    @Test
    public void get() throws Exception {
        GetResponse response = client.prepareGet("test", "info", "101").get();
//                .execute().actionGet();  
        System.out.println("response.getId():"+response.getId());  
        System.out.println("response.getSourceAsString():"+response.getSourceAsString());  
    }
    
    @Test
    public void query() throws Exception {
        //term查询
//        QueryBuilder queryBuilder = QueryBuilders.termQuery("age", 50) ;
        //range查询
        QueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("name");
        SearchResponse searchResponse = client.prepareSearch("diagnosis")
                .setTypes("diagnosis")
                .setQuery(rangeQueryBuilder)
                .addSort("count", SortOrder.DESC)
                .setSize(20)
                .execute()
                .actionGet();
/*        SearchResponse searchResponse = client.prepareSearch("test")
        		.setTypes("info")
        		.setQuery(rangeQueryBuilder)
        		.addSort("count", SortOrder.DESC)
        		.setSize(20)
        		.execute()
        		.actionGet();
*/        
        SearchHits hits = searchResponse.getHits(); 
        System.out.println("查到记录数："+hits.getTotalHits());
        SearchHit[] searchHists = hits.getHits();
        if(searchHists.length>0){
            for(SearchHit hit:searchHists){
                Set<Entry<String,Object>> set = hit.getSource().entrySet();
                for(Entry<String,Object> entry : set){
                	System.out.println(entry.getKey() + ":" + entry.getValue());
                }
            }
        }
    }
    
    
}
