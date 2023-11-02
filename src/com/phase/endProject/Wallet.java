package com.phase.endProject;

public class Wallet {
	private String username;
    private double balance;

    public Wallet(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
