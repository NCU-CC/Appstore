<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>

		<div class="section section-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1>NCU OAuth</h1>
					</div>
				</div>
			</div>
		</div>
		
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<ol>
							<li>如果你是一般使用者，你可以到<a href="https://api.cc.ncu.edu.tw/manage">OAuth manage</a>，管理該應用程式的使用權限。</li>
							<li>如果你是一個開發者，而且你願意使用我們已經開發好的API，你可以參考我們的<a href="https://github.com/ncu-cc/api-documentation">文件</a>後，再到<a href="https://api.cc.ncu.edu.tw/manage">OAuth manage</a>申請使用。</li>
							<li>如果你是一個開發者，且希望開發一個目前中央大學目前沒有，且具有創意的應用程式，也歡迎你參考<a href="http://ncu-cc.github.io/proposal.html">提案說明</a>。</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		
		<jsp:include page="commonjs.jsp"></jsp:include>
	
	</body>
</html>