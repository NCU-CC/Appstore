<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp"></jsp:include>

		<div class="section section-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1>Page Not Found...</h1>
					</div>
				</div>
			</div>
		</div>
        
        <div class="section">
	    	<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="error-page-wrapper">
							<p>Sorry, the page you are looking for is not here or never was...</p>
							<p>Why don't you try the <a href="/appstore">Homepage</a>?</p>
						</div>
					</div>
				</div>
			</div>
		</div>

<jsp:include flush="true" page="footer.jsp"></jsp:include>

        <jsp:include page="commonjs.jsp"></jsp:include>

    </body>
</html>