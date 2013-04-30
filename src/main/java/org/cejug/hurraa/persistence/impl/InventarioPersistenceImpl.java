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
package org.cejug.hurraa.persistence.impl;

import java.util.List;
import javax.persistence.EntityManager;

import org.cejug.hurraa.entity.inventario.Fabricante;
import org.cejug.hurraa.persistence.InventarioPersistence;
import org.cejug.hurraa.persistence.util.SuportePersistencia;

/**
 * Classe de persistencia InventarioPersistenceImpl.
 * @author helio frota
 *
 */
public class InventarioPersistenceImpl implements InventarioPersistence {

	/**
	 * EntityManager injetado pelo mentaContainer.
	 */
	private EntityManager entityManager;

	/**
	 * Construtor parametrico.
	 *
	 * @param entityManager EntityManager
	 */
	public InventarioPersistenceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Busca fabricantes na base de dados com determinado limite e offset.
	 * @param inicio int
	 * @param limite int
	 * @return List < Fabricante >
	 */
        @Override
	public List < Fabricante > getFabricantes(int inicio, int limite) {
		String query = "select f from Fabricante f order by f.nome asc";
		return entityManager.createQuery(query, Fabricante.class)
				.setFirstResult(inicio)
				.setMaxResults(limite)
				.getResultList();
	}

    @Override
    public void saveFabricante(Fabricante fabricante) {
        entityManager.getTransaction().begin();
        if (SuportePersistencia.INSTANCE.isIdNotValid(fabricante)) {
            entityManager.persist(fabricante);
        } else {
            entityManager.merge(fabricante);
        }
        entityManager.getTransaction().commit();
    }
}
