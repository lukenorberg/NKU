<?php
require_once('JSONHelper.php');

function fillServices($servicesArray){
    if (!isset($servicesArray)) {
        die('services array is not set');
    }
    foreach ($servicesArray as $name => $details) {
        echo '<div class="col-lg-4">
            <div class="service-box text-center px-4 py-5 position-relative mb-4">
                <div class="service-box-content p-4">
                    <div class="icon-mono service-icon avatar-md mx-auto mb-4">
                        <i class="" data-feather="box"></i>
                    </div>
                    <h4 class="mb-3 font-size-22">' . $name . '&trade;</h4>
                    <p class="text-muted mb-0">' . $details['description'] . '</p>
                </div>
            </div>
        </div>';
    }
}

function fillTeam($teamArray) {
   if (!isset($teamArray)) {
       die('team array is not set');
   }
    foreach ($teamArray as $name => $content) {
        echo '

            <div class="col-lg-3 col-sm-6">
                <div class="team-box mt-4 position-relative overflow-hidden rounded text-center shadow">
                    <div class="position-relative overflow-hidden">
                        <img src="' . $content['image'] . '" alt="" class="img-fluid d-block mx-auto" />
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
                        <p class="text-muted text-uppercase font-size-14 mb-0">' . $content['title'] . '</p>
                    </div>
                </div>
            </div>
';
    }
}
