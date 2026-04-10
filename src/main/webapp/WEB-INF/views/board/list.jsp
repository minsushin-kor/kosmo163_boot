<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">공지사항</h1>

					<!-- 테이블 DIV 시작 -->
					<div class="row justify-content-center">
						<div class="col-6">
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th scope="col">글 번호</th>
										<th scope="col">제목</th>
										<th scope="col">작성자</th>
										<th scope="col">작성시간</th>
										<th scope="col">조회수(Hit)</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="d">
										<tr>
											<td>${d.boardNum}</td>
											<td>${d.boardTitle}</td>
											<td>${d.boardWriter}</td>
											<td>${d.boardDate}</td>
											<td>${d.boardHit}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<div>
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<li class="page-item ${pager.pre?'':'disabled'}"><a class="page-link" href="./list?page=${pager.pre?pager.start-1:pager.start}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>

										<!-- step을 비워두면 1씩 증가 -->
										<c:forEach begin="${pager.start}" end="${pager.end}" var="i">
											<li class="page-item"><a class="page-link"
												href="./list?page=${i}">${i}</a></li>
										</c:forEach>
										<li class="page-item ${pager.next?'':'disabled'}"><a class="page-link" href="./list?page=${pager.next?pager.end+1:pager.end}"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</ul>
								</nav>
							</div>

							<div>
								<a href="./create">공지 등록</a>
							</div>

						</div>
					</div>
					<!-- 테이블 DIV 끝 -->

				</div>
				<!-- End Page container-fluid -->
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