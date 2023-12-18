<?php
require_once('./pages.php');

if (count($_POST) > 0) {
    $index = htmlspecialchars($_POST['index']);
    deletePage($index);
}
$pageLinks = getPageLinks();

?>
<table>
    <?php
    for ($i = 0; $i < count($pageLinks);+ $i++) {
      echo '<tr>';
      echo '<td>
                <a href="detail.php?index='.$i.'">'
                    .$pageLinks[$i].
                '</a>
            </td>';
    }
    ?>
</table>
<button><a href="create.php">Create</a></button>
