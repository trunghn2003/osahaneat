$(document).ready(function() {
    var token = localStorage.getItem("token");
    var linkRestaurant = "http://localhost:8080/restaurant";
    var linkCategory = "http://localhost:8080/category";
    var linkMenu = "http://localhost:8080/menu";

    // console.log("Token:", token);

    $.ajax({
        method: "GET",
        url: linkRestaurant,
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
    .done(function(msg) {
        if (msg.sucess) {
            $.each(msg.data, function(index, value) {
                // Handle the case where rating is 'NaN'
                var rating = isNaN(value.rating) ? 'N/A' : value.rating;

                // Create HTML for each restaurant
                var html = `
                    <div class="restaurant-item">
                        <img class="image1 restaurant-image" src="${linkRestaurant}/file/${value.image}" alt="${value.title}">
                        <div class="restaurant-details">
                            <p class="title">${value.title}</p>
                            <p class="subtitle">${value.subtitle}</p>
                            <p class="rating">Rating: ${rating}</p>
                            <p class="freeship">Free Shipping: ${value.freeship ? 'Yes' : 'No'}</p>
                        </div>
                    </div>
                `;

                // Append HTML to the feature-restaurant div
                $("#feature-restaurant").append(html);
            });
        }
    })
    .fail(function(jqXHR, textStatus, errorThrown) {
        console.error("AJAX Request Failed: " + textStatus, errorThrown);
        // Handle the error appropriately (e.g., show an error message to the user).
    });

    //Load danh sach cac category
    $.ajax({
        method: "GET",
        url: linkCategory,
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
    .done(function(msg) {
        if (msg.sucess) {
            $.each(msg.data, function(index, value) {
                console.log(value)
                // Handle the case where rating is 'NaN'
                var rating = isNaN(value.rating) ? 'N/A' : value.rating;

                // Create HTML for each CatelinkCategory
                var html = `
                    <div class="CatelinkCategory-item">
                        <div class="CatelinkCategory-details">
                            <p class="title">${value.name_cate}</p>
                        </div>
                    </div>
                `;
                html += '<div> '
                $.each(value.listMenuDTO, function(index, data){
                    html += `
                    <div class="CatelinkCategory-item">
                        <div class="CatelinkCategory-details">
                        <img class="image1 restaurant-image" src="${linkMenu}/file/${data.image}" alt="${data.title}">
                            
                        </div>
                    </div>`
                });
                html += "</div> "
                // Append HTML to the feature-CatelinkCategory div
                $("#feature-category").append(html);
            });
        }
    })
    .fail(function(jqXHR, textStatus, errorThrown) {
        console.error("AJAX Request Failed: " + textStatus, errorThrown);
        // Handle the error appropriately (e.g., show an error message to the user).
    });
});
