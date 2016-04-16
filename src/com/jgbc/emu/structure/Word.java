/**
Copyright (c) 2016, Nir Haike.
*/
package com.jgbc.emu.structure;

public class Word implements Comparable<Word> {
	
	private int low; // low byte
	private int high; // high byte
	
	private int num; // the whole number
	
	public Word(int num) {
		setValue(num);
	}
	
	public Word() {
		this(0);
	}
	
	
	public int getValue() {
		return num & 0xFFFF;
	}
	
	
	public void setValue(int num) {
		this.num = num & 0xFFFF;
		this.low = num & 0xFF;
		this.high = (num >> 8) & 0xFF;
	}
	
	
	public int getHighByte() {
		return high;
	}
	
	
	public int getLowByte() {
		return low;
	}
	
	
	public void setHighByte(int num) {
		this.high = num & 0xFF;
		this.num = high << 8 + low;
	}
	
	
	public void setLowByte(int num) {
		this.low = num & 0xFF;
		this.num = high << 8 + low;
	}
	
	
	public void increase() {
		num = (num+1) & 0xFFFF;
		setValue(num);
	}
	
	
	public void decrease() {
		num = (num-1) & 0xFFFF;
		setValue(num);
	}
	
	
	public String toString() {
		return high + ":" + low;
	}


	public int compareTo(Word other) {
		return this.getValue() - other.getValue();
	}
	
}
