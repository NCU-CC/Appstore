<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="section section-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1>管理員登入</h1>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                    
                    <div class="col-sm-3"> </div>
                        <div class="col-sm-5">
                        <div class="basic-login">
                            <struts:form action="admin!login" theme="simple"  method="post" >
                                <div class="form-group">
                                    <label for="login-username"><i class="icon-user"></i> <b>Username</b></label>
                                    <input class="form-control" name="userName" type="text" placeholder="">
                                </div>
                                <div class="form-group">
                                    <label for="login-password"><i class="icon-lock"></i> <b>Password</b></label>
                                    <input class="form-control" name="userPassword" type="password" placeholder="">
                                </div>
                                <div class="form-group">                                    
                                    <button type="submit" class="btn pull-right">Login</button>
                                    <div class="clearfix"></div>
                                </div>
                            </struts:form>
                        </div>
                        </div>
                        
                        
                    </div>
                </div>
            </div>
        </div>

<jsp:include flush="true" page="footer.jsp"></jsp:include>

<jsp:include page="commonjs.jsp"></jsp:include>
        
    </body>
</html>