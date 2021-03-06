/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrInteger;

public class Unsigned16 extends AxdrInteger {

	public Unsigned16() {
		super(0, 65535, 0);
	}

	public Unsigned16(byte[] code) {
		super(0, 65535, 0);
		this.code = code;
	}

	public Unsigned16(long val) {
		super(0, 65535, val);
	}

}
