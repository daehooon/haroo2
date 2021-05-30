<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param.broadCategory == '1'}">
	<option value="1">도자기</option>
	<option value="2">가죽</option>
	<option value="3">목공</option>
	<option value="4">플라워</option>
	<option value="5">향수</option>
	<option value="6">뜨개·자수</option>
	<option value="7">캔들·석고방향제</option>
	<option value="8">비누</option>
	<option value="9">라탄·마크라메</option>
	<option value="10">액세서리·비즈</option>
	<option value="11">조명·네온사인</option>
	<option value="12">기타</option>
</c:if>

<c:if test="${param.broadCategory == '2'}">
	<option value="13">방송댄스</option>
	<option value="14">스포츠댄스</option>
	<option value="15">폴댄스</option>
	<option value="16">벨리댄스</option>
	<option value="17">탭댄스</option>
	<option value="18">힙합댄스</option>
	<option value="19">기타</option>
</c:if>

<c:if test="${param.broadCategory == '3'}">
	<option value="20">한식</option>
	<option value="21">일식</option>
	<option value="22">중식</option>
	<option value="23">양식</option>
	<option value="24">베이킹·디저트</option>
	<option value="25">비건·키토</option>
	<option value="26">기타</option>
</c:if>

<c:if test="${param.broadCategory == '4'}">
	<option value="27">맥주</option>
	<option value="28">와인</option>
	<option value="29">칵테일·위스키</option>
	<option value="30">전통주</option>
	<option value="31">커피·차</option>
	<option value="32">기타</option>
</c:if>

<c:if test="${param.broadCategory == '5'}">
	<option value="33">피아노</option>
	<option value="34">기타(악기)</option>
	<option value="35">드럼</option>
	<option value="36">서양악기</option>
	<option value="37">동양악기</option>
	<option value="38">보컬</option>
	<option value="39">연기·공연</option>
	<option value="40">기타</option>
</c:if>

<c:if test="${param.broadCategory == '6'}">
	<option value="41">클라이밍</option>
	<option value="42">구기스포츠</option>
	<option value="43">라켓스포츠</option>
	<option value="44">무도</option>
	<option value="45">요가</option>
	<option value="46">필라테스</option>
	<option value="47">피트니스</option>
	<option value="48">발레</option>
	<option value="49">수영</option>
	<option value="50">등산·트레킹</option>
	<option value="51">러닝·라이딩</option>
	<option value="52">스키·스노우보드</option>
	<option value="53">서핑·SUP</option>
	<option value="54">수상레저</option>
	<option value="55">기타</option>
</c:if>

<c:if test="${param.broadCategory == '7'}">
	<option value="56">사진</option>
	<option value="57">영상</option>
	<option value="58">기타</option>
</c:if>

<c:if test="${param.broadCategory == '8'}">
	<option value="59">동양화</option>
	<option value="60">서양화</option>
	<option value="61">캘리그라피·드로잉</option>
	<option value="62">기타</option>
</c:if>

<c:if test="${param.broadCategory == '9'}">
	<option value="63">헤어·메이크업</option>
	<option value="64">이미지메이킹</option>
	<option value="65">네일·왁싱</option>
	<option value="66">기타</option>
</c:if>