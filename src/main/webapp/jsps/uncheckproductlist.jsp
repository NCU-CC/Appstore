<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>


<div class="section section-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-10">
                        <h1>申請上架總覽</h1>                        
                    </div>
                    <div class="col-md-2">
                    <button type="button" class="btn btn-primary" onClick="location.href='<struts:url action="uploadone"/>'">申請新APP上架</button>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <struts:if test="productList.size() > 0">
                    
                        <table class="events-list">
                        <struts:set var="productSize" value="productList.size()" />
                        <struts:iterator value="productList" begin="productList.size()-1" end="0" step="-1" id="per" status="status">
                        
                            <tr>
                                <td>
                                    <div class="event-date">
                                        <div class="event-day"><struts:date name="dateCreated" format="dd" /></div>
                                        <div class="event-month"><struts:date name="dateCreated" format="MMM" /></div>
                                    </div>
                                </td>
                                <td class="event-venue hidden-xs"><i class="icon-map-marker"></i> ${chineseName }</td>
                                <td>
                                    ${author.account}
                                </td>
                                
                                <td class="event-price hidden-xs">${state}</td>
                                <td><a href="productcheck?id=${productsId[productSize-status.count]}" class="btn btn-grey btn-sm event-more">Read More</a></td>
                            </tr>
                            </struts:iterator>                            
                        </table>
                        </struts:if>
                        <struts:else>
                            <h4> 目前尚未有申請任何APP上架 </h4>
                        </struts:else>
                    </div>
                </div>
            </div>
        </div>


<jsp:include flush="true" page="footer.jsp"></jsp:include>

<jsp:include page="commonjs.jsp"></jsp:include>
        
    </body>
</html>