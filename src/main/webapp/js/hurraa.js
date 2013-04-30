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

function handleResponse(r) {
	var hasError = false;
	if (r.indexOf('{') > -1) {
		var arrayField = r.substring(1, r.length - 1).split(',');
		var i = 0;
		var f = null;
		var msgs = '';
		var content = '';
		content += '<div class="alert alert-error">';
		content += '<a class="close" data-dismiss="alert">×</a>';
		content += '<strong>Atenção:</strong><br>';
		for (i = 0; i < arrayField.length; i++) {
			f = arrayField[i];
			f = f.substring(f.indexOf('=') + 1);
			f = $.trim(f);
			msgs += f + '<br>';
			hasError = true;
		}
		content += msgs;
		content += '</div>';
		document.getElementById('alertContent').innerHTML = content;
	} else {
		if (r !== 'NO_FEEDBACK') {
			console.log(r);
		}
		hasError = false;
	}
	
	return hasError;
}
