package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.ShoppingOrder;
import com.nt.repository.ShoppingOrderRepository;

@Component
public class ShoppingOrderRunner implements CommandLineRunner {

	private final ShoppingOrderRepository repo;

	ShoppingOrderRunner(ShoppingOrderRepository repo) {
		this.repo = repo;
	}

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			IO.println("1. Add Order");
			IO.println("2. View All Orders");
			IO.println("3. Display Orders by Category");
			IO.println("4. Display Orders by Payment Mode");
			IO.println("5. Find Orders Above a Given Amount");
			IO.println("6. Delete Order");
			IO.println("7. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			case 1 -> {
				String customerName = IO.readln("Enter Customer Name : ");
				String productName = IO.readln("Enter Product Name : ");
				String category = IO.readln("Enter Category : ");
				Double totalAmount = Double.parseDouble(IO.readln("Enter Total Amount : "));
				String paymentMode = IO.readln("Enter Payment Mode : ");
				String orderStatus = IO.readln("Enter Order Status : ");

				ShoppingOrder order = new ShoppingOrder(null, customerName, productName, category, totalAmount, paymentMode, orderStatus);

				repo.save(order);

				IO.println("Order Added Successfully");
			}

			case 2 -> {
				IO.println("\nAll Orders:");

				if (repo.findAll().isEmpty()) {
					IO.println("No Orders Found");
				} else {
					repo.findAll().forEach(IO::println);
				}
			}

			case 3 -> {
				String category = IO.readln("Enter Category : ");

				IO.println("\nOrders from Category " + category + ":");

				if (repo.findOrdersByCategory(category).isEmpty()) {
					IO.println("No Orders Found");
				} else {
					repo.findOrdersByCategory(category).forEach(IO::println);
				}
			}

			case 4 -> {
				String paymentMode = IO.readln("Enter Payment Mode : ");

				IO.println("\nOrders by Payment Mode " + paymentMode + ":");

				if (repo.findOrdersByPaymentMode(paymentMode).isEmpty()) {
					IO.println("No Orders Found");
				} else {
					repo.findOrdersByPaymentMode(paymentMode).forEach(IO::println);
				}
			}

			case 5 -> {
				Double amount = Double.parseDouble(IO.readln("Enter Amount : "));

				IO.println("\nOrders above amount " + amount + ":");

				if (repo.findOrdersAboveAmount(amount).isEmpty()) {
					IO.println("No Orders Found");
				} else {
					repo.findOrdersAboveAmount(amount).forEach(IO::println);
				}
			}

			case 6 -> {
				Long orderId = Long.parseLong(IO.readln("Enter Order ID : "));

				if (repo.existsById(orderId)) {
					repo.deleteById(orderId);
					IO.println("Order Deleted Successfully");
				} else {
					IO.println("Order ID Not Found");
				}
			}

			case 7 -> {
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}
}
