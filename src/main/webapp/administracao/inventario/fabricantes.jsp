<%--
   Hurraa http://code.google.com/p/hurraa/

   This file is part of Hurraa.

   Hurraa is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   Hurraa is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
 
   You should have received a copy of the GNU General Public License
   along with Hurraa.  If not, see <http://www.gnu.org/licenses/>.
--%>

<%@ taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<%@ include file="../../top.jsp"%>

  <%@ include file="../../nav.jsp"%>
  
  </br>
  <div class="container" style="width: 98%;">

    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}">Início</a> <span class="divider">/</span></li>
        <li><a href="Hurraa.administracao.mtw">Administração</a> <span class="divider">/</span></li>
        <li><a href="Hurraa.inventario.mtw">Inventário</a> <span class="divider">/</span></li>
        <li class="active">Fabricantes:</li>
    </ul>

    <a href="#fabricanteModal" id="novoFabricante" role="button" class="btn" data-toggle="modal" style="margin-bottom: 20px;">Novo fabricante</a>

    <div id="fabricanteModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="fabricanteModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="fabricanteModalLabel">Fabricante:</h3>
      </div>
      <div class="modal-body">

      <div id="alertContent"></div>

      <form class="form-horizontal well" id="fabricanteForm">
        <fieldset>
          <div class="control-group">
            <label class="control-label" for="fabricanteNome">Nome:</label>
            <div class="controls">
              <input type="text" name="fabricanteNome" id="fabricanteNome" class="input-xlarge">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Tipo:</label>
            <div class="controls">
              <label class="radio">
			    <input type="radio" name="fabricanteTipo" id="fabricanteTipoHardware" value="HARDWARE" checked>
			    Hardware
			  </label>
			  <label class="radio">
			    <input type="radio" name="fabricanteTipo" id="fabricanteTipoSoftware" value="SOFTWARE">
			    Software
			  </label>
			  <label class="radio">
			    <input type="radio" name="fabricanteTipo" id="fabricanteTipoHardwareSoftware" value="HARDWARE_SOFTWARE">
			    Hardware / Software
			  </label>
            </div>
          </div>

        </fieldset>
      </form>

      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" id="cancelarFabricante" aria-hidden="true">Cancelar</button>
        <button class="btn btn-primary" id="salvarFabricante">Salvar</button>
      </div>
    </div>

    <table id="fabricantesTable" class="table table-condensed table-striped table-hover table-bordered">
    <thead>
       <th>#</th><th>Nome</th><th>Tipo</th><th colspan="2"></th>
    </thead>
    <tbody></tbody>
    </table>

    <a class="btn" id="verMaisFabricantes">Ver mais</a>

  </div>

<%@ include file="../../bottom.jsp"%>

<script src="${pageContext.request.contextPath}/js/inventario.js"></script>

<script>
$(document).ready(function() {
  fabricante.getFabricantes(0, 10);
});
</script>
