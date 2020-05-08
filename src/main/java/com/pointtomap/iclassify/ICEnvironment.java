package com.pointtomap.iclassify;

import java.util.jar.Manifest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <h1>PerfTestEnvironment</h1>
 *
 * The PerfTestEnvironment is an environment class that is initialized by the
 * spring framework based on the application.properties
 *
 * @author Andre St-Louis
 * @version 1.0
 * @since 2020-04-15
 */

@Component
@ConfigurationProperties("app")

@SuppressWarnings("unused")
@Getter
@Setter
@ToString
public class ICEnvironment {

	private static Logger log = LoggerFactory.getLogger(ICEnvironment.class);

	private static final String IMPLEMENTATION_VERSION = "Implementation-Version";

	private static Manifest manifest = null;

	String dcsDirectory;

	public ICEnvironment() {
		super();

		try {
			ClassPathResource clpr = new ClassPathResource("/META-INF/MANIFEST.MF");
			ICEnvironment.manifest = new Manifest(clpr.getInputStream());
		} catch (Exception e) {
			log.error("/META-INF/MANIFEST.MF not found");
		}
	}

	public static String getManifestVersion() {

		try {
			return getManifestPropertyByAtrribute(IMPLEMENTATION_VERSION);
		} catch (Exception e) {
			return ("0.0.0.0");
		}

	}

	public static String getManifestPropertyByAtrribute(String attrKey) throws Exception {

		String attr = manifest.getMainAttributes().getValue(attrKey);

		if (attr == null) {

			throw new Exception(String.format("Fetching missing attribute %s from manifest.mf", attrKey));
		}

		return attr;
	}

}