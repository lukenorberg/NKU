"use strict";
const $ = selector => document.querySelector(selector);

const names = ["Ben", "Joel", "Judy", "Anne"];
const scores = [88, 98, 77, 88];

const addScore = () => {
	const name = $("#name");
	const score = $("#score");
	const nameSpan = name.nextElementSibling;
	const scoreSpan = score.nextElementSibling;

	if (name.value == "") {
		const nameErr = document.createTextNode("Please enter a name");
		if (nameSpan.textContent == "") {
			nameSpan.appendChild(nameErr);
		}
	} else {
		if (nameSpan.hasChildNodes()) {
			nameSpan.firstChild.remove();
		}
	}
	if (score.value == "" || parseInt(score.value) < 0 || parseInt(score.value) > 100 || isNaN(score.value)) {
		const scoreErr = document.createTextNode("Score must be between 0 and 100.");
		if (scoreSpan.textContent == "") {
			scoreSpan.appendChild(scoreErr);
		}
	} else {
		if (scoreSpan.hasChildNodes()) {
			scoreSpan.firstChild.remove();
		}
	}
	if (nameSpan.textContent == "" && scoreSpan.textContent == "") {
		names.push(name.value);
		scores.push(parseInt(score.value));
		name.value = "";
		score.value = "";
		name.focus();
	}
}

const displayResults = () => {
	const results = $("#results");
	if (results.hasChildNodes()) {
		results.remove();
		const newResult = document.createElement("div");
		newResult.setAttribute("id", "results");
		$("main").insertBefore(newResult, $("#scores"));

	}
	const h2 = document.createElement("h2");
	const h2Text = document.createTextNode("Results");
	h2.appendChild(h2Text);
	results.appendChild(h2);

	let highScore = 0;
	let highScoreIndex = 0;
	let sum = 0;
	let count = 0;
	for (let i in scores) {
		sum += scores[i];
		count++;
		if (scores[i] > highScore) {
			highScore = scores[i];
			highScoreIndex = i;
		}
	}
	const averageScore = sum / count;
	const p1 = document.createElement("p");
	const p2 = document.createElement("p");
	const p1Text = document.createTextNode(`Average score = ${averageScore}`);
	const p2Text = document.createTextNode(`High Score = ${names[highScoreIndex]} with a score of ${highScore}`)
	p1.appendChild(p1Text);
	p2.appendChild(p2Text);
	results.appendChild(p1);
	results.appendChild(p2);
}

const displayScores = () => {
	const divScores = $("#scores");
	if (divScores.hasChildNodes()) {
		divScores.remove();
		const newDivScores = document.createElement("div");
		newDivScores.setAttribute("id", "scores");
		$("main").appendChild(newDivScores);
	}
	const h2 = document.createElement("h2");
	const h2Text = document.createTextNode("Scores");
	const table = document.createElement("table");
	h2.appendChild(h2Text);
	divScores.appendChild(h2);
	divScores.appendChild(table);
	for (let num in scores) {
		const row = document.createElement("tr");
		const data1 = document.createElement("td");
		const data2 = document.createElement("td");
		const data1Text = document.createTextNode(`${names[num]}`);
		const data2Text = document.createTextNode(`${scores[num]}`);
		data1.appendChild(data1Text);
		data2.appendChild(data2Text);
		row.appendChild(data1);
		row.appendChild(data2);
		table.appendChild(row);
	}

}
document.addEventListener("DOMContentLoaded", () => {
	// add event handlers
	$("#add").addEventListener("click", addScore);
	$("#display_results").addEventListener("click", displayResults);
	$("#display_scores").addEventListener("click", displayScores);
});