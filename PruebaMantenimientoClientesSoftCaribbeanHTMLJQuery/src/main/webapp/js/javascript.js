var ws="http://localhost:8080/WSCliente/WSCliente"
$(document)
		.ready(
				function() {
					$
							.ajax(
									{
										url : ws+"/getAllClientes",
										type : "GET",
										success : function(data) {
											for (i = 0; i < data.length; i++) {
												$("#table")
														.append(
																"<tr><td>"
																		+ data[i].id
																		+ "</td><td>"
																		+ data[i].codigo
																		+ "</td><td>"
																		+ data[i].nombre
																		+ "</td><td>"
																		+ data[i].direccion
																		+ "</td><td>"
																		+ data[i].email
																		+ "</td><td>"
																		+ data[i].fechaRegistro
																		+ "</td><td>"
																		+ data[i].fechaBaja
																		+ "</td><td>"
																		+ data[i].usuario
																		+ "</td><td>"
																		+ data[i].activo
																		+ "</td><td>"
																		+ data[i].telefono
																		+ "</td><td>"
																		+ data[i].contacto
																		+ "</td><td>"
																		+ data[i].logo
																		+ "</td><td>"
																		+ "</td><td><input type='button' value='Actualizar' onclick='buscar("
																		+ data[i].id
																		+ ")'/>"
																		+ "</td><td><input type='button' value='Eliminar' onclick='eliminar("
																		+ data[i].id
																		+ ")'/></td></tr>");
											}
											;
										},
										error : function(data) {
											alert("Error: No se ha logrado cargar los datos");
											console.log(data);
										},
									});
				});

function buscar(id) {
	$.ajax({
		url : ws+"/getClienteById/" + id,
		type : "GET",
		success : function(data) {
			$("#txtId").val(data.id + "");
			$("#txtCodigo").val(data.codigo + "");
			$("#txtNombre").val(data.nombre + "");
			$("#txtDireccion").val(data.direccion + "");
			$("#txtEmail").val(data.email + "");
			$("#cldFechaRegistro").val(data.fechaRegistro + "");
			$("#cldFechaBaja").val(data.fechaBaja + "");
			$("#txtUsuario").val(data.usuario + "");
			$("#txtActivo").val(data.activo + "");
			$("#txtTelefono").val(data.telefono + "");
			$("#txtContacto").val(data.contacto + "");
			$("#txtLogo").val(data.logo + "");
			;
		},
		error : function(data) {
			alert("Error: No se ha logrado cargar los datos");
			console.log(data);
		},
	})
};

function eliminar(id) {
	$.ajax({
		url : ws+"/deleteCliente/" + id,
		type : "DELETE",
		success : function(data) {
			alert("El cliente se ha eliminado correctamente.");
			location.reload();
			;
		},
		error : function(data) {
			alert("Error: No se ha logrado eliminar el cliente.");
			console.log(data);
		},
	});
};

function guardar() {
	var cliente = {
		"id" : $("#txtId").val(),
		"codigo" : $("#txtCodigo").val(),
		"nombre" : $("#txtNombre").val(),
		"direccion" : $("#txtDireccion").val(),
		"email" : $("#txtEmail").val(),
		"fechaRegistro" : $("#cldFechaRegistro").val(),
		"fechaBaja" : $("#cldFechaBaja").val(),
		"usuario" : $("#txtUsuario").val(),
		"activo" : $("#txtActivo").val(),
		"telefono" : $("#txtTelefono").val(),
		"contacto" : $("#txtContacto").val(),
		"logo" : $("#txtLogo").val()
	};
	var registro = new Date($("#cldFechaRegistro").val());
	var baja = new Date($("#cldFechaBaja").val());
	if (baja > registro) {
		if ($("#txtId").val() == 0) {
			$.ajax({
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				type : "POST",
				data : JSON.stringify(cliente),
				url : ws+"/addCliente",
				success : function(data) {
					alert("El cliente se ha guardado correctamente.");
					location.reload();
					limpiar();
					;
				},
				error : function(data) {
					alert("Error: No se ha logrado guardar el cliente.");
					console.log(data);
				},
			});
		} else {
			if (confirm("¿Desea sobreescribir al cliente N°:"
					+ $("#txtId").val() + "?")) {
				$.ajax({
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					type : "PUT",
					data : JSON.stringify(cliente),
					url : ws+"/updateCliente",
					success : function(data) {
						alert("El cliente se ha cambiado correctamente.");
						location.reload();
						limpiar();
						;
					},
					error : function(data) {
						console.log(data);
					},
				});
			} else {
				limpiar();
			}
		}
	} else {
		alert("La fecha de registro debe ser anterior a la fecha de baja.");
	}
}

function limpiar() {
	$("txtId").val(0), $("txtCodigo").val(""), $("txtNombre").val(""), $(
			"txtDireccion").val(""), $("txtEmail").val(""), $(
			"cldFechaRegistro").val(new Date()), $("cldFechaBaja").val(
			new Date()), $("txtUsuario").val(""), $("txtActivo").val(""), $(
			"txtTelefono").val(""), $("txtContacto").val(""), $("txtLogo").val(
			"")
};