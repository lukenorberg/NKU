<?php

// Given the recurrence of the need to express a range of years, a function is created to do this in a consistent manner.
// It takes 1-2 values, the first being the start of the range, the second being the end of the range.
// null is used to represent "Present" or "Still at this position" and is the default value used when no end date is passed.
function stringifyRange($start, $end = null)
{
	if ($end == null)
		$end = "Present";
	return $start . " - " . $end;
}

// Allows the delivery of online profiles as links given a username
function getProfileLink($username,$platform=null,$protocol=False)
{	$ret='';
	if($protocol)	$ret=$ret.'https://';

	if($platform==null)				$ret=$ret.'';
	else if($platform=='GitHub')	$ret=$ret.'github.com/';
	else if($platform=='LinkedIn')	$ret=$ret.'linkedin.com/';

	$ret=$ret.$username;

	return $ret;
}
// Shorthands for getProfileLink()
function getGitLink($username,$protocol=False)
{	return getProfileLink($username,'GitHub',$protocol);
}
function getLinkedLink($username,$protocol=False)
{	return getProfileLink($username,'LinkedIn',$protocol);
}

// Function to take 1-2 DateTime objects and return their difference in years as an int.
// If only one parameter is passed, second defaults to current time.
function calculateDuration($startDate,$endDate=null)
{	if($endDate==null)	$endDate = new DateTime("now");;
	$duration = $startDate->diff($endDate);
	return (int)$duration->format('%Y');
}

// Creates a member card displaying name, occupation, and a full profile button of the given member
function teamMemberCard($profile, $index)
{
    echo '
		    <header class="resume-header mt-4 pt-4 pt-md-0">
			    <div class="row">
				    <div class="col-block col-md-auto resume-picture-holder text-center text-md-start">
				    ';
    if (isset($profile['photoPath'])) {
        echo '<img class="picture" src="assets/images/profilephotos/'.$profile['photoPath'].'" alt="">';
    }
    echo '</div><!--//col-->
				    <div class="col">
					    <div class="row p-4 justify-content-center justify-content-md-between">
						    <div class="primary-info col-auto">';
    if (isset($profile['name'])) {
        echo '<h1 class="name mt-0 mb-1 text-white text-uppercase text-uppercase">'.$profile['name'].'</h1>';
    }
    if (isset($profile['jobTitle'])) {
        echo '<div class="title mb-1">'.$profile['jobTitle'].'</div>';
    }



    echo '<div class="title mb-3">' . calculateDuration($profile['dateOfBirth']) . ' Years Old</div>';


    echo '
								<a href="detail.php?profile='.$index.'" class="btn btn-secondary">See full profile</a>
						    </div><!--//primary-info-->
						    <div class="secondary-info col-auto mt-2">
						    </div><!--//secondary-info-->
					    </div><!--//row-->
				    </div><!--//col-->
			    </div><!--//row-->
		    </header>';
}

//displays each work experience item on the detail page. The function accepts one work experience item as a parameter, and it must display the code for the work experience filled with the employment information.
function displayWorkExp($profile)
{
	foreach ($profile['workExperience'] as $item) {
		echo '<article class="resume-timeline-item position-relative pb-5">
			<div class="resume-timeline-item-header mb-2">
				<div class="d-flex flex-column flex-md-row">
					<h3 class="resume-position-title font-weight-bold mb-1">
						' . htmlspecialchars($item['Title']) . '
					</h3>
					<div class="resume-company-name ms-auto">
					' . htmlspecialchars($item['Company']) . '
					</div>
				</div><!--//row-->
				<div class="resume-position-time">
				' . htmlspecialchars(stringifyRange($item['YearStart'], $item['YearLeave'])) . '
				</div>
			</div><!--//resume-timeline-item-header-->
			<div class="resume-timeline-item-desc">';
		if (array_key_exists('Description', $item)) {
			echo '
					<p>
						' . htmlspecialchars($item['Description']) . '
					</p>';
		}
		if (array_key_exists('Achievements', $item)) {
			echo '
					<h4 class="resume-timeline-item-desc-heading font-weight-bold">Achievements:
					</h4>
					<p>
						' . htmlspecialchars($item['Achievements']) . '
					</p>';
		}
		if (array_key_exists('AchieveBullets', $item)) {
			echo '
					<ul>';
			foreach ($item['AchieveBullets'] as $bullet) {
				echo '
							<li>
								' . htmlspecialchars($bullet) . '
							</li>';
			}
			;
			echo '
					</ul>';
		}
		if (array_key_exists('TechUsed', $item)) {
			echo '
					<h4 class="resume-timeline-item-desc-heading font-weight-bold">Technologies
						used:</h4>
					<ul class="list-inline">
						';
			foreach ($item["TechUsed"] as $bullet) {
				echo '
							<li class="list-inline-item"><span
									class="badge bg-secondary badge-pill">
									' . htmlspecialchars($bullet) . '
								</span></li>';
			}
			;
			echo '
					</ul>';
		}
		echo '
				</div><!--//resume-timeline-item-desc-->
				</article><!--//resume-timeline-item-->
				';
	}

}



?>