<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mysite.mini_bobjo.Book" %>
<html>
<head>
    <title>책 목록</title>
    
</head>


<link href="${path}/resources/css/index.css" rel="stylesheet"/>
<body>
<h1><a href="/">책 목록</a></h1>

<div class="search-container">
    <form action="/" method="get">
     	<select name="searchoption" class="select-dropdown">
    		<option value="타이틀">타이틀</option>
    		<option value="작가">작가</option>
  		</select>    
        <input type="text" class="search-input" name="keyword" value="${keyword}" placeholder="책 제목 또는 저자 검색..." />
        <button type="submit" class="search-button">검색</button>
    </form>
</div>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>제목</th>
            <th>저자</th>
            <th>출판일</th>
        </tr>
    </thead>
    <tbody>
        <%
            // Model에서 books 리스트를 가져옴
            List<?> books = (List<?>) request.getAttribute("books"); 
            if (books != null) {
                for (Object obj : books) {
                    Book book = (Book) obj;
        %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getYear() %></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="4">책이 없습니다.</td>
            </tr>
        <%
            }
        %>
    </tbody>
</table>
</body>
</html>
