package com.shoppingapp.model;

public class User {
	
	static public String UserID;
		private String name;
		private String password;
		
		public User() {
			this("N/A","N/A");
		}

		public User(String name, String password) {
			super();
			this.name = name;
			this.password = password;
		}

		public static String getUserID() {
			return UserID;
		}

		public static void setUserID(String userID) {
			UserID = userID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", password=" + password + "]";
		}
		

		}