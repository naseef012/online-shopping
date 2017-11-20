<%--
    Created by IntelliJ IDEA.
  User: Naseef M Abdus Sattar
  Date: 11/19/2017
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

    <div class="row">

        <!--Message Alert check -->
        <c:if test="${not empty message}">
            <div class="col-xs-12">
                <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    ${message}
                </div>
            </div>
        </c:if>

        <div class="col-md-offset-2 col-md-8">
            <div class="panel panel-primary">
                <div class = "panel-heading">
                    <h4>Product Management</h4>
                </div>
                <!--Form Panel-->
                <div class="panel-body">

                    <!--Form Elements-->
                    <sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST">

                        <!--Product Form info-->
                        <div class="form-group">
                            <label class="control-label col-md-4" for="name">Enter Product Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control"/>
                                <sf:errors cssClass="help-block" path="name" element="em"/>
                            </div>
                        </div>

                        <!-- Brand Form Info -->
                        <div class="form-group">
                            <label class="control-label col-md-4" for="brand">Enter Product Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control"/>
                                <sf:errors cssClass="help-block" path="brand" element="em"/>
                            </div>
                        </div>

                        <!-- Product Description -->
                        <div class="form-group">
                            <label class="control-label col-md-4" for="description">Product Description</label>
                            <div class="col-md-8">
                                <sf:textarea path="description" id="description" rows="4" placeholder="Write a description for your product" class="form-control"/>
                                <sf:errors cssClass="help-block" path="description" element="em"/>
                            </div>
                        </div>

                        <!-- Product Unit Price -->
                        <div class="form-group">
                            <label class="control-label col-md-4" for="unitPrice">Enter Product Unit Price</label>
                            <div class="col-md-8">
                                <sf:input type="text" path = "unitPrice" id="unitPrice" placeholder="Unit Price in '&#2547;'" class="form-control"/>
                                <sf:errors cssClass="help-block" path="unitPrice" element="em"/>
                            </div>
                        </div>

                        <!-- Product Quantity -->
                        <div class="form-group">
                            <label class="control-label col-md-4" for="quantity">Enter Quantity Available</label>
                            <div class="col-md-8">
                                <sf:input type="text" path = "quantity" id="quantity" placeholder="Quantity Available" class="form-control"/>
                            </div>
                        </div>

                        <!-- Product Category-->
                        <div class="form-group">
                            <label class="control-label col-md-4" for="categoryId">Enter Product Category</label>
                            <div class="col-md-8">
                                <sf:select path = "categoryId" id="categoryId" class="form-control"
                                   items = "${categories}"
                                    itemLabel = "name"
                                    itemValue = "id"
                                />
                            </div>
                        </div>

                        <!-- Submit Button -->
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" value = "Submit" id="submit"  class="btn btn-primary"/>
                            </div>
                        </div>

                        <!-- Hidden Fields for Products-->
                        <sf:hidden path="id"/>
                        <sf:hidden path="code"/>
                        <sf:hidden path="supplierId"/>
                        <sf:hidden path="purchases"/>
                        <sf:hidden path="views"/>
                        <sf:hidden path="active"/>


                    </sf:form>


                </div>

            </div>

        </div>

    </div>

</div>
