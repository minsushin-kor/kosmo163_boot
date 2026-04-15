<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
</head>
<body id="page-top">

	<!-- Begin Wrapper -->
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>

		 <!-- Begin Content-Wrapper -->
		 <div id="content-wrapper" class="d-flex flex-column">

		 	 <!-- Begin Page Content -->
		 	 <div id="content">
		 	 	<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>

				<!-- Begin Page container-fluid -->
		 	 	<div class="container-fluid">

                    <!-- 수정 부분 -->
                    <h1 class="h3 mb-4 text-gray-800">Detail Page</h1>
                    <div>
                    	<h3>${dto.boardTitle}</h3>
                    	<h3>${dto.boardWriter}</h3>
                    	<div>
                    		${dto.boardContents}
                    	</div>
                    	
                    	<div>
                    		<c:forEach items="${dto.list}" var="f">
                    			<h4><img src="/files/notice/${f.fileName}"> </h4>
                    		</c:forEach>
                    	</div>
                    	
                    </div>
					
					<div>
						<a class="btn btn-primary" href="./reply?boardNum=${dto.boardNum}">답글 작성</a>
						<a class="btn btn-primary" href="./update?boardNum=${dto.boardNum}">내용 수정</a>
						<form action="./delete" method="post">
							<input type="hidden" name="boardNum" value="${dto.boardNum}">
							<button class="btn btn-danger">DELETE</button>
						</form>
					</div>
					
                </div>
                <!-- End Page container-fluid -->
		 	 </div>
		 	 <!-- End Page Content -->
		 	 <c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		 </div>
		 <!-- End Content-Wrapper -->
	</div>
	<!-- End Wrapper -->
	
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
</body>
</html>