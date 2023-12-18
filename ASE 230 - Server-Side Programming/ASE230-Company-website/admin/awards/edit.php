<?php
require_once('./awards.php');

$index = htmlspecialchars($_GET['index']);
$item = getItem($index);
$getYear = htmlspecialchars($item[0]);
$getDesc = htmlspecialchars($item[1]);
if (count($_POST) > 0) {
    $year = htmlspecialchars($_POST['year']);
    $description = htmlspecialchars($_POST['description']);
    updateItem($index, $year, htmlspecialchars_decode($description));
    echo '<p style="color: green;">Item updated successfully</p>';
}
?>

<form method="POST" action="<?= $_SERVER['PHP_SELF'] . '?index=' . $index ?>">
    <label for="year">
        <select name="year">
            <?php
            for ($year = 2000; $year <= 2023; $year++) {
                echo '<option value="'.$year.'"';
                if ($year == $getYear) echo 'selected';
                echo '>'.$year.'</option>';
            }
            ?>
        </select>
    </label>
    <br>
    <label for="description">
        Description: <br>
        <textarea name="description" cols="30" rows="10" required minlength="15"><?=$getDesc?></textarea>
    </label>
    <br>
    <button type="submit">Save Changes</button>
</form>

