<?php
require_once('data.php');
require_once('functions.php');

$keys = array_keys($profiles);
// variable of names for the end of the page
$namesString = '';

// formats the names appropriately, e.g. name1 vs. name1 and name2 vs. name1, name2, and name3 etc.
if (sizeof($profiles) == 1) {
    $namesString = $profiles[$keys[0]]['name'];
} elseif (sizeof($profiles) == 2) {
    $namesString = $profiles[$keys[0]]['name'] . ' and ' . $profiles[$keys[1]]['name'];
} else {
    for ($i = 0; $i < sizeof($keys); $i++) {
        if ($i == sizeof($keys) - 1) {
            $namesString .= ' and ' . $profiles[$keys[$i]]['name'];
        } else {
            $namesString .= $profiles[$keys[$i]]['name'] . ', ';
        }
    }
}

?>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>Our amazing team</title>

        <!-- Meta -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Your name's resume">
        <meta name="author" content="Your name">
        <link rel="shortcut icon" href="favicon.ico">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900" rel="stylesheet">

        <!-- FontAwesome JS-->
        <script defer src="assets/fontawesome/js/all.min.js"></script>

        <!-- Theme CSS -->
        <link id="theme-style" rel="stylesheet" href="assets/css/pillar-1.css">


    </head>

    <body>
    <article class="resume-wrapper text-center position-relative">
        <div class="resume-wrapper-inner mx-auto text-start bg-white shadow-lg">
            <h1 class="py-4 text-center">OUR AMAZING TEAM</h1>
            <?php
            // loops through each array and creates each team member's card
            foreach ($profiles as $id => $profile) {
                teamMemberCard($profile, $id);
            }
            ?>
        </div>
    </article>
    <footer class="footer text-center pt-2 pb-5">
        <!--/* This template is free as long as you keep the footer attribution link. If you'd like to use the template without the attribution link, you can buy the commercial license via our website: themes.3rdwavemedia.com Thank you for your support. :) */-->
        <small class="copyright">Designed with <span class="sr-only">love</span><i
                    class="fas fa-heart"></i><?= ' by ' . $namesString ?></small>
    </footer>
    </body>
    </html>

<?php
