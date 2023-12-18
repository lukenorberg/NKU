<?php
function readUserData()
{

    $file = file_get_contents('./lib/starluxe.json', false, null);
    $file = json_decode($file,true);
    
    return $file;
}

function fillTeam($JSONData)
{
    $counter = 0;
    
    foreach ($JSONData['Team'] as $teamKey => $team) {
        $teamMember = $JSONData['Team'][array_keys($JSONData['Team'])[$counter]];

        // Extract team member information from JSON
        $name = $teamKey;
        $position = $teamMember['title'];
        $imageSrc = $teamMember['image'];

        // Echo the HTML template with the extracted information
        echo '

            <div class="col-lg-3 col-sm-6">
                <div class="team-box mt-4 position-relative overflow-hidden rounded text-center shadow">
                    <div class="position-relative overflow-hidden">
                        <img src="' . $imageSrc . '" alt="" class="img-fluid d-block mx-auto" />
                        <ul class="list-inline p-3 mb-0 team-social-item">
                            <li class="list-inline-item mx-3">
                                <a href="javascript: void(0);" class="team-social-icon h-primary"><i class="icon-sm" data-feather="facebook"></i></a>
                            </li>
                            <li class="list-inline-item mx-3">
                                <a href="javascript: void(0);" class="team-social-icon h-info"><i class="icon-sm" data-feather="twitter"></i></a>
                            </li>
                            <li class="list-inline-item mx-3">
                                <a href="javascript: void(0);" class="team-social-icon h-danger"><i class="icon-sm" data-feather="instagram"></i></a>
                            </li>
                        </ul>
                    </div>
                    <div class="p-4">
                        <h5 class="font-size-19 mb-1">' . $name . '</h5>
                        <p class="text-muted text-uppercase font-size-14 mb-0">' . $position . '</p>
                    </div>
                </div>
            </div>
';

        $counter++;
    }
}

function fillTeamTable($JSONData){
    $counter = 0;
    
    foreach ($JSONData['Team'] as $teamKey => $team) {
        $teamMember = $JSONData['Team'][array_keys($JSONData['Team'])[$counter]];

        // Extract team member information from JSON
        $name = $teamKey;
        $position = $teamMember['title'];
        $imageSrc = $teamMember['image'];

        // Echo the HTML template with the extracted information
        echo '
    <table>
  <tr>
    <th>Name</th>
    <th>Position</th>
    <th>Image</th>
  </tr>
  <tr>
    <td>'. $name .'</td>
    <td>'. $position .'</td>
    <td>'.$imageSrc .'</td>
  </tr>
</table>';
$counter++;
}}


function fillServices($JSONData) {
    // Loop through the services in the JSON data
    foreach ($JSONData["Key Products & Services"] as $serviceName => $serviceDetails) {
        $description = $serviceDetails["description"];
        
        // Start generating the HTML for each service
        echo '<div class="col-lg-4">
            <div class="service-box text-center px-4 py-5 position-relative mb-4">
                <div class="service-box-content p-4">
                    <div class="icon-mono service-icon avatar-md mx-auto mb-4">
                        <i class="" data-feather="box"></i>
                    </div>
                    <h4 class="mb-3 font-size-22">' . $serviceName . '</h4>
                    <p class="text-muted mb-0">' . $description . '</p>
                </div>
            </div>
        </div>';
    }


}
?>