/*
 * Copyright 2012-15 Fraunhofer ISE
 *
 * This file is part of jDLMS.
 * For more information visit http://www.openmuc.org
 *
 * jDLMS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jDLMS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jDLMS.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openmuc.jdlms.interfaceclass.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openmuc.jdlms.interfaceclass.InterfaceClass;
import org.openmuc.jdlms.interfaceclass.attribute.AttributeDirectory.AttributeNotFoundException;

public class AttributeDirectoryTest {

	@Test
	public void testDirectory1() throws Exception {
		InterfaceClass interfaceClass = InterfaceClass.interfaceClassFor(7, 1);
		AttributeClass attributeClass = AttributeDirectory.attributeClassFor(interfaceClass, 2);

		assertEquals(attributeClass.interfaceClass(), InterfaceClass.PROFILE_GENERIC);
		assertEquals(attributeClass.attributeName(), ProfileGenericAttribute.BUFFER.name());
	}

	@Test(expected = AttributeNotFoundException.class)
	public void testDirectory2() throws Exception {
		InterfaceClass interfaceClass = InterfaceClass.interfaceClassFor(200, 0);
		AttributeDirectory.attributeClassFor(interfaceClass, 2);
	}

	@Test(expected = AttributeNotFoundException.class)
	public void testDirectory3() throws Exception {
		InterfaceClass interfaceClass = InterfaceClass.interfaceClassFor(15, 1);
		AttributeDirectory.attributeClassFor(interfaceClass, 99);
	}
}
