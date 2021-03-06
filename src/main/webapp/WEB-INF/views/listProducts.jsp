<%--
  Created by IntelliJ IDEA.
  User: Naseef M Abdus Sattar
  Date: 10/1/2017
  Time: 2:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="/onlineshopping"/>
<div class="container">
    <div class="row">

        <!-- Would Display the Sidebar -->
        <div class="col-md-3">
            <%@include file="shared/sidebar.jsp"%>
        </div>

        <!-- Used to display the actual Products -->
        <div class="col-md-9">

            <!-- Added BreadCrumb component-->
            <div class="row">
                <div class="col-lg-12">

                    <!-- Adding whether user clicked All product test using JSTL tag -->
                   <c:if test="${userClickedAllProducts == true}">

                       <script>
                           window.categoryId ='';
                       </script>

                        <ol class="breadcrumb">
                            <li> <a href="${contextRoot}/home">Home</a> </li>
                            <li class="active"> All Products </li>
                        </ol>
                   </c:if>

                    <!-- Adding whether user clicked product by category test using JSTL tag -->
                    <c:if test="${userClickedCategoryProducts == true}">

                        <script>
                            window.categoryId = '${category.id}';
                        </script>

                        <ol class="breadcrumb">
                            <li> <a href="${contextRoot}/home">Home</a> </li>
                            <li class="active">Category</li>
                            <li class="active">${category.name}</li>
                        </ol>
                    </c:if>

                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">

                    <table id="productListTable" class="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th></th>
                                <th>Name</th>
                                <th>Brand</th>
                                <th>Price</th>
                                <th>Quantity Available</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tfoot>
                            <tr>
                                <th></th>
                                <th>Name</th>
                                <th>Brand</th>
                                <th>Price</th>
                                <th>Quantity Available</th>
                                <th></th>
                            </tr>
                        </tfoot>

                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
