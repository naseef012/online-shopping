/**
 * Created by USER on 9/25/2017.
 */
$(function () {
    //Solving the active menu problem
    switch (menu)
    {
        case 'About Us':
            $("#about").addClass('active');
            break;
        case 'Contact Us':
            $("#contact").addClass('active');
            break;
        case 'All Products':
            $("#listProducts").addClass('active');
            break;
        case 'Manage Products':
            $("#manageProducts").addClass('active');
            break;
        default:
            $("#home").addClass('active');
            $("#a_"+menu).addClass('active');
            break;
    }

    //Code for Jquery DataTable

    var $table = $('#productListTable');
    if ($table.length)
    {
        var jsonUrl = '';
        if (window.categoryId == '')
        {
            jsonUrl = window.contextRoot + "/json/data/all/products";
        }
        else
        {
            jsonUrl = window.contextRoot + "/json/data/category/"+ window.categoryId +"/products";
        }

        //console.log("Inside the table");
        $table.DataTable({
            lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records','10 Records','All']],
            pageLength: 5,
            ajax: {
                url: jsonUrl,
                dataSrc : '' //since no data is appended before the dataset in JSON
            },

            columns:
                [
                    {
                        bSortable : false,
                        data:'code',
                        mRender : function (data,type,row)
                        {
                            return '<a href="'+window.contextRoot+'/show/'+row.id+'/product"><img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/></a>'
                        }

                    },
                    {
                        data:'name'
                    },
                    {
                        data:'brand'
                    },
                    {
                        data:'unitPrice',
                        mRender : function (data,type,row)
                        {
                            return "&#2547; "+data
                        }
                    },
                    {
                        data:'quantity',
                        mRender : function (data , type , row)
                        {
                            if (data < 1)
                            {
                                return '<span style="color:red">Out of Stock!</span>'
                            }
                            else
                            {
                                return data
                            }
                        }
                    },
                    {
                        data:'id',
                        bSortable:false,
                        mRender : function (data,type,row)
                        {
                            var str='';
                            //&#160 is given so that there is a gap in between the icons of View and Add To Cart
                            str+= '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

                            if (row.quantity < 1)
                            {
                                str+= '<a href ="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>'
                            }
                            else
                            {
                                str+= '<a href ="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>'
                            }

                            //str+= '<a href ="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

                            return str;
                        }
                    }
                ]
        });
    }

});

//Dismissing the alert after 3 seconds in manageProducts

var $alert =$('.alert');
if ($alert.length)
{
    setTimeout(function () {
        $alert.fadeOut('slow');
    }, 3000);
}