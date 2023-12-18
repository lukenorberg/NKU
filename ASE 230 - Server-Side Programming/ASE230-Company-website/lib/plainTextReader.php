<?php

function getMyText($filename)
{	$dir='';
	$path=$dir.$filename;
	if(file_exists($path)) return file_get_contents($path);
	else die('<h1 style="color:red;background-color:yellow;">MISSING FILE: \''.$filename.'\'</h1>');
}

?>