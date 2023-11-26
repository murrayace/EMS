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
      <!--頂部搜索-->
      <div class="panel panel-default">
        <div class="panel-heading">搜索</div>
        <div class="panel-body">
          <form role="form" class="form-inline" action="/absent.action?method=search" method="post">
            <div class="form-group">
              <label for="name">字段: </label>
              <select name="key" class="form-control">
                <option value="branchName">分公司</option>
                <option value="groupName">小組</option>
              </select>
            </div>
            <div class="form-group" style="margin-left: 20px">
              <label for="value">值: </label>
              <input type="text" class="form-control" name="value" placeholder="字段值" maxlength="12" style="">
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
            <th>分公司</th>
            <th>小組</th>
            <th>員工</th>
            <th>缺勤原因</th>
            <th>分公司管理員</th>
            <th>日期</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${list}" var="absent">
            <tr>
              <td>${absent.id}</td>
              <td>${absent.branchName}</td>
              <td>${absent.groupName}</td>
              <td>${absent.employeeName}</td>
              <td>${absent.reason}</td>
              <td>${absent.branchAdminName}</td>
              <td>${absent.createDate}</td>
              <td>
                <div class="btn-group">
                  <button type="button" class="btn btn-danger"
                          data-id="${absent.id}"
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
<!--    彈出刪除對話框    -->
        <form method="post" action="/absent.action?method=delete"
              class="form-horizontal" style="margin-top: 0px" role="form"
              id="form_data" style="margin: 20px">
          <div class="modal fade" id="delUserModal" tabindex="-1"
               role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal"
                          aria-hidden="true"></button>
                  <h4 class="modal-title" id="myModalLabel">用戶信息</h4>
                </div>
                <div class="modal-body">
                  <form class="form-horizontal" role="form">
                    <div class="form-group">
                      <div class="col-sm-9">
                        <h3 class="col-sm-18 control-label" id="deleteLabel">刪除信息</h3>
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
  $('#delUserModal').on('show.bs.modal',function(event) {
    var button = $(event.relatedTarget)
    var id = button.data('id')
    var modal = $(this)
    modal.find('.modal-title').text('刪除缺勤資訊')
    modal.find('#deleteLabel').text('是否刪除ID為 ' + id + ' 的缺勤紀錄?')
    modal.find('#id').val(id)
  })
</script>
</body>
</html>