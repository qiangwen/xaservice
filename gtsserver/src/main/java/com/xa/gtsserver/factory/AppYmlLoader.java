package com.xa.gtsserver.factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

/**
 * 加载yml文件
 * @author qiang.wen
 * @date 2017年7月28日 下午2:26:20
 */
@SuppressWarnings("unchecked")
public class AppYmlLoader {

	private static Map<String,String> proMap = new HashMap<>();
	
	static{
		InputStream is = AppYmlLoader.class.getResourceAsStream("/app.yml");
		Yaml yaml = new Yaml();
		proMap = yaml.loadAs(is, HashMap.class);
	}
	
	private AppYmlLoader(){}
	
	public static String getValue(String key){
		return proMap.get(key);
	}
}
