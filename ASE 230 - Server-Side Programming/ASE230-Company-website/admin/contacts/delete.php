<?php
require_once('functions.php');
if(array_key_exists('message',$_GET))
	deleteContact($_GET['message']);
header("Location: index.php");
?>
