/**
 * 		try (InputStream keyStoreStream = ExperianPreciseIDCall.class.getClassLoader()
				.getResourceAsStream("UAT_JQALN9FK.PFX")) {
			KeyStore keyStore = KeyStore.getInstance("PKCS12"); // or "PKCS12"
			keyStore.load(keyStoreStream, "H44nUIsb".toCharArray());
			SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, "H44nUIsb".toCharArray()).build();
			CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
			return httpClient;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
 * 
 * 
 */

package com.syuan0321.unitseed.HttpClient.SSLKeystore;

public class SSLKeystore {

}
