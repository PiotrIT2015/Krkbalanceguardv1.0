<?php

$password = $nick = $comment = ' ';

$link = mysql_connect("mysql5", "french_prochnicp", "techniki55")
    or die("Could not connect");

mysql_select_db("french_prochnicp")
    or die("Could not select database");

    if(isset($_POST['submit']))
{

 $ins = @mysql_query("SELECT * FROM uzytkownicy WHERE \"password\"  LIKE '$password'  ");
        if($ins) echo "Poprawne haslo";
    else echo "BÅ‚Ä…d nie udaÅ‚o siÄ™ dodaÄ‡ nowego rekordu"; 
    
 $inz = @mysql_query("SELECT * FROM uzytkownicy WHERE \"nick\"  LIKE '$nick'  ");
        if($inz) echo "Poprawny nick";
    else echo "BÅ‚Ä…d nie udaÅ‚o siÄ™ dodaÄ‡ nowego rekordu";    
    
 $ink = @mysql_query("INSERT INTO komentarze SET autor='$nick', data='$comment'");
        if($ink) echo "Poprawny comment";
    else echo "BÅ‚Ä…d nie udaÅ‚o siÄ™ dodaÄ‡ nowego rekordu";    
    
    
 mysql_free_result($ins, $inz, $ink);
 
 echo  $ins, $inz, $ink ;
echo  'Zalogowano użytkownika:', $nick ;

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
 background-color: #b0c4de;
 // background-image: url(noticia_nanotecnologia.jpg);
  
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
    
</style>
         <title>Logowanie</title>
</head>
    <body>

    

  <table width="200" border="0" cellpadding="0" cellspacing="0" class="boxes">
        <tr>
          <td class="boxheader">News Letter</td>
        </tr>
        <tr>
          <td><?php
                          $mailbar=1;
                          $group=1;
                          include("maillist/mailbar.php");
                           ?></td>
        </tr>
      </table>
      <br>
      <table width="200" border="0" cellpadding="0" cellspacing="0" class="boxes">
        <tr>
          <td class="boxheader">News Letter</td>
        </tr>
        <tr>
          <td><?php
                          $mailbar=2;
                          $group=1;
                          include("maillist/mailbar.php");
                           ?></td>
        </tr>
      </table>
      <br>
      <table width="200" border="0" cellpadding="0" cellspacing="0" class="boxes">
        <tr>
          <td class="boxheader">News Letter</td>
        </tr>
        <tr>
          <td><?php
                          $mailbar=6;
                          $group=1;
                          include("maillist/mailbar.php");
                           ?></td>
        </tr>
      </table>
            <br>
      <table width="200" border="0" cellpadding="0" cellspacing="0" class="boxes">
        <tr>
          <td class="boxheader">News Letter</td>
        </tr>
        <tr>
          <td><?php
                          $mailbar=4;
                          $group=1;
                          include("maillist/mailbar.php");
                           ?></td>
        </tr>
      </table>
      <p><br>
      </p></td>
    <td width="685" valign="top"> <table width="460" border="0" cellpadding="0" cellspacing="0" class="codeboxes">
      <tr>
        <td width="20">&nbsp;</td>
        <td><code>
          <br>
          <?php
                      if(isset ($_GET['page']))
                                        {
                                        if ($_GET['page'] == "mail")
                                        {
                                    include("maillist/mailmain.php");
                                        }
                                        if ($_GET['page'] == "about")
                                        {
                                    include("about.php");
                                        }
                                        }else {
                                        /* include( your title page"); */
                                        print(":The subscribe messages will appear here :");
                                        }
              ?>
          <br>
          <br>
        </code></td>
      </tr>
    </table>  


                   
    </body>
</html>


