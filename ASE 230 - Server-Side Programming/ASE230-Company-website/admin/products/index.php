<?php
// Load JSON data from starluxe.json file
require_once('/Applications/XAMPP/xamppfiles/htdocs/ase230/week4/ASE230-Company-website/lib/jsonReader.php');
$data = readUserData();

// Check if the "Key Products & Services" section exists in the data
if (isset($data['Key Products & Services'])) {
    $keyProducts = $data['Key Products & Services'];
} else {
    $keyProducts = [];
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Key Products & Services</title>
</head>
<body>
    <h1>Key Products & Services</h1>

    <!-- Create button to navigate to the create page -->
    <button><a href="create.php">Create New Product/Service</a></button>

    <!-- Display a table of available items -->
    <table border="1">
        <tr>
            <th>Product/Service Name</th>
            <th>Description</th>
            <th>Applications</th>
        </tr>
        <?php foreach ($keyProducts as $productName => $productInfo) : ?>
            <tr>
                <td><a href="detail.php?name=<?php echo urlencode($productName); ?>"><?php echo htmlspecialchars($productName); ?></a></td>
                <td><?php echo htmlspecialchars($productInfo['description']); ?></td>
                <td>
                    <ul>
                        <?php foreach ($productInfo['applications'] as $application) : ?>
                            <li><?php echo htmlspecialchars($application); ?></li>
                        <?php endforeach; ?>
                    </ul>
                </td>
            </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>



