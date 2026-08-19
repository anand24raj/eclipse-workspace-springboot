package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.entity.PanCard;
import com.nt.repository.CustomerRepository;

@Component
public class CustomerRunner implements CommandLineRunner {

	private final CustomerRepository repo;

	CustomerRunner(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer savedCustomer = null;

        if (repo.count() == 0) {

            Customer customer = new Customer(
                    "Anand Raj",
                    "Anand@gmail.com",
                    "Hyderabad");

            PanCard panCard = new PanCard(
                    "ABCDE1234F",
                    "12-01-2024");

            customer.setPanCard(panCard);
            panCard.setCustomer(customer);

            savedCustomer = repo.save(customer);

            System.out.println("Customer and PAN Card inserted successfully");

        } else {

            System.out.println("Data already exists, not inserted again");

            savedCustomer = repo.findAll().get(0);
        }

        System.out.println("\nCustomer Details");
        System.out.println("-------------------------");
        System.out.println("Customer Id   : " + savedCustomer.getCustomerId());
        System.out.println("Customer Name : " + savedCustomer.getCustomerName());
        System.out.println("Email         : " + savedCustomer.getEmail());
        System.out.println("City          : " + savedCustomer.getCity());

        System.out.println("\nPAN Card Details");
        System.out.println("-------------------------");

        PanCard panCard = savedCustomer.getPanCard();

        if (panCard != null) {
            System.out.println("PAN Id       : " + panCard.getPanId());
            System.out.println("PAN Number   : " + panCard.getPanNumber());
            System.out.println("Issue Date   : " + panCard.getIssueDate());
        }
    }
}