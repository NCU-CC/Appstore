<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<jsp:include page="header.jsp"></jsp:include>


		<%-- Homepage Slider --%>
		<div class="homepage-slider">
			<div id="sequence">
				<ul class="sequence-canvas">
					<%-- Slide 1 --%>
					<li class="bg4">
						<%-- Slide Title --%>
						<h2 class="title">NCU App Store</h2> <%-- Slide Text --%>
						<h3 class="subtitle">NCU App Store 是相當安全的，我們全程透過 ssl
							加密來傳送屬於您個人資料的部份。您不需要當心您的資料被竊取，若您在使用上屬於您個人資料時感覺有問題，您可以利用這裡的說明來解除該
							App 應用程式的允許權限。</h3> <%-- Slide Image --%> <img class="slide-img"
						src="img/homepage-slider/slide1.png" alt="Slide 1" />
					</li>
					<%-- End Slide 1 --%>
					<%-- Slide 2 --%>
					<li class="bg3">
						<%-- Slide Title --%>
						<h2 class="title">App</h2> <%-- Slide Text --%>
						<h3 class="subtitle">我們的 App 將會提供各式各樣的服務，現階段 NCU App Store
							只提供"學生社團活動"，"課表查詢"，"校園公車"，"宿網流量" 和 "校園地圖導覽"的 App，在將來，我們會提供更多服務。</h3> <%-- Slide Image --%>
						<img class="slide-img" src="img/homepage-slider/slide2.png"
						alt="Slide 2" />
					</li>
					<%-- End Slide 2 --%>
					<%-- Slide 3 --%>
					<li class="bg1">
						<%-- Slide Title --%>
						<h2 class="title">開發的 App</h2> <%-- Slide Text --%>
						<h3 class="subtitle">NCU App Store 是中央大學 App
							的統合網站，希望透過此網站您可以掌握最新的中央大學 App，也希望您有自己開發的 App 時，也可以透過我們幫您傳播出去。</h3> <%-- Slide Image --%>
						<img class="slide-img" src="img/homepage-slider/slide3.png"
						alt="Slide 3" />
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
								<struts:param name="group">TOUR</struts:param>
							</struts:url>
							<span class="glyphicon glyphiconbig glyphicon-user"
								aria-hidden="true"></span>
							<h3>訪客專區</h3>
							<p>這些App能夠使您在中央玩得更盡興</p>
							<a href="<struts:property value="#tourPage" />" class="btn">進入專區</a>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#touristdeclaration">聲明</button>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="service-wrapper">
							<struts:url action="allproduct" var="studentPage">
								<struts:param name="group">STUDENT</struts:param>
							</struts:url>
							<span class="glyphicon glyphiconbig glyphicon-book"
								aria-hidden="true"></span>
							<h3>學生專區</h3>
							<p>專屬於學生的方便服務</p>
							<a href="<struts:property value="#studentPage" />" class="btn">進入專區</a>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#studentdeclaration">聲明</button>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="service-wrapper">
							<struts:url action="allproduct" var="teacherPage">
								<struts:param name="group">TEACHER</struts:param>
							</struts:url>
							<span class="glyphicon glyphiconbig glyphicon-briefcase"
								aria-hidden="true"></span>
							<h3>教職員專區</h3>
							<p>專屬於教職員的方便服務</p>
							<a href="<struts:property value="#teacherPage" />" class="btn">進入專區</a>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#teacherdeclaration">聲明</button>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="service-wrapper">
							<struts:url action="allproduct" var="officialPage">
								<struts:param name="group">OFFICIAL</struts:param>
							</struts:url>
							<span class="glyphicon glyphiconbig glyphicon-home"
								aria-hidden="true"></span>
							<h3>計中官方專區</h3>
							<p>計中官方專區</p>
							<a href="<struts:property value="#officialPage" />" class="btn">進入專區</a>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#officialdeclaration">聲明</button>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="service-wrapper">
							<struts:url action="allproduct" var="nonofficialPage">
								<struts:param name="group">NONOFFICIAL</struts:param>
							</struts:url>
							<span class="glyphicon glyphiconbig glyphicon-globe"
								aria-hidden="true"></span>
							<h3>非計中官方專區</h3>
							<p>非計中官方專區</p>
							<a href="<struts:property value="#nonofficialPage" />" class="btn">進入專區</a>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#unofficialdeclaration">聲明</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%-- End Services --%>	
		
		<!-- Modal -->
		<div class="modal fade" id="touristdeclaration" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<jsp:include page="touristdeclaration.jsp"></jsp:include>
		</div>
		<div class="modal fade" id="studentdeclaration" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<jsp:include page="studentdeclaration.jsp"></jsp:include>
		</div>
		<div class="modal fade" id="teacherdeclaration" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<jsp:include page="teacherdeclaration.jsp"></jsp:include>
		</div>
		<div class="modal fade" id="officialdeclaration" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<jsp:include page="officialdeclaration.jsp"></jsp:include>
		</div>
		<div class="modal fade" id="unofficialdeclaration" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<jsp:include page="unofficialdeclaration.jsp"></jsp:include>
		</div>
		
		
		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		
		<jsp:include page="commonjs.jsp"></jsp:include>
	
	</body>
</html>
