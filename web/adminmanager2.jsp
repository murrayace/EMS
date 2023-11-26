<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

  <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <title>人事管理系統</title>
</head>
<body>
 <div class="container-fluid">
   <div class="row">
     <div class="col-sm-10">
       <div class="panel panel-default">
         <div class="panel-heading">搜索</div>
         <div class="panel-body">
           <form role="form" class="form-inline" action="/branchAdmin.action?method=search2" method="post">
             <div class="form-group">
               <label for="name">字段: </label>
               <select name="key" class="form-control">
                 <option value="username">管理員帳號</option>
                 <option value="name">管理員姓名</option>
                 <option value="telephone">管理員電話</option>
               </select>
             </div>
             <div class="form-group" style="margin-left: 20px">
               <label for="value">值: </label>
               <input type="text" class="form-control" name="value" placeholder="字段值" maxlength="12">
             </div>
             <div class="form-group" style="margin-left: 20px">
               <button type="submit" class="btn btn-info">
                 <span style="margin-right: 5px" class="glyphicon glyphicon-search" aria-hidden="true">
                 </span>開始搜索
               </button>
             </div>
           </form>
         </div>
       </div>
       <div class="table-responsive">
         <table class="table table-hover">
           <thead>
           <tr>
             <th>帳號</th>
             <th>姓名</th>
             <th>性別</th>
             <th>聯絡電話</th>
           </tr>
           </thead>
           <tbody>
           <c:forEach items="${list}" var="branchAdmin">
             <tr>
               <td>${branchAdmin.username}</td>
               <td>${branchAdmin.name}</td>
               <td>${branchAdmin.gender}</td>
               <td>${branchAdmin.telephone}</td>
             </tr>
           </c:forEach>
           </tbody>
         </table>

       </div>
     </div>
   </div>
 </div>

 <script>
   function readOnly() {
     $('input[name=id]').attr("readonly","readonly")
   }
 </script>
</body>
</html>