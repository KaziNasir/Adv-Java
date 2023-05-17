package com.myfixer.dao;

import java.util.List;

import com.myfixer.entity.Ticket;

public interface TicketDAO {
	
	boolean save(Ticket vehicle);
	
	List<Ticket> list();
	
	boolean delete(int id);
	
	Ticket get(int id);
	
	Ticket getTicketByTicketid(int ticketId);
	
	List<Ticket> getListBasedOnUserId(int userId);
}
