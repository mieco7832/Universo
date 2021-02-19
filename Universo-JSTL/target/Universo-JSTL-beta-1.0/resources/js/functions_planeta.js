function newPlaneta() {
    if ($("#input-nombre-planeta").val() !== "" && $("#input-masa-planeta").val() !== "" && $("#input-numero-planeta").val() > 0 && $("#input-descripcion-planeta").val() !== "" && $("#input-url-planeta").val() !== "") {
        $.ajax({
            url: "./main?action=newPlaneta",
            method: "POST",
            data: {
                nombre: $("#input-nombre-planeta").val(),
                masa: $("#input-masa-planeta").val(),
                numero: $("#input-numero-planeta").val(),
                descripcion: $("#input-descripcion-planeta").val(),
                url: $("#input-url-planeta").val(),
                id: $("#hidden-id-galaxia").val()
            }
        }).done(function (data) {
            if (data !== "[]") {
                window.location.reload();
            }
        });
    }
}

function add() {
    $("#modal-new-planeta .modal-footer").html("<button type='button' class='btn btn-success' onclick='newPlaneta()'>Crear</button>");
}

function update(id) {
    $(".modal").modal("show");
    $(".modal-footer").html("<button type='button' class='btn btn-success' onclick='updatePlaneta(" + id + ")'>Guardar</button>");
    $.ajax({
        url: "./main?action=updateP",
        method: "POST",
        data: {
            id: id
        }
    }).done(function (data) {
        let gx = JSON.parse(data);
        $("#input-nombre-planeta").val(gx.nombre_planeta);
        $("#input-masa-planeta").val(gx.masa);
        $("#input-numero-planeta").val(gx.numero);
        $("#input-descripcion-planeta").val(gx.descripcion);
        $("#input-url-planeta").val(gx.url);
    });
}

function updatePlaneta(id) {
    if ($("#input-nombre-planeta").val() !== "" && $("#input-masa-planeta").val() !== "" && $("#input-numero-planeta").val() > 0 && $("#input-descripcion-planeta").val() !== "" && $("#input-url-planeta").val() !== "") {
        $.ajax({
            url: "./main?action=updatePlaneta",
            method: "POST",
            data: {
                nombre: $("#input-nombre-planeta").val(),
                masa: $("#input-masa-planeta").val(),
                numero: $("#input-numero-planeta").val(),
                descripcion: $("#input-descripcion-planeta").val(),
                url: $("#input-url-planeta").val(),
                id: id,
                galaxia: $("#hidden-id-galaxia").val()
            }
        }).done(function () {
            window.location.reload();
        });
    }
}

function remove(id) {
    $("#remove").modal("show");
    $("#remove .modal-footer").html("<button type='button' class='btn btn-danger' onclick='removePlaneta(" + id + ")' >Si</button>");
}

function removePlaneta(id) {
    $.ajax({
        url: "./main?action=removePlaneta",
        method: "POST",
        data: {id: id}
    }).done(function () {
        window.location.reload();
    });
}

$(".modal").on('hidden.bs.modal', function () {
    $("#input-nombre-planeta").val("");
    $("#input-masa-planeta").val("");
    $("#input-numero-planeta").val("");
    $("#input-descripcion-galaxia").val("");
    $("#input-url-planeta").val("");
});