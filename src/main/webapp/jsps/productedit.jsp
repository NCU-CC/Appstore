<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            
                <struts:if test="product.state == 'CHECKED' ">
                    <div class="alert alert-success" role="alert">此APP狀態為: ${product.state }  </div>
                </struts:if>
                <struts:elseif test="product.state == 'CHECKING'">
                    <div class="alert alert-info" role="alert">此APP狀態為: ${product.state }</div>
                </struts:elseif>
                <struts:elseif test="product.state == 'UNCHECKED'">
                    <div class="alert alert-warning" role="alert">此APP狀態為: ${product.state }</div>
                </struts:elseif>
                <struts:elseif test="product.state == 'FAIL'">
                    <div class="alert alert-danger" role="alert">此APP狀態為: ${product.state }</div>
                </struts:elseif>
                
                <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary ">
                      <div class="panel-heading">
                        <h3 class="panel-title">狀態更變</h3>
                      </div>
                      <div class="panel-body">
                             
                             <a href="<struts:url action="updateproductone">
                                 <struts:param name="id" >${id }</struts:param>
                                 <struts:param name="struts.token.name" value="%{'token'}"/>
                                 <struts:param name="token" value="%{token}"/>
                             </struts:url>" class="btn">提交新版本</a>
                             
                             <a href="<struts:url namespace="/" action='productdelete' ><struts:param name="id" >${id }</struts:param><struts:param name="struts.token.name" value="%{'token'}"/><struts:param name="token" value="%{token}"/></struts:url>" data-confirm="是否要刪除該APP？ 刪除APP將無法回復" data-method="post"  class="btn btn-danger">刪除APP</a>
                             
                      </div>
                    </div>
                    </div>
                        </div>
                
            
                <div class="row">
                    <%-- Product Image & Available Colors --%>
                    <div class="col-sm-6">
                        <div class="product-image-large">
                            <img src="upload/images?fileName=${product.imagePath}" alt="Item Name">
                        </div>
                        <div class="colors">
                            <p>宣傳照片</p>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="product-image-large">
                            <img src="upload/images?fileName=${product.image2Path}" alt="Item Name">
                        </div>
                        <div class="colors">
                            <p>程式照片(內頁)</p>
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
                                        <struts:iterator value="product.category">
                                            <struts:property/> 
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
                                <td><b>更新日期:</b></td>
                                <td>
                                    <struts:set var="productKD" value="product.dateCreated " />
                                       <struts:date name="productKD" format="yyyy-MMM-dd" />
                                </td>
                            </tr>
                            <%-- Add to Cart Button --%>
                            <tr>
                                <td>&nbsp;</td>
                                <td>
                                    <struts:if test="product.sourceCodePath !=null && product.sourceCodePath != ''">
                                        <a href="upload/code?fileName=${product.sourceCodePath}" target="_blank" class="btn btn"><i class="icon-shopping-cart icon-white"></i>原始碼</a>
                                    </struts:if>
                                    <struts:if test="product.filePath !=null && product.filePath != ''">
                                        <a href="upload/code?fileName=${product.filePath}" target="_blank" class="btn btn"><i class="icon-shopping-cart icon-white"></i>直接下載</a>
                                    </struts:if>
                                    <struts:if test="product.googlePlay !=null && product.googlePlay != ''">
                                         <a href="${product.googlePlay}" target="_blank" class="btn btn"><i class="icon-shopping-cart icon-white"></i>Google Play</a>
                                     </struts:if>
                                     <struts:if test="product.appleStore !=null && product.appleStore != ''">
                                         <a href="${product.appleStore}" target="_blank" class="btn btn"><i class="icon-shopping-cart icon-white"></i>Apple Store</a>
                                     </struts:if>
                                     
                                </td>
                            </tr>
                        </table>
                    </div>
                    <%-- End Product Summary & Options --%>
                    <div class="col-sm-6 product-details">
                    <h4>作者</h4>
                        <p>聯絡資料</p>
                        <table class="shop-item-selections">
                            <tr>
                                <td><b>作者姓名:</b></td>
                                <td>
                                   ${product.authorName}
                                </td>
                            </tr>
                            <tr>
                                <td><b>作者電話:</b></td>
                                <td>
                                   ${product.authorPhone}
                                </td>
                            </tr>
                            <tr>
                                <td><b>作者信箱:</b></td>
                                <td>
                                   ${product.authorEmail}
                                </td>
                            </tr>
                        </table>
                    </div>
                    
                    <%-- Full Description & Specification --%>
                    <div class="col-sm-12">
                        <div class="tabbable">
                            <%-- Tabs --%>
                            <ul class="nav nav-tabs product-details-nav">
                                <li class="active"><a href="#tab1" data-toggle="tab">Description</a></li>
                                <%--<li><a href="#tab2" data-toggle="tab">Specification</a></li> --%>
                            </ul>
                            <%-- Tab Content (Full Description) --%>
                            <div class="tab-content product-detail-info">
                                <div class="tab-pane active" id="tab1">
                                    <h4>Product Description</h4>
                                    <p>${product.introduction}</p>
                                </div>
                                <%-- Tab Content (Specification) 
                                <div class="tab-pane" id="tab2">
                                    <table>
                                        <tr>
                                            <td>Total sensor Pixels (megapixels)</td>
                                            <td>Approx. 16.7</td>
                                        </tr>
                                        <tr>
                                            <td>Effective Pixels (megapixels)</td>
                                            <td>Approx. 16.1</td>
                                        </tr>
                                        <tr>
                                            <td>Automatic White Balance</td>
                                            <td>YES</td>
                                        </tr>
                                        <tr>
                                            <td>White balance: preset selection</td>
                                            <td>Daylight, Shade, Cloudy, Incandescent, Fluorescent, Flash</td>
                                        </tr>
                                        <tr>
                                            <td>White balance: custom setting</td>
                                            <td>YES</td>
                                        </tr>
                                        <tr>
                                            <td>White balance: types of color temperature</td>
                                            <td>YES (G7 to M7,15-step) (A7 to B7,15-step)</td>
                                        </tr>
                                        <tr>
                                            <td>White balance bracketing</td>
                                            <td>NO</td>
                                        </tr>
                                        <tr>
                                            <td>ISO Sensitivity Setting</td>
                                            <td>ISO100 - 25600 equivalent</td>
                                        </tr>
                                    </table>
                                </div>
                                --%>
                            </div>
                        </div>
                    </div>
                    <%-- End Full Description & Specification --%>
                </div>
            </div>
        </div>

<jsp:include flush="true" page="footer.jsp"></jsp:include>

<jsp:include page="commonjs.jsp"></jsp:include>
<script src="<c:url value='/js/rails.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/js/data-confirm-modal.js'/>" type="text/javascript"></script>     

    </body>
</html>