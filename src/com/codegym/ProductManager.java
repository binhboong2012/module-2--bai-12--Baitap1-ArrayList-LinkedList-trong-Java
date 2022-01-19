package com.codegym;

import java.util.*;

public class ProductManager {
    private ArrayList<Product> list = new ArrayList<>();

    public ProductManager() {
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public int size() {
        return list.size();
    }

    public void printAllProduct() {
        String tittle = String.format("%-10s %-40s %-15s %s", "ID", "Name", "Price", "Description");
        System.out.println(tittle);
        for (Product product : list)
            System.out.println(product);
    }

    public Product inputNewProduct(Scanner scanner) {
        System.out.print("Nhập id: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên SP: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá: ");
        long price = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        return new Product(id, name, price, description);
    }

    public void setProduct(int index, Product product) {
        if (index < 0 || index > size())
            return;
        list.set(index, product);
    }
    public int indexOfById(String searchId){
        int index = -1;
        for (int i = 0; i< size(); i++){
            boolean isFound = list.get(i).getId().toLowerCase().equals(searchId);
            if (isFound){
                index = i;
                break;
            }
        }
        return index;
    }
    public void editProduct(Scanner scanner){
        printAllProduct();
        System.out.print("Nhập id sản phẩm muốn sửa: ");
        String id = scanner.nextLine();
        int index = indexOfById(id);
        if (index < 0) {
            System.out.println("Không tìm thấy sản phẩm.");
        } else {
            Product editProduct = inputNewProduct(scanner);
            setProduct(index, editProduct);
        }
    }

    public void removeProduct(Scanner scanner){
        printAllProduct();
        System.out.print("Nhập id sản phẩm muốn xóa: ");
        String id = scanner.nextLine();
        int index = indexOfById(id);
        if (index < 0) {
            System.out.println("Không tìm thấy sản phẩm.");
        } else {
            list.remove(index);
            System.out.println("Đã xóa sản phẩm.");
        }
    }
    public void searchProduct(Scanner scanner){
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        boolean isFound = false;
        System.out.println("Kết quả tìm kiếm:");

        for(Product product : list){
            if (product.getName().toLowerCase().contains(name.toLowerCase())){
                isFound = true;
                System.out.println(product);
            }
        }
        if (!isFound)
            System.out.println("Không tìm thấy sản phẩm nào.");
    }
    public void sortList(Comparator<Product> comparator){
        Collections.sort(list, comparator);
    }

}
