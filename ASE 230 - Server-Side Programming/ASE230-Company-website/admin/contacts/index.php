<?php
require_once('functions.php');
$contactsArray=importContacts();
?>

<?php foreach($contactsArray as $mID => $msg): ?>
<hr>
<div style='background-color:LightGray;'>
	<h1><?= $msg['subject'] ?></h1>
	<div>from <i><?= $msg['name'] ?></i> on <?= date('Y-m-d \a\t H:i:s',$msg['date']) ?></div>
	<pre><?php
		if(strlen($msg['comments'])>100)
			echo substr($msg['comments'],0,100).'…';
		else echo $msg['comments'];
	?></pre>
	<a href="detail.php?message=<?= $mID ?>">See message →</a>
</div>
<?php endforeach ?>