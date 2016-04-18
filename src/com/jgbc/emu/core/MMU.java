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
	private Z80 core;
	
	private int[] workingRam;
	private int[] externalRam;
	private int[] zeroPageRam;
	private int[] bios;
	
	private boolean inBios;
	
	public MMU() {
		// TODO
	}
	
	public void initialize() {
		// TODO complete this
		inBios = true;
		workingRam = new int[0x2000]; // 8k
		externalRam = new int[0x2000]; // 8k
		zeroPageRam = new int[0x80];
		bios = new int[0x100];
		
	}
	
	public void setCartridge(Cartridge cart) {
		this.cart = cart;
	}
	
	public void setCore(Z80 core) {
		this.core = core;
	}
	
	public int readByte(int address) {
		switch (address & 0xF000) {
		// bios
		case 0x0000:
			if (inBios) {
				if (address < 0x100) {
					return bios[address] & 0xff;
				} else if (this.core.getPC() == 0x100) {
					inBios = false;
				}
			}
			return cart.readRom(address);
		// rom0
		case 0x1000:
		case 0x2000:
		case 0x3000:
			break;
		// rom1 (unbanked)
		case 0x4000:
		case 0x5000:
		case 0x6000:
		case 0x7000:
			break;
		// vram (graphics)
		case 0x8000:
		case 0x9000:
			break;
		// external ram
		case 0xA000:
		case 0xB000:
			break;
		// working ram
		case 0xC000:
		case 0xD000:
		// working ram shadow
		case 0xE000:
			break;
		// working ram shadow, I/O, zero-page ram
		case 0xf000:
			break;
		}
		return 0;
	}
	
	public void writeByte(int address, int value) {
		// TODO
	}

}
