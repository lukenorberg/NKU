<?php
// Load JSON data from starluxe.json file
require_once('/Applications/XAMPP/xamppfiles/htdocs/ase230/week4/ASE230-Company-website/lib/jsonReader.php');
$data = readUserData();

// Initialize variables
$productName = '';
$error = '';

// Check if the product name is provided in the URL query parameter
if (isset($_GET['name'])) {
    $productName = $_GET['name'];

    // Check if the product exists in the data
    if (isset($data['Key Products & Services'][$productName])) {
        // Check if the user has confirmed the deletion
        if (isset($_POST['confirm'])) {
            // Remove the product from the data
            unset($data['Key Products & Services'][$productName]);

            // Save the updated data back to the starluxe.json file
            file_put_contents('starluxe.json', json_encode($data, JSON_PRETTY_PRINT));

            // Redirect to the index page or another appropriate page
            header("Location: index.php");
            exit();
        }
    } else {
        $error = 'Product not found.';
    }
} else {
    $error = 'Product name not provided.';
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Delete Product/Service</title>
</head>
<body>
    <h1>Delete Product/Service</h1>
    
    <?php
    // Display an error message if applicable
    if (!empty($error)) {
        echo '<p style="color: red;">' . $error . '</p>';
    } else {
        // Display confirmation message and form
        echo '<p>Are you sure you want to delete the product/service: <strong>' . htmlspecialchars($productName) . '</strong>?</p>';
        echo '<form method="post" action=""><input type="submit" name="confirm" value="Yes, Delete"><a href="index.php">Cancel</a></form>';
    }
    ?>
</body>
</html>
