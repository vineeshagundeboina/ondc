<!DOCTYPE html>
<html>
<head>
    <title>Entries List</title>
    <script type="text/javascript">
        function showAddEntryForm() {
        	alert("hello world");
            document.getElementById("form-div").style.display = "block";
            document.getElementById("form-div").style.display = "none";
        }
    </script>
</head>
<body>
    

<div class="entry-list">
   <div class="button-div">
   <button onclick="showAddEntryForm()">Add Entry</button>
   </div>
   <div id="form-div" entriesentriesentriesentriesentriesentriesentriesstyle="display:none;font-size: 30px">
    <h3>Add Entry</h3>
    <form action="${pageContext.request.contextPath}/addEntry" method="post">
        <input type="hidden" name="userId" value="${userId}">
        
        <label for="date">Date:</label>
        <input type="date" id="date" name="entryDate" required><br><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>
        
        <input type="submit" value="Add Entry">
    </form>
   </div>
   
   <h2>Entries List</h2>
    <c:forEach var="entry" items="${entries}">
        <p>${entry.content}</p>
    </c:forEach>
    </div>
</body>
</html>