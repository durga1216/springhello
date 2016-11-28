package com.durga.main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.durga.dto.User;
import com.durga.service.UserService;

   @Controller
   public class UserController{
	   
	   @Autowired

	   private UserService uService;
//	   @SupressWarnings("resource")
	   
	   @RequestMapping(value="/userDetail")
	    public ModelAndView listEmployees()throws IOException{
     
  	    //  List<Employee> employees = eService.getAllEmployees();
		   Map<String,Object> model = new HashMap<String,Object>();
  	       model.put("users",  prepareUserList(uService.getAllUsers()));
		   return new ModelAndView("userDetail", model);
	   }
	   
	   
	   @RequestMapping(value = "/save", method = RequestMethod.POST)
	   public ModelAndView saveEmployee(@ModelAttribute("command")User userBean, 
	      BindingResult result) throws ParseException {
	     User user = prepareModel(userBean);
	     uService.createUser(user);
	     return new ModelAndView("redirect:/add.html");
	    }
	   
	   @RequestMapping(value = "/add", method = RequestMethod.GET)
	   public ModelAndView addEmployee(@ModelAttribute("command")User userBean,
	     BindingResult result) {
	    Map<String, Object> model = new HashMap<String, Object>();
	    model.put("users",  prepareUserList(uService.getAllUsers()));
	    return new ModelAndView("userForm", model);
	   }

	   @RequestMapping(value = "/edit", method = RequestMethod.GET)
	   public ModelAndView deleteEmployee(@ModelAttribute("command")User employeeBean,
	      BindingResult result) throws ParseException {
	     Map<String, Object> model = new HashMap<String, Object>();
	     model.put("user", prepareModel(uService.getUser(employeeBean.getUser_id())));
	     model.put("users",  prepareUserList(uService.getAllUsers()));
	     return new ModelAndView("userForm", model);
	    }

	   
	   @RequestMapping(value = "/delete", method = RequestMethod.GET)
	   public ModelAndView editEmployee(@ModelAttribute("command")User userBean,
	      BindingResult result) {
	     uService.deleteUser(userBean.getUser_id());
	     Map<String, Object> model = new HashMap<String, Object>();
	     model.put("user", null);
	     model.put("users",  prepareUserList(uService.getAllUsers()));
	     return new ModelAndView("userForm", model);
	    }



	   private List<User> prepareUserList(List<User> users){
		   List<User> list=null;
		    Set<String> orderSet = new HashSet(Arrays.asList("order_id151","order_id162", "order_id203"));

		   try{
			Map<String, Date> order_history = new HashMap<String, Date>();
			order_history.put("ORDERED", dateStringToDate("2015-08-14 12:13"));
			order_history.put("ACCEPTED", dateStringToDate("2015-08-14 13:10"));
			order_history.put("PARTIALLYEXECUTED",dateStringToDate("2015-08-14 13:20"));
			order_history.put("EXECUTED", dateStringToDate("2015-08-14 14:00"));
			order_history.put("DELIVERED", dateStringToDate("2015-08-15 12:10"));
			order_history.put("RETIERED", dateStringToDate("2015-08-16 12:30"));
		 
		   if(users != null && !users.isEmpty()){
			   list=new ArrayList<User>();
			   User use=null;
			   for(User user:users){

				   use=new User();
				   use.setUser_id(user.getUser_id());
				   use.setFirst_name(user.getFirst_name());
				   use.setLast_name(user.getLast_name());
				   use.setDispathchAddress(user.getDispathchAddress());
				   use.setAmount(user.getAmount());
				   use.setOrder_ids(orderSet);
				 //  printOderHistory(user.getOrder_history());
				   use.setOrder_history(order_history);
				   list.add(use);
				   
			   }//for
			   
		   }//if
		   
		   }
		   catch(Exception e){
			   e.printStackTrace();
		   }
		return list;

		   }
	   
	   
	   private User prepareModel(User user) throws ParseException{
		    Set<String> orderSet = new HashSet(Arrays.asList("order_id151","order_id162", "order_id203"));
		    Map<String, Date> order_history = new HashMap<String, Date>();
			order_history.put("ORDERED", dateStringToDate("2015-08-14 12:13"));
			order_history.put("ACCEPTED", dateStringToDate("2015-08-14 13:10"));
			order_history.put("PARTIALLYEXECUTED",dateStringToDate("2015-08-14 13:20"));
			order_history.put("EXECUTED", dateStringToDate("2015-08-14 14:00"));
			order_history.put("DELIVERED", dateStringToDate("2015-08-15 12:10"));
			order_history.put("RETIERED", dateStringToDate("2015-08-16 12:30"));
		    User use=new User();
		    use.setUser_id(user.getUser_id());
			   use.setFirst_name(user.getFirst_name());
			   use.setLast_name(user.getLast_name());
			   use.setDispathchAddress(user.getDispathchAddress());
			   use.setAmount(user.getAmount());
			   use.setOrder_ids(orderSet);
			 //  printOderHistory(user.getOrder_history());
			   use.setOrder_history(order_history);
		   return use;
	   }

	   
	   public static void printOderHistory(final Map<String,Date>order_history){
			 if(order_history == null){
				 System.out.println("Order History is"+null);
				 return;
			 }
			 final Set<String> keys=order_history.keySet();
			 final Iterator<String> keysItr=keys.iterator();
			  while(keysItr.hasNext()){
				  String key=keysItr.next();
				  Date val=order_history.get(key);
				  System.out.println("Order Status:"+key+ "Time is :"+new SimpleDateFormat(DATE_TIME_FORMAT).format(val));
			  }
			  System.out.println();
		 }
		
		public static Date dateStringToDate(final String inDateStr)throws ParseException 
		{
		return new SimpleDateFormat(DATE_TIME_FORMAT).parse(inDateStr);
		}
	   public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";


   
     
       
   }
//	   private List<EmployeeBean> prepareListofBean(List<Employee> employees){
//		   List<employeebean> beans = null;
//		   if(employees != null && !employees.isEmpty()){
//		    beans = new ArrayList<EmployeeBean>();
//		    EmployeeBean bean = null;
//		    for(Employee employee : employees){
//		     bean = new EmployeeBean();
//		     bean.setName(employee.getEmpName());
//		     bean.setId(employee.getEmpId());
//		     bean.setAddress(employee.getEmpAddress());
//		     bean.setSalary(employee.getSalary());
//		     bean.setAge(employee.getEmpAge());
//		     beans.add(bean);
//		    }
//		   }
//		   return beans;
//		  }

	   
//	   private Employee prepareEmployee(Employee employee){
//		   Employee emp=new Employee();
//		   emp.setId(employee.getId());
//		   emp.setName(employee.getName());
//		   emp.setSalary(employee.getSalary());
//		   emp.setAddress(employee.getAddress());
//		   return emp;
//	   }
	   

   


    
    

