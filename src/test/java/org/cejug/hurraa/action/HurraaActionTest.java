/*
 *   Hurraa http://code.google.com/p/hurraa/
 *
 *   This file is part of Hurraa.
 *
 *   Hurraa is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Hurraa is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Hurraa.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.cejug.hurraa.action;

import org.cejug.hurraa.action.HurraaAction;
import org.junit.Before;
import org.junit.Test;
import org.mentawai.util.MockAction;


/**
 * Classe de teste HurraaActionTest.
 *
 * @author helio frota
 *
 */
public class HurraaActionTest {

	private HurraaAction action;
	
	private MockAction mockAction;
	
	@Before
	public void setUp() throws Exception {
		action = new HurraaAction();
		mockAction = new MockAction(action);
		action.setInput(mockAction.getInput());
		action.setOutput(mockAction.getOutput());
	}
	
	@Test
	public void execute() {
		action.execute();
	}
	
}

