package org.openmuc.axdr.compiler.someexamples;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openmuc.axdr.compiler.someexamples.generated.My_Choice;
import org.openmuc.axdr.compiler.someexamples.generated.My_Choice2;
import org.openmuc.axdr.compiler.someexamples.generated.SequenceOfAll;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrBitString;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrBoolean;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrEnum;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrGeneralizedTime;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrInteger;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrNull;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrOctetString;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrVisibleString;

public class SomeExamplesCodingTest {
	@Test
	public void encodingDecoding() throws IOException {

		BerByteArrayOutputStream axdrOS = new BerByteArrayOutputStream(1000);

		My_Choice2 choice2 = new My_Choice2();
		choice2.setmyint(new AxdrInteger(4711));

		My_Choice choice1 = new My_Choice();
		choice1.setmy_choice2(choice2);

		SequenceOfAll seq = new SequenceOfAll(new AxdrInteger(-271864), new AxdrInteger(89), new AxdrBoolean(false),
				new AxdrBitString(new byte[] { 0x03 }, 8), new AxdrEnum(253),
				new AxdrGeneralizedTime(new byte[] { 12, 34 }), new AxdrNull(), new AxdrOctetString(new byte[] {}),
				new AxdrVisibleString(new byte[] { 39, 32 }), new SequenceOfAll.SubSeqOf_my_sequence(), choice1);

		// Encode seq and check against pre-computed byte array
		seq.encode(axdrOS);
		byte[] expectedBytes = new byte[] { (byte) 0x83, (byte) 0xFB, (byte) 0xDA, (byte) 0X08, (byte) 0x81,
				(byte) 0x59, (byte) 0x00, (byte) 0x08, (byte) 0x03, (byte) 0xFD, (byte) 0x02, (byte) 0x0C, (byte) 0x22,
				(byte) 0x00, (byte) 0x02, (byte) 0x27, (byte) 0x20, (byte) 0x00, (byte) 0x01, (byte) 0x01, (byte) 0x82,
				(byte) 0x12, (byte) 0x67 };

		System.out.println(getByteArrayString(axdrOS.getArray()));
		System.out.println(getByteArrayString(expectedBytes));
		Assert.assertArrayEquals(expectedBytes, axdrOS.getArray());

		// Decode the generated byte array and check selected values
		ByteArrayInputStream bais = new ByteArrayInputStream(axdrOS.getArray());
		SequenceOfAll seq2 = new SequenceOfAll();

		seq2.decode(bais);
		Assert.assertEquals(seq.myBoolean.getValue(), seq2.myBoolean.getValue());
		Assert.assertEquals(seq.myInteger2.getValue(), seq2.myInteger2.getValue());
		Assert.assertEquals(seq.my_choice.getChoiceIndex(), seq2.my_choice.getChoiceIndex());
		Assert.assertEquals(seq.my_choice.my_choice2.myint.getValue(), seq2.my_choice.my_choice2.myint.getValue());

		// Encode the decoded PersonnelRecord again. The resulting byte array
		// must be identical to the first.
		BerByteArrayOutputStream axdrOS2 = new BerByteArrayOutputStream(1000);

		seq2.encode(axdrOS2);
		Assert.assertArrayEquals(axdrOS.getArray(), axdrOS2.getArray());
	}

	public static String getByteArrayString(byte[] byteArray) {
		StringBuilder builder = new StringBuilder();
		int l = 1;
		for (byte b : byteArray) {
			if ((l != 1) && ((l - 1) % 8 == 0)) {
				builder.append(' ');
			}
			if ((l != 1) && ((l - 1) % 16 == 0)) {
				builder.append('\n');
			}
			l++;
			builder.append("0x");
			String hexString = Integer.toHexString(b & 0xff);
			if (hexString.length() == 1) {
				builder.append(0);
			}
			builder.append(hexString + " ");
		}
		return builder.toString();
	}
}