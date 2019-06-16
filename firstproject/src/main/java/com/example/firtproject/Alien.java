package com.example.firtproject;

import org.springframework.stereotype.Component;

@Component
public class Alien {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Alien [id=" + id + "]";
	}
	
	public void print() {
		System.out.print(this);
	}
	
}
