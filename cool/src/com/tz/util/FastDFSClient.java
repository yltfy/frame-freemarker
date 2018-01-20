package com.tz.util;


import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * 
 * FastDFSClient
 * 创建人:cool 
 * 时间：2018年1月18日-下午7:34:54 
 * @version 1.0.0
 *
 */
public class FastDFSClient {
	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageServer storageServer = null;
	private StorageClient1 storageClient = null;
	
	public FastDFSClient(String conf) throws Exception{
		if(conf.contains("classpath:")){
			conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
		}
		ClientGlobal.init(conf);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageServer = null;
		storageClient = new StorageClient1(trackerServer, storageServer);
	}
	
	/**
	 * 上传文件方法
	 */
	public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception{
		String result = storageClient.upload_file1(fileName, extName, metas);
		return result;
	}
	
	public String uploadFile(String fileName) throws Exception{
		return uploadFile(fileName, null, null);
	}
	
	public String uploadFile(String fileName, String extName) throws Exception{
		return uploadFile(fileName, extName, null);
	}
	
	/**
	 * 文件上传方法
	 * @throws MyException 
	 * @throws Exception 
	 */
	public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception{
		String result = storageClient.upload_appender_file1(fileContent, extName, metas);
		return result;
	}
	
	public String uploadFile(byte[] fileContent) throws Exception{
		return uploadFile(fileContent, null, null);
	}
	
	public String uploadFile(byte[] fileContent, String extName) throws Exception{
		return uploadFile(fileContent, extName, null);
	}
}
