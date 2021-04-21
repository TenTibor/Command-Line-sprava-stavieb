import authentication.Authentication;
import buildings.Building;
import customers.Customer;
import customers.CustomersList;
import employees.Boss;
import employees.Employee;
import employees.EmployeesList;

import java.util.Scanner;

public class Main {
    final static String exitInput = "0";

    static void whoIsBoss() {
        System.out.println("You are!");
    }

    public static void main(String[] args) {
        // employees
        EmployeesList employeesList = new EmployeesList();

        // UPCASTING is here
        Employee randomEmployee = new Boss("Tibor", "Dulovec", "tibor@mail.com", "123456");
        employeesList.addEmployee(randomEmployee);
        randomEmployee = new Employee("Ferko", "Trelko", "empl@mail.com", "123456");
        employeesList.addEmployee(randomEmployee);
        randomEmployee = new Employee("Nezmar", "Zmareny", "zmarendo@mail.com", "123456");
        employeesList.addEmployee(randomEmployee);
        randomEmployee = new Employee("Trendo", "Drendo", "prendo@mail.com", "123456");
        employeesList.addEmployee(randomEmployee);
        employeesList.addEmployee(new Employee("Velky", "Frajer", "frajer@mail.com", "123456"));

        // buildings
        CustomersList customerList = new CustomersList();
        customerList.addCustomer(new Customer("Fero", "Velky", "maik23@mail.com"));
        customerList.addCustomer(new Customer("Jano", "Maly", "mas321@mail.com"));
        customerList.addCustomer(new Customer("Peto", "Siroky", "mdsa23@mail.com"));
        customerList.addCustomer(new Customer("Pato", "Tenky", "mh31@mail.com"));

        // start interface
        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication(employeesList);
        String response = "";
        System.out.println("====================\n Welcome to system!\n====================");
        boolean showMenu = true;
        while (!response.equals(exitInput)) {
            if (!auth.isLoggedIn()) {
                // Login
                System.out.println("Log in as:");
                System.out.println("0: Exit\n1: Employee\n2: Guest");
                response = scanner.nextLine();
                showMenu = true;
                switch (response) {
                    case "1":
                        auth.logIn();
                        break;
                    case "2":
                        auth.logAsGuest();
                        break;
                }
            } else {
                // Logged in
                if (showMenu) {
                    System.out.println("================");
                    System.out.println("0: Exit\n1: Log out" +
                            (!auth.isGuest() ? "\n2: Show my profile" : "") +
                            (!auth.isGuest() ? "\n3: Show all employees" : "") +
                            (!auth.isGuest() && auth.getUser().canEditEmployees() ? "\n4: Add new employee" : "") +
                            ("\n5: Show all customers") +
                            (!auth.isGuest() ? "\n6: Add new customer" : "") +
                            ("\n7: Show customer") +
                            ("\n8: Show all buildings") +
                            ("\n9: Search customer")
                    );
                    System.out.print("What you wanna do? ");

                }
                response = scanner.nextLine();
                showMenu = false;

                // For everybody
                switch (response) {
                    // Show menu
                    case "m":
                        showMenu = true;
                        break;
                    // Log out
                    case "1":
                        auth.logOut();
                        break;
                    // Show all customers
                    case "5":
                        customerList.writeList();
                        break;
                    // Show customer
                    case "7":
                        System.out.print("Type index of customer: ");
                        String sIndex = scanner.nextLine();
                        Customer thisCustomer = customerList.getCustomer(sIndex);

                        // Check if index was found
                        if (thisCustomer == null) {
                            System.out.println("You wrote bad index!");
                            showMenu = true;
                            break;
                        }

                        // Menu for customer
                        String customerResponse = "";
                        if (!auth.isGuest()) while (!customerResponse.equals(exitInput)) {
                            // Show card
                            thisCustomer.showCard(true);
                            customerResponse = scanner.nextLine();

                            // If input is number or character
                            try {
                                int indexBuilding = Integer.parseInt(customerResponse);
                                // Show building
                                Building thisBuilding = thisCustomer.getBuilding(indexBuilding);

                                // Check if index was found
                                if (thisBuilding == null) {
                                    System.out.println("You wrote bad index!");
                                    showMenu = true;
                                    break;
                                }


                                // Menu for building
                                String buildingResponse = "";
                                while (!buildingResponse.equals(exitInput)) {
                                    // Show card
                                    thisBuilding.showCard();
                                    buildingResponse = scanner.nextLine();

                                    switch (buildingResponse.toUpperCase()) {
                                        case "R":
                                            thisCustomer.removeBuilding(indexBuilding - 1);
                                            System.out.println("Building was removed!");
                                            buildingResponse = exitInput;
                                            break;
                                        case "F":
                                            thisBuilding.finish();
                                            buildingResponse = exitInput;
                                            break;
                                        case "C":
                                            thisBuilding.cancel();
                                            buildingResponse = exitInput;
                                            break;
                                        case "W":
                                            System.out.print("Name of new worker: ");
                                            thisBuilding.addWorker(scanner.nextLine());
                                            break;
                                        case "N":
                                            System.out.print("New note: ");
                                            thisBuilding.note.editText(scanner.nextLine());
                                            break;
                                        case "RN":
                                            thisBuilding.note.removeNote();
                                            System.out.println("others.Note was removed");
                                            break;
                                    }
                                }
                            } catch (NumberFormatException e) {
                                switch (customerResponse.toUpperCase()) {
                                    case "A":
                                        thisCustomer.newBuilding();
                                        break;
                                    case "R":
                                        customerList.removeItem(Integer.parseInt(sIndex) - 1);
                                        System.out.println("Customer was removed!");
                                        customerResponse = exitInput;
                                        showMenu = true;
                                        break;
                                    case "N":
                                        System.out.print("New note: ");
                                        thisCustomer.note.editText(scanner.nextLine());
                                        break;
                                    case "RN":
                                        thisCustomer.note.removeNote();
                                        System.out.println("others.Note was removed");
                                        break;
                                }
                            }
                        }
                        else thisCustomer.showCard(false);
                        break;
                    // Show all buildings
                    case "8":
                        customerList.writeBuildingList();
                        break;
                    case "9":
                        System.out.print("Name of customer: ");
                        customerList.showCustomer(scanner.nextLine());
                        break;
                    default:
                        // For only employees
                        if (!auth.isGuest()) switch (response) {
                            // Show profile of logged employees
                            case "2":
                                System.out.println("Your profile:");
                                System.out.println(auth.getUser().getName());
                                System.out.println(auth.getUser().getEmail());
                                System.out.println("Press number to do action. (Press m to show menu)");
                                break;
                            // Show all employees
                            case "3":
                                employeesList.writeList();
                                break;

                            // Add new customer
                            case "6":
                                customerList.addCustomerInterface();
                                break;
                            default:
                                // Only for boss
                                if (auth.getUser().canEditEmployees()) switch (response) {
                                    // Add employee
                                    case "4":
                                        employeesList.addEmployeeInterface();
                                        break;
                                    // Who is boss? -- Ano, dochadzali mi napady
                                    case "who is boss":
                                        whoIsBoss();
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
        }
    }
}