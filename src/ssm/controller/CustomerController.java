package ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ssm.entity.Customer;
import ssm.service.CustomerService;

// GET /customers
@Controller
public class CustomerController {
	
	private CustomerService customerService;
	
	private String uploadDir = "D:/zhujunqi/upload"; // TODO 配置外部化
	
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers/new")
	public String newCustomer(@ModelAttribute Customer customer) {
		return "customers-edit";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers/new")
	public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) { // 表单bean封装
		// 使用@Valid进行校验，BindingResult获得校验结果，它们往往成对出现，并且要保证先后顺序
		System.out.println("添加客户: " + customer);
		if (bindingResult.hasErrors()) {
			return "customers-edit";
		} else {
			customerService.create(customer);
			return "redirect:/customers"; // 重定向
		}
	}
	
	// GET /customers/28/edit
	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Customer customer = customerService.findOne(id);
		System.out.println("GET 修改: #" + id + ", " + customer);
		model.addAttribute("customer", customer);
		return "customers-edit";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers/{id}/edit")
	public String update(@PathVariable Long id, 
			@Valid @ModelAttribute Customer customer, BindingResult bindingResult) throws Exception {
		
		System.out.println("POST 修改：" + customer);
		System.out.println("照片: " + customer.getPicture().getOriginalFilename() + ", " 
							+ customer.getPicture().getSize() + "字节");
		
		if (customer.getPicture().getSize() == 0 
				|| !customer.getPicture().getContentType().toLowerCase().startsWith("image/")) {
			// 手动添加校验错误
			bindingResult.rejectValue("picture", "formError.pictureRequired", "请选择照片");
		}
		
		if (bindingResult.hasErrors()) {
			return "customers-edit";
		} else {
			customer.setId(id);
			// TODO 需要将文件保存的路径存入数据库，以便后续在详情页显示客户照片
			customer.getPicture().transferTo(new File(uploadDir, customer.getPicture().getOriginalFilename()));
			customerService.update(customer);
			return "redirect:/customers";			
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}/details")
	public String details(@PathVariable Long id, Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);
		return "customer-details";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers/{id}/delete")
	public String delete(@PathVariable Long id) {
		customerService.delete(id);
		return "redirect:/customers";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers/batch-delete")
	public String batchDelete(@RequestParam String ids) {
		List<Long> idList = new ArrayList<>();
		for (String id : ids.split(",")) {
			idList.add(Long.valueOf(id));
		}
		
		System.out.println("批量删除: #" + idList);
		customerService.batchDelete(idList);
		
		return "redirect:/customers";
	}
}
