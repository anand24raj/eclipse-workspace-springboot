package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.ShoppingOrder;

public interface ShoppingOrderRepository extends JpaRepository<ShoppingOrder, Long> {

	@Query("SELECT o FROM ShoppingOrder o WHERE o.category = :category")
	List<ShoppingOrder> findOrdersByCategory(String category);

	@Query("SELECT o FROM ShoppingOrder o WHERE o.paymentMode = :paymentMode")
	List<ShoppingOrder> findOrdersByPaymentMode(String paymentMode);

	@Query("SELECT o FROM ShoppingOrder o WHERE o.totalAmount > :amount")
	List<ShoppingOrder> findOrdersAboveAmount(Double amount);
}