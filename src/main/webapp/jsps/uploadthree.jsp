<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>

        <%-- Page Title --%>
        <div class="section section-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>申請上架 - 步驟三</h1>
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
                        <h3>APP File</h3>
                        <struts:form cssClass="form-horizontal" action="uploadthree!upload" theme="simple" enctype="multipart/form-data" method="post" validate="true">
                             <struts:actionerror/>
                        <div class="contact-form-wrapper">
                            <div class="form-group">
                                    <label for="Name" class="col-sm-3 control-label"><b>可執行黨(.apk)</b></label>
                                        <struts:label value="上傳檔案"></struts:label>
                                        <struts:file name="apk" label="可執行黨(.apk)"></struts:file> 
                                        </div>
                               <div class="form-group">
                                      <label for="contact-email" class="col-sm-3 control-label"><b>原始碼</b></label>
                                        <struts:label value="上傳檔案"></struts:label>
                                        <struts:file name="sourceCode" label="原始碼"></struts:file>       
                                        </div> 
                                
                        <h3>其他APPSTORE連結</h3>
                        
                                <div class="form-group">
                                    <label for="Name" class="col-sm-3 control-label"><b>Google Play</b></label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="googlePlay" type="text" placeholder="">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="contact-email" class="col-sm-3 control-label"><b>Apple Store</b></label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="appleStore" type="text" placeholder="">
                                    </div>
                                </div>
                                
                                
                                 <div class="form-group">
                                    <label for="contact-email" class="col-sm-3 control-label"><b>服務條款</b></label>
                                    <div class="col-sm-6">
                                        <label class="checkbox inline">
                                          <input type="checkbox" name="terms" value="true"> 已詳讀並同意<a href="<struts:url action="terms"/>" target="_blank">使用條款</a>
                                        </label>
                                    </div>                                    
                                </div>
                                
                               <div class="form-group">
                                    <div class="col-sm-12">
                                    <struts:submit cssClass="btn pull-right" value="送出" method="upload"></struts:submit>
                                    </div>
                               </div>
                               
                        </div>
                        <struts:token/>
                        </struts:form>
                        <%-- End Contact Info --%>
                    </div>
                </div>
            </div>
        </div>

<jsp:include flush="true" page="footer.jsp"></jsp:include>

<jsp:include page="commonjs.jsp"></jsp:include>
    </body>
</html>