package com.devkh.advancedjpa.repostitory;

import com.devkh.advancedjpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
