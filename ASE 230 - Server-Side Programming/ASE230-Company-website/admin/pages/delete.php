<?php
require_once('./pages.php');
$index = htmlspecialchars($_GET['index']);
$page = getPage($index);
?>

<div><?=$page?></div>
<form method="POST" action="./index.php">
    <div>Are you sure you want to delete the above?</div>
    <input type="hidden" name="index" value="<?=$index?>">
    <button type="submit">Yes</button>
</form>
