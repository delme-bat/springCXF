package com.bush76.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;

public class CXFUtils {
	
	private static final String KEYSTORE_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\config\\tomcat.keystore";
	
	private static final String TRUSTSTORE_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\config\\tomcat.keystore";
	
	private static final String SSL_PASSWORD_TYPE = "jks";
	
	private static final String KEYSTORE_PASSWORD = "changeit";
	
	private static final String TRUSTSTORE_PASSWORD = "changeit";
	
	@SuppressWarnings("rawtypes")
	public static Object getCXFClientObj(Class clazz,String wsdl){
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setAddress(wsdl);
		factoryBean.setServiceClass(clazz);
		Object obj = factoryBean.create();
		CXFUtils.setSSLConnect(obj);
		return obj;
	}
	
	private static void setSSLConnect(Object obj){
		Client proxy = ClientProxy.getClient(obj);
		HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
		TLSClientParameters tlsParams = conduit.getTlsClientParameters();
		if (tlsParams == null) {
			tlsParams = new TLSClientParameters();
		}
		tlsParams.setDisableCNCheck(true);
		tlsParams.setKeyManagers(getKeyManagers());
		tlsParams.setTrustManagers(getTrustManagers());
		conduit.setTlsClientParameters(tlsParams);
	}
	
	private static KeyManager[] getKeyManagers() {
		InputStream is = null;
		try {
			String alg = KeyManagerFactory.getDefaultAlgorithm();
			KeyManagerFactory factory = KeyManagerFactory.getInstance(alg);
			File certFile = new File(KEYSTORE_FILE);
			if (!certFile.exists() || !certFile.isFile()) {
				return null;
			}
			is = new FileInputStream(certFile);
			KeyStore ks = KeyStore.getInstance(SSL_PASSWORD_TYPE);
			ks.load(is, KEYSTORE_PASSWORD.toCharArray());
			factory.init(ks, KEYSTORE_PASSWORD.toCharArray());
			KeyManager[] keyms = factory.getKeyManagers();
			return keyms;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private static TrustManager[] getTrustManagers() {
		InputStream is = null;
		try {
			String alg = TrustManagerFactory.getDefaultAlgorithm();
			TrustManagerFactory factory = TrustManagerFactory.getInstance(alg);
			is = new FileInputStream(new File(TRUSTSTORE_FILE));
			KeyStore ks = KeyStore.getInstance(SSL_PASSWORD_TYPE);
			ks.load(is, TRUSTSTORE_PASSWORD.toCharArray());
			factory.init(ks);
			TrustManager[] tms = factory.getTrustManagers();
			return tms;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
}
