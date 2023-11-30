<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <!-- 引入bootstrap -->
  <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <!-- 引入fontawesome -->
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
          <form role="form" class="form-inline" action="/group.action?method=search2" method="post">
            <div class="form-group">
              <label for="name">字段: </label>
              <select name="key" class="form-control">
                <option value="name">小組名稱</option>
                <option value="telephone">小組電話</option>
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
          <!--     表頭      -->
          <thead>
          <tr>
            <th>ID</th>
            <th>分公司</th>
            <th>小組名稱</th>
            <th>最大人數</th>
            <th>可增加人數</th>
            <th>電話</th>
          </tr>
          </thead>
          <!--     表內容      -->
          <tbody>
          <c:forEach items="${list}" var="group">
            <tr>
              <td>${group.id}</td>
              <td>${group.branchName}</td>
              <td>${group.name}</td>
              <td>${group.type}</td>
              <td>${group.available}</td>
              <td>${group.telephone}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>

      </div>
    </div>
  </div>
</div>

</body>
</html>
