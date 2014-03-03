package com.askcts.training.mknowles.advworks.service;

import com.askcts.training.mknowles.advworks.model.BusinessEntity;

public interface BusinessEntityService {
	void persistBusinessEntity(BusinessEntity businessEntity);
	BusinessEntity findBusinessEntityById(int id);
	void updateBusinessEntity(BusinessEntity businessEntity);
	void deleteBusinessEntity(BusinessEntity businessEntity);
}
