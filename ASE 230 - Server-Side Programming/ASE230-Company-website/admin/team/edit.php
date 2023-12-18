<?php
// Load JSON data from starluxe.json file
require_once('../../lib/jsonReader.php');
$data = readUserData('../../data/starluxe.json');

// Initialize variables to hold form data
$teamMemberName = $title = $description = '';
$error = '';

// Check if the team member name is provided in the URL query parameter
if (isset($_GET['name'])) {
    $teamMemberName = $_GET['name'];

    // Check if the team member exists in the data
    if (isset($data['Team'][$teamMemberName])) {
        // Retrieve the existing team member data
        $teamMemberData = $data['Team'][$teamMemberName];
        $title = $teamMemberData['title'];
        $description = $teamMemberData['description'];

        // Check if the form is submitted
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            // Retrieve form data
            $newTitle = $_POST['title'];
            $newDescription = $_POST['description'];

            // Validate form data (you can add more validation as needed)
            if (empty($newTitle) || empty($newDescription)) {
                $error = 'Please fill in all required fields.';
            } else {
                // Update the title and description in the team member data
                $data['Team'][$teamMemberName]['title'] = $newTitle;
                $data['Team'][$teamMemberName]['description'] = $newDescription;

                // Save the updated data back to the starluxe.json file
                file_put_contents('../../data/starluxe.json', json_encode($data, JSON_PRETTY_PRINT));

                // Redirect back to the list of team members or another appropriate page
                header("Location: index.php");
                exit();
            }
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
    <title>Edit Team Member</title>
</head>
<body>
    <h1>Edit Team Member</h1>
    
    <?php
    // Display an error message if applicable
    if (!empty($error)) {
        echo '<p style="color: red;">' . $error . '</p>';
    }
    ?>

    <form method="post" action="">
        <label for="team_member_name">Team Member Name:</label>
        <input type="text" name="team_member_name" value="<?php echo htmlspecialchars($teamMemberName); ?>" readonly><br>
        <label for="title">Title:</label>
        <input type="text" name="title" required value="<?php echo htmlspecialchars($title); ?>"><br>
        <label for="description">Description:</label>
        <textarea name="description" required><?php echo htmlspecialchars($description); ?></textarea><br>
        <input type="submit" value="Save Changes">
    </form>
</body>
</html>
