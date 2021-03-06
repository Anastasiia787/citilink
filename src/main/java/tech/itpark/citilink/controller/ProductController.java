package tech.itpark.citilink.controller;

import org.springframework.web.bind.annotation.*;
import tech.itpark.citilink.domain.*;
import tech.itpark.citilink.manager.ProductManager;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductManager manager = new ProductManager();

    @GetMapping()
    public List<Product> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public void getById(@PathVariable long id) {
        manager.getById(id);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String text) {
        return manager.search(text);
    }

    @GetMapping("/catalog/{type}")
    public List<Product> filter(@PathVariable String type) {
        return manager.filter(type);
    }

    @PostMapping("/caps")
    public void add(@RequestBody Cap product) {
        manager.add(product);
    }

    @PostMapping("/books")
    public void add(@RequestBody Book product) {
        manager.add(product);
    }

    @PostMapping("/laptops")
    public void add(@RequestBody Laptop product) {
        manager.add(product);
    }

    @PostMapping("/smartphones")
    public void add(@RequestBody Smartphone product) {
        manager.add(product);
    }

    @PutMapping("/{id}")
    public Object updateById(@PathVariable long id, @RequestBody ProductUpdate dto) {
        try {
            return manager.updateById(id, dto);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) throws RuntimeException {
        try {
            manager.removeById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
