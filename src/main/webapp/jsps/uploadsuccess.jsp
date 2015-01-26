<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>

       <div class="section section-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1>申請上架 - 完成</h1>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="error-page-wrapper">
                            <p>恭喜你。您的申請已經完成，約一周內會完成審核</p>
                            <p>查詢 <a href="<struts:url action="personalpage"/>">審核狀態</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		
		<jsp:include page="commonjs.jsp"></jsp:include>
    </body>
</html>