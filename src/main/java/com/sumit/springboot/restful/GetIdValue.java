package com.sumit.springboot.restful;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning; 

//@Aspect
//@Component
public class GetIdValue {
	
	   //@AfterReturning(pointcut = "execution(* com.sumit.springboot.restful.article.Article.setId(*)))",  returning = "retVal")
	// @Before("execution(* org.springframework.data.repository.CrudRepository+.save(*))")
	 //@After("execution(* com.sumit.springboot.restful.article.Article.setId(*))")  
	public void afterReturningAdvice(JoinPoint jp){
	      System.out.println("Method Signature: "  + jp.getSignature());  
	      Object ob=jp.getTarget();
	     // System.out.println("Returning:" + retVal.toString() );
	   }
}
