package com.weijiekeji.tngou.cache.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;


/**
 * 文件处理
 * @author tngou@tngou.net
 *
 */
public class FileManager {
	private static final String CacheName = "default";
	private static final String Cache="target/tngou_cache";
	private static File directory = new File(Cache);
	/**
	 * 初始化
	 */
	public void init(){	
		if(!directory.isDirectory())directory.mkdir();
	}
	/**
	 * 关闭
	 * @throws IOException 
	 */
	public void close() throws IOException
	{	
		if(directory.isDirectory())FileUtils.deleteDirectory(directory);
	}
	
	/**
	 * 添加缓存
	 * @param cacheName
	 * @param key
	 * @param data
	 * @throws IOException
	 */
	public void add(String cacheName, Serializable key, byte[] data) throws IOException {
		File file=new File(directory, cacheName+File.separator+key.toString());
		System.out.println(file.getCanonicalPath());
		FileUtils.writeByteArrayToFile(file, data);
	}
	public void add(Serializable key, byte[] data) throws IOException {
		add(CacheName, key, data);
	}
	
	/**
	 * 取得缓存
	 * @param cacheName
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public byte[]  get(String cacheName, Serializable key) throws IOException {
		File file=new File(directory, cacheName+File.separator+key.toString());
		if(!file.isFile())return null;
		return FileUtils.readFileToByteArray(file);
	}
	public byte[]  get( Serializable key) throws IOException {	
		return get(CacheName, key);
	}
	
	/**
	 * 移除缓存
	 * @param cacheName
	 * @param key
	 */
	public void remove(String cacheName, Serializable key) {
		File file=new File(directory, File.separator+key.toString());
		if(file.isFile())file.delete();
	}
	public void remove( Serializable key) {
		remove(CacheName, key);
	}
	
	/**
	 * 清空缓存
	 * @param cacheName
	 * @throws IOException
	 */
	public void clear(String cacheName) throws IOException
	{
		File file=new File(directory, cacheName);
		if(file.isDirectory())FileUtils.deleteDirectory(directory);
	}
	public void clear() throws IOException
	{
		clear(CacheName);
	}
	
}
