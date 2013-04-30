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

import org.cejug.hurraa.action.HurraaAction;
import org.cejug.hurraa.action.LoginAction;
import org.cejug.hurraa.helper.ViewPath;
import org.mentawai.action.LogoutAction;
import org.mentawai.core.ApplicationManager;

/**
 * Classe de configuracao de actions.
 *
 * @author helio frota
 *
 */
public class HurraaManager extends ApplicationManager {
    
    /**
     * Metodo padrao do mentawai para configuracao das actions.
     */
    @Override
    public void loadActions() {

        // Mapeamentos gerais de forward e/ou redirect sem ajax.
        action("/Login", LoginAction.class)
                .on(SUCCESS, redir(ViewPath.MAIN))
                .on(ERROR, fwd(ViewPath.LOGIN));

        action("/Logout", LogoutAction.class)
                .on(SUCCESS, redir(ViewPath.INDEX));

        // Navegacao simples com forward.
        action("/Hurraa", HurraaAction.class).fwdOk(ViewPath.MAIN);
        action("/Hurraa.administracao", HurraaAction.class).fwdOk(ViewPath.ADMINISTRACAO);
        action("/Hurraa.inventario", HurraaAction.class).fwdOk(ViewPath.INVENTARIO);

    }
}
