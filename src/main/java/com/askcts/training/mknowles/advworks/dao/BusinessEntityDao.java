package com.askcts.training.mknowles.advworks.dao;

import com.askcts.training.mknowles.advworks.model.BusinessEntity;

public interface BusinessEntityDao {
	
	  void persistBusinessEntity(BusinessEntity businessEntity);
	  
	  BusinessEntity findBusinessEntityById(int id);
	  
	  void updateBusinessEntity(BusinessEntity businessEntity);
	  
	  void deleteBusinessEntity(BusinessEntity businessEntity);
}
