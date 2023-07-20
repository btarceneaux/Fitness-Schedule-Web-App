package com.bean;

public class Participant
{
	private int userId;
	private String lastName;
	private String firstName;
	private String password;
	private String email;
	
	public Participant()
	{
		
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "Participant [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", password="
				+ password + ", email=" + email + "]";
	}
	
	
}
