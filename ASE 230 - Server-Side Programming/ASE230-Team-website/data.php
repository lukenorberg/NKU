<?php
// Variable declarations, $profiles is an associative array with keys defining user ids, values are associative arrays, the format of which can be seen in the sample entry below
// NOTE: All variables are, before being inserted into the HTML document, sanitized via a htmlspecialchars() function.  All Strings should print as they are typed.

$profiles = [
//	'test' =>
//		[	//	The following are simple variables taking a single string.
//			'name'				=> 'Sam Poole',	// User's name as meant to be printed.  Used in the page title, header, and footer.
//			'photoPath'			=> 'test.jpg',			// File name of user's profile photo in the assets/images/profilephotos directory.
//			'jobTitle'			=> 'Tester',			// User's job title as intended to be printed.
//			'emailAddress'		=> 'sample@nku.edu',	// User's e-mail address, will also be used in a mailto: link.  Can be left as null to omit.
//			'phoneNumber'		=> '(555) 555-5555',	// User's phone number, will also be used in a tel: link.  Can be left as null to omit.
//			'unameLinkedIn'		=> 'example',			// User's LinkedIn vanity URL, will also be used to generate a link to the profile.  Can be left as null to omit.
//			'unameGitHub'		=> 'example',			// User's GitHub username, will also be used to generate a link to the profile.  Can be left as null to omit.
//			'personalWebsite'	=> 'nku.edu/~sample',	// User's website in the format of yourwebsite.com, protocols will be added when needed.  Can be left as null to omit.
//			'personalSummary'	=> 	//User's personal summary, a brief paragraph on the user.  Note: Plain-text only, no formatting options are provided.
//				'Lorem ipsum dolro sit amet.',
//
//			//	Work experience is defined as an array of associative arrays.  Each associative array can contain the following keys:
//			//	'Title'			- A string indicating the entry's position title.
//			//	'Company'		- A string indicating the entry's employer.
//			//	'YearStart		- An int indicating the year this entry started.
//			//	'YearLeave		- An int indicating the year this entry concluded.  Can be left as null to indicate still at position.
//			//	'Description'	- A string to provide a paragraph to describe the entry's position.  Optional: key can be omitted to exclude section.
//			//	'Achievements'	- A string to provide a second paragraph under an 'Achievements' header to describe what was achieved in this entry's position.  Optional: key can be omitted to exclude section.
//			//	'AchieveBullets'- An indexed array of strings, each string to be listed as a bullet point in the section.  Optional: key can be omitted to exclude section.
//			//	'TechUsed'		- An indexed array of strings, each string being a technology used in the position to be listed horizontally.  Optional: key can be omitted to exclude section.
//			'workExperience'	=>
//				[	[	'Title'			=> 'Product Tester',
//						'Company'		=> 'ACME Testing Co',
//						'YearStart'		=> 2023,
//						'YearLeave'		=> null,
//						'Description'	=> 'Tested products and produced tests.',
//						'Achievements'	=> 'Achieved tests of the following:',	//In this instance, the 'Achievements' key is left defined as null as to retain the header above the bullets.
//						'AchieveBullets'=> ['Stuff','Things','Items'],
//						'TechUsed'		=> ['Test Suites','Bubble wrap']
//					]
//				],
//
//			//	Skills and tools are defined in an associative array.
//			//	The array can be constructed in the format where keys are Strings indicating the skill/tool's name corresponding to an int representing competence in the associated tool as a percentage (0-100)
//			'skillsAndTools' =>
//				[	'TNT' => 100,
//					'Mallets' => 50,
//					'Paint' => 10
//				],
//			//Additional skills/tools can be defined in the indexed array, skillsAndToolsAdditional, simply containing String representations of items to list.
//			'skillsAndToolsAdditional' => ['Skills','Tools'],
//
//			//	education experience is defined as an array of associative arrays.  Each associative array should contain the following keys:
//			//	'Degree'		- String representing the name of the degree was earned.
//			//	'Institution'	- String representing the name of the academic institution from which the degree was earned.
//			//	'YearStart		- An int indicating the year this entry started.
//			//	'YearLeave		- An int indicating the year this entry concluded.  Can be left as null to indicate still at position.
//			'education' =>
//				[
//					[	'Degree'		=> 'PhD in Degree Forgery',
//						'Institution'	=> 'Harvard',
//						'YearStart'		=> 2019,
//						'YearLeave'		=> 2024
//					],
//					[	'Degree'		=> 'BS in Degree Forgery',
//						'Institution'	=> 'Northern Kentucky University',
//						'YearStart'		=> 1988,
//						'YearLeave'		=> 1992
//					]
//				],
//
//			//	awards are defined as an associative array.
//			//	The array can be constructed in the format where keys are Strings indicating the name of the award mapping to strings with additional details
//			'awards' =>
//				[	'The Celestial Flame of Abernethy' => '2 time recipient of this prestigious award',
//					'Holy Flaming Hammer' => 'of Unholy Cosmic Frost',
//					'Hollywood Hootsman Award' => 'Presented by the King of California'
//				],
//
//			//	languages are defined as an associative array.
//			//	The array can be constructed in the format where keys are Strings indicating the name of the language mapping to strings indicating proficiency
//			'languages' =>
//				[	'English' => 'Native',
//					'Spanish' => 'Limited Working Proficiency'
//				],
//
//			//	interests are defined in an indexed array of Strings.
//			'interests' =>
//				[	'Testing',
//					'Sampling',
//					'Testing Samples',
//					'Sampling Tests'
//				],
//
//			//	Featured projects are defined as an array of associative arrays.  Each associative array should contain the following keys:
//			//	'ImgPath'		- String indicating the filename of the project's image in the assets/images/projectphotos directory.  Optional: key can be omitted to exclude image.
//			//	'Name'			- String representing the name of the project.
//			//	'Description'	- String containing a description of the project.
//			//	'Link'			- String containing a link to the project on the web.  Optional: key can be omitted to exclude button.
//			//	'LinkText'		- String defining display text of the link.  Optional: defaults to "Go to link" if key is omitted.
//			'projects' =>
//				[
//					[	'ImgPath'		=> 'img.jpg',
//						'Name'			=> 'Something',
//						'Description'	=> 'Lorem ipsum.',
//						'Link'			=> 'https://www.youtube.com/watch?v=dQw4w9WgXcQ',
//						'LinkText'		=> 'Watch it'
//					],
//					[	'ImgPath'		=> 'img.jpg',
//						'Name'			=> 'Something Else',
//						'Description'	=> 'Lorem ipsum.',
//						'Link'			=> 'https://www.youtube.com/watch?v=dQw4w9WgXcQ'
//					],
//					[	'ImgPath'		=> 'img.jpg',
//						'Name'			=> 'Yet Another Thing',
//						'Description'	=> 'Lorem ipsum.',
//						'Link'			=> 'https://www.youtube.com/watch?v=dQw4w9WgXcQ',
//						'LinkText'		=> 'View them'
//					]
//				]
//		],
    'HirschP2' =>
        [
            'name'				=> 'Patrick Hirsch',
            'photoPath'			=> 'HirschP2.jpg',
            'jobTitle'			=> 'Cybersecurity Student',
			'dateOfBirth'		=> new DateTime('2001-04-06'),
            'emailAddress'		=> 'HirschP2@nku.edu',
            'phoneNumber'		=> '(407) 734-0654',
            'unameLinkedIn'		=> 'patrickhirsch',
            'unameGitHub'		=> 'patrickhirsch',
            'personalWebsite'	=> 'nku.edu/~HirschP2',
            'personalSummary'	=>
                'Northern Kentucky University student dual majoring in Computer Science & Cybersecurity with minors in Computer Forensics, Computer Information Technology, and Information Security looking to obtain an internship or co-op in the field of cybersecurity and/or computer information technology.',
            'workExperience'	=>
                [
                    [	'Title'			=> 'Outreach',
                        'Company'		=> 'NKCyber',
                        'YearStart'		=> 2023,
                        'YearLeave'		=> null,
                        'Description'	=> 'Responsible for outreach and PR efforts of NKU\'s student-run cybersecurity-focused student organization and cyberdefence team.',

                        'TechUsed'		=> ['Meta Business Suite','Photoshop']
                    ],
                    [	'Title'			=> 'Web Editor',
                        'Company'		=> 'The Northerner',
                        'YearStart'		=> 2023,
                        'YearLeave'		=> null,
                        'Description'	=> 'Responsible for overseeing Northern Kentucky University\'s Independent Student Newspaper, The Northerner\'s website and any stories that need to be presented in an alternative format to the traditional written word.',

                        'TechUsed'		=> ['Wordpress','SNO','PHP']
                    ],
                    [	'Title'			=> 'General Manager',
                        'Company'		=> 'Norse Code Radio',
                        'YearStart'		=> 2023,
                        'YearLeave'		=> null,
                        'Description'	=> 'Responsible for overseeing the overall operations of NKU\'s campus radio station and student organization, \'Norse Code Radio\'.'

                    ],
                    [	'Title'			=> 'Assistant General Manager',
                        'Company'		=> 'Norse Code Radio',
                        'YearStart'		=> 2022,
                        'YearLeave'		=> 2023,
                        'Description'	=> 'Second-in-command of NKU\'s student-run campus radio station, \'Norse Code Radio\'.',

                        'AchieveBullets'=> ['Maintained the organization\'s roster.','Tracked weekly meeting attendance.','Recorded and distributed weekly meeting minutes.'],
                        'TechUsed'		=> ['Google Sheets','Icecast','Wordpress']
                    ],
                    [	'Title'			=> 'Systems Administrator',
                        'Company'		=> 'Norse Code Radio',
                        'YearStart'		=> 2020,
                        'YearLeave'		=> 2022,
                        'Description'	=> 'Appointed \'Systems Administrator\' of NKU\'s student-run online streaming radio station, Norse Code Radio.  Served as the main consultant on any technical questions or issues that arose regarding the station\'s operations.',
                        'Achievements'	=> null,
                        'AchieveBullets'=> ['Worked to investigate systems in place and learn how they worked together to run the station.','Designed a system allowing for remote broadcasting and station control during the pandemic.','Configured existing hardware to allow listeners to call in and be on the air.','Designed new pages to showcase the station\'s podcasts and Live at the Loch sessions.'],
                        'TechUsed'		=> ['Wordpress','BASH Scripting','AppleScript','Icecast','Python']
                    ]
                ],
            'skillsAndTools' =>
                [	'HTML' => 95,
                    'Java' => 90,
                    'Python' => 90,
                    'BASH' => 85,
                    'Powershell' => 10
                ],
            'skillsAndToolsAdditional' => ['CSS','Javascript','PHP'],
            'education' =>
                [
                    [	'Degree'		=> 'BS in Cybersecurity',
                        'Institution'	=> 'Northern Kentucky University',
                        'YearStart'		=> 2019,
                        'YearLeave'		=> 2024
                    ],
                    [	'Degree'		=> 'BS in Computer Science',
                        'Institution'	=> 'Northern Kentucky University',
                        'YearStart'		=> 2019,
                        'YearLeave'		=> 2024
                    ],
                    [	'Degree'		=> 'High School Diploma',
                        'Institution'	=> 'Randall K. Cooper High School',
                        'YearStart'		=> 2015,
                        'YearLeave'		=> 2019
                    ]
                ],
            'awards' =>
                [	'Hey-U Award' => '2021',
                    'Randall K. Cooper High School Award for Excellence in Information Technologies' => '2019',
                    'Randall K. Cooper High School Award for Excellence in Yearbook Production' => '2019'
                ],
            'languages' =>
                [	'English' => 'Native',
                    'Spanish' => 'Limited Working Proficiency'
                ],
            'interests' =>
                [	'Cybersecurity',
                    'Networking',
                    'Server Management',
                    'Artificial Intelligence'
                ],
            'projects' =>
                [
                    [	'ImgPath'		=> 'HirschP2_Vampotter.jpg',
                        'Name'			=> 'Short Film: \'Vampotter\'',
                        'Description'	=> 'A short film I wrote, directed, filmed and edited for Norse Film Society\'s Cards Against Humanity Film Fest.',
                        'Link'			=> 'https://www.youtube.com/watch?v=SJEHJOuNqXw',
                        'LinkText'		=> 'Watch it'
                    ],
                    [	'ImgPath'		=> 'HirschP2_sl.jpg',
                        'Name'			=> 'ChooChoo.sh',
                        'Description'	=> 'A small /slightly/ malicious BASH script I wrote to override all commands with an infinite loop of the sl program.',
                        'Link'			=> 'https://github.com/PatrickHirsch/ChooChoo'
                    ],
                    [	'ImgPath'		=> 'HirschP2_PhotoPort.jpg',
                        'Name'			=> 'Photography Portfolio',
                        'Description'	=> 'A small showcase of photographs I\'ve captured.',
                        'Link'			=> 'https://nku.edu/~HirschP2/photography',
                        'LinkText'		=> 'View them'
                    ]
                ]
        ],
    'NorbergP2' => [
        'name' => 'Luke Norberg',
        'photoPath' => 'NorbergP2me.png',
        'jobTitle' => 'Software Engineer',
		'dateOfBirth' => new DateTime('2004-03-15'),
        'emailAddress' => 'Norbergp2@mymail.nku.edu',
        'phoneNumber' => '(859) 962-9251',
        'unameLinkedIn' => 'lukenorberg',
        'unameGitHub' => 'lukenorberg',
        'personalWebsite' => 'nku.edu/~NorbergP2',
        'personalSummary' => 'Applied Software Engineering Major at Northern Kentucky University. Motivated professional focused on continual education through a career and schooling. Accomplished at interpersonal communication and confident with asking for support when needed.',
        'workExperience' => [
            [
                'Title' => 'Research Assistant',
                'Company' => 'NKU',
                'YearStart' => 2023,
                'YearLeave' => 2023,
                'Description' => 'Adapted an eye-tracking solution to incorporate data visualization tools for easier diagnosis by medical professionals.',
                'TechUsed' => [
                    'HTML/CSS',
                    'PHP',
                    'JavaScript',
                    'NodeJS',
                    'MediaPipe'
                ]
            ],
            [
                'Title' => 'Customer Service Representative',
                'Company' => 'Fidelity Investments',
                'YearStart' => 2022,
                'YearLeave' => 2023,
                'Description' => 'Provided stellar customer service utilizing empathy, strong problem-solving skills, and clear communication. Clearly and effectively educated participants on the details of their retirement plans. Navigated resources to provide an end result in a timely manner.',
                'TechUsed' => [
                    'OneNote',
                    'Zoom',
                    'Proprietary Software'
                ]
            ],
            [
                'Title' => 'To-go Specialist',
                'Company' => 'Outback Steakhouse',
                'YearStart' => 2020,
                'YearLeave' => 2022,
                'Description' => 'Anticipated needs, processed guests orders, and took payment in a hospitable, timely manner. Successfully adapted to various business needs, including contributing to multiple positions. Focused on a customer-first mindset by assisting customers over the phones by answering inquiries, taking orders, and resolving complaints.',
                'TechUsed' => ['Proprietary Software']
            ],
        ],
        'skillsAndTools' => [
            'JavaScript' => 90,
            'HTML/CSS' => 90,
            'Java' => 80,
            'React' => 75,
            'Node.js' => 65
        ],
        'skillsAndToolsAdditional' => ['Git', 'Tailwind', 'PHP'],
        'education' => [
            [
                'Degree' => 'BS in Applied Software Engineering',
                'Institution' => 'Northern Kentucky University',
                'YearStart' => 2023,
                'YearLeave' => 2026
            ],
        ],
        'awards' => [
            'John Philip Sousa Award' => '2022',
        ],
        'languages' => [
            'English' => 'Native',
        ],
        'interests' => [
            'Musical Performance', 'Road Trips', 'Biblical Scholarship'
        ],
        'projects' => [
            [
                'ImgPath' => 'NorbergP2search_Music.png',
                'Name' => 'Music Search Site',
                'Description' => 'a Music search site built with React and Tailwind that lets user\'s navigate their favorite songs, artists, and albums conveniently using a public music API. This music search site is designed to allow a comfortable UI/UX experience for the user.',
                'Link' => 'https://github.com/lukenorberg/PersonalProjects/tree/main/Music%20Search',
                'LinkText' => 'View Project'
            ],
            [
                'ImgPath' => 'NorbergP2Rate_Your_Music_Logo.jpg',
                'Name' => 'RateYourMusic.com Web Scraper',
                'Description' => 'Extracted and analyzed music data from RateYourMusic.com using Beautiful Soup and Pandas. Scraped website data to gather information such as scores and genre tags, and used Pandas to organize and categorize the data. The resulting insights were used to gain a deeper understanding of music trends and preferences.',
                'Link' => 'https://github.com/lukenorberg/PersonalProjects/tree/main/RYM_Web_Scraper',
                'LinkText' => 'View Project'
            ],
            [
                'ImgPath' => 'NorbergP2calculator.png',
                'Name' => 'Calculator',
                'Description' => 'Developed a calculator application using HTML, CSS, and JavaScript. Implemented user-friendly interface using HTML and CSS, and programmed the calculator\'s functions and logic using JavaScript. The application was designed to perform basic mathematical operations and was built with scalability and flexibility in mind.',
                'Link' => 'https://github.com/lukenorberg/PersonalProjects/tree/main/Calculator',
                'LinkText' => 'View Project'
            ]
        ]],
        'Rileys14' =>
        [
            'name'				=> 'Sarah Riley',
            'photoPath'			=> 'SarahRileyProfile.png',
            'jobTitle'			=> 'Software Engineer Student',
			'dateOfBirth'		=> new DateTime('1997-11-01'),
            'emailAddress'		=> 'Rileys14@mymail.nku.edu',
            'phoneNumber'		=> '(989) 387-3686',
            'unameLinkedIn'		=> 'sarah-riley-33a429241',
            'unameGitHub'		=> 'Sarahphoo',
            'personalWebsite'	=> 'nku.edu/~rileys14',
            'personalSummary'	=>
                'I am a student currently studying Applied Software Engineering at, Northern Kentucky University. During the course of my academic career, I managed to accrue 1 semester of database management, 2 semesters of Java experience, and 2 semesters of web development. During this time, I had the privilege of working for Newport Aquarium in the Guest Experiance role, where I learned valuable professional skills such as team work, client needs assessment, and client communications. ',
            'workExperience'	=>
                [
                    [	'Title'			=> 'Software Engineer',
                        'Company'		=> 'DatFlo',
                        'YearStart'		=> 2023,
                        'YearLeave'		=> null,
                        'Description'	=> 'Role description goes here ipsum dolor sit amet, consectetuer adipiscing
                        elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
                        penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec
                        quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Donec
                        pede justo, fringilla vel.',

                        'TechUsed'		=> ['Meta Business Suite','Photoshop']
                    ],
                    [	'Title'			=> 'Web Developer',
                        'Company'		=> 'Pokemon Company',
                        'YearStart'		=> 2022,
                        'YearLeave'		=> 2023,
                        'Description'	=> 'Role description goes here ipsum dolor sit amet, consectetuer adipiscing
                        elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
                        penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec
                        quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Donec
                        pede justo, fringilla vel.',

                        'TechUsed'		=> ['Wordpress','SNO','PHP','JavaScript']
                    ],
                    [	'Title'			=> 'Junior Sortware Engineer',
                        'Company'		=> 'The Nothing Company',
                        'YearStart'		=> 2020,
                        'YearLeave'		=> 2022,
                        'Description'	=> 'Role description goes here ipsum dolor sit amet, consectetuer adipiscing
                        elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
                        penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec
                        quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Donec
                        pede justo, fringilla vel.',

                        'TechUsed'		=> ['Wordpress','SNO','PHP','JavaScript']

                    ],
                    [	'Title'			=> 'Software Engineer Intern',
                        'Company'		=> 'Source Toad',
                        'YearStart'		=> 2019,
                        'YearLeave'		=> 2020,
                        'Description'	=> 'Role description goes here ipsum dolor sit amet, consectetuer adipiscing
                        elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
                        penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec
                        quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Donec
                        pede justo, fringilla vel.',

                        'AchieveBullets'=> ['Maintained the organization\'s roster.','Tracked weekly meeting attendance.','Recorded and distributed weekly meeting minutes.'],
                        'TechUsed'		=> ['PHP','JavaScript','Docker', 'YII2']
                    ]
   
                ],
            'skillsAndTools' =>
                [	'HTML' => 95,
                    'Java' => 90,
                    'JavaScript'=> 70,
                    'PHP'=> 20,
                    'BASH' => 85,
                    'Powershell' => 10
                ],
            'skillsAndToolsAdditional' => ['CSS','Javascript','PHP'],
            'education' =>
                [
                    [	'Degree'		=> 'BS in Applied Software Engineering',
                        'Institution'	=> 'Northern Kentucky University',
                        'YearStart'		=> 2019,
                        'YearLeave'		=> 2024
                    ],
                    [	'Degree'		=> 'High School Diploma',
                        'Institution'	=> 'Ogemaw Heights High school',
                        'YearStart'		=> 2012,
                        'YearLeave'		=> 2016
                    ]
                ],
            'awards' =>
                [	'Cutest Dog' => '2023'
                ],
            'languages' =>
                [	'English' => 'Native',
                    'Spanish' => 'Limited Working Proficiency'
                ],
            'interests' =>
                [	'Software Engineering',
                    'Web Development',
                    'Digital Art',
                    'Artificial Intelligence'
                ],
            'projects' =>
                [
                    [	'ImgPath'		=> 'Rileys14_PetLog.png',
                        'Name'			=> 'PetLog',
                        'Description'	=> 'A project made with the help of other students from ASE220',
                        'Link'			=> 'https://github.com/Saraphoo/Assignment7_Final',
                        'LinkText'		=> 'View the Code'
                    ]
                ]
        ]
];
?>