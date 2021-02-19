function newGalaxia() {
    if ($("#input-nombre-galaxia").val() !== "" && $("#input-desc-galaxia").val() !== "" && $("#input-url-galaxia").val() !== "") {
        $.ajax({
            url: "./main?action=newGalaxia",
            method: "POST",
            data: {
                nombre: $("#input-nombre-galaxia").val(),
                descripcion: $("#input-desc-galaxia").val(),
                url: $("#input-url-galaxia").val()
            }
        }).done(function () {
            window.location.reload();
        });
    }
}

function add() {
    $("#modal-new-galaxia .modal-footer").html("<button type='button' class='btn btn-success' onclick='newGalaxia()'>Crear</button>");
}

function update(id) {
    $(".modal").modal("show");
    $(".modal-footer").html("<button type='button' class='btn btn-success' onclick='updateGalaxia(" + id + ")'>Guardar</button>");
    $.ajax({
        url: "./main?action=update",
        method: "POST",
        data: {
            id: id
        }
    }).done(function (data) {
        let gx = JSON.parse(data);
        $("#input-nombre-galaxia").val(gx.nombre);
        $("#input-desc-galaxia").val(gx.descripcion);
        $("#input-url-galaxia").val(gx.url);
    });
}

function updateGalaxia(id) {
    if ($("#input-nombre-galaxia") !== "" && $("#input-desc-galaxia") !== "" && $("#input-url-galaxia") !== "") {
        $.ajax({
            url: "./main?action=updateGalaxia",
            method: "POST",
            data: {
                nombre: $("#input-nombre-galaxia").val(),
                descripcion: $("#input-desc-galaxia").val(),
                url: $("#input-url-galaxia").val(),
                id: id
            }
        }).done(function () {
            window.location.reload();
        });
    }
}

function remove(id) {
    $("#remove .modal-footer").html("<button type='button' class='btn btn-danger' onclick='removeGlaxia(" + id + ")' >Si</button>");
}

function removeGlaxia(id) {
    $.ajax({
        url: "./main?action=removeGalaxia",
        method: "POST",
        data: {id: id}
    }).done(function () {
        window.location.reload();
    });
}

$(".modal").on('hidden.bs.modal', function () {
    $("#input-nombre-galaxia").val("");
    $("#input-desc-galaxia").val("");
    $("#input-url-galaxia").val("");
});
