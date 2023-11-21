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
  <!--日期插件-->
  <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
  <script src="https://cdn.bootcss.com/moment.js/2.24.0/moment-with-locales.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
  <title>人事管理系統</title>
</head>
<body>
<div class="container-fluid">
  <form method="post" action="/absent.action?method=save" class="form-horizontal" style="margin-top: 0px"
        role="form" id="form_data" style="margin: 20px">
    <div role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">添加缺勤資訊</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" role="form">
              <div class="form-group">
                <label for="user_id" class="col-sm-3 control-label">分公司</label>
                <div class="col-sm-9">
                  <select id="branch" required class="form-control" name="branchId">
                    <c:forEach items="${managedBranches}" var="branch">
                      <option value="${branch.id}">${branch.name}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label for="user_id" class="col-sm-3 control-label">小組</label>
                <div class="col-sm-9">
                  <select id="group" required class="form-control" name="groupId">
                    <c:forEach items="${groupList}" var="group">
                      <option value="${group.id}">${group.name}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label for="user_id" class="col-sm-3 control-label">員工</label>
                <div class="col-sm-9">
                  <select id="employee" required class="form-control" name="employeeId">
                    <c:forEach items="${employeeList}" var="employee">
                      <option value="${employee.id}">${employee.name}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label for="user_id" class="col-sm-3 control-label">原因</label>
                <div class="col-sm-9">
                  <input type="text" required class="form-control" name="reason" placeholder="請輸入缺勤資訊">
                </div>
              </div>

              <div class="form-group">
                <label for="user_id" class="col-sm-3 control-label">日期</label>
                <div class="col-sm-9">
                  <div class='input-group date' id='datetimepicker'>
                    <input type="text" name="date" required class="form-control"/>
                    <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="submit" class="btn btn-primary">提交</button>
          </div>
        </div>
      </div>
    </div>
  </form>
</div>

<script>
  $(function(){
    $('#branch').change(function(){
      var id = $(this).val();
      $.ajax({
        url:"/group.action?method=findByBranchId&branchId="+id,
        type:"post",
        dataType:"json",
        success:function (data) {
          var groupList = $(data).get(0).groupList;
          var employeeList = $(data).get(0).employeeList;
          var str = '';
          for (var i = 0; i < groupList.length; i++) {
            var group = $(groupList).get(i);
            str += '<option value="'+group.id+'">'+group.name+'</option>'
          }
          $('#group').html(str);
          str = '';
          for (var i = 0; i < employeeList.length; i++) {
            var employee = $(employeeList).get(i);
            str += '<option value="'+employee.id+'">'+employee.name+'</option>'
          }
          $('#employee').html(str);
        }
      })
    })

    $('#group').change(function() {
      var id = $(this).val();
      $.ajax({
        url:"/employee.action?method=findByGroupId&groupId="+id,
        type:"post",
        dataType:"json",
        success:function(data){
          var str = '';
          for (var i = 0; i < data.length; i++) {
            var employee = $(data).get(i);
            str += '<option value="'+employee.id+'">'+employee.name+'</option>'
          }
          $('#employee').html(str);
        }
      })
    })

    $('#datetimepicker').datetimepicker({
      format: 'YYYY-MM-DD',
      locale: moment.locale('zh-tw'),
    });
  })
</script>
</body>
</html>