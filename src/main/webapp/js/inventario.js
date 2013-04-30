/*
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
 
*/


/*
 * Responsavel por funcionalidade de fabricantes.
 */
var fabricante = (function () {

  $('#verMaisFabricantes').click(function() {
    fabricante.getLastItemId();
  });

  $('#novoFabricante').click(function() {
    $('#fabricanteForm')[0].reset();
    $('#alertContent').empty();
  });

  $('#salvarFabricante').click(function() {
    fabricante.addFabricante();
  });

  /* API publica */
  return {

	paginationId: 0,
	  
    getFabricantes: function(inicio, limite) {
      $('#fabricantesTable').hide();
      $.getJSON('Fabricantes.getFabricantes.mtw?inicio=' + inicio + '&limite=' + limite, function(json) {
        if (json !== '') { $('#fabricantesTable table tbody').empty(); }
        var result = '';
          $.each(json, function(key, val) {
            result += '<tr>';
            result += '<td>' + val.id + '<input type="hidden" class="paginationId" value="' + fabricante.paginationId + '" /></td>';
            result += '<td>' + val.nome + '</td>';
            result += '<td>' + val.tipoLiteral + '</td>';
            result += '<td style="width:20px;cursor:pointer;" onclick="fabricante.prepareUpdateFabricante('+ val.id + ')"><i class="icon-pencil"></i></td>';
            result += '<td style="width:20px;cursor:pointer;" onclick="fabricante.confirmDeleteFabricante('+ val.id + ')"><i class="icon-trash"></i></td>';
            result += '</tr>';
            fabricante.paginationId++;
            });
          $('#fabricantesTable > tbody:last').append(result);
        });
      $('#fabricantesTable').show();
    },

    getLastItemId: function () {
        this.getFabricantes(fabricante.paginationId, 10);
    },

    addFabricante: function () {
      $.ajax({ type: 'POST', url: 'Fabricantes.addFabricante.mtw', data: $('#fabricanteForm').serialize(),
          success: function(r) {
            var hasError = handleResponse(r);
            if (!hasError) {
                fabricante.getLastItemId();
                $('#fabricanteModal').modal('hide');
            }
          }
       });
    }

  };
}());
