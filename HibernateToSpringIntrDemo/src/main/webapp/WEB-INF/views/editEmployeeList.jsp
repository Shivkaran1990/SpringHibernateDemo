<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
          <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
	
   <body>
    
  <div class="container ">
  <h2>Panels with Contextual Classes</h2>
  <div class="panel-group" style="border: 20px solid #f8f8f8;border-bottom: aliceblue;border-top: aliceblue; border-radius: 11px;box-shadow:3px 3px 8px 0px rgba(50, 50, 50, 1);">
     <div class="panel panel-default" style="border: aliceblue;">
		  <div class="panel-heading">Registration From</div>
		  <div class="panel-body">
					<table class="table">
						<tr>
							<td>Firstname</td>
							<td><input type="text" id="firstName" class="form-control" size="40"/>
						</tr>

						<tr>
							<td>Lastname</td>
							<td><input type="text" id="lastname" class="form-control" size="40"/>
						</tr>

						<tr>
							<td>Mobile Number</td>
							<td><input type="text" id="mnumber" class="form-control" size="40"/>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" id="email" class="form-control" size="40"/>
						</tr>
				 </table>			
		  </div>
      </div>
			 <div class="panel-footer">
			 <button type="button" id ="createUser" class="btn btn-primary">Register User</button>
			</div>
  </div>
</div><br><br>

<div>

<c:if  test="${!empty employeeList}">
    <table class="table table-hover"  style="border-top: aliceblue;border-radius: 3px;box-shadow: 3px 3px 8px 0px rgba(50, 50, 50, 1);width: 1200;margin: auto;">
    <tr style="background: lightgray;">
        <th>Name</th>
        <th>Email</th>
        <th>Telephone</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${employeeList}" var="emp">
        <tr>
            <td>${emp.lastname}, ${emp.firstname} </td>
            <td>${emp.email}</td>
            <td>${emp.telephone}</td>
            <td><a operationid="${emp.id}" onclick="clicked(this)">delete</a>&nbsp;&nbsp&nbsp;<a empobj="${emp}" operationid="${emp.id}" onclick="editClick(this)" >Edit<a/></td>
        </tr>
    </c:forEach>
    </table>
    </c:if>

</div>

	
</body>

<script>


function clicked(element) {     	
    var oprId=$(element).attr("operationid");
    console.log(oprId);
    var id = parseInt(oprId);
    console.log(id);
    $.ajax({  
            type: 'POST',  
            dataType: 'json',  
            url: '/HibernateToSpringIntrDemo/delete/'+oprId,  
            data: {},  
            success: function (Data) {  
            },  
            error: function (XMLHttpRequest, textStatus, errorThrown) {  
   
            }  
        });
		     	
		}
		
function editClick(element) {     	
    var oprId=$(element).attr("operationid");
    var fds=$(element).attr("empobj");
    

    }
	
$(document).ready(function(){
	
  $("#createUser").click(function(){
    	var name=document.getElementById("firstName").value;
    	var email=document.getElementById("email").value;
    	var surname=document.getElementById("lastname").value;
    	var mobileNo=document.getElementById("mnumber").value;
    	var obj = new Object();
    	   obj.firstname = name;
    	   obj.email  = email;
    	   obj.lastname = surname;
    	   obj.telephone =mobileNo;
    	   var jsonString= JSON.stringify(obj);
    	$.ajax({  
            type: 'POST',  
            dataType: 'json',  
            url: '/HibernateToSpringIntrDemo/add',  
            data: {customerInfo:jsonString,employee:obj},  
            success: function (Data) {  
            },  
            error: function (XMLHttpRequest, textStatus, errorThrown) {  
   
            }  
        });

    });
});

</script>

</html>