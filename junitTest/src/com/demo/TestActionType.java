package com.demo;

public class TestActionType {

	public TestActionType() {

	}

	private static String INSERT = "INSERT";
	private static String DELETE = "DELETE";
	private static String UPDATE = "UPDATE";
	private static String SELECT = "SELECT";
	public static String[] ACTION_TYPE;

	public static String[] getActionType() {
		String[] ACTION_TYPE = { INSERT, DELETE, UPDATE, SELECT };
		return ACTION_TYPE;
	}

}
