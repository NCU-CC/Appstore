<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>


        <%-- Homepage Slider --%>
        <div class="homepage-slider">
        	<div id="sequence">
				<ul class="sequence-canvas">
					<%-- Slide 1 --%>
					<li class="bg4">
						<%-- Slide Title --%>
						<h2 class="title">NCU App Store</h2>
						<%-- Slide Text --%>
						<h3 class="subtitle">NCU App Store 是相當安全的，我們全程透過 ssl 加密來傳送屬於您個人資料的部份。您不需要當心您的資料被竊取，若您在使用上屬於您個人資料時感覺有問題，您可以利用這裡的說明來解除該 App 應用程式的允許權限。</h3>
						<%-- Slide Image --%>
						<img class="slide-img" src="img/homepage-slider/slide1.png" alt="Slide 1" />
					</li>
					<%-- End Slide 1 --%>
					<%-- Slide 2 --%>
					<li class="bg3">
						<%-- Slide Title --%>
						<h2 class="title">App</h2>
						<%-- Slide Text --%>
						<h3 class="subtitle">我們的 App 將會提供各式各樣的服務，現階段 NCU App Store 只提供"學生社團活動"，"課表查詢"，"校園公車"，"宿網流量" 和 "校園地圖導覽"的 App，在將來我們我提供更多服務。</h3>
						<%-- Slide Image --%>
						<img class="slide-img" src="img/homepage-slider/slide2.png" alt="Slide 2" />
					</li>
					<%-- End Slide 2 --%>
					<%-- Slide 3 --%>
					<li class="bg1">
						<%-- Slide Title --%>
						<h2 class="title">開發的 App</h2>
						<%-- Slide Text --%>
						<h3 class="subtitle">NCU App Store 是中央大學 App 的統合網站，希望透過此網站您可以掌握最新的中央大學 App，也希望您有自己開發的 App 時，也可以透過我們幫您傳播出去。</h3>
						<%-- Slide Image --%>
						<img class="slide-img" src="img/homepage-slider/slide3.png" alt="Slide 3" />
					</li>
					<%-- End Slide 3 --%>
				</ul>
				<div class="sequence-pagination-wrapper">
					<ul class="sequence-pagination">
						<li>1</li>
						<li>2</li>
						<li>3</li>
					</ul>
				</div>
			</div>
        </div>
        <%-- End Homepage Slider --%>

		

		<%-- Services --%>
        <div class="section">
	        <div class="container">
	        	<div class="row">
	        		<div class="col-md-4 col-sm-6">
	        			<div class="service-wrapper">
	        			                    <struts:url action="allproduct" var="tourPage">
                                                <struts:param name="group" >TOUR</struts:param>
                                            </struts:url>
		        			<img src="img/service-icon/diamond.png" alt="Service 1">
		        			<h3>遊客專區</h3>
		        			<p>這些App能夠使您在中央玩得更盡興</p>
		        			<a href="<struts:property value="#tourPage" />" class="btn">Read more</a>
		        		</div>
	        		</div>
	        		<div class="col-md-4 col-sm-6">
	        			<div class="service-wrapper">
	        			                    <struts:url action="allproduct" var="studentPage">
                                                <struts:param name="group" >STUDENT</struts:param>
                                            </struts:url>
		        			<img src="img/service-icon/ruler.png" alt="Service 2">
		        			<h3>學生專區</h3>
		        			<p>專屬於學生的方便服務</p>
		        			<a href="<struts:property value="#studentPage" />" class="btn">Read more</a>
		        		</div>
	        		</div>
	        		<div class="col-md-4 col-sm-6">
	        			<div class="service-wrapper">
	        			                    <struts:url action="allproduct" var="parentPage">
                                                <struts:param name="group" >PARENT</struts:param>
                                            </struts:url>
		        			<img src="img/service-icon/box.png" alt="Service 3">
		        			<h3>教職員專區</h3>
		        			<p>方便的App使您得知學子與學校的最新消息</p>
		        			<a href="<struts:property value="#parentPage" />" class="btn">Read more</a>
		        		</div>
	        		</div>
	        		<div class="col-md-4 col-sm-6">
                        <div class="service-wrapper">
                                            <struts:url action="allproduct" var="parentPage">
                                                <struts:param name="group" >PARENT</struts:param>
                                            </struts:url>
                            <img src="img/service-icon/diamond.png" alt="Service 3">
                            <h3>計中官方專區</h3>
                            <p>計中官方專區</p>
                            <a href="<struts:property value="#parentPage" />" class="btn">Read more</a>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="service-wrapper">
                                            <struts:url action="allproduct" var="parentPage">
                                                <struts:param name="group" >PARENT</struts:param>
                                            </struts:url>
                            <img src="img/service-icon/chat.png" alt="Service 3">
                            <h3>非計中官方專區</h3>
                            <p>非計中官方專區</p>
                            <a href="<struts:property value="#parentPage" />" class="btn">Read more</a>
                        </div>
                    </div>
	        	</div>
	        </div>
	    </div>
	    <%-- End Services --%>

		<%-- Call to Action Bar --%>
	    <div class="section section-white">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="calltoaction-wrapper">
							<h3>總攬所有的App</h3> <a href="allproduct" class="btn btn-orange">進入!</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%-- End Call to Action Bar --%>


	  


		<%-- Our Clients 
	    <div class="section">
	    	<div class="container">
	    		<h2>Our Clients</h2>
				<div class="clients-logo-wrapper text-center row">
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/canon.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/cisco.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/dell.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/ea.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/ebay.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/facebook.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/google.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/hp.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/microsoft.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/mysql.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/sony.png" alt="Client Name"></a></div>
					<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="img/logos/yahoo.png" alt="Client Name"></a></div>
				</div>
			</div>
	    </div>
	    --%>
	    <%-- End Our Clients --%>

<jsp:include flush="true" page="footer.jsp"></jsp:include>

        <jsp:include page="commonjs.jsp"></jsp:include>

    </body>
</html>