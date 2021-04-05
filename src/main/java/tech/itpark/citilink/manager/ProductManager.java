package tech.itpark.citilink.manager;

import tech.itpark.citilink.domain.*;


import java.util.*;


public class ProductManager {

    private long nextId = 1;
    private List<Product> items = new ArrayList<>();

    public List<Product> getAll() {
        return items;
    }

    public void add(Product product) {
        product.setId(nextId);
        items.add(product);
        nextId++;

    }

    public Product getById(long id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<Product> search(String text) {
        List<Product> result = new ArrayList<>();
        String target = text.trim().toLowerCase();

        for (Product item : items) {
            if (contains(item.getName(), target)) {
                result.add(item);
                continue;
            }
            if (item instanceof Book) {
                Book book = (Book) item;
                if (contains(book.getAuthor(), target)) {
                    result.add(item);
                    continue;
                }
            }
            if (item instanceof Cap) {
                Cap cap = (Cap) item;
                if (contains(cap.getColor(), target)) {
                    result.add(item);
                    continue;
                }
            }
            if (item instanceof Laptop) {
                Laptop laptop = (Laptop) item;
                if (contains(laptop.getProcessor(), target)) {
                    result.add(item);
                    continue;
                }
            }
            if (item instanceof Smartphone) {
                Smartphone smartphone = (Smartphone) item;
                if (contains(smartphone.getName(), target)) {
                    result.add(item);
                    continue;
                }
            }
        }
        return result;
    }

    public List<Product> filter(String type) {
        List<Product> result = new ArrayList<>();

        for (Product item : items) {
            if (type.equals("caps") && item instanceof Cap) {
                result.add(item);
                continue;
            }
            if (type.equals("books") && item instanceof Book) {
                result.add(item);
                continue;
            }

            if (type.equals("laptops") && item instanceof Laptop) {
                result.add(item);
                continue;
            }

            if (type.equals("smartphones") && item instanceof Smartphone) {
                result.add(item);
                continue;
            }
        }
        return result;
    }

    public Product updateById(long id, ProductUpdate dto) {
        for (Product item : items) {
            if (item.getId() == id) {
                item.setName(dto.getName());
                item.setPrice(dto.getPrice());
                return item;
            }
        }
        throw new RuntimeException("Product by id = " + id + " not found!");
    }

    public void removeById(long id) {
        for (Product item : items) {
            if (item.getId() == id) {
                item.setRemoved(true);
                return;
            }
        }
        throw new RuntimeException("Product by id = " + id + " not found!");
    }

    private boolean contains(String field, String target) {
        return field.toLowerCase().contains(target);
    }

}

