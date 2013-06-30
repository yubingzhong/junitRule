package com.demo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;

public class TestDemo {
	
	

	    @Rule  
	    public MethodRule rule = (MethodRule) new RepeatableRule(TestDemo.class.getResource("/").getPath()+"../sql.properties", "aaa.insert", "aaa.delete", 1, new String[]{"test1","test2"});  
	    //@Rule  
	    //public MethodRule rule2 =(MethodRule) new RepeatableRule(TestDemo.class.getResource("/").getPath()+"../sql.properties", "aaa.insert", "", 1, new String[]{"test2"});  
	      
	    @Test  
	    public void test1(){
	    	System.out.println(" do test1");
	    }  
	    @Test  
	    public void test2(){
	    	
	    	System.out.println(" do test2");
	    }  


}
