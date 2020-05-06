package com.pointtomap.iclassify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.pointtomap.iclassify.jpa.dao.IcImageDao;
import com.pointtomap.iclassify.jpa.dao.IcUserDao;
import com.pointtomap.iclassify.jpa.dao.IcUserImageDao;
import com.pointtomap.iclassify.jpa.orm.EnumUserGroup;
import com.pointtomap.iclassify.jpa.orm.IcDocument;
import com.pointtomap.iclassify.jpa.orm.IcUser;
import com.pointtomap.iclassify.jpa.orm.IcUserDocument;

@SpringBootTest
@Transactional()
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/test-context.xml" })

@Rollback(false)

class OrmTest {

	@Autowired
	IcUserDao icUserDao;

	@Autowired
	IcImageDao icImageDao;

	@Autowired
	IcUserImageDao icUserImageDao;

	@Test
	public void createIcUser() {

		IcUser aUser = new IcUser();
		aUser.setEmailAddress("sb87321234@gmail.com");
		aUser.setEnabled(true);
		aUser.setHashedPasswd("Password1");
		aUser.setUserGroup(EnumUserGroup.ADMIN);
		aUser.setUsername("sb87321234");

		icUserDao.persist(aUser);

		System.out.println("Done");
	}

	@Test
	public void createIcImage() {

		IcDocument aImage = new IcDocument();
		aImage.setDescription("My first image");
		aImage.setImageSha1("test");
		aImage.setEnabled(true);
		icImageDao.persist(aImage);

		System.out.println("Done");
	}

	@Test
	public void createIcUserImage() {

		IcUser aUser = icUserDao.findUserByUsername("sb87321234");

		IcDocument aImage = new IcDocument();
		aImage.setDescription("My first image");
		aImage.setImageSha1("test");
		aImage.setEnabled(true);
		aImage = icImageDao.persist(aImage);

		IcUserDocument icUserImage = new IcUserDocument();
		icUserImage.setIcUser(aUser);
		icUserImage.setIcImage(aImage);

		icUserImageDao.persist(icUserImage);

		System.out.println("Done");
	}

}
