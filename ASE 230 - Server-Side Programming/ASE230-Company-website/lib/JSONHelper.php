<?php

// manipulates any given JSON file with CRUD operations
class JSONHelper {

    // CREATE
    public static function createItem(string $filePath, string $entity, array $content): void {
        $jsonFile = self::readAll($filePath);
        if (!isset($jsonFile[$entity])) {
            die('entity ' . $entity . ' does not exist.');
        }
        $jsonFile[$entity][] = $content;
        self::updateFile($filePath, $jsonFile);
    }

    // READ
    public static function readItem(string $filePath, string $entity, string $item): array {
        $jsonArray = self::readAll($filePath);
        if (!isset($jsonArray[$entity][$item])) {
            die('either ' . $entity . ' or ' . $item . ' does not exist');
        }
        return $jsonArray[$entity][$item];
    }

    // UPDATE
    public static function updateItem(string $filePath, string $entity, string $item, array $updatedItem): void {
        $jsonArray = self::readAll($filePath);
        if (!isset($jsonArray[$entity][$item])) {
            die('either ' . $entity . ' or ' . $item . ' does not exist');
        }
        $jsonArray[$entity][$item] = $updatedItem;
        self::updateFile($filePath, $jsonArray);
    }

    // DELETE
    public static function deleteItem(string $filePath, string $entity, string $item): void {
        $jsonArray = self::readAll($filePath);
        if (!isset($jsonArray[$entity][$item])) {
            die('either ' . $entity . ' or ' . $item . ' does not exist');
        }
        unset($jsonArray[$entity][$item]);
        self::updateFile($filePath, $jsonArray);
    }

    // HELPER FUNCTIONS

    // transforms json contents to PHP associative array
    public static function readAll(string $filePath): array {
        if (!file_exists($filePath)) {
            die('file ' . $filePath . ' does not exist');
        }
        $file = file_get_contents($filePath, false, null);
        return json_decode($file, true);
    }

    // transforms PHP associative array to json and writes the file
    public static function updateFile(string $filePath, array $jsonArray): void {
        $jsonData = json_encode($jsonArray);
        file_put_contents($filePath, $jsonData);
    }
}

