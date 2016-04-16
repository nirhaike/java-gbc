/**
Copyright (c) 2016, Nir Haike.
*/
package com.jgbc.emu;

import java.io.File;

import com.jgbc.emu.core.Cartridge;
import com.jgbc.emu.core.InterruptHandler;
import com.jgbc.emu.core.MMU;
import com.jgbc.emu.core.Z80;

public class GameboyColor implements Runnable {

	private Z80 core;
	private MMU mmu;
	private Cartridge cart;
	private InterruptHandler irq;
	
	private boolean powerOn;

	public GameboyColor() {
		// initialize the hardware components
		this.core = new Z80();
		this.mmu = new MMU();
		this.cart = new Cartridge();
		this.irq = new InterruptHandler();
		// update core components
		this.core.setMMU(mmu);
		this.core.setCartridge(cart);
		this.core.setInterruptHandler(irq);
		// update memory map components
		this.mmu.setCartridge(cart);
		// initialize other variables
		powerOn = false;
	}
	/**
	 * Powers the gameboy color.
	 * @param f the path to the game file
	 * @post the game will be ready to run
	 */
	public void power(File f) {
		// TODO finish this
		core.initialize();
		mmu.initialize();
		powerOn = true;
	}

	public void run() {
		// TODO finish this
		while (powerOn) {
			// execute a frame
			execute();
		}
	}
	
	public void execute() {
		// TODO
	}

}
