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
package org.cejug.hurraa.action.administracao;

import org.cejug.hurraa.business.InventarioBusiness;
import org.cejug.hurraa.entity.inventario.Fabricante;
import org.cejug.hurraa.entity.inventario.FabricanteTipo;
import org.mentawai.core.BaseAction;
import org.mentawai.rule.RequiredFieldRule;
import org.mentawai.rule.StringRule;
import org.mentawai.validation.Validatable;
import org.mentawai.validation.Validator;

/**
 * Action FabricantesAction.
 *
 * @author helio frota
 *
 */
public class FabricantesAction extends BaseAction implements Validatable {

    /**
     * Classe de negocio injetada pelo mentaContainer.
     */
    private InventarioBusiness inventarioBusiness;

    /**
     * Construtor parametrico usando constructor injection.
     * @param inventarioBusiness InventarioBusiness
     */
    public FabricantesAction(InventarioBusiness inventarioBusiness) {
        this.inventarioBusiness = inventarioBusiness;
    }

    /**
     * Metodo default execute.
     */
    @Override
    public String execute() {
        return SUCCESS;
    }

    /**
     * Retorna lista de fabricantes no formato JSON com determinado limite e offset.
     */
    public void getFabricantes() {
        ajax(inventarioBusiness.getFabricantes(input.getInt("inicio"), input.getInt("limite")));
    }

    public void addFabricante() {
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(input.getString("fabricanteNome"));
        String fabricanteTipo = input.getString("fabricanteTipo");
        if(fabricanteTipo != null && !fabricanteTipo.isEmpty()) {
            fabricante.setTipo(FabricanteTipo.valueOf(fabricanteTipo));
        }
        inventarioBusiness.saveFabricante(fabricante);

        ajax("Fabricante cadastrado com sucesso.");
    }

    @Override
    public void prepareValidator(Validator validator, String innerAction) {
        if (!isEmpty(innerAction)) {
            if (innerAction.equals("addFabricante")) {
                validator.add("fabricanteNome", RequiredFieldRule.getInstance(), "Nome do fabricante obrigatório.");
                validator.add("fabricanteNome", StringRule.getInstance(3, 30), "Nome do fabricante deverá possuir entre 3 e 30 caracteres.");
            } else if (innerAction.equals("updateFabricante")) {
                validator.add("fabricanteNome", RequiredFieldRule.getInstance(), "Nome do fabricante obrigatório.");
                validator.add("fabricanteNome", StringRule.getInstance(3, 30), "Nome do fabricante deverá possuir entre 3 e 30 caracteres.");
            }
        }
    }
}