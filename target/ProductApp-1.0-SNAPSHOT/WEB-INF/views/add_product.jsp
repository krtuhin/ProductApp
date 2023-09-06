<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--bootstrap-->
        <%@include file="./base.jsp" %>

    </head>
    <body>
        <div class="container mt-5">

            <div class="row pt-5">

                <div class="col-md-6 offset-md-3">

                    <!--add product form-->
                    <form action="save-product" method="post">

                        <!--product name-->
                        <div class="form-group">
                            <input type="text" name="productName" class="form-control" placeholder="Enter product name">
                        </div>

                        <!--product description-->
                        <div class="form-group">
                            <textarea name="productDescription" class="form-control" placeholder="Enter product description" rows="3"></textarea>
                        </div>

                        <!--product price-->
                        <div class="form-group">
                            <input type="text" name="productPrice" class="form-control" placeholder="Enter product price">
                        </div>

                        <!--buttons-->
                        <div class="text-center">

                            <!--back button-->
                            <a href="${pageContext.request.contextPath}" class="btn btn-danger text-white font-weight-bold">Back</a>

                            <!--save product button-->
                            <button type="submit" class="btn btn-success font-weight-bold">Add Product</button>    
                        </div>

                    </form>
                    <!--end add product form-->

                </div>

            </div>

        </div>
    </body>
</html>
