package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoriesController {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @GetMapping("{id}")
    public Category getCategoryById(@PathVariable int id) {
        Category category = categoryDao.getCategoryById(id);
        if (category == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found.");
        }
        return category;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category) {
        return categoryDao.create(category);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        categoryDao.update(id, category);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        categoryDao.delete(id);
    }
}
