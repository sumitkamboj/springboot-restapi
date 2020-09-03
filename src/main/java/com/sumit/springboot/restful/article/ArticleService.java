package com.sumit.springboot.restful.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRespository;

    @Autowired
    public ArticleService(ArticleRepository articleRespository) {
        this.articleRespository = articleRespository;
    }

    public List<Article> findAll() {
        return articleRespository.findAll();
    }

    public Optional<Article> findById(Long id) {
        return articleRespository.findById(id);
    }

    public Article save(Article stock) {
        return articleRespository.save(stock);
    }

    public void deleteById(Long id) {
    	articleRespository.deleteById(id);
    }
    public Optional<Article> findBySlug(String slug){
    	return articleRespository.findBySlug(slug);
    }
    public void deleteBySlug(String slug) {
    	articleRespository.deleteBySlug(slug);
    }
}
