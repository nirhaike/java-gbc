/**
Copyright (c) 2016, Nir Haike.
*/
package com.jgbc.emu.core;

public class Z80 {
	
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
