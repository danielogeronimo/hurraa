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
package org.cejug.hurraa.entity.listeners;

import javax.persistence.PrePersist;

import org.cejug.hurraa.entity.inventario.Fabricante;
import org.cejug.hurraa.persistence.util.SuportePersistencia;

/**
 * Classe listener para modificar estado do objeto de forma não intrusiva.
 * Podemos salvar histórico de alterações, enviar emails, etc a cada modificação
 * na base de dados.
 *
 * @author helio frota
 *
 */
public class FabricanteEntityListener {

	@PrePersist
	void onPrePersist(Fabricante fabricante) {
		fabricante.setId(SuportePersistencia.INSTANCE.gerarIdValido());
	}

}
