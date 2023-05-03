"use strict";
const $ = selector => document.querySelector(selector);

/*********************
*  helper functions  *
**********************/
const calculateCelsius = temp => (temp-32) * 5/9;
const calculateFahrenheit = temp => temp * 9/5 + 32;

const toggleDisplay = (label1Text, label2Text) => {
    $("#degree_label_1").textContent = label1Text;
    $("#degree_label_2").textContent = label2Text;
    $("#degrees_computed").value = "";
    $("#degrees_entered").focus();
}

/****************************
*  event handler functions  *
*****************************/
const convertTemp = () => {
    const degreesEntered = $("#degrees_entered" || $(".error") == "");
    if (isNaN(degreesEntered.value) || degreesEntered.value === "") {
        const htmlString = document.createTextNode("You must enter a valid number for degrees");
        const div = document.createElement("div");
        div.setAttribute("class", "error");
        div.appendChild(htmlString);
        $("main").appendChild(div);
        degreesEntered.focus();
        $("#degrees_computed").value = "";
    } else {
        const inputBox = $("#degrees_entered");
        const outputBox = $("#degrees_computed");

        const errorMessage = document.querySelectorAll(".error");
        for (let err of errorMessage) {
            err.remove();
        }
        if ($("#to_celsius").checked) {
            outputBox.value = calculateCelsius(inputBox.value).toFixed(2);
        } else if ($("#to_fahrenheit").checked) {
            outputBox.value = calculateFahrenheit(inputBox.value).toFixed(2);
        }
    }
};

const toCelsius = () => toggleDisplay("Enter F degrees:", "Degrees Celsius:");
const toFahrenheit = () => toggleDisplay("Enter C degrees:", "Degrees Fahrenheit:");

document.addEventListener("DOMContentLoaded", () => {
	// add event handlers
	$("#convert").addEventListener("click", convertTemp);
    $("#to_celsius").addEventListener("click", toCelsius);
    $("#to_fahrenheit").addEventListener("click", toFahrenheit);
	
	// move focus
	$("#degrees_entered").focus();
});