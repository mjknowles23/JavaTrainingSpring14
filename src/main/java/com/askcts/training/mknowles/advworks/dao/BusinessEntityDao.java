package com.askcts.training.mknowles.advworks.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.askcts.training.mknowles.advworks.model.BusinessEntity;

@Repository("businessEntityDao")
public class BusinessEntityDao implements IBusinessEntityDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistBusinessEntity(BusinessEntity businessEntity) {
		sessionFactory.getCurrentSession().persist(businessEntity);
	}

	@Override
	public BusinessEntity findBusinessEntityById(int id) {
		return (BusinessEntity) sessionFactory.getCurrentSession().get(BusinessEntity.class, id);
	}

	@Override
	public void updateBusinessEntity(BusinessEntity businessEntity) {
		sessionFactory.getCurrentSession().update(businessEntity);
	}
	
	@Override
	public void deleteBusinessEntity(BusinessEntity businessEntity) {
		sessionFactory.getCurrentSession().delete(businessEntity);
	}
}
