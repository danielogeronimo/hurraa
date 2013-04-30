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
package org.cejug.hurraa.helper;

/**
 * Classe utilitária não instanciável para guardar paths das views.
 *
 * @author helio frota
 *
 */
public final class ViewPath {

	/**
	 * Construtor privado.
	 */
	private ViewPath() {

	}

	public static final String INDEX = "/index.jsp";
	public static final String LOGIN = "/login.jsp";
	public static final String MAIN = "/main.jsp";
	public static final String ADMINISTRACAO = "/administracao/administracao.jsp";
	public static final String INVENTARIO = "/administracao/inventario/inventario.jsp";
	public static final String FABRICANTES = "/administracao/inventario/fabricantes.jsp";

}
