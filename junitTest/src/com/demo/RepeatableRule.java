package com.demo;

import java.util.Arrays;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

class RepeatableRule implements MethodRule {

	String filePath;
	String beforeSqlKey;
	String afterSqlKey;
	// Loop times
	int times = 1;
	// Loop methods
	String[] testMethods = null;
	
	public RepeatableRule(String filePath, String beforeSqlKey,
			String afterSqlKey, int times, String[] testMethods) {
		super();
		this.filePath = filePath;
		this.beforeSqlKey = beforeSqlKey;
		this.afterSqlKey = afterSqlKey;
		this.times = times;
		this.testMethods = testMethods;
	}
	
	@Override
	public Statement apply(final Statement base, final FrameworkMethod method,
			final Object target) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				if (Arrays.asList(testMethods).contains(method.getName())) {
					if(beforeSqlKey!=null && beforeSqlKey.length()>0)
					before(base, method, target);
				}
				// before() and after() are also executed
				base.evaluate();
				if (Arrays.asList(testMethods).contains(method.getName())) {
					if(afterSqlKey!=null && afterSqlKey.length()>0)
					after(base, method, target);
				}
			}

			public void before(final Statement base,
					final FrameworkMethod method, Object target) {
				String methodName = method.getName();
				System.out.println(methodName + " rule start...");
				beforeActions(beforeSqlKey, times);

			}

			private void beforeActions(String beforeSqlKey, int times) {
				String keyContent = (String) Tools
						.getPropertyFile(filePath).get(beforeSqlKey);
				System.out.println("keyContent:" + keyContent);
				excuteActionSql(keyContent);
				
			}


			private void excuteActionSql(String keyContent) {
				System.out.println("start excute....");
				System.out.println(keyContent);
				System.out.println("excute finished....");
			}

			public void after(final Statement base,
					final FrameworkMethod method, Object target) {
				String methodName = method.getName();
				System.out.println(methodName + " rule end....");
				afterActions(
						afterSqlKey, times);
			}

			private void afterActions(String afterSqlKey, int times) {
				String keyContent = (String) Tools
						.getPropertyFile(filePath).get(afterSqlKey);
				System.out.println("keyContent:" + keyContent);
				excuteActionSql(keyContent);
				
			}
		};
	}
}