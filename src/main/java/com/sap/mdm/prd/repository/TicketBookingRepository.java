package com.sap.mdm.prd.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sap.mdm.prd.entities.TicketBookingEntity;

@Repository
public interface TicketBookingRepository extends CrudRepository<TicketBookingEntity, String> {
	
	
	public TicketBookingEntity findByNumber(String number);

}
