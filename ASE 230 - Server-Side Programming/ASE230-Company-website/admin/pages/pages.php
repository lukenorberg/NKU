<?php
require_once('../../lib/plainTextReader.php');

function getPageLinks() {
    $links = glob('../../*.php');
    for ($i = 0; $i < sizeof($links); $i++) {
        $links[$i] = str_replace('../../', '', $links[$i]);
    }
   return $links;
}


function getPage($index) {
    return getPageLinks()[$index];
}

function getPageContent($index) {
    return getMyText('../../'.getPage($index));
}

function createPage($fileName, $text) {
    $fileName = str_replace('.php', '', $fileName);
    $fileLink = '../../'.$fileName.'.php';

    if (file_exists($fileLink)) {
        return 'Error: File already exists';
    }

    $fp = fopen($fileLink, 'x');
    fwrite($fp, $text);
    fclose($fp);
    return 'File successfully created';
}

function updatePage($fileName, $text) {
    $fileName = str_replace('.php', '', $fileName);
    $fileLink = '../../'.$fileName.'.php';

    if (!file_exists($fileLink)) {
        return "page doesn't exist. Create the page first.";
    }
    unlink($fileLink);
    $fp = fopen($fileLink, 'x');
    fwrite($fp, $text);
    fclose($fp);
    return "file modified successfully.";
}

function deletePage($index) {
    $fileName = getPage($index);
    $fileName = str_replace('.php', '', $fileName);
    $fileLink = '../../'.$fileName.'.php';

    if (!file_exists($fileLink)) {
        return;
    }
    unlink($fileLink);
}