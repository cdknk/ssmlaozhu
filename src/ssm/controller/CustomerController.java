package ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ssm.dao.CustomerDaoImpl;
import ssm.entity.Customer;
import ssm.service.CustomerService;
import ssm.service.CustomerServiceImpl;

// GET /customers
public class CustomerController extends HttpServlet {
	
	private CustomerService customerService = 
			new CustomerServiceImpl(new CustomerDaoImpl());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("处理: GET /customers");
		
		// 调service
		List<Customer> customers = customerService.findAll();
		
		// 数据放model
		req.setAttribute("customers", customers);
		
		// 展示
		req.getRequestDispatcher("/WEB-INF/jsp/customers.jsp").forward(req, resp);
	}
}
