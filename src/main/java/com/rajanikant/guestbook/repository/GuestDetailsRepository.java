package com.rajanikant.guestbook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rajanikant.guestbook.entity.GuestDetails;


/**
 * 
 * @author Rajanikant Yadav
 *
 */

@Repository
public interface GuestDetailsRepository extends   CrudRepository<GuestDetails,Long> {
	
	public GuestDetails findGuestDetailsByguestId(Long guestId );

	GuestDetails findByEmailId(String emailId);

	Boolean existsByGuestName(String guestName);

	Boolean existsByEmailId(String emailId);

}
