<?php

$dzien = date('d');
$dzien_tyg = date('l');
$miesiac = date('n');
$rok = date('Y');

$miesiac_pl = array(1 => 'stycznia', 'lutego', 'marca', 'kwietnia', 'maja', 'czerwca', 'lipca', 'sierpnia', 'września', 'października', 'listopada', 'grudnia');

$dzien_tyg_pl = array('Monday' => 'poniedziałek', 'Tuesday' => 'wtorek', 'Wednesday' => 'środa', 'Thursday' => 'czwartek', 'Friday' => 'piątek', 'Saturday' => 'sobota', 'Sunday' => 'niedziela');

echo $dzien_tyg_pl[$dzien_tyg].", ".$dzien." ".$miesiac_pl[$miesiac]." ".$rok."r.";

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
 
td {
    text-align: center;
}

h5 {
    color: black;    
}
    
          
</style>
        <title>Sklad osobowy</title>
    </head>
    <body>
        <h5> Skad</h5>
        <table>
  <tr>
      <th> <h5>Prezes<h5></th>
                  <th><h5>dr.hab.inż.J.Chwiej<h5></th>
  </tr>
  <tr>
      <td><h5>Z-ca Prezes</h5></td>
      <td><h5>Martyna Dziadosz</h5></td>
  </tr>
  <tr>
      <td><h5> Wiceprezes</h5></td>
      <td><h5>Barbara Stenczyk</h5></td>
  </tr>
  <tr>
      <td><h5>Sekretarz</h5></td>
      <td><h5>Anna Guzik</h5></td>
  </tr>
     <tr>
         <td><h5>Skarbnik</h5></td>
         <td><h5>Magdalena Konefa</h5>�</td>
  </tr>
            <tr>
             <td>
        <FONTSIZE="5"<FONTCOLOR="silver"><center><H2><B><A HREF="mailto:-sknfmkerma@gmail.com"
<A HREF="mailto:sknfmkerma@gmail.com?subject=List do sknfmkerma@gmail.com" TITLE="List do sknfmkerma@gmail.com"><center></td><img src="MAILBOX.GIF" alt="Tu podaj tekst alternatywny" /></td></A></H2>
</FONT></FONT>
    </td>
            </tr>
</table>
        
          

        <?php

$link = mysql_connect("mysql5", "french_prochnicp", "techniki55")
    or die("Could not connect");

mysql_select_db("french_prochnicp")
    or die("Could not select database");

$query  = "SELECT * FROM uzytkownicy";
$result = mysql_query($query)
    or die("Query failed");

$zapytanie = "INSERT INTO `formularz` VALUES('$imie','$nazwisko','$email')";
$wykonaj = "mysql_query('$zapytanie')";


while ($row = mysql_fetch_array($result)) {

    echo "<TR><h5><TD>" . $row["username"] .
         "</TD><TD>" . $row["surname"] .
          "</TD><TD>" . $row["nick"] .
           "</TD><TD>" . $row["email"] .
         "</TD></h5></TR>\n";
}

mysql_free_result($result);
mysql_close($link);

?>

           

    </body>
</html>
