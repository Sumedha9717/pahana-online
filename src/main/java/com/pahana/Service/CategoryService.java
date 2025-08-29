package com.pahana.Service;

import com.pahana.Dao.CategoryDao;
import com.pahana.Model.*;
import java.util.List;

public class CategoryService {
	private static  CategoryService  instance;
    private CategoryDao categoryDao;

    private  CategoryService()
    {
        this.categoryDao = new CategoryDao();
    }

    public static CategoryService getInstance() {
        if (instance == null)
        {
            synchronized (CategoryService.class) {
                if (instance == null) {
                    instance = new CategoryService();
                }
            }
        }
        return instance;
    }
	
	
}
