package com.sumit.springboot.restful.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sumit.springboot.restful.DTO.ArticleReadDTO;
import com.sumit.springboot.restful.DTO.TimeToReadDTO;
import com.sumit.springboot.restful.DTO.TagMetricsDTO;
import com.sumit.springboot.restful.utility.UtilityClass;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:aplication.properties")
@RestController
@RequestMapping("/api/v1/article")
public class ArticleAPI {
	
    private final ArticleService articleService;
    private final TagMetricsService tagMetricsService;
    @Value("${speed.of.average.human}")
    private int speedToRead;
    
    private ArticleReadDTO articleReadDTO = new ArticleReadDTO();
    
    private TimeToReadDTO timeToReadDTO= new TimeToReadDTO();
    private TagMetricsDTO tag;
   
	@Autowired 
    public ArticleAPI(ArticleService articleService, TagMetricsService tagMetricsService) {
		this.articleService = articleService;
		this.tagMetricsService = tagMetricsService;
		
    }
	
    @GetMapping
    public ResponseEntity<List<Article>> findAll() {
        return ResponseEntity.ok(articleService.findAll());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable Long id) {
        Optional<Article> article = articleService.findById(id);

        return ResponseEntity.ok(articleService.findById(id).get());
    }*/
    @GetMapping("/{slug}")
    public ResponseEntity<Article> findBySlug(@PathVariable String slug) {
        Optional<Article> article = articleService.findBySlug(slug);

        return ResponseEntity.ok(articleService.findBySlug(slug).get());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Article> create(@RequestBody Article articeBody) {
    	articeBody.setSlug(articeBody.getTitle());
    	articeBody.setTags(UtilityClass.replace(articeBody.getTags()));
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.save(articeBody));
    }

  /*  @PutMapping("/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article articleBody) {
    	
    	
    	Optional<Article> article = articleService.findById(id);
   	 if (!article.isPresent())
   			return ResponseEntity.notFound().build();

   	 Article updatedArticle = article.get();
   	 updatedArticle.setTitle(articleBody.getTitle());
	 updatedArticle.setSlug(articleBody.getTitle());
   		
   	 articleService.save(updatedArticle);
   	 return ResponseEntity.ok(articleService.findById(id).get());
    }*/
    
    @PutMapping("/{slug}")
    public ResponseEntity<Article> update(@PathVariable String slug, @RequestBody Article articleBody) {
    	
    	
    	Optional<Article> article = articleService.findBySlug(slug);
   	 if (!article.isPresent())
   			return ResponseEntity.notFound().build();

   	 Article updatedArticle = article.get();
   	 updatedArticle.setTitle(articleBody.getTitle());
	 updatedArticle.setSlug(articleBody.getTitle());
   		
	 articleService.save(updatedArticle);
   	 return ResponseEntity.ok(articleService.findBySlug(updatedArticle.getSlug()).get());
    }

  /*  @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        articleService.deleteById(id);

        return ResponseEntity.accepted().build();
    }
    */
    @Transactional
    @DeleteMapping("/{slug}")
    public ResponseEntity deleteBySlug(@PathVariable String slug) {
    	articleService.deleteBySlug(slug);

        return ResponseEntity.accepted().build();
    }
    
    @GetMapping("/{slug}/timetoread")
    public ResponseEntity<ArticleReadDTO> findTimeToRead(@PathVariable String slug) {
        Optional<Article> article = articleService.findBySlug(slug);
        Article articleOb = article.get();
        articleReadDTO.setArticleId(articleOb.getId());
        int totalNumberOfWords = UtilityClass.wordcount(articleOb.getBody());
        double time = (float)totalNumberOfWords/speedToRead;
        List<Integer> timeList= UtilityClass.timeToConvert(time);
        timeToReadDTO.setMins(timeList.get(1));
        timeToReadDTO.setSeconds(timeList.get(2));
        articleReadDTO.setTimeToRead(timeToReadDTO);
        return ResponseEntity.ok(articleReadDTO);
    }
    @GetMapping("/tags")
    public ResponseEntity<List<TagMetricsDTO>> tagMetrics() {
    	List<Object[]> list =  tagMetricsService.findTagMetricsDTOMapping();
    	List<TagMetricsDTO> listTagMetricsDTO = new ArrayList<TagMetricsDTO>();
    	for (Object[] result : list) {
    	   String tag = (String)result[0];
    	   System.out.println(tag); 
    	    BigInteger occurence = (BigInteger) result[1];
    	    System.out.println(occurence);
    	    TagMetricsDTO tagMetricsDTO = new TagMetricsDTO();
    	    tagMetricsDTO.setTag(tag);
    	    tagMetricsDTO.setOccurence(occurence.intValue());
    	    listTagMetricsDTO.add(tagMetricsDTO);
    	}
    	return ResponseEntity.ok(listTagMetricsDTO);
    }
}
