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
package org.cejug.hurraa.business.impl;

import java.util.List;

import org.cejug.hurraa.business.InventarioBusiness;
import org.cejug.hurraa.entity.inventario.Fabricante;
import org.cejug.hurraa.persistence.InventarioPersistence;

/**
 * Classe de negocio InventarioBusinessImpl.
 *
 * @author helio frota
 *
 */
public class InventarioBusinessImpl implements InventarioBusiness {

    /**
     * Classe de persistencia injetada pelo mentaContainer.
     */
    private InventarioPersistence inventarioPersistence;

    /**
     * Construtor parametrico.
     *
     * @param inventarioPersistence InventarioPersistence
     */
    public InventarioBusinessImpl(InventarioPersistence inventarioPersistence) {
        this.inventarioPersistence = inventarioPersistence;
    }

    /**
     * Busca fabricantes via camada de persistencia com determinado limite e
     * offset.
     *
     * @param inicio int
     * @param limite int
     * @return List < Fabricante >
     */
    @Override
    public List< Fabricante> getFabricantes(int inicio, int limite) {
        return inventarioPersistence.getFabricantes(inicio, limite);
    }

    @Override
    public void saveFabricante(Fabricante fabricante) {
        inventarioPersistence.saveFabricante(fabricante);
    }
}