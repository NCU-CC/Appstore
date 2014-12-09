<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>


        <!-- Homepage Slider -->
        <div class="homepage-slider">
        	<div id="sequence">
				<ul class="sequence-canvas">
					<!-- Slide 1 -->
					<li class="bg4">
						<!-- Slide Title -->
						<h2 class="title">NCU AppStore</h2>
						<!-- Slide Text -->
						<h3 class="subtitle">NCU AppStore是中央大學App的統合網站，透過此網站您可以掌握最新的中央大學App</h3>
						<!-- Slide Image -->
						<img class="slide-img" src="img/homepage-slider/slide1.png" alt="Slide 1" />
					</li>
					<!-- End Slide 1 -->
					<!-- Slide 2 -->
					<li class="bg3">
						<!-- Slide Title -->
						<h2 class="title">App</h2>
						<!-- Slide Text -->
						<h3 class="subtitle">我們的App提供各式各樣的服務，現階段NCUAPP.只提供course和location的APP，在將來我們我提供更多服務</h3>
						<!-- Slide Image -->
						<img class="slide-img" src="img/homepage-slider/slide2.png" alt="Slide 2" />
					</li>
					<!-- End Slide 2 -->
					<!-- Slide 3 -->
					<li class="bg1">
						<!-- Slide Title -->
						<h2 class="title">Security</h2>
						<!-- Slide Text -->
						<h3 class="subtitle">NCUAPP.是相當安全的，我們全程透過ssl加密來傳送資料。不需要當心您的資料被竊取。</h3>
						<!-- Slide Image -->
						<img class="slide-img" src="img/homepage-slider/slide3.png" alt="Slide 3" />
					</li>
					<!-- End Slide 3 -->
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
        <!-- End Homepage Slider -->

		<!-- Press Coverage -->
        <div class="section">
	    	<div class="container">
				<div class="row">
					<div class="col-md-4 col-sm-6">
						<div class="in-press press-wired">
							<a href="#">NCU AppStore是中央大學App的統合網站，透過此網站您可以掌握最新的中央大學App</a>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="in-press press-mashable">
							<a href="#">我們的App提供各式各樣的服務，現階段NCUAPP.只提供course和location的APP，在將來我們我提供更多服務</a>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="in-press press-techcrunch">
							<a href="#">NCUAPP.是相當安全的，我們全程透過ssl加密來傳送資料。不需要當心您的資料被竊取。</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Press Coverage -->

		<!-- Services -->
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
		        			<h3>家長專區</h3>
		        			<p>方便的APP使您得知學子與學校的最新消息</p>
		        			<a href="<struts:property value="#parentPage" />" class="btn">Read more</a>
		        		</div>
	        		</div>
	        	</div>
	        </div>
	    </div>
	    <!-- End Services -->

		<!-- Call to Action Bar -->
	    <div class="section section-white">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="calltoaction-wrapper">
							<h3>總攬所有的APP</h3> <a href="allproduct" class="btn btn-orange">進入!</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Call to Action Bar -->


	  


		<!-- Our Clients 
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
	    -->
	    <!-- End Our Clients -->

<jsp:include flush="true" page="footer.jsp"></jsp:include>

        <!-- Javascripts -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.9.1.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js"></script>
        <script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>
        <script src="js/jquery.fitvids.js"></script>
        <script src="js/jquery.sequence-min.js"></script>
        <script src="js/jquery.bxslider.js"></script>
        <script src="js/main-menu.js"></script>
        <script src="js/template.js"></script>

    </body>
</html>