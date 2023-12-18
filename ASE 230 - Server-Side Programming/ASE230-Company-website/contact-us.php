<?php
// Ensure all needed fields are present
foreach(['unique_id','name','email','subject','comments'] as $key)
	if(!array_key_exists($key,$_POST))
		die("ERROR - Invalid request");

// Attempt to validate e-mail address
if(!preg_match('/^[A-Za-z0-9\.-]+@[A-Za-z0-9\.-]+\.[A-Za-z]+$/',$_POST['email']))
	die('ERROR - Invalid e-mail address.');

// Open file and import values.
$filepath='admin/contacts/data.json.php';
$contents=file_get_contents($filepath);
$contents=explode("\n",$contents);
array_shift($contents);
$contents=implode("\n",$contents);
$ourArray=json_decode($contents,true);

// Ensure unique_id doesn't already exist as to avoid accidental duplicate/replays
if(array_key_exists($_POST['unique_id'],$ourArray))
	die('ERROR - Duplicate packet received.');

// Add new message to array of messages
$ourArray[$_POST['unique_id']]=
[	'date'		=> time(),
	'name'		=> $_POST['name'],
	'email'		=> $_POST['email'],
	'subject'	=> $_POST['subject'],
	'comments'	=> $_POST['comments'],
];

// Write back to file
file_put_contents($filepath,"<?php die('Insufficient permissions'); ?>\n".json_encode($ourArray));

// Send user back home!
header("Location: index.php");
?>
