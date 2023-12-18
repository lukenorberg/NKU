<?php
function readCsv($file) {
    $pricingPlan = [];
    if (file_exists($file)) {
        $fp = fopen($file, 'r');
        while (!feof($fp)) {
            $pricingPlan[] = fgetcsv($fp, 1024, ';');
        }
        fclose($fp);
    }
    return $pricingPlan;
}
