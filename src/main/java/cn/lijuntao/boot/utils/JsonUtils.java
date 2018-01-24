package cn.lijuntao.boot.utils;

import java.util.List;
import com.alibaba.fastjson.JSON;

public class JsonUtils {
	
	public static <T> List<T> toList(String str, Class<T> class1){
		return JSON.parseArray(str, class1);
	}
	
	public static <T> T toObject(String str, Class<T> class1){
		return JSON.parseObject(str, class1);
	}
	
	public static <T> String toJson(T t){
		return JSON.toJSONString(t);
	}
}
