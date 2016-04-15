/**
Copyright (c) 2016, Nir Haike.
*/
package com.jgbc.emu.core;

import com.jgbc.emu.structure.Word;

public class Z80 {
	
	public static final int Z_FLAG = 0x80; // zero flag
	public static final int N_FLAG = 0x40; // operation (subtraction) flag
	public static final int H_FLAG = 0x20; // half-carry flag
	public static final int C_FLAG = 0x10; // carry flag
	
	private Word AF;
	
	private MMU mmu;
	private InterruptHandler irq;
	
	public Z80() {
		// TODO
	}
	
	public void initialize() {
		// TODO
	}
	
	public void setMMU(MMU mmu) {
		this.mmu = mmu;
	}
	
	public void setInterruptHandler(InterruptHandler irq) {
		this.irq = irq;
	}
	
}
