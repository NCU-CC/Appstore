<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>



        <%-- Page Title --%>
        <div class="section section-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1>App列表</h1>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="section">
            <div class="container">
                <div class="row">
                    <struts:if test="productList !=null && productList.size() > 0">
                        <struts:set var="productSize" value="productList.size()" />
                        <struts:iterator value="productList" begin="productList.size()-1" end="0" step="-1" id="per" status="status">
                    
		                    <div class="col-md-4 col-sm-6">
		                        <div class="portfolio-item">
		                            <div class="portfolio-image">
		                                <a href="product?id=${productsId[productSize-status.count]}"><img src="upload/images?fileName=${imagePath}" height="300" alt="Project Name"></a>
		                            </div>
		                            <div class="portfolio-info">
		                                <ul>
		                                    <li class="portfolio-project-name">${chineseName }</li>
		                                    <li>作者: ${authorName }</li>
		                                    <li class="read-more"><a href="product?id=${productsId[productSize-status.count]}" class="btn">Read more</a></li>
		                                </ul>
		                            </div>
		                        </div>
		                    </div>
		                </struts:iterator>    
	                </struts:if>
	                <struts:else>
	                          <h4> 目前尚未有APP上架 </h4>
                            <br>
                            <p> 您可點擊右上角 申請上架您的APP </p>
	                </struts:else>
                </div>
            </div>
        </div>

<jsp:include flush="true" page="footer.jsp"></jsp:include>

<jsp:include page="commonjs.jsp"></jsp:include>

    </body>
</html>