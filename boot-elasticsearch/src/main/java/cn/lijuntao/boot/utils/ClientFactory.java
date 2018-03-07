package cn.lijuntao.boot.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
public class ClientFactory {
	
	public static TransportClient getInstance(){
		Settings esSettings = Settings.builder()
                .put("cluster.name", "elasticsearch") //设置ES实例的名称
                .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();
		TransportClient client = new PreBuiltTransportClient(esSettings);//初始化client较老版本发生了变化，此方法有几个重载方法，初始化插件等。
        //此步骤添加IP，至少一个，其实一个就够了，因为添加了自动嗅探配置
        try {
			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
        return client;
	}
}
