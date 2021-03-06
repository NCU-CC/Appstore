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
                
                    <struts:if test="productList !=null && productList.size() > 0">
                    <div class="row">
                        <struts:set var="productSize" value="productList.size()" />
                        <struts:iterator value="productList" begin="0" end="productList.size()-1" step="1" id="per" status="status">
                    
		                    <div class="col-md-4 col-sm-6">
		                        <div class="portfolio-item">
		                            <div class="portfolio-image">
		                                <a href="product?id=${productsId[status.count-1]}"><img src="upload/images?fileName=${imagePath}" height="300" alt="Project Name"></a>
		                            </div>
		                            <div class="portfolio-info">
		                                <ul>
		                                    <li class="portfolio-project-name">${chineseName }</li>
		                                    <li>作者: ${authorName }</li>
		                                    <li class="read-more"><a href="product?id=${productsId[status.count-1]}" class="btn">Read more</a></li>
		                                </ul>
		                            </div>
		                        </div>
		                    </div>
		                </struts:iterator>   
		                </div> 
		                <div class="row row-centered">                            
		                  <nav>
							  <ul class="pagination">
							    <struts:if test="pageManager.getPreviousPage() > 0">
								    <struts:url action="allproduct" var="previousP" escapeAmp="false">                                 
	                                    <struts:param name="group">${group}</struts:param>                                    
	                                    <struts:param name="page">${pageManager.getPreviousPage()}</struts:param>
	                                </struts:url>
							    
							    <li>
							      <a href="<struts:property value="#previousP" />" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>	
							    </struts:if>		
							    <struts:if test="pageManager.getNextPage() > 0">
                                <struts:url action="allproduct" var="nextP" escapeAmp="false">
                                        <struts:param name="group">${group}</struts:param>
                                    <struts:param name="page">${pageManager.getNextPage()}</struts:param>
                                </struts:url>				    
							    <li>
							      <a href="<struts:property value="#nextP" />" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							    </li>
							    </struts:if>     
							  </ul>
							</nav>
		                </div>
	                </struts:if>
	                <struts:else>
	                <div class="row">
	                          <h4> 目前尚未有APP上架 </h4>
                            <br>
                            <p> 您可點擊右上角 申請上架您的APP </p>
                            </div>
	                </struts:else>
                
            </div>
        </div>

		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		
		<jsp:include page="commonjs.jsp"></jsp:include>

    </body>
</html>