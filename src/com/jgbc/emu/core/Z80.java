/**
Copyright (c) 2016, Nir Haike.
*/
package com.jgbc.emu.core;

import com.jgbc.emu.structure.Word;

public class Z80 {
	
	public static final int C_FLAG_MASK = 0x10; // carry flag
	public static final int H_FLAG_MASK = 0x20; // half-carry flag
	public static final int N_FLAG_MASK = 0x40; // operation (subtraction) flag
	public static final int Z_FLAG_MASK = 0x80; // zero flag
	
	private Word AF; // accumulator and flags
	private Word BC; // b and c registers
	private Word DE;
	private Word HL;

	private Word PC; // program counter
	private Word SP; // stack pointer
	
	private MMU mmu;
	private InterruptHandler irq;
	
	public Z80() {
		// TODO
	}
	
	public void initialize() {
		// TODO continue this
		// initialize the registers
		AF = new Word();
		BC = new Word();
		DE = new Word();
		HL = new Word();
		PC = new Word();
		SP = new Word();
	}
	
	public void setMMU(MMU mmu) {
		this.mmu = mmu;
	}
	
	public void setInterruptHandler(InterruptHandler irq) {
		this.irq = irq;
	}
	
}
