package com.playup.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.playup.database.DBUtils;

public class SearchVenue extends SearchFactoryDAO{
	
	private static SearchVenue instance = null;
	
	private SearchVenue() {
		
	}
	
	public static SearchVenue getInstance() {
		if(instance == null) {
			instance = new SearchVenue();
		}
		return instance;
	}

	@Override
	public ArrayList<Object> search(String searchKey) {
		try {
			List<Venue> venuesList = DBUtils.getVenuesFromDB();
			ArrayList<Object> searchResults = new ArrayList<Object>();
			searchResults.addAll(filterBySearchKey(venuesList, searchKey));
			return searchResults;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private Collection<Venue> filterBySearchKey(List<Venue> venuesList, String searchKey) {
		Collection<Venue> venueCollection = new HashSet<>();
		for(Venue venue: venuesList) {
			if(venue.getVenueName().toLowerCase().contains(searchKey.toLowerCase())) {
				venueCollection.add(venue);
				continue;
			} else if(venue.getVenueID().contains(searchKey.toLowerCase())) {
				venueCollection.add(venue);
				continue;
			}else if(venue.getVenueCity().toLowerCase().contains(searchKey.toLowerCase())) {
				venueCollection.add(venue);
				continue;
			}
		}
		return venueCollection;
	}

}
