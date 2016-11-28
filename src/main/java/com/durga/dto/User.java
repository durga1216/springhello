package com.durga.dto;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value="UserOrders")
public class User {

        public User() {
		super();
		// TODO Auto-generated constructor stub
	}


		@PrimaryKey(value="user_id")
		private int user_id;
	    
	    @Column(value="first_name")
		private String first_name;
	    
	    @Column(value="last_name")
		private String last_name;
	    
	    @Column(value="dispathchAddress")
		private String dispathchAddress;
	    
	    @Column(value="amount")
		private int amount;
	    
	    @Column(value="order_ids")
		private Set<String> order_ids;
		//private List<String> routing_point;
	    
	    @Column(value="order_history")
		private Map<String, Date> order_history;
	    
	    
		public User(int user_id, String first_name, String last_name,
				String dispathchAddress, int amount, Set<String> order_ids,
				Map<String, Date> order_history) {
			super();
			this.user_id = user_id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.dispathchAddress = dispathchAddress;
			this.amount = amount;
			this.order_ids = order_ids;
			this.order_history = order_history;
		}


		public int getUser_id() {
			return user_id;
		}


		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}


		public String getFirst_name() {
			return first_name;
		}


		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}


		public String getLast_name() {
			return last_name;
		}


		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}


		public String getDispathchAddress() {
			return dispathchAddress;
		}


		public void setDispathchAddress(String dispathchAddress) {
			this.dispathchAddress = dispathchAddress;
		}


		public int getAmount() {
			return amount;
		}


		public void setAmount(int amount) {
			this.amount = amount;
		}


		public Set<String> getOrder_ids() {
			return order_ids;
		}


		public void setOrder_ids(Set<String> order_ids) {
			this.order_ids = order_ids;
		}


		public Map<String, Date> getOrder_history() {
			return order_history;
		}


		public void setOrder_history(Map<String, Date> order_history) {
			this.order_history = order_history;
		}
	    
	    
	    
	    
	 
}