package com.pointtomap.iclassify;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

/**
 * <h1>PerfTestApplicationr</h1>
 *
 * Main class that starts the PerfTest Application
 *
 * @author Andre St-Louis
 * @version 1.0
 * @since 2020-04-15
 */

/**
 * @author stlouisa
 *
 */
@SpringBootApplication
@EntityScan(basePackages = { "com.pointtomap.iclassify.jpa" }) // scan JPA entities
@Transactional
//@EnableConfigurationProperties

public class IClassifyApplication {

	private static Logger log = LoggerFactory.getLogger(IClassifyApplication.class);

	@Autowired
	ICConfig perfTestConfig;

	@SuppressWarnings("unused")
	private static ICEnvironment env;

	/**
	 * 
	 * PerfTestApplication main method to start the application.
	 * 
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, IOException {

		SpringApplication.run(IClassifyApplication.class, args);

		log.info("Started --------------------->");

	}

	/**
	 * Initialize the env properties ready to be used in a static context.
	 * 
	 * @param env
	 * 
	 */
	@Autowired
	public void initEnv(ICEnvironment env) throws Exception {

		log.info("Initialization initEnv");
		IClassifyApplication.env = env;

		log.info(String.format("IClassify (%s)", ICEnvironment.getManifestVersion()));

	}

	/**
	 * 
	 * Dump system properties and system environment properties
	 * 
	 * @param env
	 */
	@Autowired
	public void dumpEnvironmentProperties(ICEnvironment env) {

		System.getProperties().forEach((k, v) -> {
			log.debug(k + "=" + v);
		});

		log.debug("-----------------------------------------------------------");

		System.getenv().forEach((k, v) -> {
			log.debug(k + "=" + v);
		});

	}

	/**
	 * Show Banner
	 * 
	 * @param env
	 * @throws IOException
	 */
	@Autowired
	public void showBanner(ICEnvironment env) throws IOException {

		ClassPathResource clpr = new ClassPathResource("static/spring-boot-banner.txt");
		ByteArrayOutputStream ous = new ByteArrayOutputStream(100000);
		FileCopyUtils.copy(clpr.getInputStream(), ous);
		byte[] banner = new byte[ous.size()];

		banner = ous.toByteArray();

		System.out.print(new String(banner, "UTF-8"));

	}

}