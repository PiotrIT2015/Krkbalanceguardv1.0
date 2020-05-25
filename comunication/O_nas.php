<?php

$dzien = date('d');
$dzien_tyg = date('l');
$miesiac = date('n');
$rok = date('Y');

$miesiac_pl = array(1 => 'stycznia', 'lutego', 'marca', 'kwietnia', 'maja', 'czerwca', 'lipca', 'sierpnia', 'wrzeÅ›nia', 'paÅºdziernika', 'listopada', 'grudnia');

$dzien_tyg_pl = array('Monday' => 'poniedziaÅ‚ek', 'Tuesday' => 'wtorek', 'Wednesday' => 'Å›roda', 'Thursday' => 'czwartek', 'Friday' => 'piÄ…tek', 'Saturday' => 'sobota', 'Sunday' => 'niedziela');

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
    
</style>
         <title>O nas</title>
</head>

        <FRAMESET COLS="25%, *%"">
<FRAME SRC="plik.html">
<FRAME SRC="https://www.google.pl/maps/place/Wydzia%C5%82+Fizyki+i+Informatyki+Stosowanej/@50.066855,19.91309,17z/data=!3m1!4b1!4m2!3m1!1s0x47165ba48fa84b9b:0x9a491cf861c762e3">
</FRAMESET>
<NO FRAMES>

    <body>
     
         <h5>O nas</h5>

        <h5>Misj? ?l?skiego Klastra Nano jest kszta?towanie ?l?ska jako innowacyjnego regionu sprzyjaj?cego rozwojowi nanotechnologii w kraju i na ?wiecie. Celem Klastra jest rozwijanie trwa?ej wspó?pracy pomi?dzy biznesem
a nauk?, pozwalaj?cej na realizacj? wspólnych projektów badawczo-rozwojowych oraz komercjalizacj? ich wyników. U?atwiaj?c dost?p i wymian? informacji oraz wspomagaj?c nawi?zywanie nowych kontaktów b?dzie integrowa? ?rodowisko przyczyniaj?c si? tym samym do rozwoju nauki i przemys?u na ?l?sku.</h5>

         
        <table>
 
  <tr>

      <th><a href="#" onclick="window.open('https://www.google.pl/maps/place/Wydzia%C5%82+Fizyki+i+Informatyki+Stosowanej/@50.066855,19.91309,17z/data=!3m1!4b1!4m2!3m1!1s0x47165ba48fa84b9b:0x9a491cf861c762e3', 'Nowe_okno', 'height=500,width=400');"><input type="submit" name="button" value="Mapa"/></a></th>

  
  </tr>
      </table>
           
    </body>
</html>
