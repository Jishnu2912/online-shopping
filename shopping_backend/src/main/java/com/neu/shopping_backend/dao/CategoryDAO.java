package com.neu.shopping_backend.dao;

import java.util.List;

import com.neu.shopping_backend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	/*Abstract method to get 
	 * a single category by id
	 *  in the PageController*/
	Category get(int id);
	

}
