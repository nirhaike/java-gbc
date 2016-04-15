/**
Copyright (c) 2016, Nir Haike.
*/
package com.jgbc.emu;

import com.jgbc.emu.structure.Word;

public class Test {

	public static void main(String[] args) throws Exception {
		Word w1 = new Word(0xffff);
		if (w1.getLowByte() != 0xff) {
			throw new Exception("Test 1 failed " + w1.getLowByte());
		}
		if (w1.getHighByte() != 0xff) {
			throw new Exception("Test 2 failed " + w1.getHighByte());
		}
	}
	
}
