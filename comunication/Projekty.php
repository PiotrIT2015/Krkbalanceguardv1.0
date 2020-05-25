<?php
if ($_POST['button'] == "wyslij") {
/* sprawdzam czy dane zostały wysłane z formularza */
  $plik = "db.txt";
  if (is_writeable($plik)) {
  /* sprawdzam czy plik jest do zapisu */
    if (!$handle = fopen($plik, "a")) echo "Nie mogę otworzyć pliku...";
    if (fwrite($handle, $_POST['imie']." || ".$_POST['nazwisko']." || ".$_POST['miejscowosc']."
") === FALSE) echo "Nie mogę zapisać danych do pliku...";
      else echo "Dane zostały dodane...";
    fclose($handle);
  } else echo "Plik nie istnieje lub jest nie do zapisu...";
}

$dzien = date('d');
$dzien_tyg = date('l');
$miesiac = date('n');
$rok = date('Y');

$miesiac_pl = array(1 => 'stycznia', 'lutego', 'marca', 'kwietnia', 'maja', 'czerwca', 'lipca', 'sierpnia', 'września', 'października', 'listopada', 'grudnia');

$dzien_tyg_pl = array('Monday' => 'poniedziałek', 'Tuesday' => 'wtorek', 'Wednesday' => 'środa', 'Thursday' => 'czwartek', 'Friday' => 'piątek', 'Saturday' => 'sobota', 'Sunday' => 'niedziela');

echo $dzien_tyg_pl[$dzien_tyg].", ".$dzien." ".$miesiac_pl[$miesiac]." ".$rok."r.";

$comment = "";

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
 //background-color: #b0c4de;
 background-image: url(noticia_nanotecnologia.jpg);
}
div {
 border: 1px solid;
 width: 50%;
}
    
    table, td, th, tab {
    border: 1px solid black;
}

table {
    width: 10%;
    position: relative;
    left: 1600px;
}
    
    table#t01 {
    width: 30%;
    background-color: #f1f1c1;
      border: 1px solid black;
    position: relative;
   left: 200px;
}
    
     table#p01 {
    width: 30%;
    background-color: #f1f1c1;
      border: 1px solid black;
    position: relative;
   left: 800px;
}
    
         table#c01 {
    width: 10%;
    background-color: #f1f1c1;
      border: 1px solid black;
    position: relative;
   left: 1500px;
}
    
    table#r01 {
    width: 60%;
    background-color: #f1f1c1;
      border: 1px solid black;
    position: relative;
   left: 200px;
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
    
h2.pos_left {
    position: relative;
    left: -500px;
}

h2.pos_right {
    position: relative;
    left: 100px;
}
 
h5 {
    color: yellow;    
}

</style>
<title> KlasterNano</title>
</head>

    <body>
    
         <h2> Klaster Nano</h2> 
         
    <th>
      
            
        <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
              
  <table>
  <tr>
    <td> <input type="checkbox" name="Grafen" <?php if (isset($projekt) && $projekt=="Grafen") echo $_SERVER=$projekt;?>  value="Grafen"><h5>Grafen</h5></td>
    <td> <input type="checkbox" name="Nanorurki" <?php if (isset($projekt) && $projekt=="Nanorurki") echo $_SERVER=$projekt;?>  value="Nanorurki"><h5>Nanorurki</h5></td>
    <td> <input type="checkbox" name="Nanoczastki" <?php if (isset($projekt) && $projekt=="Nanocz?stki") echo $_SERVER=$projekt;?>  value="Nanoczastki"><h5>Nanocz?ski</h5></td>
  </tr>
  <tr>
      <td> <input type="checkbox" name="Badania" <?php if (isset($projekt) && $projekt=="Badania") echo $projekt;?>  value="Badania"><h5>Badania</h5></td>
    <td> <input type="checkbox" name="Rozwoj" <?php if (isset($projekt) && $projekt=="Rozwoj") echo $projekt;?>  value="Rozwoj"><h5>Rozwoj</h5></td>
    <td> <input type="checkbox" name="Przedsiebiorstwa" <?php if (isset($projekt) && $projekt=="Przessiebiorstwa") echo $projekt;?>  value="Przedsiebiorstwa"><h5>Przeds?biorstwa</h5></td>
  </tr>
  <tr>
    <td> <input type="checkbox" name="Nanoproszki" <?php if (isset($projekt) && $projekt=="Nanoproszki") echo $projekt;?>  value="Nanoproszki"><h5>Nanoproszki</h5></td>
    <td> <input type="checkbox" name="Nanokompozyty" <?php if (isset($projekt) && $projekt=="Nanokompozyty") echo $projekt;?>  value="Nanokompozyty"><h5>Nanokompozyty</h5></td>
    <td> <input type="checkbox" name="Nanodruty" <?php if (isset($projekt) && $projekt=="Nanodruty") echo $projekt;?>  value="Nanodruty"><h5>Nanodruty</h5></td>
  </tr>
  <tr>
      <input type ="submit" name="submit" value ="Zapisz">
  </tr>
</table>    
            
     
     
 </form>    
        

       

        




        






    
                            
    </body>
</html>