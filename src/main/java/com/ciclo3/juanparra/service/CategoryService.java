package com.ciclo3.juanparra.service;

import java.util.List;
import java.util.Optional;
import com.ciclo3.juanparra.model.Category;
import com.ciclo3.juanparra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category catg) {
        if (catg.getId() == null) {
            return categoryRepository.save(catg);
        } else {
            Optional<Category> consulta = categoryRepository.getCategory(catg.getId());
            if (consulta.isEmpty()) {
                return categoryRepository.save(catg);
            } else {
                return catg;

            }
        }
    }

    public Category update(Category catg) {
        if (catg.getId() != null) {
            Optional<Category> consulta = categoryRepository.getCategory(catg.getId());
            if (!consulta.isEmpty()) {
                if (catg.getDescription() != null) {
                    consulta.get().setDescription(catg.getDescription());
                }
                if (catg.getName() != null) {
                    consulta.get().setName(catg.getName());
                }
                return categoryRepository.save(consulta.get());
            }
        }
        return catg;
    }

    public boolean deleteCategory(int categoriaId) {
        Boolean caBoolean = getCategory(categoriaId).map(categoria -> {
            categoryRepository.delete(categoria);
            return true;
        }).orElse(false);
        return caBoolean;
    }
}
