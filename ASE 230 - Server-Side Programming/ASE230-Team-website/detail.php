<?php
require_once('data.php');
require_once('functions.php');

//Interpret profile specified in URL, assign it to $profile variable if it is defined in $profiles array, otherwise: print appropriate error and die.
if (array_key_exists('profile', $_GET)) {
	if (array_key_exists($_GET['profile'], $profiles)) {
		$profile = $_GET['profile'];
	} else {
		echo 'ERROR: Invalid profile provided.';
		die();
	}
} else {
	echo 'ERROR: No profile provided.';
	die();
}
$thisProfile=$profiles[$profile];
?>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>
		<?= htmlspecialchars($thisProfile['name']) ?>'s Resume
	</title>

	<!-- Meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Your name's resume">
	<meta name="author" content="Your name">
	<link rel="shortcut icon" href="favicon.ico">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900" rel="stylesheet">

	<!-- FontAwesome JS-->
	<script defer src="assets/fontawesome/js/all.min.js"></script>

	<!-- Theme CSS -->
	<link id="theme-style" rel="stylesheet" href="assets/css/pillar-1.css">
</head>

<body>
	<article class="resume-wrapper text-center position-relative">
		<div class="resume-wrapper-inner mx-auto text-start bg-white shadow-lg">
			<header class="resume-header pt-4 pt-md-0">
				<div class="row">
					<div class="col-block col-md-auto resume-picture-holder text-center text-md-start">
						<img class="picture"
							src="assets/images/profilephotos/<?= htmlspecialchars($thisProfile['photoPath']); ?>"
							alt="">
					</div><!--//col-->
					<div class="col">
						<div class="row p-4 justify-content-center justify-content-md-between">
							<div class="primary-info col-auto">
								<h1 class="name mt-0 mb-1 text-white text-uppercase text-uppercase">
									<?= htmlspecialchars($thisProfile['name']); ?>
								</h1>
								<div class="title mb-1">
									<?= htmlspecialchars($thisProfile['jobTitle']) ?>
								</div>
								<ul class="list-unstyled">
									<?php if (array_key_exists('dateOfBirth', $thisProfile)): ?>
										<li class="mb-2"><i
													class="far fa-calendar fa-fw me-2" data-fa-transform="grow-3"></i>
												<?= calculateDuration($thisProfile['dateOfBirth']).' Years Old' ?>
											</li>
									<?php endif ?>
									<?php if ($thisProfile['emailAddress'] !== null): ?>
										<li class="mb-2"><a class="text-link"
												href="mailto:<?= htmlspecialchars($thisProfile['emailAddress']); ?>"><i
													class="far fa-envelope fa-fw me-2" data-fa-transform="grow-3"></i>
												<?= htmlspecialchars($thisProfile['emailAddress']) ?>
											</a></li>
									<?php endif ?>
									<?php if ($thisProfile['phoneNumber'] !== null): ?>
										<li><a class="text-link"
												href="tel:<?= preg_replace("/[^0-9]/", '', $thisProfile['phoneNumber']); ?>"><i
													class="fas fa-mobile-alt fa-fw me-2" data-fa-transform="grow-6"></i>
												<?= htmlspecialchars($thisProfile['phoneNumber']) ?>
											</a></li>
									<?php endif ?>
								</ul>
							</div>
							<div class="secondary-info col-auto mt-2">
								<ul class="resume-social list-unstyled">
									<?php if ($thisProfile['unameLinkedIn'] !== null): ?>
										<li class="mb-3"><a class="text-link"
												href="<?= htmlspecialchars(getGitLink($thisProfile['unameLinkedIn'],true)) ?>"><span
													class="fa-container text-center me-2"><i
														class="fab fa-linkedin-in fa-fw"></i></span>
												<?= htmlspecialchars(getGitLink($thisProfile['unameLinkedIn'])) ?>
											</a></li>
									<?php endif ?>
									<?php if ($thisProfile['unameGitHub'] !== null): ?>
										<li class="mb-3"><a class="text-link"
												href="<?= htmlspecialchars(getGitLink($thisProfile['unameGitHub'],true)) ?>"><span
													class="fa-container text-center me-2"><i
														class="fab fa-github-alt fa-fw"></i></span>
												<?= htmlspecialchars(getGitLink($thisProfile['unameGitHub'])) ?>
											</a></li>
									<?php endif ?>
									<?php if ($thisProfile['personalWebsite'] !== null): ?>
										<li><a class="text-link"
												href="<?= htmlspecialchars(getProfileLink($thisProfile['personalWebsite'],null,true)) ?>"><span
													class="fa-container text-center me-2"><i
														class="fas fa-globe"></i></span>
												<?= htmlspecialchars(getProfileLink($thisProfile['personalWebsite'])) ?>
											</a></li>
									<?php endif ?>
								</ul>
							</div><!--//secondary-info-->
						</div><!--//row-->
					</div><!--//col-->
				</div><!--//row-->
			</header>



			<div class="resume-body p-5">
				<section class="resume-section summary-section mb-5">
					<h2 class="resume-section-title text-uppercase font-weight-bold pb-3 mb-3">Summary</h2>
					<div class="resume-section-content">
						<p class="mb-0">
							<?= htmlspecialchars($thisProfile['personalSummary']) ?>
						</p>
					</div>
				</section><!--//summary-section-->

				<div class="row">
					<div class="col-lg-9">
						<section class="resume-section experience-section mb-5">
							<h2 class="resume-section-title text-uppercase font-weight-bold pb-3 mb-3">Work Experience
							</h2>
							<div class="resume-section-content">
								<div class="resume-timeline position-relative">
									<?php displayWorkExp($thisProfile);?>
								</div><!--//resume-timeline-->
							</div>
						</section><!--//projects-section-->
					</div>
					<div class="col-lg-3">
						<section class="resume-section skills-section mb-5">
							<h2 class="resume-section-title text-uppercase font-weight-bold pb-3 mb-3">Skills &amp;
								Tools</h2>
							<div class="resume-section-content">
								<div class="resume-skill-item">
									<ul class="list-unstyled mb-4">
										<?php foreach ($thisProfile['skillsAndTools'] as $skill => $percent): ?>
											<li class="mb-2">
												<div class="resume-skill-name">
													<?= htmlspecialchars($skill) ?>
												</div>
												<div class="progress resume-progress">
													<div class="progress-bar theme-progress-bar-dark" role="progressbar"
														style="width: <?= htmlspecialchars($percent) ?>%" aria-valuenow="25"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</li>
										<?php endforeach ?>
									</ul>
								</div><!--//resume-skill-item-->
								<div class="resume-skill-item">
									<h4 class="resume-skills-cat font-weight-bold">Others</h4>
									<ul class="list-inline">
										<?php foreach ($thisProfile['skillsAndToolsAdditional'] as $item): ?>
											<li class="list-inline-item"><span class="badge badge-light">
													<?= htmlspecialchars($item) ?>
												</span></li>
										<?php endforeach ?>
									</ul>
								</div><!--//resume-skill-item-->
							</div><!--resume-section-content-->
						</section><!--//skills-section-->
						<section class="resume-section education-section mb-5">
							<h2 class="resume-section-title text-uppercase font-weight-bold pb-3 mb-3">education</h2>
							<div class="resume-section-content">
								<ul class="list-unstyled">
									<?php foreach ($thisProfile['education'] as $item): ?>
										<li class="mb-2">
											<div class="resume-degree font-weight-bold">
												<?= htmlspecialchars($item["Degree"]) ?>
											</div>
											<div class="resume-degree-org">
												<?= htmlspecialchars($item["Institution"]) ?>
											</div>
											<div class="resume-degree-time">
												<?= htmlspecialchars(stringifyRange($item['YearStart'], $item['YearLeave'])) ?>
											</div>
										</li>
									<?php endforeach ?>
								</ul>
							</div>
						</section><!--//education-section-->
						<section class="resume-section reference-section mb-5">
							<h2 class="resume-section-title text-uppercase font-weight-bold pb-3 mb-3">awards</h2>
							<div class="resume-section-content">
								<ul class="list-unstyled resume-awards-list">
									<?php foreach ($thisProfile['awards'] as $arrKey => $description): ?>
										<li class="mb-2 ps-4 position-relative">
											<i class="resume-award-icon fas fa-trophy position-absolute"
												data-fa-transform="shrink-2"></i>
											<div class="resume-award-name">
												<?= htmlspecialchars($arrKey) ?>
											</div>
											<div class="resume-award-desc">
												<?= htmlspecialchars($description) ?>
											</div>
										</li>
									<?php endforeach ?>
								</ul>
							</div>
						</section><!--//interests-section-->
						<section class="resume-section language-section mb-5">
							<h2 class="resume-section-title text-uppercase font-weight-bold pb-3 mb-3">languages</h2>
							<div class="resume-section-content">
								<ul class="list-unstyled resume-lang-list">
									<?php foreach ($thisProfile['languages'] as $arrKey => $description): ?>
										<li class="mb-2"><span class="resume-lang-name font-weight-bold">
												<?= htmlspecialchars($arrKey) ?>
											</span>
											<?php if (strcmp($description, "")): ?>
												<small class="text-muted font-weight-normal">(
													<?= htmlspecialchars($description) ?>)
												</small>
											</li>
										<?php endif ?>
									<?php endforeach ?>
								</ul>
							</div>
						</section><!--//language-section-->
						<section class="resume-section interests-section mb-5">
							<h2 class="resume-section-title text-uppercase font-weight-bold pb-3 mb-3">interests</h2>
							<div class="resume-section-content">
								<ul class="list-unstyled">
									<?php foreach ($thisProfile['interests'] as $item): ?>
										<li class="mb-1">
											<?= htmlspecialchars($item) ?>
										</li>
									<?php endforeach ?>
								</ul>
							</div>
						</section><!--//interests-section-->
					</div>
				</div><!--//row-->



				<section class="resume-section experience-section mb-5">
					<h2 class="resume-section-title text-uppercase font-weight-bold pb-3 mb-3">projects</h2>
					<div class="row mt-4">
						<?php foreach ($thisProfile['projects'] as $item): ?>
							<div class="col-md-4">
								<div class="card">
									<?php if (array_key_exists('ImgPath', $item)): ?>
										<img src="<?= "assets/images/projectphotos/" . htmlspecialchars($item['ImgPath']) ?>"
											alt="<?= htmlspecialchars($item['Name']) ?>" class="card-img-top">
									<?php endif ?>
									<div class="card-body">
										<h5 class="card-title">
											<?= htmlspecialchars($item['Name']) ?>
										</h5>
										<p class="card-text">
											<?= htmlspecialchars($item['Description']) ?>
										</p>
										<?php if (array_key_exists('Link', $item)): ?>
											<a class="btn btn-outline-primary" href="<?= htmlspecialchars($item['Link']) ?>">
												<?php if (array_key_exists('LinkText', $item)): ?>
													<?= htmlspecialchars($item['LinkText']) ?>
												<?php else: ?>
													Go to link
												<?php endif ?>
											</a>
										<?php endif ?>
									</div>
								</div>
							</div>
						<?php endforeach ?>
					</div>
				</section><!--//projects-section-->
			</div><!--//resume-body-->


		</div>
	</article>


	<footer class="footer text-center pt-2 pb-5">
		<!--/* This template is free as long as you keep the footer attribution link. If you'd like to use the template without the attribution link, you can buy the commercial license via our website: themes.3rdwavemedia.com Thank you for your support. :) */-->
		<small class="copyright">Designed with <span class="sr-only">love</span><i class="fas fa-heart"></i> by
			<?= htmlspecialchars($thisProfile['name']) ?>
		</small>
	</footer>
</body>

</html>