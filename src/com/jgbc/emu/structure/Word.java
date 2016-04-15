/**
Copyright (c) 2016, Nir Haike.
*/
package com.jgbc.emu.structure;

public class Word implements Comparable<Word> {
	
	private byte low; // low byte
	private byte high; // high byte
	
	private int num; // the whole number
	
	public Word(int num) {
		setNum(num);
	}
	
	
	public int getNum() {
		return num & 0xFFFF;
	}
	
	
	public void setNum(int num) {
		this.num = num & 0xFFFF;
		this.low = (byte) (num & 0xFF);
		this.high = (byte) ((num >> 8) & 0xFF);
	}
	
	
	public int getHighByte() {
		return high;
	}
	
	
	public int getLowByte() {
		return low;
	}
	
	
	public void setHighByte(int num) {
		this.high = (byte) (num & 0xFF);
		this.num = high << 8 + low;
	}
	
	
	public void setLowByte(int num) {
		this.low = (byte) (num & 0xFF);
		this.num = high << 8 + low;
	}
	
	
	public void increase() {
		num = (num+1) & 0xFFFF;
		setNum(num);
	}
	
	
	public void decrease() {
		num = (num-1) & 0xFFFF;
		setNum(num);
	}
	
	
	public String toString() {
		return high + ":" + low;
	}


	public int compareTo(Word other) {
		return this.getNum() - other.getNum();
	}
	
}
