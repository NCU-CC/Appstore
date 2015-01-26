<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>

        <%-- Page Title --%>
        <div class="section section-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>申請上架 - 步驟二</h1>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="section">
            <div class="container">
                <div class="row">
                <div class="col-xs-3 col-sm-3 col-md-3">
                </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <%-- Contact Form --%>
                        <h3>程式簡介圖片</h3>
                        <div class="contact-form-wrapper">
                        
                            
                                 <div class="form-group">
                                    
                                    <struts:form cssClass="form-horizontal" action="uploadtwo!upload" enctype="multipart/form-data" method="post" validate="true">
                                    <div class="col-sm-9">
                                        <struts:actionerror/>								
											<struts:label value="宣傳圖片(330x200)"></struts:label>
											<struts:file name="pictureOne" label="宣傳圖片"></struts:file>
									</div>
										
									<div class="col-sm-9">
									<div class="col-sm-6"> 									
										<struts:label value="程式圖片(330x200)"></struts:label>
                                        <struts:file name="pictureTwo" label="程式圖片"></struts:file>
                                        </div>
									</div>
										
										<struts:submit cssClass="btn pull-right" value="開始上傳" method="upload"></struts:submit>
										<struts:token/>
										</struts:form>
								</div>
						  
                          </div>
                                    
                                </div>
                                
                                <div class="form-group">
                                    
                                </div>
                                
                        </div>
                        <%-- End Contact Info --%>
                    </div>
                </div>

		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		
		<jsp:include page="commonjs.jsp"></jsp:include>
        
    </body>
</html>