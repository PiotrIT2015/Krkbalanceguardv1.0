<?php

$dzien = date('d');
$dzien_tyg = date('l');
$miesiac = date('n');
$rok = date('Y');

$miesiac_pl = array(1 => 'stycznia', 'lutego', 'marca', 'kwietnia', 'maja', 'czerwca', 'lipca', 'sierpnia', 'września', 'października', 'listopada', 'grudnia');

$dzien_tyg_pl = array('Monday' => 'poniedziałek', 'Tuesday' => 'wtorek', 'Wednesday' => 'środa', 'Thursday' => 'czwartek', 'Friday' => 'piątek', 'Saturday' => 'sobota', 'Sunday' => 'niedziela');

echo $dzien_tyg_pl[$dzien_tyg].", ".$dzien." ".$miesiac_pl[$miesiac]." ".$rok."r.";



// define variables and set to empty values
$nameErr = $passwordErr = "";
$name = $password = $comment = "";
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

      /*if (empty($_POST["password"])) {
     $passwordErr = "Password is required";
   } else {
     $password = test_input($_POST["password"]);
     // check if name only contains letters and whitespace
     if (!preg_match("/^[a-zA-Z ]*$/",$password)) {
       $passwordErr = "Only letters and white space allowed";
     }
   }*/


  
  /* if (empty($_POST["email"])) {
     $emailErr = "Email is required";
   } else {
     $email = test_input($_POST["email"]);
     // check if e-mail address is well-formed
     if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
       $emailErr = "Invalid email format";
     }
   }
    
   if (empty($_POST["website"])) {
     $website = "";
   } else {
     $website = test_input($_POST["website"]);
     // check if URL address syntax is valid (this regular expression also allows dashes in the URL)
     if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) {
       $websiteErr = "Invalid URL";
     }
   }
*/

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
 // background-image: url(noticia_nanotecnologia.jpg);
}
    
h2.pos_left {
    position: relative;
    left: -100px;
}

h2.pos_right {
    position: relative;
    left: 3px;
}
    
    table {
    width: 30%;
}

th {
    text-align: center;
}
  
h5 {
    color: black;    
}

table {
    border-collapse: collapse;
    width: 100%;
}

td {
    height: 50px;
    vertical-align: bottom;
}

</style>
         <title>O nas</title>

    </head>
    <body>
           
<table>
 

  

    <p><span class="error"><h5>* required field.</h5></span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"> 
     <tr>
      
    <th>
    <h5> Name:</h5> <input type="text" name="name" value="<?php echo $name;?>">
     </th>

  </tr>
    
   <span class="error">* <?php echo $nameErr;?></span>
   <br><br>
   
       <tr>
      
    <th>
   <h5>Password:</h5> <input type="text" name="password" value="<?php echo $password;?>">
    </th>

  </tr>
   
  <tr>
   <span class="error">* <?php echo $passwordErr;?></span>
   <br><br>
   <input type="submit" name="submit1" value="Delete"> 
   <br><br>
   Comment: <textarea name="comment" rows="5" cols="40"><?php echo $comment;?></textarea>
   <br><br>
   </tr>
   
   
    <tr>
      
    <th>
   <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female"><h5>Aktualnosci</h5>
   <input type="radio" name="gender" <?php if (isset($gender) && $gender=="male") echo "checked";?>  value="male"><h5>Seminaria</h5>
   <span class="error">* <?php echo $genderErr;?></span>
     </th>

  </tr>
   
   <br><br>
   <input type="submit" name="submit" value="Przydziel"> 
</form>


</table>

<?php
    
$link = mysql_connect("mysql5", "french_prochnicp", "techniki55")
    or die("Could not connect");

mysql_select_db("french_prochnicp")
    or die("Could not select database");


    if(isset($_POST['submit1']))
{

$login = $_POST['name'];
$haslo = $_POST['password'];
$haslo = addslashes($haslo);
$login = addslashes($login);
$login = htmlspecialchars($login);

if ($_GET['login'] != '') { //jezeli ktos przez adres probuje kombinowac
exit;
}
if ($_GET['haslo'] != '') { //jezeli ktos przez adres probuje kombinowac
exit;
}

$haslo = md5($haslo); //szyfrowanie hasla
    if (!$login OR empty($login)) {
//include("head2.php");
echo '<p class="alert">Wypełnij pole z loginem!</p>';

//include("foot.php");
exit;
}
    if (!$haslo OR empty($haslo)) {
//include("head2.php");
echo '<p class="alert">Wypełnij pole z hasłem!</p>';
//include("foot.php");
exit;
}
$istnick = mysql_fetch_array(mysql_query("SELECT COUNT(*) FROM `admin_panel` WHERE `nick` = '$login' AND `haslo` = '$haslo'")); // sprawdzenie czy istnieje uzytkownik o takim nicku i hasle
    if ($istnick[0] == 0) {
echo 'Logowanie nieudane. Sprawdź pisownię nicku oraz hasła.';
    } else {

$_SESSION['nick'] = $login;
$_SESSION['haslo'] = $haslo;

header("Location: indeks.php");

}

 mysql_free_result($istnick);

}


mysql_close($istnick);

/*
?>

<?php
*/



    if(isset($_POST['submit']))
{

 $ins = @mysql_query("INSERT INTO article SET autor='$name', password='$password', data='$comment', title='Aktualności'");
        if($ins) echo "Rekord został dodany poprawnie";
    else echo "Błąd nie udało się dodać nowego rekordu"; 
 mysql_free_result($ins);

}

mysql_close($link);

?>









    </body>
</html>
