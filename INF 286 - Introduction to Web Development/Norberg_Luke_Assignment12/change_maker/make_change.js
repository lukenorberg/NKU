const $ = selector => document.querySelector(selector);
const calculate = $("#calculate");

let calculateTotal = () => {
    const quarters = $("#quarters");
    const dimes = $("#dimes");
    const nickels = $("#nickels");
    const pennies = $("#pennies");
    const userInput = $("#cents").value;

    if (userInput < 0) {
        alert("Please enter a value that is greater than 0");
    } else if (userInput > 99) {
        alert("Please enter a value that is less than 100");
    } else {
        const numOfQuarters = parseInt(userInput / 25);
        const inputDime = userInput % 25;
        const numOfDimes = parseInt(inputDime / 10);
        const inputNickels = inputDime % 10;
        const numOfNickels = parseInt(inputNickels / 5);
        const numOfPennies = inputNickels % 5;

        quarters.value = numOfQuarters;
        dimes.value = numOfDimes;
        nickels.value = numOfNickels;
        pennies.value = numOfPennies;
    }
}

calculate.addEventListener("click", calculateTotal);



