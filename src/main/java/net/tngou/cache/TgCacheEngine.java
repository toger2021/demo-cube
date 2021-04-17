package net.tngou.cache;

import java.io.IOException;
import java.io.Serializable;

import net.tngou.cache.fst.SerializationUtils;
import net.tngou.cache.util.FileManager;

/**
 * 文件存储换成
 * @author tngou@tngou.net
 *
 */
public class TgCacheEngine implements  CacheEngine{

	private  static FileManager fileManager;
	static
	{
		fileManager= new FileManager();
		fileManager.init();
	}
	@Override
	public void add(String cacheName, Serializable key, Object value) {
		if(cacheName!=null&&key!=null&&value!=null){		
			try {
				byte[] data = SerializationUtils.serialize(value);
				fileManager.add(cacheName, key, data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void add( Serializable key, Object value) {
		add(cacheName, key, value);	
	}
	@Override
	public Object get(String cacheName, Serializable key) {
		if(cacheName!=null&&key!=null)
		{
			try {
				byte[] data = fileManager.get(cacheName, key);
				return SerializationUtils.deserialize(data);
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public Object get( Serializable key) {		
		return get(cacheName, key);
	}

	@Override
	public void remove(String cacheName, Serializable key) {
		if(cacheName!=null&&key!=null)
		{
			fileManager.remove(cacheName, key);
		}
		
	}
	@Override
	public void remove( Serializable key) {
		remove(cacheName, key);
		
	}
	@Override
	public void clear(String cacheName) {
		if(cacheName!=null)
		{
			try {
				fileManager.clear(cacheName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void clear() {
		clear(cacheName);
		
	}
	@Override
	public void stop() {
		try {
			fileManager.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
	}

}
