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
          <form role="form" class="form-inline" action="/moveout.action?method=search" method="post">
            <div class="form-group">
              <label for="name">字段: </label>
              <select name="key" class="form-control">
                <option value="number">員工編號</option>
                <option value="name">員工姓名</option>
              </select>
            </div>
            <div class="form-group" style="margin-left: 20px">
              <label for="value">值: </label>
              <input type="text" class="form-control" name="value" placeholder="字段值" maxlength="12">
            </div>
            <div class="form-group" style="margin-left: 20px">
              <button type="submit" class="btn btn-info">
                  <span style="margin-right: 5px"
                        class="glyphicon glyphicon-search" aria-hidden="true">
                  </span>開始搜索
              </button>
            </div>
          </form>
        </div>
      </div>
      <!-- 列表展示 -->
      <div class="table-responsive">
        <table class="table table-hover">
          <thead>
          <tr>
            <th>ID</th>
            <th>小組</th>
            <th>員工編號</th>
            <th>姓名</th>
            <th>性別</th>
            <th>在職狀態</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${list}" var="employee">
            <tr>
              <td>${employee.id}</td>
              <td>${employee.groupName}</td>
              <td>${employee.number}</td>
              <td>${employee.name}</td>
              <td>${employee.gender}</td>
              <td>${employee.state}</td>
              <td>
                <div class="btn-group">
                  <button type="button" class="btn btn-danger"
                          data-id="${employee.id}"
                          data-group-id="${employee.groupId}"
                          data-toggle="modal"
                          data-target="#delUserModal">
                    <i class="fa fa-user-times">離退</i>
                  </button>
                </div>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>

        <form method="post" action="/moveout.action?method=moveout"
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
                      <div class="col-sm-9">
                        <h3 class="col-sm-18 control-label" id="deleteLabel">刪除資訊</h3>
                        <input type="hidden" class="form-control" id="tab"
                               name="tab" placeholder="" value="dor_admin">
                        <input type="hidden" class="form-control" id="id"
                               name="employeeId" placeholder="">
                        <input type="hidden" required class="form-control"
                               name="groupId" id="groupId">
                      </div>
                    </div>

                    <div class="form-group">
                      <label for="user_id" class="col-sm-3 control-label">離退原因</label>
                      <div class="col-sm-9">
                        <input type="text" required class="form-control"
                               name="reason">
                      </div>
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                  <button type="submit" class="btn btn-danger">離退</button>
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
  $('#delUserModal').on('show.bs.modal',function(event) {
    var button = $(event.relatedTarget)
    var id = button.data('id')
    var groupId = button.data('group-id')
    var modal = $(this)
    modal.find('.modal-title').text('員工離退資訊(請於員工離退當日登記)')
    modal.find('#deleteLabel').text('離退員工編號ID為 ' + id + ' 的資訊')
    modal.find('#id').val(id)
    modal.find('#groupId').val(groupId)
  })
</script>
</body>
</html>