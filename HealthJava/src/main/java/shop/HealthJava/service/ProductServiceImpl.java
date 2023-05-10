package shop.HealthJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.HealthJava.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDao;
}
