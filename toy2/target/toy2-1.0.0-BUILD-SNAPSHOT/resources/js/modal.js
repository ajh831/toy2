// Open the modal
function openModal() {
    document.getElementById("optionModal").style.display = "block";
}

// Close the modal
function closeModal() {
    document.getElementById("optionModal").style.display = "none";
}

// Increase quantity
function increaseQuantity() {
    let quantity = document.getElementById("quantity");
    quantity.value = parseInt(quantity.value) + 1;
}

// Decrease quantity
function decreaseQuantity() {
    let quantity = document.getElementById("quantity");
    if (parseInt(quantity.value) > 1) {
        quantity.value = parseInt(quantity.value) - 1;
    }
}