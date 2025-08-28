package Interfaces;

import java.util.List;

import Model.Venue;

public interface Searchable {
	List<Venue> search(String keyword);

	List<Venue> search(int id);

}
