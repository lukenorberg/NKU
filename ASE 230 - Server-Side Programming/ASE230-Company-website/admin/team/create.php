<?php
// Load JSON data from starluxe.json file
require_once('../../lib/jsonReader.php');
$data = readUserData('../../data/starluxe.json');
$uploadDirectory = '../../images/team';

// Include the collectImage function here

// Initialize variables to hold form data
$name = $title = $description = $image = '';
$error = '';

// Check if the form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve form data
    $name = $_POST['name'];
    $title = $_POST['title'];
    $description = $_POST['description'];

    // Validate form data (you can add more validation as needed)
    if (empty($name) || empty($title) || empty($description)) {
        $error = 'Please fill in all required fields.';
    } else {
        // Create a new team member entry
        $newMember = [
            'title' => $title,
            'description' => $description,
			'image' => null
        ];
		
        
        $result = collectImage('image1', $uploadDirectory,$data);

        if ($result['success']) {
            // Update the $image variable with the uploaded filename
            $image = 'images/team/' . $result['filename']; // Adjust the path to match your directory structure
			$newMember['image'] = $image;
            echo 'File uploaded successfully. Filename: ' . $image;
        } else {
            echo 'Error: ' . $result['message'];
        }

		

        // Add the new team member to the "Team" section
        $data['Team'][$name] = $newMember;

        // Save the updated data back to the starluxe.json file
        $updatedData = json_encode($data, JSON_PRETTY_PRINT);
        file_put_contents('../../data/starluxe.json', $updatedData);

        // Redirect to the detail page for the newly created team member
        header("Location: detail.php?name=" . urlencode($name));
        exit();
    }
}

$uploadDirectory = '../../images/team'; // Specify the upload directory

?>

<!DOCTYPE html>
<html>
<head>
    <title>Create New Team Member</title>
</head>
<body>
    <h1>Create New Team Member</h1>
    
    <?php
    // Display an error message if validation fails
    if (!empty($error)) {
        echo '<p style="color: red;">' . $error . '</p>';
    }
    ?>

    <form method="post" action="" enctype="multipart/form-data">
        <label for="name">Name:</label>
        <input type="text" name="name" required><br>
        <label for="title">Title:</label>
        <input type="text" name="title" required><br>
        <label for="description">Description:</label>
        <textarea name="description" required></textarea><br>
        <label for="image1">Image (optional):</label>
        <input type="file" name="image1" id="image1">
        <input type="submit" value="Create">
    </form>
</body>
</html>
