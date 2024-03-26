package com.dao;
import java.sql.SQLException;
import java.util.List;
import com.model.Products;


public interface ProdDao {
	public List<Products> getProductDetails() throws SQLException;
	public void updateProductName(int pId, String productName) throws SQLException;
	
}
