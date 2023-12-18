<?php
// Load JSON data from team.json file
require_once('../../lib/jsonReader.php');
$JSONData = readUserData('../../data/starluxe.json');
error_log(print_r($JSONData,true));
?>

<!DOCTYPE html>
<html>
<head>
    <title>Starluxe Team</title>
</head>
<body>
    <h1>Starluxe Team</h1>
     <table border="1">
    <tr>
      <th>Name</th>
      <th>Position</th>
      <th>Image</th>
      <th>Description</th>
    </tr>
    <?php fillTeamTable($JSONData);?>
     </table>
    <br>
    <button><a href="create.php">Create</a></button>
</body>
</html>
