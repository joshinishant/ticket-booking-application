package com.sap.mdm.prd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sap.mdm.prd.entities.TicketBookingEntity;

@Service
public interface TicketBookingService {
	
	
	public TicketBookingEntity insertTicket(TicketBookingEntity ticket);
	
	public TicketBookingEntity updateTicket(TicketBookingEntity ticket);
	 
	public boolean deleteTicket(String ticketNumber);
	
	public void deleteAllTickets();
	
	public TicketBookingEntity findTicketById(String ticketId);
	
	public TicketBookingEntity findTicketByNumber(String ticketNumber);

	public List<TicketBookingEntity> findAllTickets();

}
