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

import org.cejug.hurraa.business.UsuarioBusiness;
import org.cejug.hurraa.entity.administracao.Autenticacao;
import org.cejug.hurraa.persistence.UsuarioPersistence;

/**
 * Classe de negocio UsuarioBusinessImpl.
 *
 * @author helio frota
 *
 */
public class UsuarioBusinessImpl implements UsuarioBusiness {

	/**
	 * Classe de persistencia injetada pelo mentaContainer.
	 */
	private UsuarioPersistence usuarioPersistence;

	/**
	 * Construtor parametrico.
	 *
	 * @param usuarioPersistence UsuarioPersistence
	 */
	public UsuarioBusinessImpl(UsuarioPersistence usuarioPersistence) {
		this.usuarioPersistence = usuarioPersistence;
	}

	/**
	 * Autenticacao de email e senha via camada de persistencia.
	 *
	 * @param email String
	 * @param senha String
	 * @return Autenticacao
	 */
	public Autenticacao autenticar(String email, String senha) {
		Autenticacao a = usuarioPersistence.autenticar(email, senha);
		
		if (a != null && a.getSenha().equals(senha)) {
			return a;
		}
		
		return null;
	}

}
