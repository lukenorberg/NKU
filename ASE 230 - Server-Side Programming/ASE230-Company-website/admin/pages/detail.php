<?php
require_once('./pages.php');
$index = htmlspecialchars($_GET['index']);
$page = getPage($index);
?>

<div><?=$page?></div>
<div>

    <button>
        <a href="./edit.php?index=<?=$index?>">Edit</a>
    </button>
    <button>
        <a href="./delete.php?index=<?=$index?>">Delete</a>
    </button>
</div>

