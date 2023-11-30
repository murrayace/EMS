<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入fontawesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="application/javascript">
      function change(url,index){
        $(".list-group-item").removeClass("active");
        $(".list-group-item").eq(index).addClass("active");
        $("iframe").attr("src",url);
      }
    </script>
  </head>
  <body>
  <nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
      <!--左上-->
      <ul class="nav navbar-nav navbar-left">
        <li>
          <a style="font-size: 26px">EMS員工管理系統-分公司管理員</a>
        </li>
      </ul>
      <span style="color: #cccccc;font-size: 26px;position: relative;top: 5px;"></span>
      <!--右上-->
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a>歡迎您,${branchAdmin.name}</a>
        </li>
        <li>
          <a href="/account?method=logout">安全退出</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="container-fluid">
    <div class="row">
      <!--   左邊功能列   -->
      <div class="col-sm-2">

        <a href="javascript:void(0)" class="list-group-item active" onclick="change('/absent.action?method=init',0)">
          <span class="" aria-hidden="true">
            <i class="fa fa-bookmark fa-fw"></i>
          </span>員工缺勤登記
        </a>
        <a href="javascript:void(0)" class="list-group-item" onclick="change('/absent.action?method=list2',1)">
          <span class="" aria-hidden="true">
            <i class="fa fa-bookmark fa-fw"></i>
          </span>員工缺勤紀錄
        </a>

        <a href="javascript:void(0)" class="list-group-item"
           onclick="change('/branchAdmin.action?method=list2',2)">
          <span class="" aria-hidden="true">
            <i class="fa fa-user-circle-o fa-fw"></i>
          </span>分公司管理員查詢
        </a>

        <a href="javascript:void(0)" class="list-group-item" onclick="change('/branch.action?method=list2',3)">
          <span class="" aria-hidden="true">
            <i class="fa fa-user-circle-o fa-fw"></i>
          </span>分公司查詢
        </a>

        <a href="javascript:void(0)" class="list-group-item" onclick="change('/group.action?method=list2',4)">
          <span class="" aria-hidden="true">
            <i class="fa fa-user-circle-o fa-fw"></i>
          </span>小組查詢
        </a>

        <a href="javascript:void(0)" class="list-group-item" onclick="change('/employee.action?method=list2',5)">
          <span class="" aria-hidden="true">
            <i class="fa fa-user-circle-o fa-fw"></i>
          </span>員工查詢
        </a>
      </div>
      <!--   右邊內容   -->
      <iframe style="width: 81%; height: 600px; border: 0px;" src="/absent.action?method=init"></iframe>
    </div>
  </div>
  <div class="footer">
    <p class="text-center">
      2023@EMS
    </p>
  </div>
  </body>
</html>
