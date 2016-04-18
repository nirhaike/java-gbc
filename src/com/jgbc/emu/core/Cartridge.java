/**
Copyright (c) 2016, Nir Haike.
*/
package com.jgbc.emu.core;

public class Cartridge {

	public static final int ROM_BANK_OFFSET = 0x4000;
	
	private boolean cgbFlag;
	private boolean sgbFlag;
		
	private int[] rom; // cartridge loaded data (all banks)
	private int currRomBank;
	
	public Cartridge() {
		// TODO load cartridge
	}
	
	public boolean isCGB() {
		return cgbFlag;
	}
	
	public boolean isSGB() {
		return sgbFlag;
	}
	
	public int getType() {
		return rom[0x0147];
	}
	
	// read from the current rom bank
	public int readRom(int addr) {
		return rom[ROM_BANK_OFFSET * currRomBank + addr] & 0xff;
	}
	
	// write to the current rom bank
	public void writeRom(int addr, int val) {
		rom[ROM_BANK_OFFSET * currRomBank + addr] = val & 0xff;
	}
	
	public void setRomBank(int romBank) {
		this.currRomBank = romBank;
	}
	
	public int getRomBank() {
		return currRomBank;
	}
	
}
