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
      border: 1px solid red;
    position: relative;
   left: 200px;
}
    
     table#p01 {
    width: 30%;

background-color: graytext;



    position: relative;
   left: 600px;
}
    
         table#c01 {
    width: 10%;
    position: relative;
   left: 200px;
}
    
    table#r01 {
    width: 60%;
    background-color: pink;
      border: 1px solid black;
    position: relative;
   left: 400px;
}   
    
tr:nth-child(even){background-color: #f2f2f2}   
   
th {
    text-align: left;
}

table {
    border-collapse: collapse;
    width: 100%;
    background-color: #f1f1c1;
}

td {
    height: 50px;
    vertical-align: bottom;
}
    
h2.pos_left {
    position: relative;
    left: -500px;
    vertical-align: bottom;
}

h2.pos_right {
    position: relative;
    left: 800px;
    vertical-align: bottom;
}
 
h2 {
    color: yellow;    
}

h5 {
    color: yellow;    
}

</style>
<title> KlasterNano</title>
</head>

    <body>
    
         <h2> Klaster Nano</h2> 
         
         
         <table id="p01"  style="border: 3mm ridge yellow; overflow:scroll;" >
           
          
             
             <tr>        

                 
                 
          <?php
/*            
$wierszy = 5;
$kolumn = 5;



$tresc = '<table id="t01">';

for($i=0;$i<=$wierszy;$i++){
   $tresc.='<tr>';
   for($a=0;$a<=$kolumn;$a++){
      $tresc.='<td>'.$i.$a.'</td>';
      }
   $tresc.'</tr>';
}*/


$link = mysql_connect("mysql5", "french_prochnicp", "techniki55")
    or die("Could not connect");

mysql_select_db("french_prochnicp")
    or die("Could not select database");

$query  = "SELECT * FROM article";
$result = mysql_query($query)
    or die("Query failed");

$zapytanie = "INSERT INTO `formularz` VALUES('$imie','$nazwisko','$email')";
$wykonaj = "mysql_query('$zapytanie')";


while ($row = mysql_fetch_array($result)) {

/*
$wierszy2 = 5;
$kolumn2 = 5;



$tresc2 = '<table id=t01">';
for($i=0;$i<=$wierszy2;$i++){
   $tresc2.='<tr>';
   for($a=0;$a<=$kolumn2;$a++){
      $tresc2.='<td>'. $row["title"]. $row["autor"] .'</td>';
      }
   $tresc2.'</tr>';
}
   $tresc2.= '</table>';*/
    
    
   
    echo "<tr><TD>" . $row["title"] .
         "</TD><TD>" . $row["time"] .
          "</TD><TD>" . $row["autor"] .
           "</TD></tr>\n".
           "<tr><TD>" . $row["data"] .
         "</TD></tr>\n"; 
}

mysql_free_result($result);
mysql_close($link);

//$tresc.= '</table>';
//echo $tresc2;

?>
     
             

             
         </tr> 
     <tr>
  
         <th>
             
      
 

             <h2 class="pos_left"> <a href="#" onclick="window.open('logowanie.php', 'Nowe_okno', 'height=500,width=400');">
                     <svg>
<circle cx="60" cy="60" r="30"
	style="fill: #ff9; stroke: gray; stroke-width: 10;">
    <animateColor attributeName="fill"
        begin="2s" dur="4s" from="#ff9" to="red" fill="freeze"/>
    <animateColor attributeName="stroke"
        begin="2s" dur="4s" from="gray" to="blue" fill="freeze"/>
</circle>

     <text id="parent" font-family="Arial, sans-serif" font-size="32" fill="red" x="40" y="40"
    rotate="5,15,25,35,45,55">
  Newsletter   
  </text>

</svg>
                 </a>
             </h2>     
  
             <h2 class="pos_left">     
        
        <a href="#" onclick="window.open('Panel.php', 'Nowe_okno', 'height=700,width=490');">
<svg>
        <circle cx="60" cy="60" r="30"
	style="fill: #ff9; stroke: gray; stroke-width: 10;">
    <animateColor attributeName="fill"
        begin="2s" dur="4s" from="#ff9" to="red" fill="freeze"/>
    <animateColor attributeName="stroke"
        begin="prev.begin" dur="4s" from="gray" to="blue" fill="freeze"/>
</circle>

     <text id="parent" font-family="Arial, sans-serif" font-size="32" fill="red" x="95" y="40"
    rotate="5,15,25,35,45,55">
  Komentarze
  </text>

</svg>
</a>
        </h2>
     
             
  <h2 class="pos_left">
  
  <a href="#" onclick="window.open('https://www.survio.com/survey/d/O1T2I3M1F3Q7L3X1M', 'Nowe_okno', 'height=500,width=400');">
<svg>
<circle cx="60" cy="60" r="30"
	style="fill: #ff9; stroke: gray; stroke-width: 10;">
    <animateColor attributeName="fill"
        begin="2s" dur="4s" from="#ff9" to="red" fill="freeze"/>
    <animateColor attributeName="stroke"
        begin="2s" dur="4s" from="gray" to="blue" fill="freeze"/>
</circle>

     <text id="parent" font-family="Arial, sans-serif" font-size="32" fill="red" x="40" y="40"
    rotate="5,15,25,35,45,55">
  Projekty   
  </text>

</svg>
</a>
 
  </h2>
      
         </th>
    
    
    <th>   
  <h2 class="pos_right"> 
        
      <a href="#" onclick="window.open('rejestracja.php', 'Nowe_okno', 'height=500,width=400');">
<svg>
<circle cx="60" cy="60" r="30"
	style="fill: #ff9; stroke: gray; stroke-width: 10;">
    <animateColor attributeName="fill"
        begin="2s" dur="4s" from="#ff9" to="red" fill="freeze"/>
    <animateColor attributeName="stroke"
        begin="2s" dur="4s" from="gray" to="blue" fill="freeze"/>
</circle>

     <text id="parent" font-family="Arial, sans-serif" font-size="32" fill="red" x="40" y="40"
    rotate="5,15,25,35,45,55">
  Rejestracja   
  </text>

</svg>
</a>
              </h2>
        
        
        
  <h2 class="pos_right"> 
      
       <a href="#" onclick="window.open('O_nas.php', 'Nowe_okno', 'height=700,width=490');">
<svg>
        <circle cx="60" cy="60" r="30"
	style="fill: #ff9; stroke: gray; stroke-width: 10;">
    <animateColor attributeName="fill"
        begin="2s" dur="4s" from="#ff9" to="red" fill="freeze"/>
    <animateColor attributeName="stroke"
        begin="prev.begin" dur="4s" from="gray" to="blue" fill="freeze"/>
</circle>

    <text id="parent" font-family="Arial, sans-serif" font-size="32" fill="red" x="60" y="40"
    rotate="5,15,25,35,45,55">
   O nas   
  </text>

</svg>
</a>
 
            </h2>
        
  <h2 class="pos_right"> 
        
      <a href="#" onclick="window.open('Sklad.php', 'Nowe_okno', 'height=700,width=490');">
  <svg>
        <circle cx="60" cy="60" r="30"
	style="fill: #ff9; stroke: gray; stroke-width: 10;">
    <animateColor attributeName="fill"
        begin="2s" dur="4s" from="#ff9" to="red" fill="freeze"/>
    <animateColor attributeName="stroke"
        begin="prev.begin" dur="4s" from="gray" to="blue" fill="freeze"/>
</circle>

        <text id="parent" font-family="Arial, sans-serif" font-size="32" fill="red" x="75" y="40"
    rotate="5,15,25,35,45,55">
  Skład  
  </text>

</svg>
</a>
   
          </h2>
        
  
     </th>
     </tr>
    </table>

              




      






        






    
                            
    </body>
</html>