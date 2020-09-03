package com.sumit.springboot.restful.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumit.springboot.restful.DTO.TagMetricsDTO;
@Service
public class TagMetricsService {
	  
	private final TagMetricsRepository tagMetricsRepository;
	private TagMetricsDTO tagMetricsDTO;

	    @Autowired
	    public TagMetricsService(TagMetricsRepository tagMetricsRepository/*,TagMetricsDTO tagMetricsDTO*/) {
	        this.tagMetricsRepository = tagMetricsRepository;
	    //    this.tagMetricsDTO = tagMetricsDTO;
	    }
	    
	    public List<Object[]> findTagMetricsDTOMapping() {
	        return tagMetricsRepository.findTagMetricsDTOMapping();
	       
	    }
}
