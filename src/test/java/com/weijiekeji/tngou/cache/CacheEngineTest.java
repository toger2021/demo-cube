package com.weijiekeji.tngou.cache;

import java.util.Date;

public class CacheEngineTest {

	@org.junit.jupiter.api.Test
	public void CacheEngine() {
		
		CacheEngine engine = new TgCacheEngine();//创建缓存	
		engine.add("name",  "tngou2");//存在  默认的储存库为 default
		engine.add("table", "time", new Date()); //缓存库 table ,key=tile,value= 时间对象


		CacheEngine engine1 = new TgCacheEngine();
		Object name = engine1.get("name"); //取值
		Object time = engine1.get("table", "time"); //取值

		System.err.println(name+":"+time);
//		engine.clear("table");//清除缓存
//		engine.stop(); //关闭

	}

}
