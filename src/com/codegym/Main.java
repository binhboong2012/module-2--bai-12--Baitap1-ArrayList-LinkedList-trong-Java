package com.codegym;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        initProductList(manager);
        int choice = -1;
        do {
            displayMenu();
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Goodbye...");
                    break;
                case 1:
                    System.out.println("Danh sách sản phẩm: ");
                    manager.printAllProduct();
                    break;
                case 2:
                    System.out.println("Thêm sản phẩm: ");
                    Product newProduct = manager.inputNewProduct(scanner);
                    manager.addProduct(newProduct);
                    System.out.println("Đã thêm sản phẩm mới");
                    break;
                case 3:
                    System.out.println("Sửa sản phẩm: ");
                    manager.editProduct(scanner);
                    break;
                case 4:
                    System.out.println("Xóa sản phẩm theo Id");
                    manager.removeProduct(scanner);
                    break;
                case 5:
                    System.out.println("Tìm sản phẩm theo tên");
                    manager.searchProduct(scanner);
                    break;
                case 6:
                    System.out.println("Sắp xếp sản phẩm theo giá tăng dần");
                    manager.sortList(new ProductPriceComparator());
                    break;
                case 7:
                    System.out.println("Sắp xếp sản phẩm theo giá giảm dần");
                    manager.sortList(new ProductPriceComparator().reversed());
                    break;
            }
        } while (choice != 0);

    }

    public static void displayMenu() {
        System.out.println("---Menu quản lý sản phẩm ---");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Sửa sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Sắp xếp theo giá tăng dần");
        System.out.println("7. Sắp xếp theo giá giảm dần");
        System.out.println("0. Thoát");
    }


    public static void initProductList(ProductManager manager) {
        manager.addProduct(new Product("121", "Iphone 6S", 4000000, "like new"));
        manager.addProduct(new Product("122", "Iphone 7", 7500000, "new"));
        manager.addProduct(new Product("123", "Iphone 8+", 6500000, "like new"));
        manager.addProduct(new Product("123", "Iphone 8+", 9900000, "new"));
    }
}
