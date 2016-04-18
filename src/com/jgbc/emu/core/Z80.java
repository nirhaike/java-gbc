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
	
	private int mCycles;
	private int tCycles; 
	
	private MMU mmu;
	private Cartridge cart;
	private InterruptHandler irq;
	
	
	public Z80() {
		// TODO
	}
	
	public void initialize() {
		// TODO continue this
		// initialize the registers
		if (cart.isCGB())
			AF = new Word(0x11b0);
		else
			AF = new Word(0x01b0);
		BC = new Word(0x0013);
		DE = new Word(0x00d8);
		HL = new Word(0x014d);
		PC = new Word(0x0100);
		SP = new Word(0xfffe);
		// initialize the cycles
		mCycles = 0;
		tCycles = 0;
	}
	
	public int getPC() {
		return PC.getValue();
	}
	
	public int getAF() {
		return AF.getValue();
	}
	
	public int getBC() {
		return BC.getValue();
	}
	
	public int getDE() {
		return DE.getValue();
	}
	
	public int getHL() {
		return HL.getValue();
	}
	
	public int getSP() {
		return SP.getValue();
	}
	
	public int getA() {
		return AF.getHighByte();
	}
	
	public int getF() {
		return AF.getLowByte();
	}
	
	public int getB() {
		return BC.getHighByte();
	}
	
	public int getC() {
		return BC.getLowByte();
	}
	
	public int getD() {
		return DE.getHighByte();
	}
	
	public int getE() {
		return DE.getLowByte();
	}
	
	public int getH() {
		return HL.getHighByte();
	}
	
	public int getL() {
		return HL.getLowByte();
	}
	
	public void setMMU(MMU mmu) {
		this.mmu = mmu;
	}
	
	public void setInterruptHandler(InterruptHandler irq) {
		this.irq = irq;
	}
	
	public void setCartridge(Cartridge cart) {
		this.cart = cart;
	}
	
	// execute single instruction
	public void execute() throws Exception {
		int opcode = mmu.readByte(PC.getValue());
		this.PC.increase();
		if (opcode != 0xcb) {
			// handle 1 byte opcodes
			runOpcode(opcode);
		} else {
			// get the next byte
			opcode = mmu.readByte(PC.getValue());
			this.PC.increase();
			// handle 2 bytes opcodes
			runCBOpcode(opcode);
		}
	}
	
	// instructions map
	public void runOpcode(int opcode) throws Exception {
		switch (opcode) {
		case 0x00:
			nop();
			break;
		case 0xE1:
			popHL();
			break;
		case 0xE5:
			pushHL();
			break;
		case 0xF1:
			popAF();
			break;
		case 0xF5:
			pushAF();
			break;
		default:
			unimplementedOpcode(opcode);
			break;
		}
	}
	
	public void runCBOpcode(int opcode) throws Exception {
		switch (opcode) {
		default:
			unimplementedOpcode(opcode);
			break;
		}
	}
	
	// instructions simulating functions
	public void pushAF() {
		SP.decrease(); // move the stack pointer
		mmu.writeByte(SP.getValue(), AF.getHighByte()); // write A
		SP.decrease(); // move the stack pointer
		mmu.writeByte(SP.getValue(), AF.getLowByte()); // write F
		// update cycles
		mCycles += 3;
		tCycles += 12;
	}
	
	public void pushHL() {
		SP.decrease(); // move the stack pointer
		mmu.writeByte(SP.getValue(), HL.getHighByte()); // write H
		SP.decrease(); // move the stack pointer
		mmu.writeByte(SP.getValue(), HL.getLowByte()); // write L
		// update cycles
		mCycles += 3;
		tCycles += 12;
	}
	
	public void popAF() {
		this.AF.setLowByte(mmu.readByte(SP.getValue())); // read F
		SP.increase(); // move the stack pointer
		this.AF.setHighByte(mmu.readByte(SP.getValue())); // read A
		SP.increase(); // move the stack pointer
		// update cycles
		mCycles += 3;
		tCycles += 12;
	}
	
	public void popHL() {
		this.HL.setLowByte(mmu.readByte(SP.getValue())); // read L
		SP.increase(); // move the stack pointer
		this.HL.setHighByte(mmu.readByte(SP.getValue())); // read H
		SP.increase(); // move the stack pointer
		// update cycles
		mCycles += 3;
		tCycles += 12;
	}
	
	public void nop() {
		// update cycles
		mCycles += 1;
		tCycles += 4;
	}
	
	public void unimplementedOpcode(int opcode) throws Exception {
		throw new Exception("Unimplemented Opcode: " + opcode);
	}
	
}
