package com.weijiekeji.tngou.cache;

import java.io.Serializable;

/**
 * 缓存
 * @author tngou@tngou.net
 *
 */
public interface CacheEngine {
    String cacheName="default";
    /**
     * 添加缓存
     * @param cacheName 
     * @param key 
     * @param value
     */
	public  void add(String cacheName, Serializable key, Object value);
	public  void add(Serializable key, Object value);
	/**
	 * 取得缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public  Object get(String cacheName, Serializable key);
	public  Object get(Serializable key);
	/**
	 * 删除缓存
	 * @param cacheName
	 * @param key
	 */
	public  void remove(String cacheName, Serializable key);
	public  void remove(Serializable key);
	/**
	 * 清空
	 * @param cacheName
	 */
	public  void clear(String cacheName) ;
	public  void clear() ;
	/**
	 * 关闭
	 */
	public  void stop() ;
}
