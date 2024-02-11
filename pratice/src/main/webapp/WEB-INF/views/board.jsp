<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="true"%>

<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>pratice</title>
  <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: "Noto Sans KR", sans-serif;
    }
	 
	 .single-line {
        white-space: nowrap;
        display: grid;
        grid-template-columns: auto auto;
    }
    
    .container {
      width : 50%;
      margin : auto;
    }

    .writing-header {
      position: relative;
      margin: 20px 0 0 0;
      padding-bottom: 10px;
      border-bottom: 1px solid #323232;
    }

    input {
      width: 100%;
      height: 35px;
      margin: 5px 0px 10px 0px;
      border: 1px solid #e9e8e8;
      padding: 8px;
      background: #f8f8f8;
      outline-color: #e6e6e6;
    }

    textarea {
      width: 100%;
      background: #f8f8f8;
      margin: 5px 0px 10px 0px;
      border: 1px solid #e9e8e8;
      resize: none;
      padding: 8px;
      outline-color: #e6e6e6;
    }

  table {
    border-collapse: collapse;
    width: 100%;
    border-top: 2px solid rgb(39, 39, 39);
  }

  th, td {
    padding: 10px 12px;
    border-bottom: 1px solid #ddd;
  }

  tr:nth-child(even) {
    background-color: #f0f0f070;
  }

  th {
    text-align: center;
    color: black;
  }

  td {
    text-align: center;
    color: rgb(53, 53, 53);
  }

  td.title, td.writer {
    text-align: left;
  }

  td.viewcnt {
    text-align: right;
  }

  td.title:hover {
    text-decoration: underline;
  }
  tr.single-line {
    white-space: nowrap;
    display: grid;
    grid-template-columns: auto auto;
  }
    
    .frm {
      width:100%;
    }
    .btn {
      background-color: rgb(236, 236, 236); /* Blue background */
      border: none; /* Remove borders */
      color: black; /* White text */
      padding: 6px 12px; /* Some padding */
      font-size: 16px; /* Set a font size */
      cursor: pointer; /* Mouse pointer on hover */
      border-radius: 5px;
    }

    .btn:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<div id="menu">
  <ul>
    <li id="logo">pratice</li>
    <li><a href="<c:url value='/'/>">Home</a></li>
    <li><a href="<c:url value='/board/list'/>">Board</a></li>
    <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
    <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
    <li><a href=""><i class="fa fa-search"></i></a></li>
  </ul>
</div>
<script>
  let msg = "${msg}";
  if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
  if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");
</script>
<div class="container">
  <h2 class="writing-header">게시판 ${boardDto.bno==null? "글쓰기" : "읽기"}</h2>
  <form id="form" class="frm" action="" method="post">
  	<input type="text" name="bno" value="${boardDto.bno}">
    <input type="hidden" name="bno" value="${boardDto.bno}">
	<input type="hidden" name="sts" value="${boardDto.sts}">
	<input name="title" type="text" value="${boardDto.title}" placeholder="  제목을 입력해 주세요." ><br>
    <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요.">${boardDto.content}</textarea><br>

	<button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 새로운 글쓰기</button>
    <c:if test="${boardDto.bno == null}">
      <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
    </c:if>
    <c:if test="${sessionScope.id == boardDto.writer }">
      <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
      <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
    </c:if>

    <c:if test="${boardDto.bno != null}">
    	<button type="button" id="commentNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 새로운 댓글 </button>
        <div id="newCommentSection" style="display: none;">
		    		<textarea name="newComment" rows="1" placeholder="새로운 댓글을 입력하세요."></textarea>
		</div>
        <c:if test="${boardDto.comment != null}">
	        <h4 class="comment_head">게시판 댓글</h4>
	        <table>
		      <tr class="single-line comment-section">
		        <th class="comment_head1">댓글</th>
		        <th class="comment_head2">날짜</th>
		      </tr>
		      <c:forEach var="comment" items="${boardDto.comment}">
				<tr class="single-line" class="comment-section">
		          <td class="comment">${comment.comment}</td>
		          <td class="date">${comment.comment_reg_date}</td>
				</tr>
		      </c:forEach>
	    	</table>
		</c:if>
	</c:if>

  </form>
</div>
<script>
	let errorMessage = "${errorMessage}";
	if(errorMessage) {
	  alert(errorMessage);
	}
  $(document).ready(function(){
	  let form = $("#form");

	if (form.find("comment-section").length === 0) {
		  $(".writing-header").hide();
	      $(".comment-section").hide();  // Hide the existing comment textarea and input
	      $("#newCommentSection").hide(); // Hide the new comment textarea
	    }
	});
  
    let formCheck = function() {
      let form = document.getElementById("form");
      if(form.title.value=="") {
        alert("제목을 입력해 주세요.");
        form.title.focus();
        return false;
      }
      if(form.content.value=="") {
        alert("내용을 입력해 주세요.");
        form.content.focus();
        return false;
      }
      return true;
    }

    $("#writeNewBtn").on("click", function(){
    	location.href="<c:url value='/board/newwrite'/>";
    	
    });

    $("#commentNewBtn").on("click", function(){
    	 $("#newCommentSection").toggle();
    });

    $("#writeBtn").on("click", function(){
      let form = $("#form");
      form.attr("action", "<c:url value='/board/write'/>");
      form.attr("method", "post");
      $("input[name='sts']").val("I");

      if(formCheck())
        form.submit();
    });

    $("#modifyBtn").on("click", function(){
        let form = $("#form");
        form.attr("action", "<c:url value='/board/write'/>");
        form.attr("method", "POST");
        $("input[name='sts']").val("U");
        if(formCheck())
          form.submit();
      });

    $("#removeBtn").on("click", function(){
      if(!confirm("정말로 삭제하시겠습니까?")) return;

      let form = $("#form");
      form.attr("action", "<c:url value='/board/write'/>");
      form.attr("method", "POST");
      $("input[name='sts']").val("D");

      form.submit();
    });

    $("#listBtn").on("click", function(){
      location.href="<c:url value='/board/list?page=${page}&pageSize=${pageSize}'/>";
    });
</script>
</body>
</html>