<!DOCTYPE html>
<html>
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <title>User Input Form</title>
</head>
 
<body>
<h2>User Input Form</h2>
<form method="post" action="/RegProject/FormHandler">
  <fieldset>
    <legend>User Data</legend>
    Name: <input type="text" name="uname" /><br /><br />
    Password: <input type="password" name="upass" /><br /><br />
    Email: <input type="text" name="email" /><br/>
 
    Salary:<input type="text" name="salary"><br/><br/>
      
  </fieldset>
 
  <fieldset>
    <legend>Leaves</legend>
  <input type="text" name="leaves">
  </fieldset>
 
 
  <input type="submit" value="SEND" />
  <input type="reset" value="CLEAR" />
</form>
</body>
</html>