<?php
require_once('./awards.php');
if (count($_POST) > 0) {
    $year = htmlspecialchars($_POST['year']);
    $description = htmlspecialchars($_POST['description']);
    createItem($year, $description);
    echo '<p style="color: green;">Item added successfully</p>';
}
?>

<form method="POST" action="<?= $_SERVER['PHP_SELF']?>">
    <label for="year">
        <select name="year" required>
            <option value="">Select a Year</option>
            <?php
            for ($year = 2000; $year <= 2023; $year++) {
                echo '<option value="'.$year.'">'.$year.'</option>';
            }
            ?>
        </select>
    </label>
    <br>
    <label for="description">
        Description: <br>
        <textarea name="description" cols="30" rows="10" required minlength="15"></textarea>
    </label>
    <br>
    <button type="submit">Submit</button>
</form>


