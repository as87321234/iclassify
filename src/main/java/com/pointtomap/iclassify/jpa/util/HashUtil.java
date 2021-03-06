package com.pointtomap.iclassify.jpa.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class HashUtil {

	public static String sha256(String passwd) {

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			final byte[] hashbytes = digest.digest(passwd.getBytes(StandardCharsets.UTF_8));

			String sha_256hex = Hex.encodeHexString(hashbytes);

			return sha_256hex;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static String sha256(byte[] byteArray) {

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			final byte[] hashbytes = digest.digest(byteArray);

			String sha_256hex = Hex.encodeHexString(hashbytes);

			return sha_256hex;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
