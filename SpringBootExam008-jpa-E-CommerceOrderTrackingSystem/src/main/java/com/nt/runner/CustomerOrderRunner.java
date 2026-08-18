package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CustomerOrder;
import com.nt.repository.CustomerOrderRepository;

@Component
public class CustomerOrderRunner implements CommandLineRunner {

	@Autowired
	CustomerOrderRepository repo;

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			IO.println("1. Add New Order");
			IO.println("2. View All Orders");
			IO.println("3. Update Order Status");
			IO.println("4. Delete Order");
			IO.println("5. Display Order with Created and Last Modified Timestamp");
			IO.println("6. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			case 1 -> {
				String customerName = IO.readln("Enter Customer Name : ");
				String productName = IO.readln("Enter Product Name : ");
				Integer quantity = Integer.parseInt(IO.readln("Enter Quantity : "));
				Double totalAmount = Double.parseDouble(IO.readln("Enter Total Amount : "));
				String orderStatus = IO.readln("Enter Order Status : ");

				CustomerOrder order = new CustomerOrder(customerName, productName, quantity, totalAmount, orderStatus);

				CustomerOrder savedOrder = repo.save(order);

				IO.println("\nOrder Added Successfully");
				IO.println(savedOrder);
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
				Long id = Long.parseLong(IO.readln("Enter Order Id to Update Status : "));

				CustomerOrder order = repo.findById(id).orElse(null);

				if (order == null) {
					IO.println("Order Not Found");
				} else {
					IO.println("\nBefore Update:");
					IO.println("Order Status : " + order.getOrderStatus());
					IO.println("Updated At   : " + order.getUpdatedAt());

					Thread.sleep(2000);

					String newStatus = IO.readln("Enter New Order Status : ");
					order.setOrderStatus(newStatus);

					CustomerOrder updatedOrder = repo.save(order);

					IO.println("\nOrder Status Updated Successfully");
					IO.println("Order Status : " + updatedOrder.getOrderStatus());
					IO.println("Updated At   : " + updatedOrder.getUpdatedAt());
				}
			}

			case 4 -> {
				Long id = Long.parseLong(IO.readln("Enter Order Id to Delete : "));

				if (repo.existsById(id)) {
					repo.deleteById(id);
					IO.println("Order Deleted Successfully");
				} else {
					IO.println("Order Not Found");
				}
			}

			case 5 -> {
				Long id = Long.parseLong(IO.readln("Enter Order Id : "));

				CustomerOrder order = repo.findById(id).orElse(null);

				if (order == null) {
					IO.println("Order Not Found");
				} else {
					IO.println("\nOrder Details:");
					IO.println("Order Id       : " + order.getOrderId());
					IO.println("Customer Name  : " + order.getCustomerName());
					IO.println("Product Name   : " + order.getProductName());
					IO.println("Quantity       : " + order.getQuantity());
					IO.println("Total Amount   : " + order.getTotalAmount());
					IO.println("Order Status   : " + order.getOrderStatus());
					IO.println("Created At     : " + order.getCreatedAt());
					IO.println("Last Modified  : " + order.getUpdatedAt());
				}
			}

			case 6 -> {
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}

	}
}
