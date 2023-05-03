"use strict";

const $ = selector => document.querySelector(selector);

const calculate = $('#calculate');
const clear = $('#clear');

calculate.addEventListener('click', () => {
    const subtotal = parseFloat($("#subtotal").value);
    const tax_rate = parseFloat($('#tax_rate').value);
    if (isNaN(subtotal)) {
        alert('Please enter a subtotal');
    } else if (isNaN(tax_rate)) {
        alert('Please enter a tax rate');
    } else if (subtotal <= 0 || tax_rate <= 0) {
        alert('Please enter a subtotal and a tax rate greater than zero.')
    } else {
        const tax_output = subtotal * (tax_rate / 100);
        const total_output = subtotal + tax_output;
        $('#sales_tax').value = tax_output;
        $('#total').value = total_output;
    }
})

clear.addEventListener('click', () => {
    $('#subtotal').value = '';
    $('#tax_rate').value = '';
    $('#sales_tax').value = '';
    $('#total').value = '';
})
