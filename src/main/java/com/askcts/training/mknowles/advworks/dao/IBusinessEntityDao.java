/*
 * Summary:
 *
 * Interface used to assist in dependency injection.
 *
 * Author: Michael Knowles
 * 
 * Date: March 3, 2014
 * 
 * Copyright: Copyright (c) 2014 Computer Technology Solutions, Inc.  ALL RIGHTS RESERVED
 *
 * MVC Training Project - Spring 2014
 */

package com.askcts.training.mknowles.advworks.dao;

import com.askcts.training.mknowles.advworks.model.BusinessEntity;

public interface IBusinessEntityDao
{	
	  void persistBusinessEntity(BusinessEntity businessEntity);
	  
	  BusinessEntity findBusinessEntityById(int id);
	  
	  void updateBusinessEntity(BusinessEntity businessEntity);
	  
	  void deleteBusinessEntity(BusinessEntity businessEntity);
}
