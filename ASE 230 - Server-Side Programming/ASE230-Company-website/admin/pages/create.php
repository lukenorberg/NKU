<?php
require_once('./pages.php');
if (count($_POST) > 0) {
    $fileName = htmlspecialchars($_POST['fileName']);
    $content = htmlspecialchars($_POST['content']);
    echo '<p>'.
        createPage($fileName, $content)
    .'</p>';
}
?>

<form method="POST" action="<?= $_SERVER['PHP_SELF']?>">
    <label for="fileName">
        File Name: <br><input type="text" name="fileName" required>
    </label>
    <br>
    <label for="content">
        File Contents: <br>
        <textarea name="content" cols="30" rows="10" required minlength="15"></textarea>
    </label>
    <br>
    <button type="submit">Submit</button>
</form>


