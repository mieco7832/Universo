<%-- 
    Document   : galaxia
    Created on : 18 feb. 2021, 00:17:17
    Author     : Echo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${nombre_galaxia}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <style>
            .col-md-4{
                margin-top: 15px;
            }
        </style>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="./main?action=universo">¿Big Bang?</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col">
                    <h3>Estas en ${nombre_galaxia}</h3>
                </div>
            </div>
            <br>

            <div class="row">
                <c:forEach items="${list}" var="l">
                    <c:choose>
                        <c:when test="${l.id_planeta != null}">
                            <div class="col-md-4">
                                <div class="card shadow-sm hoverable" style="width: 15rem;">
                                    <img src="${l.url}" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col"></div>
                                            <div class="col">  
                                                <div class="dropdown">
                                                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M10 13a1 1 0 100-2 1 1 0 000 2zm-4 0a1 1 0 100-2 1 1 0 000 2zm1-5a1 1 0 11-2 0 1 1 0 012 0zm3 1a1 1 0 100-2 1 1 0 000 2zm1-5a1 1 0 11-2 0 1 1 0 012 0zM6 5a1 1 0 100-2 1 1 0 000 2z"></path></svg>
                                                    </button>
                                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                                        <li><button type="button" class="dropdown-item" onclick="update(${l.id_planeta})">Actualizar</button></li>
                                                        <li><button type="button" class="dropdown-item" data-bs-toggle="modal" data-bs-target="#remove" onclick="remove(${l.id_planeta})">Eliminar</button></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <h5 class="card-title">${l.nombre_planeta}</h5>
                                        <p class="card-text">Masa: ${l.masa}</p>
                                        <p class="card-text">Número: ${l.numero}</p>
                                        <p class="card-text">Descripción: ${l.descripcion}</p>
                                    </div>
                                </div>
                            </div>   
                        </c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose> 
                </c:forEach>

                <div class="col-md-4">
                    <div class="card shadow-sm hoverable" style="width: 15rem;">
                        <img src="resources/img/polvo-cosmico.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Nuevo Planeta</h5>
                            <p class="card-text">Crea un Planeta con atributos y descripción.</p>
                            <button type="button" class="btn btn-primary"  data-bs-toggle="modal" data-bs-target="#modal-new-planeta" onclick="add()">Agregar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="modal-new-planeta" tabindex="-1" role="dialog" aria-labelledby="modal-new-galaxia" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Nuevo Planeta</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" value="${id}" id="hidden-id-galaxia">
                        <input type="text" maxlength="120" class="form-control" id="input-nombre-planeta" placeholder="Nomre del Planeta"><br>
                        <div class="input-group">
                            <input type="text" maxlength="50" class="form-control" id="input-masa-planeta" placeholder="Masa">
                            <input type="number" min="1" max="99" class="form-control" id="input-numero-planeta" placeholder="Número">
                        </div><br>
                        <input type="text" maxlength="300" class="form-control" id="input-descripcion-planeta" placeholder="Descripción"><br>
                        <input type="text" maxlength="400" class="form-control" id="input-url-planeta" placeholder="Url de la imagen">
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="remove" tabindex="-1" aria-labelledby="removeLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="removeLabel">Eliminar</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        ¿De verdad quieres eliminar este Planeta?
                    </div>
                    <div class="modal-footer">

                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
        <script src="resources/js/function.js" type="text/javascript"></script>
        <script src="resources/js/functions_planeta.js" type="text/javascript"></script>
    </body>
</html>
