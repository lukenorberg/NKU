<?php
// Load JSON data from starluxe.json file
require_once('/Applications/XAMPP/xamppfiles/htdocs/ase230/week4/ASE230-Company-website/lib/jsonReader.php');
$data = readUserData();

// Initialize variables to hold form data
$productName = $description = $application ='';
$error = '';

// Check if the form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve form data
    $productName = $_POST['product_name'];
    $description = $_POST['description'];
    $application = $_POST['$application'];

    // Validate form data (you can add more validation as needed)
    if (empty($productName) || empty($description)) {
        $error = 'Please fill in all required fields.';
    } else {
        // Create a new product entry
        $newProduct = [
            'description' => $description,
            'application' => $application
        ];

        // Add the new product to the "Key Products & Services" section
        $data['Key Products & Services'][$productName] = $newProduct;

        // Save the updated data back to the starluxe.json file
        file_put_contents('starluxe.json', json_encode($data, JSON_PRETTY_PRINT));

        // Redirect to the edit page for the newly created product
        header("Location: edit.php?name=" . urlencode($productName));
        exit();
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Create New Product/Service</title>
</head>
<body>
    <h1>Create New Product/Service</h1>
    
    <?php
    // Display an error message if validation fails
    if (!empty($error)) {
        echo '<p style="color: red;">' . $error . '</p>';
    }
    ?>

    <form method="post" action="">
        <label>Product/Service Name:</label>
        <input type="text" name="product_name" required><br>
        <label>Description:</label>
        <textarea name="description" required></textarea><br>
        <label >Applications:</label>
        <textarea name="application" required></textarea><br>
        <input type="submit" value="Create">
    </form>
</body>
</html>
