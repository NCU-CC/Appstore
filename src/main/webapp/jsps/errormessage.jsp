<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>

		<div class="section section-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1>${errorTitle }</h1>
					</div>
				</div>
			</div>
		</div>
		
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">${errorMessage }</div>
				</div>
			</div>
		</div>
		
		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		
		<jsp:include page="commonjs.jsp"></jsp:include>
		
	</body>
</html>