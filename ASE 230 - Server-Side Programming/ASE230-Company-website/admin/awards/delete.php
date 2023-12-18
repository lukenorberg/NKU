<?php
require_once('./awards.php');
$index = htmlspecialchars($_GET['index']);
$item = getItem($index);
?>

<div><?=$item[0]?></div>
<div><?=$item[1]?></div>
<form method="POST" action="./index.php">
    <div>Are you sure you want to delete the above?</div>
    <input type="hidden" name="index" value="<?=$index?>">
    <button type="submit">Yes</button>
</form>

