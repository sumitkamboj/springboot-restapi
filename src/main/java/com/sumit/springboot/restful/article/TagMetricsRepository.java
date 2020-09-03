package com.sumit.springboot.restful.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sumit.springboot.restful.DTO.TagMetricsDTO;

public interface TagMetricsRepository extends JpaRepository<Article, Long>{

	//@Query(value ="select tags as tag, count(*) as occurance from article_tags group by tags")
	//value ="select title as title from article where id =1";"
	  // List<TagStatistics> findSurveyCount();
	@Query(value="SELECT " +
	         "v.tags as tag, COUNT(*) as occurence " +
	          "FROM " +
	          "article_tags v " +
             "GROUP BY " +
	           "v.tags", nativeQuery = true)
	/*@Query("SELECT " +
	         "new com.sumit.springboot.restful.DTO.TagMetricsDTO(tags as tag, COUNT(*) as occurence) " +
	          "FROM " +
	          "article_tags " +
            "GROUP BY " +
	           "tags")
	
/*	@Query("SELECT " +
    "new com.sumit.springboot.restful.DTO.TagMetricsDTO(title as tag, id as occurence) " +
     "FROM " +
     "Article" )*/
	List<Object[]> findTagMetricsDTOMapping();
}
