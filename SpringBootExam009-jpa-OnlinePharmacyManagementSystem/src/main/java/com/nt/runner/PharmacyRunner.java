package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Medicine;
import com.nt.repository.MedicineRepository;

@Component
public class PharmacyRunner implements CommandLineRunner
{

	@Autowired
	private MedicineRepository repo;

	@Override
	public void run(String... args) throws Exception
	{
		while (true)
		{
			IO.println("1. Add Medicine");
			IO.println("2. View All Medicines");
			IO.println("3. Search by Category");
			IO.println("4. Search by Manufacturer");
			IO.println("5. Search by Stock Quantity Greater Than");
			IO.println("6. Delete Medicine");
			IO.println("7. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice)
			{
			case 1 ->
			{
				String medicineName = IO.readln("Enter Medicine Name : ");
				String category = IO.readln("Enter Category : ");
				String manufacturer = IO.readln("Enter Manufacturer Name : ");
				Double price = Double.parseDouble(IO.readln("Enter Price : "));
				Integer stockQuantity = Integer.parseInt(IO.readln("Enter Stock Quantity : "));

				Medicine medicine = new Medicine(medicineName, category, manufacturer, price, stockQuantity);

				repo.save(medicine);

				IO.println("Medicine Added Successfully...");
			}

			case 2 ->
			{
				IO.println("\nAll Medicines :");

				if (repo.findAll().isEmpty())
				{
					IO.println("No Medicines Found");
				}
				else
				{
					repo.findAll().forEach(IO::println);
				}
			}

			case 3 ->
			{
				String category = IO.readln("Enter Category : ");

				List<Medicine> medicines = repo.findByCategory(category);

				if (medicines.isEmpty())
				{
					IO.println("No Medicines Found");
				}
				else
				{
					medicines.forEach(IO::println);
				}
			}

			case 4 ->
			{
				String manufacturer = IO.readln("Enter Manufacturer Name : ");

				List<Medicine> medicines = repo.findByManufacturer(manufacturer);

				if (medicines.isEmpty())
				{
					IO.println("No Medicines Found");
				}
				else
				{
					medicines.forEach(IO::println);
				}
			}

			case 5 ->
			{
				Integer quantity = Integer.parseInt(IO.readln("Enter Stock Quantity : "));

				List<Medicine> medicines =
						repo.findByStockQuantityGreaterThan(quantity);

				if (medicines.isEmpty())
				{
					IO.println("No Medicines Found");
				}
				else
				{
					medicines.forEach(IO::println);
				}
			}

			case 6 ->
			{
				Long medicineId = Long.parseLong(IO.readln("Enter Medicine ID : "));

				if (repo.existsById(medicineId))
				{
					repo.deleteById(medicineId);
					IO.println("Medicine Deleted Successfully...");
				}
				else
				{
					IO.println("Medicine ID Not Found");
				}
			}

			case 7 ->
			{
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default ->
			{
				IO.println("Invalid Choice");
			}
			}
		}
	}
}