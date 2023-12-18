<?php
// Load JSON data from starluxe.json file
require_once('../../lib/jsonReader.php');
$data = readUserData('../../data/starluxe.json');

// Initialize variables
$teamMemberName = '';
$error = '';

// Check if the team member name is provided in the URL query parameter
if (isset($_GET['name'])) {
    $teamMemberName = $_GET['name'];

    // Check if the team member exists in the data
    if (isset($data['Team'][$teamMemberName])) {
        // Check if the user has confirmed the deletion
        if (isset($_POST['confirm'])) {
            // Remove the team member from the data
            unset($data['Team'][$teamMemberName]);

            // Save the updated data back to the starluxe.json file
            file_put_contents('../../data/starluxe.json', json_encode($data, JSON_PRETTY_PRINT));

            // Redirect to the index page or another appropriate page
            header("Location: index.php");
            exit();
        }
    } else {
        $error = 'Team member not found.';
    }
} else {
    $error = 'Team member name not provided.';
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Delete Team Member</title>
</head>
<body>
    <h1>Delete Team Member</h1>
    
    <?php
    // Display an error message if applicable
    if (!empty($error)) {
        echo '<p style="color: red;">' . $error . '</p>';
    } else {
        // Display confirmation message and form
        echo '<p>Are you sure you want to delete the team member: <strong>' . htmlspecialchars($teamMemberName) . '</strong>?</p>';
        echo '<form method="post" action=""><input type="submit" name="confirm" value="Yes, Delete"><a href="index.php">Cancel</a></form>';
    }
    ?>
</body>
</html>
