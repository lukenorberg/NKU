<?php
require_once('functions.php');
?>
<div><a href='index.php'>← Return to inbox.</a></div>
<hr>
<?php 
if(!array_key_exists('message',$_GET))
	die('No message specified.');

$msg=getContactByID($_GET['message']);
if(count($msg)==0)
	die('Specified message not found');
?>
<div style='background-color:LightGray;'>
	<h1><?= $msg['subject'] ?></h1>
	<div>
		from <i><?= $msg['name'] ?></i> 
		<small>&lt;<?= $msg['email'] ?>&gt;</small> 
		on <?= date('Y-m-d \a\t H:i:s',$msg['date']) ?>
	</div>
	<pre style="white-space:pre-wrap;"><?= $msg['comments'] ?></pre>
</div>
<hr>
<a href='mailto:<?= $msg['email'] ?>?subject=Re: <?= $msg['subject'] ?>'>Reply</a> &sdot;
<a href='delete.php?message=<?= $_GET['message'] ?>'>Delete</a>