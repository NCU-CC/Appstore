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
                        <struts:if test="productsList.size() > 0">
                    
                        <table class="events-list">
                        <struts:iterator value="productsList" begin="productsList.size()-1" end="0" step="-1" id="per" status="status">
                        <struts:set var="productK" value=" allProducts[allProducts.size()-1] " />
                            <tr>
                                <td>
                                    <div class="event-date">
                                        <struts:set var="productKD" value="allProducts[allProducts.size()-1].dateCreated " />
                                        <div class="event-day"><struts:date name="productKD" format="dd" /></div>
                                        <div class="event-month"><struts:date name="productKD" format="MMM" /></div>
                                    </div>
                                </td>
                                <td class="event-venue hidden-xs"><i class="icon-map-marker"></i> ${productK.chineseName }</td>
                                <td>
                                    ${productK.introSimple}
                                </td>
                                
                                <td class="event-price hidden-xs">${productK.state}</td>
                                <td><a href="productedit?id=${id}" class="btn btn-grey btn-sm event-more">Read More</a></td>
                            </tr>
                            </struts:iterator>                            
                        </table>
                        </struts:if>
                        <struts:else>
                            <h4> 您目前尚未申請上架任何APP </h4>
                            <br>
                            <p> 您可點擊右上角 申請上架您的APP </p>
                        </struts:else>
                    </div>
                </div>
            </div>
        </div>


		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		
		<jsp:include page="commonjs.jsp"></jsp:include>
        
    </body>
</html>