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

import org.mentawai.core.MultiApplicationManager;

/**
 * O mentawai fornece suporte a multiplas classes de configuracao permitindo
 * maior separacao dos macro modulos da aplicacao.
 *
 * @author helio frota
 *
 */
public class AppManager extends MultiApplicationManager {
    
    /**
     * Metodo padrao do mentawai para registrar as varias classes centrais de
     * configuracao.
     *
     */
    @Override
    public void registerManagers() {

        // Configuracoes globais.
        register(ConfigManager.class);

        // Macro modulos da aplicacao.
        register(HurraaManager.class);
        register(AdministracaoManager.class);
    }
}