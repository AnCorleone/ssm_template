<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/22
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<a href="${contextPath}">
	<img id="logo" class="logo" src="../../../../../img/site/logo.gif" alt="label">
</a>

<form action="foresearch" method="post">
	<div class="searchDiv">
		<input type="text" id="keyword" placeholder="时尚男鞋 太阳镜 ">
		<button type="submit" class="searchButton">搜索</button>
		<div class="searchBelow">
			<c:forEach items="cs" var="c" varStatus="st">
				<c:if test="${st.count>=5 and st.count<=8}">
						<span>
							<a href="forecateogry?cid=${c.id}">${c.name}</a>
							<c:if test="${st.count!=8}">
								<span>|</span>
							</c:if>
						</span>
				</c:if>
			</c:forEach>
		</div>
	</div>
</form>
