<?php
function getFilepath()
{	return 'data.json.php';
}

function importContacts()
{	$contents=file_get_contents(getFilepath());
	$contents=explode("\n",$contents);
	array_shift($contents);
	$contents=implode("\n",$contents);
	return json_decode($contents,true);
}

function writeContacts($newArray)
{	$contents="<?php die('Insufficient permissions'); ?>\n".json_encode($newArray);
	file_put_contents(getFilepath(),$contents);
}

function getContactByID($mID)
{	$theArray=importContacts();
	if(array_key_exists($mID,$theArray))
		foreach($theArray as $uID => $msg)
			if($uID==$mID) return $msg;
	return array();
}

function deleteContact($mID)
{	$theArray=importContacts();
	unset($theArray[$mID]);
	writeContacts($theArray);
}

?>