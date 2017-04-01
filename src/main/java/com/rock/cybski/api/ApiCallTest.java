package com.rock.cybski.api;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class ApiCallTest {
	public String call() throws HttpException, IOException{
		String result = "";
		String uri = "http://localhost:8080/csrmt/api/demo/hello";
		GetMethod getMethod = new GetMethod(uri);
		HttpClient httpClient = new HttpClient();
		httpClient.executeMethod(getMethod);
		byte[] responseBody = getMethod.getResponseBody();			
		result = new String(responseBody);
		getMethod.releaseConnection();
        return result;
	}
	
	public static void main(String[] args) {
		ApiCallTest apiCallTest = new ApiCallTest();
		try {
			System.out.println(apiCallTest.call());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}