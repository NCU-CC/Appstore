<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Appstore for NCU</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="shortcut icon" href="/appstore/favicon.ico" type="image/x-icon" />  
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/icomoon-social.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="css/leaflet.css" />
        <!--[if lte IE 8]>
            <link rel="stylesheet" href="css/leaflet.ie.css" />
        <![endif]-->
        <link rel="stylesheet" href="css/main.css">
        
        <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
        

        <!-- Navigation & Logo-->
        <div class="mainmenu-wrapper">
            <div class="container">
                
                <nav id="mainmenu" class="mainmenu">
                    <ul>
                        <li class="logo-wrapper"><a href="/appstore"><img src="img/mPurpose-logo.png" alt="Multipurpose Twitter Bootstrap Template"></a></li>
                        <li>
                            <a href="/appstore">首頁</a>
                        </li>
                        <li>
                            <a href="<struts:url action="allproduct"/>">總覽APP</a>
                        </li>
                        
                        
                        <struts:if test="#session.personInfo != null && #session.personInfo.type == 'ADMIN'">
                        <li class="has-submenu">
                            <a href="#">管理APP</a>
                            <div class="mainmenu-submenu">
                                <div class="mainmenu-submenu-inner"> 
                                       
                                    <div>
                                        <h4>查看APP申請列表</h4>
                                        <ul>
                                            <struts:url action="checklist" var="uncheckedPage">
                                                <struts:param name="wantState" >UNCHECKED</struts:param>
                                            </struts:url>
                                            <struts:url action="checklist" var="checkingPage">
                                                <struts:param name="wantState" >CHECKING</struts:param>
                                            </struts:url>
                                            <struts:url action="checklist" var="failPage">
                                                <struts:param name="wantState" >FAIL</struts:param>
                                            </struts:url>
                                            <struts:url action="checklist" var="checkedPage">
                                                <struts:param name="wantState" >CHECKED</struts:param>
                                            </struts:url>
                                            <li><a href=" <struts:url action="checklist"/> ">查看所有APP申請</a></li>
                                            <li><a href=" <struts:property value="#uncheckedPage" /> ">查看所有待檢查APP申請</a></li>
                                            <li><a href=" <struts:property value="#checkingPage" /> ">查看所有檢查中APP申請</a></li>
                                            <li><a href=" <struts:property value="#checkedPage" /> ">查看所有檢查成功APP申請</a></li>
                                            <li><a href=" <struts:property value="#failPage" /> ">查看所有檢查失敗APP申請</a></li>
                                        </ul>
                                        
                                    </div>
                                    
                                </div><!-- /mainmenu-submenu-inner -->
                            </div><!-- /mainmenu-submenu -->
                        </li>
                        </struts:if>
                        
                        
                        <li>
                            <a href="<struts:url action="personalpage"/>">申請上架</a>
                        </li>
                        <struts:if test="#session.personInfo != null">
                            <li>
                            <a href="<struts:url action="logout"/>">登出</a>
                            </li>
                        </struts:if>
                    </ul>
                </nav>
            </div>
        </div>