<html>
  <head><title>Spring Application</title></head>
  <body>
    <h1>Http Request Logger</h1>
    <p>create requests here</p>
    
    <h2>Get Request</h2>
    <a href="log/get.htm">sample get</a>
    
    
    <h2>Post Request</h2>
    <form action="log/post" method="POST">
  		<input type="hidden" name="param1" value="value1">
  		<input type="hidden" name="param2" value="value2">
  		<input type="hidden" name="param3" value="value3">
  		<input type="hidden" name="param4" value="value4">
  		<input type="submit" value="post" />
	</form>
	
	<h2>View Logs</h2>
	<a href="getall">see all logs</a>
    
    
  </body>
</html>
