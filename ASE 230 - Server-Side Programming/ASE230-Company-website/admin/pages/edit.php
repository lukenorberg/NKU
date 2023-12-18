<?php
require_once('./pages.php');

$index = htmlspecialchars($_GET['index']);

if (count($_POST) > 0) {
    $fileName = htmlspecialchars($_POST['fileName']);
    $content = htmlspecialchars($_POST['content']);
    echo '<div>'.updatePage($fileName, $content).'</div>';
}
?>


<form method="POST" action="<?= $_SERVER['PHP_SELF'].'?index='.$index?>">
    <label for="fileName">
        File Name: <br><input type="text" name="fileName" value="<?=getPage($index)?>" required>
    </label>
    <br>
    <label for="content">
        File Contents: <br>
        <textarea name="content" cols="50" rows="20" required minlength="15"><?=htmlspecialchars(getPageContent($index))?></textarea>
    </label>
    <br>
    <button type="submit">Submit</button>
</form>

