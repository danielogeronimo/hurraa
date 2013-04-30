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

import org.cejug.hurraa.action.administracao.FabricantesAction;
import org.cejug.hurraa.helper.ViewPath;
import org.mentawai.ajax.renderer.JsonRenderer;
import org.mentawai.ajax.renderer.ResultRenderer;
import org.mentawai.core.ApplicationManager;
import org.mentawai.filter.AjaxFilter;
import org.mentawai.filter.AjaxValidationFilter;

/**
 * Classe de configuracao de actions.
 *
 * @author helio frota
 *
 */
public class AdministracaoManager extends ApplicationManager {
    
    /**
     * Metodo padrao do mentawai para configuracao das actions.
     */
    @Override
    public void loadActions() {

        // Filtros configurados para o modulo de Administracao.
        // Responsaveis pelo suporte ao ajax.
        ResultRenderer result = new ResultRenderer();
        AjaxFilter ajaxFilter = new AjaxFilter();
        AjaxValidationFilter ajaxValidationFilter = new AjaxValidationFilter();

        // Forward para a view.
        action("/Fabricantes", FabricantesAction.class).fwdOk(ViewPath.FABRICANTES);

        // Mapeamentos com tipo de requisicao e retorno ajax.
   
        action("/Fabricantes.getFabricantes", FabricantesAction.class)
                .on(AJAX, ajax(new JsonRenderer())).filter(ajaxFilter);

        action("/Fabricantes.addFabricante", FabricantesAction.class)
                .all(ajax(result)).filterFirst(ajaxValidationFilter);

    }
}
