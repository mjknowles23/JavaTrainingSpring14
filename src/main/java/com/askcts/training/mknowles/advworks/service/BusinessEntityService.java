/*
 * Summary:
 *
 * Likely overkill for this project, but this class is used to remove business logic
 * from the controller class and specify transactions.
 *
 * Author: Michael Knowles
 * 
 * Date: March 3, 2014
 * 
 * Copyright: Copyright (c) 2014 Computer Technology Solutions, Inc.  ALL RIGHTS RESERVED
 *
 * MVC Training Project - Spring 2014
 */

package com.askcts.training.mknowles.advworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.askcts.training.mknowles.advworks.dao.IBusinessEntityDao;
import com.askcts.training.mknowles.advworks.model.BusinessEntity;

@Service("businessEntityService")
public class BusinessEntityService implements IBusinessEntityService 
{
	@Autowired
	IBusinessEntityDao BusinessEntityDao;
	
	@Override
	@Transactional
	public void persistBusinessEntity(BusinessEntity businessEntity) 
	{
		BusinessEntityDao.persistBusinessEntity(businessEntity);
	}

	@Override
	@Transactional
	public void updateBusinessEntity(BusinessEntity businessEntity) 
	{
		BusinessEntityDao.updateBusinessEntity(businessEntity);
	}
	
	@Override
	@Transactional
	public BusinessEntity findBusinessEntityById(int id) 
	{
		return BusinessEntityDao.findBusinessEntityById(id);
	}

	@Override
	@Transactional
	public void deleteBusinessEntity(BusinessEntity businessEntity) 
	{
		BusinessEntityDao.deleteBusinessEntity(businessEntity);
	}
}
