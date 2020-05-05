package com.blastvibrations.jpa.dao;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.orm.ExEventDataFact;

@Repository
public class ExEventDataFactDaoImpl extends GenericDaoImpl<ExEventDataFact>
	implements ExEventDataFactDao {

    @Override
    public void materializedView() {

	getEntityManager().createNativeQuery(
		"select materializeviewexeventdatafact() ; ").getResultList();

	// TODO Auto-generated method stub

    }

}
