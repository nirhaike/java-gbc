/**
Copyright (c) 2016, Nir Haike.
*/
package com.jgbc.emu.core;

/**
 * Memory Interface Emulation
 *  
 * @author Nir Haike
 *
 */
public class MMU {
	
	private Cartridge cart;
	
	public MMU() {
		// TODO
	}
	
	public void initialize() {
		// TODO
	}
	
	public void setCartridge(Cartridge cart) {
		this.cart = cart;
	}
	
	public byte readByte(int address) {
		// TODO
		return 0;
	}
	
	public void writeByte(int address, int value) {
		// TODO
	}

}
