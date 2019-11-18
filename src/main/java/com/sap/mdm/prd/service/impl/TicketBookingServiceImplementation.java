package com.sap.mdm.prd.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sap.mdm.prd.entities.TicketBookingEntity;
import com.sap.mdm.prd.repository.TicketBookingRepository;
import com.sap.mdm.prd.service.TicketBookingService;

public class TicketBookingServiceImplementation implements TicketBookingService{

	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	@Override
	public TicketBookingEntity insertTicket(TicketBookingEntity ticket) {
		// TODO Auto-generated method stub
		ticket.setId(UUID.randomUUID().toString());
		ticketBookingRepository.save(ticket);
		return ticket;
	}

	@Override
	public TicketBookingEntity updateTicket(TicketBookingEntity ticket) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(ticket.getId())) {
			return null;
		}
		
		ticketBookingRepository.save(ticket);
		
		return ticket;
	}

	@Override
	public boolean deleteTicket(String ticketNumber) {
		// TODO Auto-generated method stub
				
		if(StringUtils.isEmpty(ticketNumber)||ticketBookingRepository.findByNumber(ticketNumber)==null) {
			return false;
		}		
		String ticketId=ticketBookingRepository.findByNumber(ticketNumber).getId();
		ticketBookingRepository.deleteById(ticketId);
		return true;
	}
	
	

	@Override
	public TicketBookingEntity findTicketById(String ticketId) {
		// TODO Auto-generated method stub
		
		if(StringUtils.isEmpty(ticketId)||ticketBookingRepository.findById(ticketId)==null) {
			return null;
		}
		
		return ticketBookingRepository.findById(ticketId).get();
	}

	@Override
	public TicketBookingEntity findTicketByNumber(String ticketNumber) {
		// TODO Auto-generated method stub
		
		if(StringUtils.isEmpty(ticketNumber)||ticketBookingRepository.findByNumber(ticketNumber)==null) {
			return null;
		}
		TicketBookingEntity ticket= ticketBookingRepository.findByNumber(ticketNumber);
		return ticket;
	}
	
	@Override
	public List<TicketBookingEntity> findAllTickets() {
		// TODO Auto-generated method stub
		List<TicketBookingEntity> ticketList= new LinkedList<TicketBookingEntity>();
		Iterable<TicketBookingEntity> iterableTickets= ticketBookingRepository.findAll();
		
		for(TicketBookingEntity ticket:iterableTickets) {
			ticketList.add(ticket);
		}
		
		return ticketList;
	}

	@Override
	public void deleteAllTickets() {
		// TODO Auto-generated method stub
		
		ticketBookingRepository.deleteAll();		
	}

}
