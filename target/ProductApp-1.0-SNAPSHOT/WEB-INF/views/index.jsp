<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--JSTL taglib-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--bootstrap-->
        <%@include file="./base.jsp" %>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-8 offset-md-2">

                    <div class="card">

                        <!--header message-->
                        <div class="card-header text-center text-uppercase">
                            <h2>Welcome to Product App</h2>
                        </div>

                        <!--card body-->
                        <div class="card-body">

                            <div class="table-responsive">

                                <table class="table">
                                    <thead class="thead-dark text-uppercase text-center">

                                        <tr>
                                            <th scope="col">Product id</th>
                                            <th scope="col">product name</th>
                                            <th scope="col">description</th>
                                            <th scope="col">product price</th>
                                            <th scope="col">action</th>
                                        </tr>

                                    </thead>

                                    <tbody>

                                        <c:forEach var="item" items="${list}">

                                            <tr>
                                                <th scope="row" class="text-uppercase">prd${item.id}</th>
                                                <td>${item.productName}</td>
                                                <td>${item.productDescription}</td>
                                                <td class="font-weight-bold">&#8377; ${item.productPrice}</td>
                                                <td class="text-center">

                                                    <!--delete button-->
                                                    <a href="delete/${item.id}" class="fa fa-trash text-danger mr-3 my-auto" style="font-size: 22px; text-decoration: none;"></a>

                                                    <!--edit button-->
                                                    <a href="update/${item.id}" class="fa fa-edit text-primary my-auto" style="font-size: 22px; text-decoration: none;"></a>
                                                </td>
                                            </tr>

                                        </c:forEach>

                                    </tbody>

                                </table>

                            </div>

                        </div>
                        <!--end card body-->

                        <!--add product button-->
                        <div class="card-footer text-center text-uppercase">
                            <a href="add" class="btn btn-warning text-white font-weight-bold">Add Product</a>
                        </div>

                    </div>
                    <!--end card-->

                </div>
            </div>
        </div>
    </body>
</html>
