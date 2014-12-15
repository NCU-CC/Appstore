<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>

        <%-- Footer --%>
        <div class="footer">
            <div class="container">
                <div class="row">                    
                    <div class="col-footer col-md-3 col-xs-6">
                        <h3>Navigate</h3>
                        <ul class="no-list-style footer-navigate-section">                            
                            <li><a href="<struts:url action="" />">首頁</a></li>
                            <li><a href="<struts:url action="allproduct" />">總覽所有APP</a></li>
                            <li><a href="<struts:url action="terms" />">服務條款</a></li>
                            <li><a href="<struts:url action="admin" />">管理登入</a></li>
                        </ul>
                    </div>
                    
                    <div class="col-footer col-md-9 col-xs-12">
                        <h3>Contacts</h3>
                        <p class="contact-us-details">
                            <b>校址:</b> (32001)桃園縣中壢市中大路300號<br/>
                            <b>總機電話:</b> 03-4227151<br/>
                            <b>傳真:</b> 03-4226062<br/>
                        </p>
                    </div>                   
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="footer-copyright">&copy; 2014 NCUCC. All rights reserved.</div>
                    </div>
                </div>
            </div>
        </div>