package com.neu.shopping_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.neu.shopping_backend.dao.CategoryDAO;
import com.neu.shopping_backend.dto.Category;


/*Add the "@Repository" annotation.
 * The "@Repository" annotation is a marker for the class specifying that it fulfills the role of providing 
 * access to the data and will be managed by the spring framework
*/


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories=new ArrayList<>();
	static{
		
		
		//adding first category
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description of television");
		category.setImageURL("Cat1.png");
		
		categories.add(category);
		
		
		//Second Category
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description of mobile");
		category.setImageURL("Cat2.png");
		
		categories.add(category);
		
		
		//Third Category
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description of laptop");
		category.setImageURL("Cat3.png");
		
		categories.add(category);
		
		
		
		
	}
	
	
	
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}





	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub

		/*Enhanced for loop for the Getting the id*/
		for(Category category:categories) {
			if(category.getId()==id) {
				return category;
			}
		}
		return null;
		
	}

}
