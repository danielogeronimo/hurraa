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
package org.cejug.hurraa;

import org.cejug.hurraa.AdministracaoManager;
import org.cejug.hurraa.AppManager;
import org.cejug.hurraa.ConfigManager;
import org.junit.Test;

/**
 * Test class ManagersTest.
 *
 * @author helio frota
 *
 */
public class ManagersTest {

	@Test
	public void appManagerTest() {
		new AppManager();
	}
	
	@Test
    public void configManagerTest() {
        ConfigManager configManager = new ConfigManager();
        configManager.init();
        configManager.createJPAHandler();
        configManager.loadFilters();
        configManager.setupIoC();
    }
	
	@Test
	public void administracaoManagerTest() {
		AdministracaoManager manager = new AdministracaoManager();
		manager.loadActions();
	}

}
