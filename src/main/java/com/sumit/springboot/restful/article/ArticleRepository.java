package com.sumit.springboot.restful.article;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	Optional<Article> findBySlug(String slug);

	void deleteBySlug(String slug);
}
