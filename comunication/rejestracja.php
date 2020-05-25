<?php

$dzien = date('d');
$dzien_tyg = date('l');
$miesiac = date('n');
$rok = date('Y');

$miesiac_pl = array(1 => 'stycznia', 'lutego', 'marca', 'kwietnia', 'maja', 'czerwca', 'lipca', 'sierpnia', 'września', 'października', 'listopada', 'grudnia');

$dzien_tyg_pl = array('Monday' => 'poniedziałek', 'Tuesday' => 'wtorek', 'Wednesday' => 'środa', 'Thursday' => 'czwartek', 'Friday' => 'piątek', 'Saturday' => 'sobota', 'Sunday' => 'niedziela');

echo $dzien_tyg_pl[$dzien_tyg].", ".$dzien." ".$miesiac_pl[$miesiac]." ".$rok."r.";



// define variables and set to empty values
$nameErr = $surnameErr = $nickErr = $passwordErr = "";
$name = $surname =$nick = $password = $comment = "";
//$nameErr = $emailErr = $genderErr = $websiteErr = "";
//$name = $email = $gender = $comment = $website = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {

   if (empty($_POST["name"])) {
     $nameErr = "Name is required";
   } else {
     $name = test_input($_POST["name"]);
     // check if name only contains letters and whitespace
     if (!preg_match("/^[a-zA-Z ]*$/",$name)) {
       $nameErr = "Only letters and white space allowed";
     }
   }

      if (empty($_POST["surname"])) {
     $surnameErr = "Password is required";
   } else {
     $surname = test_input($_POST["surname"]);
     // check if name only contains letters and whitespace
     if (!preg_match("/^[a-zA-Z ]*$/",$surname)) {
       $surnameErr = "Only letters and white space allowed";
     }
   }

    if (empty($_POST["nick"])) {
     $nickErr = "Password is required";
   } else {
     $nick = test_input($_POST["nick"]);
     // check if name only contains letters and whitespace
     if (!preg_match("/^[a-zA-Z ]*$/",$nick)) {
       $nickErr = "Only letters and white space allowed";
     }
   }

      if (empty($_POST["comment"])) {
     $comment = "";
   } else {
     $comment = test_input($_POST["comment"]);
   }


   if (empty($_POST["gender"])) {
     $genderErr = "Gender is required";
   } else {
     $gender = test_input($_POST["gender"]);
   }
}


function test_input($data) {
   $data = trim($data);
   $data = stripslashes($data);
   $data = htmlspecialchars($data);
   return $data;
}

?>


<!DOCTYPE html>
<html lang="pl">

    <head>
  <meta charset="utf-8" />
<style type="text/css">
    
body {
 text-align: center;
 background-color: #b0c4de;
  //background-image: url(noticia_nanotecnologia.jpg);
}
    
h2.pos_left {
    position: relative;
    left: -700px;
}

h2.pos_right {
    position: relative;
    left: 3px;
}
    
    table {
    width: 70%;
}

th {
    text-align: left;
}

table {
    border-collapse: collapse;
    width: 100%;
}

td {
    height: 50px;
    vertical-align: bottom;
}

h5 {
    color: black;    
}
    
</style>
         <title>Rejestracja</title>
</head>
    <body>

      <h5>Rejestracja</h5>
      
      
      
  <table>
  <tr>
    <td> <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Grafen</h5></td>
    <td> <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Nanorurki</h5></td>
    <td> <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Nanocz?ski</h5></td>
  </tr>
  <tr>
    <td> <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Badania</h5></td>
    <td> <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Rozwoj</h5></td>
    <td> <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Przeds?biorstwa</h5></td>
  </tr>
  <tr>
    <td> <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Nanoproszki</h5></td>
    <td> <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Nanokompozyty</h5></td>
    <td> <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Nanodruty</h5></td>
  </tr>
</table>    
      
      
      
      
      <table>


          <p><span class="error"><h5>* required field.<h5></span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"> 
    
      <tr>
      
    <th>
        <h5>Name:</h5> <input type="text" name="name" value="<?php echo $name;?>">
            </th>

  </tr>
        
   <span class="error">* <?php echo $nameErr;?></span>
   <br><br>
   
    <tr>
      
    <th>
        <h5>Surname:</h5> <input type="text" name="surname" value="<?php echo $surname;?>">
           </th>

  </tr>
        
   <span class="error">* <?php echo $surnameErr;?></span>
   <br><br>
   
    <tr>
      
    <th>
        <h5>Nick:</h5> <input type="text" name="nick" value="<?php echo $nick;?>">
            </th>

  </tr>
        
        
   <span class="error">* <?php echo $surnameErr;?></span>
   <br><br>
   <h5>Opis grupy:</h5> <textarea name="comment" rows="5" cols="40"><?php echo $comment;?></textarea>
   <br><br>
   
   <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Woman</h5>
   <input type="radio" name="gender" <?php if (isset($gender) && $gender=="male") echo "checked";?>  value="male"><h5>Man</h5>
   <span class="error">* <?php echo $genderErr;?></span>
   <br><br>
   <input type="submit" name="submit" value="Submit"> 
</form>


      </table>

<?php


$link = mysql_connect("mysql5", "french_prochnicp", "techniki55")
    or die("Could not connect");

mysql_select_db("french_prochnicp")
    or die("Could not select database");

    if(isset($_POST['submit']))
{

 $ins = @mysql_query("INSERT INTO uzytkownicy SET username='$name', surname='$surname', nick='$nick', email='poczta'");
        if($ins) echo "Rekord został dodany poprawnie";
    else echo "Błąd nie udało się dodać nowego rekordu"; 
 mysql_free_result($ins);

}



mysql_close($link);
    

?>
        
                       
    </body>
</html>


