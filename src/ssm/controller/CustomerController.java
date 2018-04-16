package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssm.entity.Customer;
import ssm.service.CustomerService;

// GET /customers
@Controller
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 指定此控制器方法用来处理GET /customers
	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	public String findAll(Model model) {
		System.out.println("处理: GET /customers");
		
		// 调service
		List<Customer> customers = customerService.findAll();
		
		// 数据放model
		model.addAttribute("customers", customers);
		
		// 展示
		return "customers";
	}
}
