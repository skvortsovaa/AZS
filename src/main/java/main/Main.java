package main;

import Car.Car;
import Fuel.Fuel;
import GasStation.GasStation;
import Pump.DieselPump;
import Pump.GasPump;
import Pump.Pump;
import Pump.ElectricPump;
import Users.Customer;
import Users.Manager;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создадим топливо
        Fuel ai95 = new Fuel("AI-95", 50, 200); // цена 50 руб/л, остаток 200 л
        Fuel diesel = new Fuel("Diesel", 45, 300);
        Fuel electricity = new Fuel("Electricity", 10, 500); // 10 руб/кВт⋅ч

        // Создадим колонки
        Pump gasPump = new GasPump("G1", Arrays.asList(ai95));
        Pump dieselPump = new DieselPump("D1", Arrays.asList(diesel));
        ElectricPump electricPump = new ElectricPump("E1", Arrays.asList(electricity));

        // Создадим станцию и добавим колонки
        GasStation station = new GasStation();
        station.addPump(gasPump);
        station.addPump(dieselPump);
        station.addPump(electricPump);

        // Создадим пользователей
        Car car = new Car("AI-95", 50, 10);  // бензиновая машина
        Customer customer = new Customer("Иван", car);
        Manager manager = new Manager("Пётр", station);

        // Главное меню
        while (true) {
            System.out.println("\n=== АЗС ===");
            System.out.println("1. Клиент");
            System.out.println("2. Менеджер");
            System.out.println("0. Выход");
            System.out.print("Выберите роль: ");
            int choice = scanner.nextInt();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    customerMenu(scanner, customer, station, gasPump, dieselPump, electricPump);
                    break;
                case 2:
                    managerMenu(scanner, manager, ai95, diesel, electricity);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }

        scanner.close();
        System.out.println("Работа завершена.");
    }

    // Меню клиента
    private static void customerMenu(Scanner scanner, Customer customer,
                                     GasStation station, Pump gasPump,
                                     Pump dieselPump, ElectricPump electricPump) {
        while (true) {
            System.out.println("\n--- Меню клиента ---");
            System.out.println("1. Заправиться по литрам");
            System.out.println("2. Заправиться по деньгам");
            System.out.println("3. Заправиться до полного");
            System.out.println("4. Зарядить электромобиль");
            System.out.println("0. Назад");
            System.out.print("Ваш выбор: ");
            int c = scanner.nextInt();

            if (c == 0) break;

            try {
                switch (c) {
                    case 1:
                        System.out.print("Сколько литров? ");
                        double liters = scanner.nextDouble();
                        customer.refuelByLiters(gasPump, liters, station);
                        break;
                    case 2:
                        System.out.print("На какую сумму? ");
                        int money = scanner.nextInt();
                        customer.refuelByMoney(gasPump, money, station);
                        break;
                    case 3:
                        customer.refuelFull(gasPump, station);
                        break;
                    case 4:
                        System.out.print("Сколько минут зарядки? ");
                        int minutes = scanner.nextInt();
                        customer.chargeElectric(electricPump, minutes, station);
                        break;
                    default:
                        System.out.println("Неверный выбор!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    // Меню менеджера
    private static void managerMenu(Scanner scanner, Manager manager,
                                    Fuel ai95, Fuel diesel, Fuel electricity) {
        while (true) {
            System.out.println("\n--- Меню менеджера ---");
            System.out.println("1. Посмотреть выручку");
            System.out.println("2. Посмотреть остатки топлива");
            System.out.println("3. Заказать поставку топлива");
            System.out.println("0. Назад");
            System.out.print("Ваш выбор: ");
            int c = scanner.nextInt();

            if (c == 0) break;

            switch (c) {
                case 1:
                    manager.viewRevenue();
                    break;
                case 2:
                    manager.viewFuelStats();
                    break;
                case 3:
                    System.out.println("Выберите вид топлива: 1.AI-95, 2.Diesel, 3.Electricity");
                    int fChoice = scanner.nextInt();
                    Fuel selectedFuel = switch (fChoice) {
                        case 1 -> ai95;
                        case 2 -> diesel;
                        case 3 -> electricity;
                        default -> null;
                    };
                    if (selectedFuel == null) {
                        System.out.println("Неверный выбор топлива!");
                        break;
                    }
                    System.out.print("Введите объём поставки: ");
                    double vol = scanner.nextDouble();
                    System.out.print("Введите закупочную цену за литр: ");
                    double price = scanner.nextDouble();
                    manager.orderFuelDelivery(selectedFuel, vol, price);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}