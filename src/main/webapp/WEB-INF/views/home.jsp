<!DOCTYPE html>
<html>
    <head>
        <title>title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div th:text="${data.name}"></div>
        <th:block th:text="${data.date}"/>
        <h1>JSP TEST</h1>
        <a href="http://192.168.1.73:8888/job01">job01</a>
    </body>
</html>