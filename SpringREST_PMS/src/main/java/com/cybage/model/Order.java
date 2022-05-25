package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
// lombok dependency to add annotation for generTING LOMBOK DEPENDENCY
@Getter
@Setter // to avoid generating getter setter for class use this annotation and add lombok dependency
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_details")
public class Order {

	@Id
	private int orderId;
	private int amount;
	
//	@OneToMany(mappedBy = "order") // one order contains multiple product
//	private List<Product> products;
	
	@ManyToOne
	private Product product;
	
//	public int getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//	public int getAmount() {
//		return amount;
//	}
//	public void setAmount(int amount) {
//		this.amount = amount;
//	}
//	public Order(int orderId, int amount) {
//		super();
//		this.orderId = orderId;
//		this.amount = amount;
//	}
//	public Order() {}
//	
//	@Override
//	public String toString() {
//		return "Order [orderId=" + orderId + ", amount=" + amount + "]";
//	}
//	
	
	
	
	
}
