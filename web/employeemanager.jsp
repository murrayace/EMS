<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>#deleteLabel {text-align: left !important;}</style>

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
      <!--頂部搜索-->
      <div class="panel panel-default">
        <div class="panel-heading">搜索</div>
        <div class="panel-body">
          <form role="form" class="form-inline" action="/employee.action?method=search" method="post">
            <div class="form-group">
              <label for="name">字段: </label>
              <select name="key" class="form-control">
                <option value="groupName">小組</option>
                <option value="number">員工編號</option>
                <option value="name">員工姓名</option>
                <option value="gender">性別</option>
                <option value="state">在職狀態</option>
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
            <div class="form-group" style="margin-left: 48px">
              <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">
                  <span style="margin-right: 5px" class="" aria-hidden="true">
                    <i class="fa fa-user-plus">添加員工資訊</i>
                  </span>
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
            <th>就職日期</th>
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
              <td>${employee.createDate}</td>
              <td>
                <div class="btn-group">
                  <button type="button" class="btn btn-default"
                          data-id="${employee.id}"
                          data-group-id="${employee.groupId}"
                          data-number="${employee.number}"
                          data-name="${employee.name}"
                          data-gender="${employee.gender}"
                          data-create-date="${employee.createDate}"
                          data-toggle="modal"
                          data-target="#updateUserModal">
                    <i class="fa fa-user-o">修改</i>
                  </button>
                  <button type="button" class="btn btn-danger"
                          data-id="${employee.id}"
                          data-group-id="${employee.groupId}"
                          data-name="${employee.name}"
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

        <form method="post" action="/employee.action?method=save" class="form-horizontal" style="margin-top: 0px" role="form"
              id="form_data" style="margin: 20px;">
          <div class="modal fade" id="addUserModal" tabindex="-1"
               role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal"
                          aria-hidden="true">x</button>
                  <h4 class="modal-title" id="myModalLabel">添加員工資訊(請於員工就職當日添加)</h4>
                </div>

                <div class="modal-body">
                  <form class="form-horizontal" role="form">
                    <div class="form-group">
                      <label for="user_id" class="col-sm-3 control-label">小組</label>
                      <div class="col-sm-9">
                        <select class="form-control" name="groupId">
                          <c:forEach items="${groupList}" var="group">
                            <option value="${group.id}">${group.name}</option>
                          </c:forEach>
                        </select>
                      </div>
                    </div>

                    <div class="form-group">
                      <label for="user_id" class="col-sm-3 control-label">員工編號</label>
                      <div class="col-sm-9">
                        <input type="text" class="form-control" id="number"
                               name="number" value="" placeholder="請輸入員工編號">
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
                        &nbsp;&nbsp;&nbsp;<input type="radio" value="女" class="gender"
                                                 name="gender">女
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

        <form method="post" action="/employee.action?method=update" class="form-horizontal" style="margin-top: 0px" role="form"
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
                        <input type="hidden" name="oldGroupId" id="oldGroupId">
                      </div>
                    </div>

                    <div class="form-group">
                      <label for="user_id" class="col-sm-3 control-label">小組</label>
                      <div class="col-sm-9">
                        <select class="form-control" name="groupId">
                          <c:forEach items="${groupList}" var="group">
                            <option class="group" value="${group.id}">${group.name}</option>
                          </c:forEach>
                        </select>
                      </div>
                    </div>

                    <div class="form-group">
                      <label for="user_id" class="col-sm-3 control-label">員工編號</label>
                      <div class="col-sm-9">
                        <input type="text" required class="form-control" id="number"
                               name="number" value="" placeholder="請輸入員工編號">
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
                        &nbsp;&nbsp;&nbsp;<input type="radio" value="女" class="gender"
                               name="gender">女
                      </div>
                    </div>

                    <div class="form-group">
                      <label for="user_id" class="col-sm-3 control-label">就職日期</label>
                      <div class="col-sm-9">
                        <input type="text" readonly class="form-control" id="createDate">
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

        <form method="post" action="/employee.action?method=delete"
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
                             name="id" placeholder="">
                      <input type="hidden" name="groupId" id="groupId">
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
  $('#updateUserModal').on('show.bs.modal',function (event) {
    var button = $(event.relatedTarget)
    var id = button.data('id')
    var groupId = button.data('group-id')
    var number = button.data('number')
    var name = button.data('name')
    var gender = button.data('gender')
    var createDate = button.data('create-date')
    var modal = $(this)

    modal.find('.modal-title').text('修改員工資訊')
    modal.find('#id').val(id)
    modal.find('#number').val(number)
    modal.find('#name').val(name)
    modal.find('#createDate').val(createDate)
    modal.find('#oldGroupId').val(groupId)
    var list = modal.find('.gender')
    for (var i = 0; i < list.length; i++) {
      if (gender == $(list.get(i)).val()){
        $(list.get(i)).prop('checked',true)
      }
    }
    var list2 = modal.find('.gender')
    for (var i = 0; i < list2.length; i++) {
      if (groupId == $(list2.get(i)).val()){
        $(list2.get(i)).prop('selected',true)
      }
    }
  })

  $('#delUserModal').on('show.bs.modal',function(event) {
    var button = $(event.relatedTarget)
    var id = button.data('id')
    var groupId = button.data('group-id')
    var name = button.data('name')
    var modal = $(this)
    modal.find('.modal-title').text('刪除員工資訊')
    modal.find('#deleteLabel').text('是否刪除 ' +'<'+name+'>'+ ' 的資訊?')
    modal.find('#id').val(id)
    modal.find('#groupId').val(groupId)
  })
</script>
</body>
</html>