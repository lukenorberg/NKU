<?php
require_once('../../lib/csvReader.php');

function getCsvArray() {
    return readCsv('../../data/awards.csv');
}

function getItem($index) {
    $awardsList = readCsv('../../data/awards.csv');
    return $awardsList[$index];
}

function createItem($year, $desc) {
    $fp = fopen('../../data/awards.csv', 'a+');
    fwrite($fp, $year . ';' . $desc . PHP_EOL);
    fclose($fp);
}

function updateItem($index, $year, $desc) {
    $awardsList = readCsv('../../data/awards.csv');
    $awardsList[$index] = [$year, $desc];
    $fp = fopen('../../data/awards.csv', 'w');
    foreach ($awardsList as $award) {
        if ($award) {
            fwrite($fp, $award[0] . ';' . $award[1] . PHP_EOL);
        }
    }
    fclose($fp);
}

function deleteItem($index) {
    $awardsList = readCsv('../../data/awards.csv');
    unset($awardsList[$index]);
    $fp = fopen('../../data/awards.csv', 'w');
    foreach ($awardsList as $award) {
        if ($award) {
            fwrite($fp, $award[0] . ';' . $award[1] . PHP_EOL);
        }
    }
    fclose($fp);
}


