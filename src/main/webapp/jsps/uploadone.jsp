<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>

        <%-- Page Title --%>
        <div class="section section-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>申請上架 - 步驟一</h1>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="section">
            <div class="container">
                <struts:if test="errorState">
                    <div class="alert alert-danger" role="alert"><struts:property value="errorMessage" /></div>
                </struts:if>
                
                <div class="row">
                <div class="col-xs-3 col-sm-3 col-md-3">
                </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <%-- Contact Form --%>
                        <h3>Application資訊</h3>
                        <div class="contact-form-wrapper">
                        <struts:form cssClass="form-horizontal" role="form" action="uploadone!upload" method="post">                            
                                 <div class="form-group">
                                    <label for="Name" class="col-sm-3 control-label"><b>APP名稱</b></label>
                                    <div class="col-sm-9">
                                        
                                        <input class="form-control" name="AppName" type="text" placeholder="限30字以內" value="${appName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="contact-email" class="col-sm-3 control-label"><b>APP簡介</b></label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="simpleIntro" type="text" placeholder="限50字以內" value="${simpleIntro}">
                                    </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label for="contact-email" class="col-sm-3 control-label"><b>鎖定族群</b></label>
                                    <div class="col-sm-3">
                                        <label class="checkbox inline">
										  <input type="checkbox" name="tour" value="true"> 遊客
										</label>
									</div>
									<div class="col-sm-3">
										<label class="checkbox inline">
										  <input type="checkbox" name="student" value="true"> 學生
										</label>
									</div>
									<div class="col-sm-3">
										<label class="checkbox inline">
										  <input type="checkbox" name="teacher" value="true"> 教職員
										</label>
                                    </div>
                                </div>
                                
                                
                                
                                 <div class="form-group">
                                    <label for="contact-message" class="col-sm-3 control-label"><b>詳細介紹</b></label>
                                    <div class="col-sm-9">
                                        <textarea class="form-control" rows="5" name="introduction" placeholder="限3000字以內" >${introduction}</textarea>
                                    </div>
                                </div>
                                
                        
                        <h3>作者資訊</h3>
                        
                                 <div class="form-group">
                                    <label for="Name" class="col-sm-3 control-label"><b>姓名</b></label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="AuthorName" type="text" placeholder="" value="${authorName }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="contact-email" class="col-sm-3 control-label"><b>連絡電話</b></label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="AuthorPhone" type="text" placeholder="" value="${authorPhone }">
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label for="contact-message" class="col-sm-3 control-label"><b>EMail</b></label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="AuthorEmail" type="text" placeholder="" value="${authorEmail }">
                                    </div>
                                </div>
                                
                               
                               <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn pull-right">Send</button>
                                    </div>
                                </div>
                                <struts:token/>
                        </struts:form>
                        </div>
                        <%-- End Contact Info --%>
                    </div>
                </div>
            </div>
        </div>

		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		
		<jsp:include page="commonjs.jsp"></jsp:include>
        
    </body>
</html>