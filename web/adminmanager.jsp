<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>#deleteLabel {text-align: left !important;}</style>
  <!-- 引入bootstrap -->
  <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <!-- 引入fontawesome -->
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <title>員工管理系統</title>
</head>
<body>
 <div class="container-fluid">
   <div class="row">
     <div class="col-sm-10">
       <!--頂部搜索-->
       <div class="panel panel-default">
         <div class="panel-heading">搜索</div>
         <div class="panel-body">
           <form role="form" class="form-inline" action="/branchAdmin.action?method=search" method="post">
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
             <!--添加-->
             <div class="form-group" style="margin-left: 48px">
               <button type="button" class="btn btn-default" data-toggle="modal" onclick="read()" data-target="#addUserModal">
                 <span style="margin-right: 5px" class="" aria-hidden="true">
                   <i class="fa fa-user-plus">添加管理員資訊</i>
                 </span>
               </button>
             </div>
           </form>
         </div>
       </div>
       <div class="table-responsive">
         <table class="table table-hover">
           <!--     表頭      -->
           <thead>
           <tr>
             <th>ID</th>
             <th>帳號</th>
             <th>密碼</th>
             <th>姓名</th>
             <th>性別</th>
             <th>聯絡電話</th>
             <th>操作</th>
           </tr>
           </thead>
           <!--     表內容      -->
           <tbody>
           <c:forEach items="${list}" var="branchAdmin">
             <tr>
               <td>${branchAdmin.id}</td>
               <td>${branchAdmin.username}</td>
               <td>${branchAdmin.password}</td>
               <td>${branchAdmin.name}</td>
               <td>${branchAdmin.gender}</td>
               <td>${branchAdmin.telephone}</td>
               <td>
                 <div class="btn-group">
                   <button type="button" class="btn btn-default "
                           data-id="${branchAdmin.id}"
                           data-username="${branchAdmin.username}"
                           data-password="${branchAdmin.password}"
                           data-name="${branchAdmin.name}"
                           data-gender="${branchAdmin.gender}"
                           data-telephone="${branchAdmin.telephone}"
                           data-toggle="modal"
                           data-target="#updateUserModal">
                     <i class="fa fa-user-o">修改</i>
                   </button>
                   <button type="button" class="btn btn-danger"
                           data-id="${branchAdmin.id}"
                           data-name="${branchAdmin.name}"
                           data-toggle="modal"
                           onclick="" data-target="#delUserModal">
                     <i class="fa fa-user-times">刪除</i>
                   </button>
                 </div>
               </td>
             </tr>
           </c:forEach>
           </tbody>
         </table>
         <!--彈出添加對話框-->
         <form method="post" action="/branchAdmin.action?method=save" class="form-horizontal" style="margin-top: 0px" role="form"
               id="form_data" style="margin: 20px;">
           <div class="modal fade" id="addUserModal" tabindex="-1"
                role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
               <div class="modal-content">
                 <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal"
                           aria-hidden="true">x</button>
                   <h4 class="modal-title" id="myModalLabel">添加管理員資訊</h4>
                 </div>
                 <div class="modal-body">
                   <form class="form-horizontal" role="form">
                     <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">帳號</label>
                       <div class="col-sm-9">
                         <input type="text" required class="form-control" id="username"
                                name="username" placeholder="請輸入帳號">
                       </div>
                     </div>
                      <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">密碼</label>
                       <div class="col-sm-9">
                         <input type="text" required class="form-control" id="password"
                                name="password" value="" placeholder="請輸入密碼">
                       </div>
                     </div>
                      <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">姓名</label>
                       <div class="col-sm-9">
                         <input type="text" required class="form-control" id="name"
                                name="name" value="" placeholder="請輸入姓名">
                       </div>
                     </div>
                      <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">性別</label>
                       <div class="col-sm-9">
                         <input type="radio" checked value="男" class="gender"
                                name="gender">男
                         <input type="radio" value="女" class="gender"
                                name="gender">女
                       </div>
                     </div>
                     <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">聯絡電話</label>
                       <div class="col-sm-9">
                         <input type="text" required class="form-control" id="telephone"
                                name="telephone" value="" placeholder="請輸入聯絡電話">
                       </div>
                     </div>
                   </form>
                 </div>
                 <div class="modal-footer">
                   <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                   <button type="submit" class="btn btn-primary">提交</button>
                 </div>
               </div>
             </div>
           </div>
         </form>
         <!--彈出修改對話框-->
         <form method="post" action="/branchAdmin.action?method=update" class="form-horizontal" style="margin-top: 0px" role="form"
               id="form_data" style="margin: 20px;">
           <div class="modal fade" id="updateUserModal" tabindex="-1"
                role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
               <div class="modal-content">
                 <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal"
                           aria-hidden="true">x</button>
                   <h4 class="modal-title" id="myModalLabel">用戶資訊</h4>
                 </div>
                 <div class="modal-body">
                   <form class="form-horizontal" role="form">
                     <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">ID</label>
                       <div class="col-sm-9">
                         <input type="text" readonly required class="form-control" id="id"
                                name="id">
                       </div>
                     </div>
                     <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">姓名</label>
                       <div class="col-sm-9">
                         <input type="text" required class="form-control" id="name"
                                name="name" value="" placeholder="請輸入姓名">
                       </div>
                     </div>

                     <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">帳號</label>
                       <div class="col-sm-9">
                         <input type="text" required class="form-control" id="username"
                                name="username" placeholder="請輸入帳號">
                       </div>
                     </div>
                     <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">密碼</label>
                       <div class="col-sm-9">
                         <input type="text" required class="form-control" id="password"
                                name="password" value="" placeholder="請輸入密碼">
                       </div>
                     </div>

                     <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">性別</label>
                       <div class="col-sm-9">
                         <input type="radio" checked value="男" class="gender"
                                name="gender">男
                         <input type="radio" value="女" class="gender"
                                name="gender">女
                       </div>
                     </div>
                      <div class="form-group">
                       <label for="user_id" class="col-sm-3 control-label">聯絡電話</label>
                       <div class="col-sm-9">
                         <input type="text" required class="form-control" id="telephone"
                                name="telephone" value="" placeholder="">
                       </div>
                     </div>
                   </form>
                 </div>
                 <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                 </div>
               </div>
             </div>
           </div>
         </form>
         <!--彈出刪除對話框-->
         <form method="post" action="/branchAdmin.action?method=delete"
               class="form-horizontal" style="margin-top: 0px" role="form"
               id="form_data" style="margin: 20px">
           <div class="modal fade" id="delUserModal" tabindex="-1"
                role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
               <div class="modal-content">
                 <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal"
                           aria-hidden="true"></button>
                   <h4 class="modal-title" id="myModalLabel">用戶資訊</h4>
                 </div>
                 <div class="modal-body">
                   <form class="form-horizontal" role="form">
                     <div class="form-group">
                       <div class="col-sm-9" style="text-align: left">
                         <h3 class="col-sm-18 control-label" id="deleteLabel">刪除資訊</h3>
                         <input type="hidden" class="form-control" id="tab"
                                name="tab" placeholder="" value="dor_admin">
                         <input type="hidden" class="form-control" id="id"
                               name="id" placeholder="">
                       </div>
                     </div>
                   </form>
                 </div>
                 <div class="modal-footer">
                   <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                   <button type="submit" class="btn btn-danger">刪除</button>
                   <span id="tip"></span>
                 </div>
               </div>
             </div>
           </div>
         </form>
       </div>
     </div>
   </div>
 </div>

 <script>
   $('#updateUserModal').on('show.bs.modal',function(event) {
     var button = $(event.relatedTarget)
     var id = button.data('id')
     var username = button.data('username')
     var password = button.data('password')
     var name = button.data('name')
     var gender = button.data('gender')
     var telephone = button.data('telephone')
     var modal = $(this)

     modal.find('.modal-title').text('修改管理員資訊')
     modal.find('#id').val(id)
     modal.find('#username').val(username)
     modal.find('#password').val(password)
     modal.find('#name').val(name)
     var list = modal.find('.gender')
     for (var i = 0; i < list.length; i++) {
       if (gender == $(list.get(i)).val()){
         $(list.get(i)).prop('checked',true)
       }
     }
     modal.find('#telephone').val(telephone)
   })

   $('#delUserModal').on('show.bs.modal', function(event){
     var button = $(event.relatedTarget)
     var id = button.data('id')
     var name = button.data('name')
     var modal = $(this)
     modal.find('.modal-title').text('刪除管理員資訊')
     modal.find('#deleteLabel').text('是否刪除 ' +'<'+name+'>'+ ' 的管理員資訊?刪除前請確認本管理員已無管理區域，否則這些區域將被系統自動分配給其他管理員')
     modal.find('#id').val(id)
   })
   function readOnly() {
     $('input[name=id]').attr("readonly","readonly")
   }
 </script>
</body>
</html>
