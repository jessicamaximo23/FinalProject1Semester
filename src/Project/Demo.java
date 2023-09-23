package Project;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		// Computer c1 = new Computer("apple", "Mac pro", 3000);
		// c1.displayComputer(c1);

		// Computer c2 = new Computer("apple", "Mac pro", 3000);
		// c1.displayComputer(c2);
		// System.out.println(c1.equal(c2));

		// --------------------------------------------------
		// Here are the part B of the program java
		// We need tracking computers
		// --------------------------------------------------

		// Display a Welcome message
		System.out.println("Welcome to this program, here we can tracking the computer that you want ");
		System.out.println("-------------------------------------------------------------------------");
		Scanner kb = new Scanner(System.in);

		int maxComputers = 0;
		// initialize the variable main menu
		int choiceMenu;
		// initialize the variable for add new computers
		int addNewComputers = 0;
		// initialize update computers
		int updateComputersNumber = 0;

		do {
			// owner put the number maximum of computers (Size or maxComputers)
			System.out.println("Whats the maximum numbers of computers that your store can contain? ");
			maxComputers = kb.nextInt();

			// test only with positives numbers
			if (maxComputers > 0) {

			} else {
				System.out.println("Invalid, try again. The number should be positive");
			}

		} while (maxComputers <= 0);

		// Create a empty array (inventory)
		// Tracking the object computer - previously created
		Computer inventory[] = new Computer[maxComputers];

		// c = new Computer(brand, model, price);

		// Put do and while for continue show the main menu
		do {
			// Display a main menu
			System.out.println("You are on the Main menu:  ");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Option 1: Enter new computers (Password Required)");
			System.out.println("Option 2: Change information of a computer (Password required)");
			System.out.println("Option 3: Display all computers by a specific brand");
			System.out.println("Option 4: Display all computers under a certain a price");
			System.out.println("Option 5: Quit");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Please enter your choice > ");

			// initialized a variably menu
			// user choose a option between 1 and 5
			choiceMenu = kb.nextInt();

			// if the user put ne number worng in the MENU 1
			if (choiceMenu > 5 || choiceMenu <= 0) {
				System.out.println("This number is invalid.Try again");
				System.out.println();
			}

			// Each main menu
			switch (choiceMenu) {
			case 1:
				System.out.println("1.Put your password: ");
				// if the correct password is check put how many computers do want to add
				if (checkPassword(kb)) {
					System.out.println();

					do {
						System.out.println("How many computers do want to add?");
						addNewComputers = kb.nextInt();

						if (addNewComputers > maxComputers || addNewComputers < 0) {
							System.out.println(
									"Please choose other number. This number exceeds tha maximum capacity or is less than 0");
						}
					}
					// check if has enough space in the computer store
					// if the new computers are more than capacity computers
					while (addNewComputers > maxComputers);
					System.out.println("");
				}

				// add new computers to the inventory
				// put the quantity of the computers
				for (int i = 0; i < addNewComputers; i++) {

					// i+1 because need show "computer 1" instead "computer 0"
					System.out.println("Computer #: " + (i + 1));
					System.out.println("Brand : ");
					String brand = kb.next();

					// initialize the price
					double price = 0;
					do {
						System.out.println("Price : ");
						price = kb.nextDouble();

						if (price <= 0) {
							System.out.println("Invalid price.Should be a positive value");
						}
					} while (price <= 0);

					System.out.println("Model : ");
					String model = kb.next();

					// Initialize the serialNumber
					// i = each new computer
					int serialNumberCounter = i + 1;

					System.out.println("Serial number : " + serialNumberCounter);
					System.out.println();

					// A new method with this new computers
					Computer c = new Computer(brand, model, price);

					// Each computer add will enter the inventory
					inventory[i] = c;

					System.out.println("Computer(s) added sucessfully");

				}
				break;

			case 2:
				System.out.println("2. Put your password");

				// if the correct password is check put how many computers do want to update
				if (checkPassword(kb)) {
					System.out.println("Which computer number do you want update?");

					// variable for update the computers
					updateComputersNumber = kb.nextInt();

					// add a computer we need to find the index, because computer already exist
					int index = updateComputersNumber - 1;

					// The computer number is the index in the array inventory.
					if (index < inventory.length) {

						Computer c = inventory[index];

						System.out.println("Computer #: " + updateComputersNumber);
						System.out.println("Model: " + c.getModel());
						System.out.println("Brand: " + c.getBrand());
						System.out.println("Computer SerialNumber: " + c.getSerialNumber());
						System.out.println("Price: $ " + c.getPrice());
						System.out.println();

						c = new Computer();

						int choicemenu2;

						// display the UPDATE MENU
						do {
							System.out.println("What information would you like to change? Put the number");
							System.out.println("1.New Brand");
							System.out.println("2.New Model");
							System.out.println("3.New SN");
							System.out.println("4.New Price");
							System.out.println("5.Quit the Update Menu");

							// what information would you like to change?
							choicemenu2 = kb.nextInt();

							// if the user put ne number worng in the MENU 2
							if (choicemenu2 > 5 || choicemenu2 <= 0) {
								System.out.println("This number is invalid.Try again");
								System.out.println();
							}

							switch (choicemenu2) {

							// MEXI AQUII
							case 1:
								System.out.println("1. Enter the new Brand:");
								String brand = kb.next();
								c.setBrand(brand);
								break;
							case 2:
								System.out.println("2. Enter the new Model:");
								String model = kb.next();
								c.setModel(model);
								break;
							case 3:
								System.out.println("3.Enter the new SN");
								long serialNumber = kb.nextLong();
								c.setSerialNumber(serialNumber);
								break;
							case 4:
								// initialize the price
								double price = 0;
								do {
									System.out.println("4. Enter the new Price: ");
									price = kb.nextDouble();
									c.setPrice(price);

									// not accepted negative numbers in the UPDATE
									if (price <= 0) {
										System.out.println("Invalid price.Should be a positive value");
									}
								} while (price <= 0);

								break;
							case 5:
								System.out.println("5.Quit the Main Menu");
								break;
							}
							System.out.println("Computer(s) changed sucessfully");
							System.out.println();

						} while (choicemenu2 != 5);
					}
				}
				break;

			case 3:
				System.out.println("3. Enter a specific brand");
				String newBrand = kb.next();

				findComputersBy(newBrand, inventory);
				break;

			case 4:
				System.out.println("4. Enter a specific price: ");
				Double price = kb.nextDouble();

				findCheaperThan(price, inventory);
				break;

			case 5:
				System.out.println(" 5 -> exit. The program finish");
				break;
			}
		} while (choiceMenu != 5);
	}

	public static boolean checkPassword(Scanner kb) {
		// user has only 3 tries
		int passwordTries = 0;

		// while the name password for different that "password" continue to prompt
		while (passwordTries < 3) {
			String namePassword = kb.next();
			passwordTries++;

			if (namePassword.equals("password")) {
				return true;
			} else {
				// After the 3rd illegal entry, the main menu in figure 1 is re-displayed again.
				System.out.println("Invalid, try again");
			}
		}
		return false;
	}
	// method for find all computers with a specific brand
	// Computer inside the class Computer
	public static void findComputersBy(String brand, Computer[] inventory) {

		// scroll through the information about Computer c
		for (Computer c : inventory) {

			// for app not crash I need to put != null for c and for brand
			if (c != null && c.getBrand() != null && c.getBrand().equalsIgnoreCase(brand)) {
				// print all the informations in computer
				System.out.println("All the computers with this brand: ");
				System.out.println(c);
				System.out.println();
			}
		}
	}
	public static void findCheaperThan(double price, Computer[] inventory) {

		// scroll through the information about Computer c
		for (Computer c : inventory) {
			// print the values less than price that user put
			if (c != null && c.getPrice() != null && c.getPrice() < price) {

				System.out.println("All the computers with this prices or less: ");
				System.out.println(c);
				System.out.println();
			}
		}
	}
}
