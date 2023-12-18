<?php
// Load JSON data from starluxe.json file
require_once('/Applications/XAMPP/xamppfiles/htdocs/ase230/week4/ASE230-Company-website/lib/jsonReader.php');
$data = readUserData();

// Initialize variables to hold form data
$productName = $description = '';
$applications = [];
$error = '';

// Check if the product name is provided in the URL query parameter
if (isset($_GET['name'])) {
    $productName = $_GET['name'];

    // Check if the product exists in the data
    if (isset($data['Key Products & Services'][$productName])) {
        // Retrieve the existing product data
        $productData = $data['Key Products & Services'][$productName];
        $description = $productData['description'];
        $applications = $productData['applications'];

        // Check if the form is submitted
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            // Retrieve form data
            $newDescription = $_POST['description'];
            $newApplications = explode(PHP_EOL, $_POST['applications']);

            // Validate form data (you can add more validation as needed)
            if (empty($newDescription) || empty($newApplications)) {
                $error = 'Please fill in all required fields.';
            } else {
                // Update the product data with new values
                $data['Key Products & Services'][$productName]['description'] = $newDescription;
                $data['Key Products & Services'][$productName]['applications'] = $newApplications;

                // Save the updated data back to the starluxe.json file
                file_put_contents('starluxe.json', json_encode($data, JSON_PRETTY_PRINT));

                // Redirect back to the list of products or another appropriate page
                header("Location: index.php");
                exit();
            }
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
    <title>Edit Product/Service</title>
</head>
<body>
    <h1>Edit Product/Service</h1>
    
    <?php
    // Display an error message if applicable
    if (!empty($error)) {
        echo '<p style="color: red;">' . $error . '</p>';
    }
    ?>

    <form method="post" action="">
        <label for="product_name">Product/Service Name:</label>
        <input type="text" name="product_name" value="<?php echo htmlspecialchars($productName); ?>" readonly><br>
        <label for="description">Description:</label>
        <textarea name="description" required><?php echo htmlspecialchars($description); ?></textarea><br>
        <label for="applications">Applications (one per line):</label>
        <textarea name="applications" required><?php echo implode(PHP_EOL, $applications); ?></textarea><br>
        <input type="submit" value="Save Changes">
    </form>
</body>
</html>
