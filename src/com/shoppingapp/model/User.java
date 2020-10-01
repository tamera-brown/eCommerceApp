package com.shoppingapp.model;

public class User {
	
	static public String Uname;
		private String email;
		private String password;
		
		public User() {
			this("N/A","N/A","N/A");
		}

		public User(String uname, String email, String password) {
			super();
			Uname = uname;
			this.email = email;
			this.password = password;
		}

		public String getUname() {
			return Uname;
		}

		public void setUname(String uname) {
			Uname = uname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "User [Uname=" + Uname + ", email=" + email + ", password=" + password + "]";
		}

}