<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>

        <%-- Page Title --%>
        <div class="section section-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1>APP Details</h1>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="section">
            <div class="container">
                <div class="row">
                    <%-- Product Image & Available Colors --%>
                    <div class="col-sm-6">
                        <div class="product-image-large">
                            <img src="upload/images?fileName=${product.image2Path}" alt="Item Name">
                        </div>
                        <div class="colors">
                            <span class="color-white"></span>
                            <span class="color-black"></span>
                            <span class="color-blue"></span>
                            <span class="color-orange"></span>
                            <span class="color-green"></span>
                        </div>
                    </div>
                    <%-- End Product Image & Available Colors --%>
                    <%-- Product Summary & Options --%>
                    <div class="col-sm-6 product-details">
                        <h4>${product.chineseName }</h4>
                        <h5>簡介</h5>
                        <p>
                            ${product.introSimple}
                        </p>
                        <table class="shop-item-selections">
                            <%-- Color Selector --%>
                            <tr>
                                <td><b>分類</b></td>
                                <td>
                                        <struts:iterator value="product.category" id="category">
                                            <struts:if test="%{#category == 'OFFICIAL'}">官方</struts:if> 
                                            <struts:elseif test="%{#category == 'NONOFFICIAL'}">非官方</struts:elseif>
                                        </struts:iterator>
                                </td>
                            </tr>
                            <%-- Size Selector --%>
                            <tr>
                                <td><b>使用族群:</b></td>
                                <td>
                                        <struts:iterator value="product.userGroup">
                                            <struts:property/> 
                                        </struts:iterator>
                                </td>
                            </tr>
                            <%-- Quantity --%>
                            <tr>
                                <td><b>作者:</b></td>
                                <td>
                                   ${product.authorName}
                                </td>
                            </tr>
                             <tr>
                                <td><b>更新日期:</b></td>
                                <td>
                                    <struts:set var="productKD" value="product.dateCreated " />
                                       <struts:date name="productKD" format="yyyy-MM-dd" />
                                </td>
                            </tr>
                            <%-- Add to Cart Button --%>
                            <tr>
                                <td>&nbsp;</td>
                                <td>
                                    <struts:if test="product.googlePlay !=null && product.googlePlay != ''">
                                         <a href="${product.googlePlay}" target="_blank" class="btn btn"><i class="icon-shopping-cart icon-white"></i>Google Play</a>
                                     </struts:if>
                                     <struts:else>
                                        <struts:if test="product.filePath !=null && product.filePath != ''">
                                            <a href="upload/code?fileName=${product.filePath}" target="_blank" class="btn btn"><i class="icon-shopping-cart icon-white"></i>直接下載</a>
                                        </struts:if>
                                    </struts:else>
                                     <struts:if test="product.appleStore !=null && product.appleStore != ''">
                                         <a href="${product.appleStore}" target="_blank" class="btn btn"><i class="icon-shopping-cart icon-white"></i>Apple Store</a>
                                     </struts:if>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <%-- End Product Summary & Options --%>
                    
                    <%-- Full Description & Specification --%>
                    <div class="col-sm-12">
                        <div class="tabbable">
                            <%-- Tabs --%>
                            <ul class="nav nav-tabs product-details-nav">
                                <li class="active"><a href="#tab1" data-toggle="tab">Description</a></li>
                            </ul>
                            <%-- Tab Content (Full Description) --%>
                            <div class="tab-content product-detail-info">
                                <div class="tab-pane active" id="tab1">
                                    <h4>Product Description</h4>
                                    <p>${product.introduction}</p>
                                </div>                                
                            </div>
                        </div>
                    </div>
                    <%-- End Full Description & Specification --%>
                </div>
            </div>
        </div>

		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		
		<jsp:include page="commonjs.jsp"></jsp:include>

    </body>
</html>